package ec.gob.educacion.controlador.titulacion;

import ec.gob.educacion.model.TitEstadoCal;
import ec.gob.educacion.model.constantes.Constantes;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.EstadoCalServicio;
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
public class EstadoCalControlador {

	@Autowired
	private EstadoCalServicio estadoCalServicio;

	@GetMapping(value = "listarTodosEstadoCal")
	public ResponseGenerico<TitEstadoCal> listarTodosEstadoCal() {
		List<TitEstadoCal> listaEstadoCal = estadoCalServicio.listarTodosEstadoCal();
		// Respuesta
		ResponseGenerico<TitEstadoCal> response = new ResponseGenerico<>();
		response.setListado(listaEstadoCal);
		response.setTotalRegistros((long) listaEstadoCal.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
	
	/**
	 * REST para obtener TitEstadoCal
	 * 
	 * @return TitEstadoCal
	 */
	@GetMapping(value = "buscarEstadoCalPorCodigo/{codEstadoCal}")
	public ResponseGenerico<TitEstadoCal> buscarEstadoCalPorCodigo(@PathVariable("codEstadoCal") Long codEstadoCal) {
		TitEstadoCal titEstadoCal = estadoCalServicio.buscarEstadoCalPorCodigo(codEstadoCal);
		// Respuesta
		ResponseGenerico<TitEstadoCal> response = new ResponseGenerico<>();
		response.setObjeto(titEstadoCal);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
	
	 /** REST para guardar o actualizar EstadoCal
	 * 
	 * @return guardar
	 */
	@PostMapping(value = "guardarEstadoCal")
	public ResponseGenerico<TitEstadoCal> guardarEstadoCal(@RequestBody TitEstadoCal titEstadoCal){
		TitEstadoCal titEstadoCalAux = estadoCalServicio.registrar(titEstadoCal) ;
		// Respuesta
		ResponseGenerico<TitEstadoCal> response = new ResponseGenerico<>();
		response.setObjeto(titEstadoCalAux);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * Metodo para eliminar (baja lógica) un registro
	 * 
	 * @return objeto response
	 */
	@DeleteMapping(value = "eliminarEstadoCalPorId/{codEstadoCal}")
	public ResponseGenerico<TitEstadoCal> eliminarEstadoCal(@PathVariable("codEstadoCal") Long codEstadoCal){
		TitEstadoCal titEstadoCal = estadoCalServicio.buscarEstadoCalPorCodigo(codEstadoCal);
		//titEstadoCal.set(Constantes.REGISTRO_INACTIVO_NUM);	
		estadoCalServicio.registrar(titEstadoCal);	
		// Respuesta
		ResponseGenerico<TitEstadoCal> response = new ResponseGenerico<>();
		response.setObjeto(titEstadoCal);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
}
