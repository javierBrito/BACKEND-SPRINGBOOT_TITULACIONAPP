package ec.gob.educacion.controlador.titulacion;

import ec.gob.educacion.model.TitTitulo;
import ec.gob.educacion.model.constantes.Constantes;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.TituloServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("private/")
public class TituloControlador {

	@Autowired
	private TituloServicio tituloServicio;

	@GetMapping(value = "listarTodosTitulo")
	public ResponseGenerico<TitTitulo> listarTodosTitulo() {
		List<TitTitulo> listaTitulo = tituloServicio.listarTodosTitulo();
		// Respuesta
		ResponseGenerico<TitTitulo> response = new ResponseGenerico<>();
		response.setListado(listaTitulo);
		response.setTotalRegistros((long) listaTitulo.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para obtener TitTitulo
	 * 
	 * @return TitTitulo
	 */
	@GetMapping(value = "buscarTituloPorCodigo/{codTitulo}")
	public ResponseGenerico<TitTitulo> buscarTituloPorCodigo(@PathVariable("codTitulo") Long codTitulo) {
		TitTitulo titTitulo = tituloServicio.buscarTituloPorCodigo(codTitulo);
		// Respuesta
		ResponseGenerico<TitTitulo> response = new ResponseGenerico<>();
		response.setObjeto(titTitulo);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para guardar o actualizar Titulo
	 * 
	 * @return guardar
	 */
	@PostMapping(value = "guardarTitulo")
	public ResponseGenerico<TitTitulo> guardarTitulo(@RequestBody TitTitulo titTitulo) {
		TitTitulo titTituloAux = tituloServicio.registrar(titTitulo);
		// Respuesta
		ResponseGenerico<TitTitulo> response = new ResponseGenerico<>();
		response.setObjeto(titTituloAux);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * Metodo para eliminar (baja lógica) un registro
	 * 
	 * @return objeto response
	 */
	@DeleteMapping(value = "eliminarTituloPorId/{codTitulo}")
	public ResponseGenerico<TitTitulo> eliminarTitulo(@PathVariable("codTitulo") Long codTitulo) {
		TitTitulo titTitulo = tituloServicio.buscarTituloPorCodigo(codTitulo);
		titTitulo.setStsEstado(Constantes.REGISTRO_INACTIVO_NUM);
		tituloServicio.registrar(titTitulo);
		// Respuesta
		ResponseGenerico<TitTitulo> response = new ResponseGenerico<>();
		response.setObjeto(titTitulo);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
}
