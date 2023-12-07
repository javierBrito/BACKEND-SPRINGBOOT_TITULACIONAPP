package ec.gob.educacion.controlador.titulacion;

import ec.gob.educacion.model.TitTipoTitulo;
import ec.gob.educacion.model.constantes.Constantes;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.TipoTituloServicio;
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
public class TipoTituloControlador {

	@Autowired
	private TipoTituloServicio tipoTituloServicio;

	@GetMapping(value = "listarTodosTipoTitulo")
	public ResponseGenerico<TitTipoTitulo> listarTodosTipoTitulo() {
		List<TitTipoTitulo> listaTipoTitulo = tipoTituloServicio.listarTodosTipoTitulo();
		// Respuesta
		ResponseGenerico<TitTipoTitulo> response = new ResponseGenerico<>();
		response.setListado(listaTipoTitulo);
		response.setTotalRegistros((long) listaTipoTitulo.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
	
	/**
	 * REST para obtener TitTipoTitulo
	 * 
	 * @return TitTipoTitulo
	 */
	@GetMapping(value = "buscarTipoTituloPorCodigo/{codTipoTitulo}")
	public ResponseGenerico<TitTipoTitulo> buscarTipoTituloPorCodigo(@PathVariable("codTipoTitulo") Long codTipoTitulo) {
		TitTipoTitulo titTipoTitulo = tipoTituloServicio.buscarTipoTituloPorCodigo(codTipoTitulo);
		// Respuesta
		ResponseGenerico<TitTipoTitulo> response = new ResponseGenerico<>();
		response.setObjeto(titTipoTitulo);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
	
	 /** REST para guardar o actualizar TipoTitulo
	 * 
	 * @return guardar
	 */
	@PostMapping(value = "guardarTipoTitulo")
	public ResponseGenerico<TitTipoTitulo> guardarTipoTitulo(@RequestBody TitTipoTitulo titTipoTitulo){
		TitTipoTitulo titTipoTituloAux = tipoTituloServicio.registrar(titTipoTitulo) ;
		// Respuesta
		ResponseGenerico<TitTipoTitulo> response = new ResponseGenerico<>();
		response.setObjeto(titTipoTituloAux);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * Metodo para eliminar (baja lógica) un registro
	 * 
	 * @return objeto response
	 */
	@DeleteMapping(value = "eliminarTipoTituloPorId/{codTipoTitulo}")
	public ResponseGenerico<TitTipoTitulo> eliminarTipoTitulo(@PathVariable("codTipoTitulo") Long codTipoTitulo){
		TitTipoTitulo titTipoTitulo = tipoTituloServicio.buscarTipoTituloPorCodigo(codTipoTitulo);
		titTipoTitulo.setStsEstado(Constantes.REGISTRO_INACTIVO_NUM);	
		tipoTituloServicio.registrar(titTipoTitulo);	
		// Respuesta
		ResponseGenerico<TitTipoTitulo> response = new ResponseGenerico<>();
		response.setObjeto(titTipoTitulo);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
}
