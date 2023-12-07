package ec.gob.educacion.controlador.titulacion;

import ec.gob.educacion.model.TitParticipacionEst;
import ec.gob.educacion.model.constantes.Constantes;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.ParticipacionEstServicio;
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
public class ParticipacionEstControlador {

	@Autowired
	private ParticipacionEstServicio participacionEstServicio;

	@GetMapping(value = "listarTodosParticipacionEst")
	public ResponseGenerico<TitParticipacionEst> listarTodosParticipacionEst() {
		List<TitParticipacionEst> listaParticipacionEst = participacionEstServicio.listarTodosParticipacionEst();
		// Respuesta
		ResponseGenerico<TitParticipacionEst> response = new ResponseGenerico<>();
		response.setListado(listaParticipacionEst);
		response.setTotalRegistros((long) listaParticipacionEst.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
	
	/**
	 * REST para obtener TitParticipacionEst
	 * 
	 * @return TitParticipacionEst
	 */
	@GetMapping(value = "buscarParticipacionEstPorCodigo/{codParticipacionEst}")
	public ResponseGenerico<TitParticipacionEst> buscarParticipacionEstPorCodigo(@PathVariable("codParticipacionEst") Long codParticipacionEst) {
		TitParticipacionEst titParticipacionEst = participacionEstServicio.buscarParticipacionEstPorCodigo(codParticipacionEst);
		// Respuesta
		ResponseGenerico<TitParticipacionEst> response = new ResponseGenerico<>();
		response.setObjeto(titParticipacionEst);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
	
	 /** REST para guardar o actualizar ParticipacionEst
	 * 
	 * @return guardar
	 */
	@PostMapping(value = "guardarParticipacionEst")
	public ResponseGenerico<TitParticipacionEst> guardarParticipacionEst(@RequestBody TitParticipacionEst titParticipacionEst){
		TitParticipacionEst titParticipacionEstAux = participacionEstServicio.registrar(titParticipacionEst) ;
		// Respuesta
		ResponseGenerico<TitParticipacionEst> response = new ResponseGenerico<>();
		response.setObjeto(titParticipacionEstAux);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * Metodo para eliminar (baja lógica) un registro
	 * 
	 * @return objeto response
	 */
	@DeleteMapping(value = "eliminarParticipacionEstPorId/{codParticipacionEst}")
	public ResponseGenerico<TitParticipacionEst> eliminarParticipacionEst(@PathVariable("codParticipacionEst") Long codParticipacionEst){
		TitParticipacionEst titParticipacionEst = participacionEstServicio.buscarParticipacionEstPorCodigo(codParticipacionEst);
		//titParticipacionEst.set(Constantes.REGISTRO_INACTIVO_NUM);	
		participacionEstServicio.registrar(titParticipacionEst);	
		// Respuesta
		ResponseGenerico<TitParticipacionEst> response = new ResponseGenerico<>();
		response.setObjeto(titParticipacionEst);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

}
