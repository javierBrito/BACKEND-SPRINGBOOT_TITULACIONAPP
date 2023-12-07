package ec.gob.educacion.controlador.titulacion;

import ec.gob.educacion.model.TitModeloCalificacion;
import ec.gob.educacion.model.constantes.Constantes;
import ec.gob.educacion.model.enumerator.EstadoEnum;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.ModeloCalificacionServicio;
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
public class ModeloCalificacionControlador {

	@Autowired
	private ModeloCalificacionServicio modeloCalificacionServicio;

	@GetMapping(value = "listarTodosModeloCalificacion")
	public ResponseGenerico<TitModeloCalificacion> listarTodosModeloCalificacion() {
		List<TitModeloCalificacion> listaModeloCalificacion = modeloCalificacionServicio.listarTodosModeloCalificacion();
		// Respuesta
		ResponseGenerico<TitModeloCalificacion> response = new ResponseGenerico<>();
		response.setListado(listaModeloCalificacion);
		response.setTotalRegistros((long) listaModeloCalificacion.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para listar TitModeloCalificacion
	 * 
	 * @return lista de TitModeloCalificacion
	 */
	@GetMapping(value = "listarModeloCalificacionPorRegAniLecYTipoEducacion/{reanleCodigo}/{tipeduCodigo}")
	public ResponseGenerico<TitModeloCalificacion> listarModeloCalificacionPorRegAniLecYTipoEducacion(
			@PathVariable("reanleCodigo") Long reanleCodigo,
			@PathVariable("tipeduCodigo") Long tipeduCodigo) {
		List<TitModeloCalificacion> listaModeloCalificacion = modeloCalificacionServicio
				.listarModeloCalificacionPorRegAniLecYTipoEducacion(reanleCodigo, tipeduCodigo, EstadoEnum.ACTIVO.getCodigo());
		// Respuesta
		ResponseGenerico<TitModeloCalificacion> response = new ResponseGenerico<>();
		response.setListado(listaModeloCalificacion);
		response.setTotalRegistros((long) (listaModeloCalificacion.size()));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para listar TitModeloCalificacion
	 * 
	 * @return lista de TitModeloCalificacion
	 */
	@GetMapping(value = "listarModeloCalificacionPorRegAniLec/{reanleCodigo}")
	public ResponseGenerico<TitModeloCalificacion> listarModeloCalificacionPorRegAniLec(
			@PathVariable("reanleCodigo") Long reanleCodigo) {
		List<TitModeloCalificacion> listaModeloCalificacion = modeloCalificacionServicio
				.listarModeloCalificacionPorRegAniLec(reanleCodigo, EstadoEnum.ACTIVO.getCodigo());
		// Respuesta
		ResponseGenerico<TitModeloCalificacion> response = new ResponseGenerico<>();
		response.setListado(listaModeloCalificacion);
		response.setTotalRegistros((long) (listaModeloCalificacion.size()));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
	/**
	 * REST para buscar TitModeloCalificacion
	 * 
	 * @return TitModeloCalificacion
	 */
	@GetMapping(value = "buscarModeloCalificacionPorCodigo/{mcaCodigo}")
	public ResponseGenerico<TitModeloCalificacion> buscarModeloCalificacionPorCodigo(
			@PathVariable("mcaCodigo") Long mcaCodigo) {
		TitModeloCalificacion titModeloCalificacion = modeloCalificacionServicio.buscarModeloCalificacionPorCodigo(mcaCodigo);
		// Respuesta
		ResponseGenerico<TitModeloCalificacion> response = new ResponseGenerico<>();
		response.setObjeto(titModeloCalificacion);;
		response.setTotalRegistros((long) 1);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para guardar o actualizar TitModeloCalificacion por DTO
	 * 
	 * @return TitModeloCalificacion DTO a guardar
	 */
	@PostMapping(value = "guardarModeloCalificacion")
	public ResponseGenerico<TitModeloCalificacion> guardarModeloCalificacion(@RequestBody TitModeloCalificacion TitModeloCalificacion) {
		TitModeloCalificacion titModeloCalificacionAux = modeloCalificacionServicio.guardarModeloCalificacion(TitModeloCalificacion);
		// Respuesta
		ResponseGenerico<TitModeloCalificacion> response = new ResponseGenerico<>();
		response.setObjeto(titModeloCalificacionAux);
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
	@DeleteMapping(value = "eliminarModeloCalificacionPorId/{mcaCodigo}")
	public ResponseGenerico<TitModeloCalificacion> eliminarModeloCalificacion(@PathVariable("mcaCodigo") Long mcaCodigo){
		TitModeloCalificacion titModeloCalificacion = modeloCalificacionServicio.buscarModeloCalificacionPorCodigo(mcaCodigo);
		titModeloCalificacion.setMcaEstado(EstadoEnum.INACTIVO.getCodigo());	
		modeloCalificacionServicio.guardarModeloCalificacion(titModeloCalificacion);	
		// Respuesta
		ResponseGenerico<TitModeloCalificacion> response = new ResponseGenerico<>();
		response.setObjeto(titModeloCalificacion);
		response.setTotalRegistros((long) 1);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_ELIMINADO);
		return response;
	}
}
