package ec.gob.educacion.controlador.titulacion;

import ec.gob.educacion.model.TitCalificacion;
import ec.gob.educacion.model.constantes.Constantes;
import ec.gob.educacion.model.enumerator.EstadoEnum;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.CalificacionServicio;
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
public class CalificacionControlador {

	@Autowired
	private CalificacionServicio calificacionServicio;

	@GetMapping(value = "listarTodosCalificacion")
	public ResponseGenerico<TitCalificacion> listarTodosCalificacion() {
		List<TitCalificacion> listaCalificacion = calificacionServicio.listarTodosCalificacion();
		// Respuesta
		ResponseGenerico<TitCalificacion> response = new ResponseGenerico<>();
		response.setListado(listaCalificacion);
		response.setTotalRegistros((long) listaCalificacion.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para listar TitCalificacion
	 * 
	 * @return lista de TitCalificacion
	 */
	@GetMapping(value = "listarCalificacionPorEstudiante/{estCodigo}")
	public ResponseGenerico<TitCalificacion> listarCalificacionPorEstudianteYRegAniLec(
			@PathVariable("estCodigo") Long estCodigo) {
		List<TitCalificacion> listaCalificacion = calificacionServicio
				.listarCalificacionPorEstudiante(estCodigo, EstadoEnum.ACTIVO.getCodigo());
		// Respuesta
		ResponseGenerico<TitCalificacion> response = new ResponseGenerico<>();
		response.setListado(listaCalificacion);
		response.setTotalRegistros((long) (listaCalificacion.size()));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para buscar TitCalificacion
	 * 
	 * @return TitCalificacion
	 */
	@GetMapping(value = "buscarCalificacionPorCodigo/{calCodigo}")
	public ResponseGenerico<TitCalificacion> buscarCalificacionPorCodigo(
			@PathVariable("calCodigo") Long calCodigo) {
		TitCalificacion TitCalificacion = calificacionServicio.buscarCalificacionPorCodigo(calCodigo);
		// Respuesta
		ResponseGenerico<TitCalificacion> response = new ResponseGenerico<>();
		response.setObjeto(TitCalificacion);;
		response.setTotalRegistros((long) 1);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para guardar o actualizar TitCalificacion por DTO
	 * 
	 * @return TitCalificacion DTO a guardar
	 */
	@PostMapping(value = "guardarCalificacion")
	public ResponseGenerico<TitCalificacion> guardarCalificacion(@RequestBody TitCalificacion titCalificacion) {
		TitCalificacion titCalificacionAux = calificacionServicio.guardarCalificacion(titCalificacion);
		// Respuesta
		ResponseGenerico<TitCalificacion> response = new ResponseGenerico<>();
		response.setObjeto(titCalificacionAux);
		response.setTotalRegistros((long) 1);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_CREADO);
		return response;
	}
	
	/**
	 * Metodo para eliminar (baja lógica) un registro
	 * 
	 * @return objeto response
	 */
	@DeleteMapping(value = "eliminarCalificacionPorId/{calCodigo}")
	public ResponseGenerico<TitCalificacion> eliminarCalificacion(@PathVariable("calCodigo") Long calCodigo){
		TitCalificacion titCalificacion = calificacionServicio.buscarCalificacionPorCodigo(calCodigo);
		titCalificacion.setCalEstado(EstadoEnum.INACTIVO.getCodigo());	
		calificacionServicio.guardarCalificacion(titCalificacion);	
		// Respuesta
		ResponseGenerico<TitCalificacion> response = new ResponseGenerico<>();
		response.setObjeto(titCalificacion);
		response.setTotalRegistros((long) 1);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_ELIMINADO);
		return response;
	}
}
