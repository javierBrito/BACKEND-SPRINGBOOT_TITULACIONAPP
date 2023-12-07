package ec.gob.educacion.controlador.titulacion;

import ec.gob.educacion.model.TitModeloPromedio;
import ec.gob.educacion.model.constantes.Constantes;
import ec.gob.educacion.model.enumerator.EstadoEnum;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.ModeloPromedioServicio;
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
public class ModeloPromedioControlador {

	@Autowired
	private ModeloPromedioServicio modeloPromedioServicio;

	@GetMapping(value = "listarTodosModeloPromedio")
	public ResponseGenerico<TitModeloPromedio> listarTodosModeloPromedio() {
		List<TitModeloPromedio> listaModeloPromedio = modeloPromedioServicio.listarTodosModeloPromedio();
		// Respuesta
		ResponseGenerico<TitModeloPromedio> response = new ResponseGenerico<>();
		response.setListado(listaModeloPromedio);
		response.setTotalRegistros((long) listaModeloPromedio.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para listar TitModeloPromedio
	 * 
	 * @return lista de TitModeloPromedio
	 */
	@GetMapping(value = "listarModeloPromedioPorRegAniLecYTipoEducacion/{reanleCodigo}/{tipeduCodigo}")
	public ResponseGenerico<TitModeloPromedio> listarModeloPromedioPorRegAniLecYTipoEducacion(
			@PathVariable("reanleCodigo") Long reanleCodigo,
			@PathVariable("tipeduCodigo") Long tipeduCodigo) {
		List<TitModeloPromedio> listaModeloPromedio = modeloPromedioServicio
				.listarModeloPromedioPorRegAniLecYTipoEducacion(reanleCodigo, tipeduCodigo, EstadoEnum.ACTIVO.getCodigo());
		// Respuesta
		ResponseGenerico<TitModeloPromedio> response = new ResponseGenerico<>();
		response.setListado(listaModeloPromedio);
		response.setTotalRegistros((long) (listaModeloPromedio.size()));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para listar TitModeloPromedio
	 * 
	 * @return lista de TitModeloPromedio
	 */
	@GetMapping(value = "listarModeloPromedioPorRegAniLec/{reanleCodigo}")
	public ResponseGenerico<TitModeloPromedio> listarModeloPromedioPorRegAniLec(
			@PathVariable("reanleCodigo") Long reanleCodigo) {
		List<TitModeloPromedio> listaModeloPromedio = modeloPromedioServicio
				.listarModeloPromedioPorRegAniLec(reanleCodigo, EstadoEnum.ACTIVO.getCodigo());
		// Respuesta
		ResponseGenerico<TitModeloPromedio> response = new ResponseGenerico<>();
		response.setListado(listaModeloPromedio);
		response.setTotalRegistros((long) (listaModeloPromedio.size()));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
	/**
	 * REST para buscar TitModeloPromedio
	 * 
	 * @return TitModeloPromedio
	 */
	@GetMapping(value = "buscarModeloPromedioPorCodigo/{mprCodigo}")
	public ResponseGenerico<TitModeloPromedio> buscarModeloPromedioPorCodigo(
			@PathVariable("mprCodigo") Long mprCodigo) {
		TitModeloPromedio titModeloPromedio = modeloPromedioServicio.buscarModeloPromedioPorCodigo(mprCodigo);
		// Respuesta
		ResponseGenerico<TitModeloPromedio> response = new ResponseGenerico<>();
		response.setObjeto(titModeloPromedio);;
		response.setTotalRegistros((long) 1);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para guardar o actualizar TitModeloPromedio por DTO
	 * 
	 * @return TitModeloPromedio DTO a guardar
	 */
	@PostMapping(value = "guardarModeloPromedio")
	public ResponseGenerico<TitModeloPromedio> guardarModeloPromedio(@RequestBody TitModeloPromedio TitModeloPromedio) {
		TitModeloPromedio titModeloPromedioAux = modeloPromedioServicio.guardarModeloPromedio(TitModeloPromedio);
		// Respuesta
		ResponseGenerico<TitModeloPromedio> response = new ResponseGenerico<>();
		response.setObjeto(titModeloPromedioAux);
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
	@DeleteMapping(value = "eliminarModeloPromedioPorId/{mprCodigo}")
	public ResponseGenerico<TitModeloPromedio> eliminarModeloPromedio(@PathVariable("mprCodigo") Long mprCodigo){
		TitModeloPromedio titModeloPromedio = modeloPromedioServicio.buscarModeloPromedioPorCodigo(mprCodigo);
		titModeloPromedio.setMprEstado(EstadoEnum.INACTIVO.getCodigo());	
		modeloPromedioServicio.guardarModeloPromedio(titModeloPromedio);	
		// Respuesta
		ResponseGenerico<TitModeloPromedio> response = new ResponseGenerico<>();
		response.setObjeto(titModeloPromedio);
		response.setTotalRegistros((long) 1);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_ELIMINADO);
		return response;
	}
}
