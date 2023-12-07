package ec.gob.educacion.controlador.titulacion;

import ec.gob.educacion.model.TitPromedio;
import ec.gob.educacion.model.constantes.Constantes;
import ec.gob.educacion.model.enumerator.EstadoEnum;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.PromedioServicio;
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
public class PromedioControlador {

	@Autowired
	private PromedioServicio promedioServicio;

	@GetMapping(value = "listarTodosPromedio")
	public ResponseGenerico<TitPromedio> listarTodosPromedio() {
		List<TitPromedio> listaPromedio = promedioServicio.listarTodosPromedio();
		// Respuesta
		ResponseGenerico<TitPromedio> response = new ResponseGenerico<>();
		response.setListado(listaPromedio);
		response.setTotalRegistros((long) listaPromedio.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para listar TitPromedio
	 * 
	 * @return lista de TitPromedio
	 */
	@GetMapping(value = "listarPromedioPorEstudiante/{estCodigo}")
	public ResponseGenerico<TitPromedio> listarPromedioPorEstudiante(
			@PathVariable("estCodigo") Long estCodigo) {
		List<TitPromedio> listaPromedio = promedioServicio
				.listarPromedioPorEstudiante(estCodigo, EstadoEnum.ACTIVO.getCodigo());
		// Respuesta
		ResponseGenerico<TitPromedio> response = new ResponseGenerico<>();
		response.setListado(listaPromedio);
		response.setTotalRegistros((long) (listaPromedio.size()));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para listar TitPromedio
	 * 
	 * @return lista de TitPromedio
	 */
	@GetMapping(value = "listarPromedioPorEstudianteYNemonico/{estCodigo}/{mprNemonico}")
	public ResponseGenerico<TitPromedio> listarPromedioPorEstudianteYNemonico(
			@PathVariable("estCodigo") Long estCodigo, @PathVariable("mprNemonico") String mprNemonico) {
		List<TitPromedio> listaPromedio = promedioServicio
				.listarPromedioPorEstudianteYNemonico(estCodigo, mprNemonico);
		// Respuesta
		ResponseGenerico<TitPromedio> response = new ResponseGenerico<>();
		response.setListado(listaPromedio);
		response.setTotalRegistros((long) (listaPromedio.size()));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para buscar TitPromedio
	 * 
	 * @return TitPromedio
	 */
	@GetMapping(value = "buscarPromedioPorCodigo/{proCodigo}")
	public ResponseGenerico<TitPromedio> buscarPromedioPorCodigo(
			@PathVariable("proCodigo") Long proCodigo) {
		TitPromedio TitPromedio = promedioServicio.buscarPromedioPorCodigo(proCodigo);
		// Respuesta
		ResponseGenerico<TitPromedio> response = new ResponseGenerico<>();
		response.setObjeto(TitPromedio);;
		response.setTotalRegistros((long) 1);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para guardar o actualizar TitPromedio por DTO
	 * 
	 * @return TitPromedio DTO a guardar
	 */
	@PostMapping(value = "guardarPromedio")
	public ResponseGenerico<TitPromedio> guardarPromedio(@RequestBody TitPromedio titPromedio) {
		TitPromedio titPromedioAux = promedioServicio.guardarPromedio(titPromedio);
		// Respuesta
		ResponseGenerico<TitPromedio> response = new ResponseGenerico<>();
		response.setObjeto(titPromedioAux);
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
	@DeleteMapping(value = "eliminarPromedioPorId/{proCodigo}")
	public ResponseGenerico<TitPromedio> eliminarPromedio(@PathVariable("proCodigo") Long proCodigo){
		TitPromedio titPromedio = promedioServicio.buscarPromedioPorCodigo(proCodigo);
		titPromedio.setProEstado(EstadoEnum.INACTIVO.getCodigo());	
		promedioServicio.guardarPromedio(titPromedio);	
		// Respuesta
		ResponseGenerico<TitPromedio> response = new ResponseGenerico<>();
		response.setObjeto(titPromedio);
		response.setTotalRegistros((long) 1);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_ELIMINADO);
		return response;
	}
}
