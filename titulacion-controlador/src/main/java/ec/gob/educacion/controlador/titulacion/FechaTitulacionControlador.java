package ec.gob.educacion.controlador.titulacion;

import ec.gob.educacion.model.TitFechaTitulacion;
import ec.gob.educacion.model.constantes.Constantes;
import ec.gob.educacion.model.enumerator.EstadoEnum;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.FechaTitulacionServicio;
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
public class FechaTitulacionControlador {

	@Autowired
	private FechaTitulacionServicio fechaTitulacionServicio;

	@GetMapping(value = "listarTodosFechaTitulacion")
	public ResponseGenerico<TitFechaTitulacion> listarTodosFechaTitulacion() {
		List<TitFechaTitulacion> listaFechaTitulacion = fechaTitulacionServicio.listarTodosFechaTitulacion();
		// Respuesta
		ResponseGenerico<TitFechaTitulacion> response = new ResponseGenerico<>();
		response.setListado(listaFechaTitulacion);
		response.setTotalRegistros((long) listaFechaTitulacion.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
	
	@GetMapping(value = "listarFechaTitulacionActivo")
	public ResponseGenerico<TitFechaTitulacion> listarFechaTitulacionActivo() {
		List<TitFechaTitulacion> listaFechaTitulacion = fechaTitulacionServicio.listarFechaTitulacionActivo(EstadoEnum.ACTIVO.getCodigo());
		// Respuesta
		ResponseGenerico<TitFechaTitulacion> response = new ResponseGenerico<>();
		response.setListado(listaFechaTitulacion);
		response.setTotalRegistros((long) listaFechaTitulacion.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
	
	/**
	 * REST para listar TitFechaTitulacion
	 * 
	 * @return lista de TitFechaTitulacion
	 */
	@GetMapping(value = "listarFechaTitulacionPorRegAniLecYTipoEducacion/{reanleCodigo}/{tipeduCodigo}")
	public ResponseGenerico<TitFechaTitulacion> listarFechaTitulacionPorRegAniLecYTipoEducacion(
			@PathVariable("reanleCodigo") Long reanleCodigo,
			@PathVariable("tipeduCodigo") Long tipeduCodigo) {
		List<TitFechaTitulacion> listaFechaTitulacion = fechaTitulacionServicio
				.listarFechaTitulacionPorRegAniLecYTipoEducacion(reanleCodigo, tipeduCodigo, EstadoEnum.ACTIVO.getCodigo());
		// Respuesta
		ResponseGenerico<TitFechaTitulacion> response = new ResponseGenerico<>();
		response.setListado(listaFechaTitulacion);
		response.setTotalRegistros((long) (listaFechaTitulacion.size()));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para buscar TitFechaTitulacion
	 * 
	 * @return TitFechaTitulacion
	 */
	@GetMapping(value = "buscarFechaTitulacionPorCodigo/{ftiCodigo}")
	public ResponseGenerico<TitFechaTitulacion> buscarFechaTitulacionPorCodigo(
			@PathVariable("ftiCodigo") Long ftiCodigo) {
		TitFechaTitulacion titFechaTitulacion = fechaTitulacionServicio.buscarFechaTitulacionPorCodigo(ftiCodigo);
		// Respuesta
		ResponseGenerico<TitFechaTitulacion> response = new ResponseGenerico<>();
		response.setObjeto(titFechaTitulacion);;
		response.setTotalRegistros((long) 1);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para guardar o actualizar TitFechaTitulacion por DTO
	 * 
	 * @return TitFechaTitulacion DTO a guardar
	 */
	@PostMapping(value = "guardarFechaTitulacion")
	public ResponseGenerico<TitFechaTitulacion> guardarFechaTitulacion(@RequestBody TitFechaTitulacion TitFechaTitulacion) {
		TitFechaTitulacion titFechaTitulacionAux = fechaTitulacionServicio.guardarFechaTitulacion(TitFechaTitulacion);
		// Respuesta
		ResponseGenerico<TitFechaTitulacion> response = new ResponseGenerico<>();
		response.setObjeto(titFechaTitulacionAux);
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
	@DeleteMapping(value = "eliminarFechaTitulacionPorId/{ftiCodigo}")
	public ResponseGenerico<TitFechaTitulacion> eliminarFechaTitulacion(@PathVariable("ftiCodigo") Long ftiCodigo){
		TitFechaTitulacion titFechaTitulacion = fechaTitulacionServicio.buscarFechaTitulacionPorCodigo(ftiCodigo);
		titFechaTitulacion.setFtiEstado(EstadoEnum.INACTIVO.getCodigo());	
		fechaTitulacionServicio.registrar(titFechaTitulacion);	
		// Respuesta
		ResponseGenerico<TitFechaTitulacion> response = new ResponseGenerico<>();
		response.setObjeto(titFechaTitulacion);
		response.setTotalRegistros((long) 1);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_ELIMINADO);
		return response;
	}
}
