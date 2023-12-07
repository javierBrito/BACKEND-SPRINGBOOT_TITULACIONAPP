package ec.gob.educacion.controlador.titulacion;

import ec.gob.educacion.model.TitConsejoEjec;
import ec.gob.educacion.model.constantes.Constantes;
import ec.gob.educacion.model.enumerator.EstadoEnum;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.ConsejoEjecServicio;
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
public class ConsejoEjecControlador {

	@Autowired
	private ConsejoEjecServicio consejoEjecServicio;

	@GetMapping(value = "listarTodosConsejosEjec")
	public ResponseGenerico<TitConsejoEjec> listarTodosConsejoEjec() {
		List<TitConsejoEjec> listaConsejoEjec = consejoEjecServicio.listarTodosConsejoEjec();
		// Respuesta
		ResponseGenerico<TitConsejoEjec> response = new ResponseGenerico<>();
		response.setListado(listaConsejoEjec);
		response.setTotalRegistros((long) listaConsejoEjec.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para listar TitConsejoEjec
	 * 
	 * @return lista de TitConsejoEjec
	 */
	@GetMapping(value = "listarConsejosEjecPorInstitucionYAnioLectivo/{insCodigo}/{reanleCodigo}")
	public ResponseGenerico<TitConsejoEjec> listarConsejosEjecPorInstitucionYAnioLectivo(
			@PathVariable("insCodigo") Long insCodigo,
			@PathVariable("reanleCodigo") Long reanleCodigo) {
		List<TitConsejoEjec> listaConsejoEjec = consejoEjecServicio
				.listarConsejosEjecPorInstitucionYAnioLectivo(insCodigo, reanleCodigo, EstadoEnum.ACTIVO.getCodigo());
		// Respuesta
		ResponseGenerico<TitConsejoEjec> response = new ResponseGenerico<>();
		response.setListado(listaConsejoEjec);
		response.setTotalRegistros((long) (listaConsejoEjec.size()));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para buscar TitConsejoEjec
	 * 
	 * @return TitConsejoEjec
	 */
	@GetMapping(value = "buscarConsejoEjecPorCodigo/{cejCodigo}")
	public ResponseGenerico<TitConsejoEjec> buscarConsejoEjecPorCodigo(
			@PathVariable("cejCodigo") Long cejCodigo) {
		TitConsejoEjec TitConsejoEjec = consejoEjecServicio.buscarConsejoEjecPorCodigo(cejCodigo);
		// Respuesta
		ResponseGenerico<TitConsejoEjec> response = new ResponseGenerico<>();
		response.setObjeto(TitConsejoEjec);;
		response.setTotalRegistros((long) 1);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para guardar o actualizar TitConsejoEjec por DTO
	 * 
	 * @return TitConsejoEjec DTO a guardar
	 */
	@PostMapping(value = "guardarConsejoEjec")
	public ResponseGenerico<TitConsejoEjec> guardarConsejoEjec(@RequestBody TitConsejoEjec titConsejoEjec) {
		TitConsejoEjec titConsejoEjecAux = consejoEjecServicio.guardarConsejoEjec(titConsejoEjec);
		// Respuesta
		ResponseGenerico<TitConsejoEjec> response = new ResponseGenerico<>();
		response.setObjeto(titConsejoEjecAux);
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
	@DeleteMapping(value = "eliminarConsejoEjecPorId/{cejCodigo}")
	public ResponseGenerico<TitConsejoEjec> eliminarConsejoEjec(@PathVariable("cejCodigo") Long cejCodigo){
		TitConsejoEjec titConsejoEjec = consejoEjecServicio.buscarConsejoEjecPorCodigo(cejCodigo);
		titConsejoEjec.setCejEstado(EstadoEnum.INACTIVO.getCodigo());	
		consejoEjecServicio.registrar(titConsejoEjec);	
		// Respuesta
		ResponseGenerico<TitConsejoEjec> response = new ResponseGenerico<>();
		response.setObjeto(titConsejoEjec);
		response.setTotalRegistros((long) 1);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_ELIMINADO);
		return response;
	}
}
