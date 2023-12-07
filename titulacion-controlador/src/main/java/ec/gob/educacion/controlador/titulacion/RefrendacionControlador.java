package ec.gob.educacion.controlador.titulacion;

import ec.gob.educacion.model.TitRefrendacion;
import ec.gob.educacion.model.constantes.Constantes;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.RefrendacionServicio;
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
public class RefrendacionControlador {

	@Autowired
	private RefrendacionServicio refrendacionServicio;

	@GetMapping(value = "listarTodosRefrendacion")
	public ResponseGenerico<TitRefrendacion> listarTodosRefrendacion() {
		List<TitRefrendacion> listaRefrendacion = refrendacionServicio.listarTodosRefrendacion();
		// Respuesta
		ResponseGenerico<TitRefrendacion> response = new ResponseGenerico<>();
		response.setListado(listaRefrendacion);
		response.setTotalRegistros((long) listaRefrendacion.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
	
	/**
	 * REST para obtener TitRefrendacion
	 * 
	 * @return TitRefrendacion
	 */
	@GetMapping(value = "buscarRefrendacionPorCodigo/{codRefrendacion}")
	public ResponseGenerico<TitRefrendacion> buscarRefrendacionPorCodigo(@PathVariable("codRefrendacion") Long codRefrendacion) {
		TitRefrendacion titRefrendacion = refrendacionServicio.buscarRefrendacionPorCodigo(codRefrendacion);
		// Respuesta
		ResponseGenerico<TitRefrendacion> response = new ResponseGenerico<>();
		response.setObjeto(titRefrendacion);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
	
	 /** REST para guardar o actualizar Refrendacion
	 * 
	 * @return guardar
	 */
	@PostMapping(value = "guardarRefrendacion")
	public ResponseGenerico<TitRefrendacion> guardarRefrendacion(@RequestBody TitRefrendacion titRefrendacion){
		TitRefrendacion titRefrendacionAux = refrendacionServicio.registrar(titRefrendacion) ;
		// Respuesta
		ResponseGenerico<TitRefrendacion> response = new ResponseGenerico<>();
		response.setObjeto(titRefrendacionAux);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * Metodo para eliminar (baja lógica) un registro
	 * 
	 * @return objeto response
	 */
	@DeleteMapping(value = "eliminarRefrendacionPorId/{codRefrendacion}")
	public ResponseGenerico<TitRefrendacion> eliminarRefrendacion(@PathVariable("codRefrendacion") Long codRefrendacion){
		TitRefrendacion titRefrendacion = refrendacionServicio.buscarRefrendacionPorCodigo(codRefrendacion);
		//titRefrendacion.set(Constantes.REGISTRO_INACTIVO_NUM);	
		refrendacionServicio.registrar(titRefrendacion);	
		// Respuesta
		ResponseGenerico<TitRefrendacion> response = new ResponseGenerico<>();
		response.setObjeto(titRefrendacion);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
}
