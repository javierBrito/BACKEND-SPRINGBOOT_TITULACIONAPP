package ec.gob.educacion.controlador.titulacion;

import ec.gob.educacion.model.TitTitulado;
import ec.gob.educacion.model.constantes.Constantes;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.TituladoServicio;
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
public class TituladoControlador {

	@Autowired
	private TituladoServicio tituladoServicio;

	@GetMapping(value = "listarTodosTitulado")
	public ResponseGenerico<TitTitulado> listarTodosTitulado() {
		List<TitTitulado> listaTitulado = tituladoServicio.listarTodosTitulado();
		// Respuesta
		ResponseGenerico<TitTitulado> response = new ResponseGenerico<>();
		response.setListado(listaTitulado);
		response.setTotalRegistros((long) listaTitulado.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
	
	/**
	 * REST para obtener TitTitulado
	 * 
	 * @return TitTitulado
	 */
	@GetMapping(value = "buscarTituladoPorCodigo/{codTitulado}")
	public ResponseGenerico<TitTitulado> buscarTituladoPorCodigo(@PathVariable("codTitulado") Long codTitulado) {
		TitTitulado titTitulado = tituladoServicio.buscarTituladoPorCodigo(codTitulado);
		// Respuesta
		ResponseGenerico<TitTitulado> response = new ResponseGenerico<>();
		response.setObjeto(titTitulado);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
	
	 /** REST para guardar o actualizar Titulado
	 * 
	 * @return guardar
	 */
	@PostMapping(value = "guardarTitulado")
	public ResponseGenerico<TitTitulado> guardarTitulado(@RequestBody TitTitulado titTitulado){
		TitTitulado titTituladoAux = tituladoServicio.registrar(titTitulado) ;
		// Respuesta
		ResponseGenerico<TitTitulado> response = new ResponseGenerico<>();
		response.setObjeto(titTituladoAux);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * Metodo para eliminar (baja lógica) un registro
	 * 
	 * @return objeto response
	 */
	@DeleteMapping(value = "eliminarTituladoPorId/{codTitulado}")
	public ResponseGenerico<TitTitulado> eliminarTitulado(@PathVariable("codTitulado") Long codTitulado){
		TitTitulado titTitulado = tituladoServicio.buscarTituladoPorCodigo(codTitulado);
		titTitulado.setStsEstado(Constantes.REGISTRO_INACTIVO_NUM);	
		tituladoServicio.registrar(titTitulado);	
		// Respuesta
		ResponseGenerico<TitTitulado> response = new ResponseGenerico<>();
		response.setObjeto(titTitulado);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
}
