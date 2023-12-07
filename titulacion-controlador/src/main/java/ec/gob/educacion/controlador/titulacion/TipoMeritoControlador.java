package ec.gob.educacion.controlador.titulacion;

import ec.gob.educacion.model.TitTipoMerito;
import ec.gob.educacion.model.constantes.Constantes;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.TipoMeritoServicio;
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
public class TipoMeritoControlador {

	@Autowired
	private TipoMeritoServicio tipoMeritoServicio;

	@GetMapping(value = "listarTodosTipoMerito")
	public ResponseGenerico<TitTipoMerito> listarTodosTipoMerito() {
		List<TitTipoMerito> listaTipoMerito = tipoMeritoServicio.listarTodosTipoMerito();
		// Respuesta
		ResponseGenerico<TitTipoMerito> response = new ResponseGenerico<>();
		response.setListado(listaTipoMerito);
		response.setTotalRegistros((long) listaTipoMerito.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
	
	/**
	 * REST para obtener TitTipoMerito
	 * 
	 * @return TitTipoMerito
	 */
	@GetMapping(value = "buscarTipoMeritoPorCodigo/{codTipoMerito}")
	public ResponseGenerico<TitTipoMerito> buscarTipoMeritoPorCodigo(@PathVariable("codTipoMerito") Long codTipoMerito) {
		TitTipoMerito titTipoMerito = tipoMeritoServicio.buscarTipoMeritoPorCodigo(codTipoMerito);
		// Respuesta
		ResponseGenerico<TitTipoMerito> response = new ResponseGenerico<>();
		response.setObjeto(titTipoMerito);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
	
	 /** REST para guardar o actualizar TipoMerito
	 * 
	 * @return guardar
	 */
	@PostMapping(value = "guardarTipoMerito")
	public ResponseGenerico<TitTipoMerito> guardarTipoMerito(@RequestBody TitTipoMerito titTipoMerito){
		TitTipoMerito titTipoMeritoAux = tipoMeritoServicio.registrar(titTipoMerito) ;
		// Respuesta
		ResponseGenerico<TitTipoMerito> response = new ResponseGenerico<>();
		response.setObjeto(titTipoMeritoAux);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * Metodo para eliminar (baja lógica) un registro
	 * 
	 * @return objeto response
	 */
	@DeleteMapping(value = "eliminarTipoMeritoPorId/{codTipoMerito}")
	public ResponseGenerico<TitTipoMerito> eliminarTipoMerito(@PathVariable("codTipoMerito") Long codTipoMerito){
		TitTipoMerito titTipoMerito = tipoMeritoServicio.buscarTipoMeritoPorCodigo(codTipoMerito);
		//titTipoMerito.set(Constantes.REGISTRO_INACTIVO_NUM);	
		tipoMeritoServicio.registrar(titTipoMerito);	
		// Respuesta
		ResponseGenerico<TitTipoMerito> response = new ResponseGenerico<>();
		response.setObjeto(titTipoMerito);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
}
