package ec.gob.educacion.controlador.titulacion;

import ec.gob.educacion.model.TitAutoridad;
import ec.gob.educacion.model.constantes.Constantes;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.AutoridadServicio;
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
public class AutoridadControlador {

	@Autowired
	private AutoridadServicio autoridadServicio;

	@GetMapping(value = "listarTodosAutoridad")
	public ResponseGenerico<TitAutoridad> listarTodosAutoridad() {
		List<TitAutoridad> listaAutoridad = autoridadServicio.listarTodosAutoridad();
		// Respuesta
		ResponseGenerico<TitAutoridad> response = new ResponseGenerico<>();
		response.setListado(listaAutoridad);
		response.setTotalRegistros((long) listaAutoridad.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para listar TitAutoridad
	 * 
	 * @return lista de TitAutoridad
	 */
	@GetMapping(value = "listarAutoridadPorInstitucion/{codInstitucion}")
	public ResponseGenerico<TitAutoridad> listarAutoridadPorInstitucion(
			@PathVariable("codInstitucion") Long codInstitucion) {
		List<TitAutoridad> listaTitAutoridad = autoridadServicio.listarAutoridadPorInstitucion(codInstitucion);
		// Respuesta
		ResponseGenerico<TitAutoridad> response = new ResponseGenerico<>();
		response.setListado(listaTitAutoridad);
		response.setTotalRegistros((long) (listaTitAutoridad.size()));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
	
	/**
	 * REST para obtener TitAutoridad
	 * 
	 * @return TitAutoridad
	 */
	@GetMapping(value = "buscarAutoridadPorCodigo/{codAutoridad}")
	public ResponseGenerico<TitAutoridad> buscarAutoridadPorCodigo(
			@PathVariable("codAutoridad") Long codAutoridad) {
		TitAutoridad titAutoridad = autoridadServicio.buscarAutoridadPorCodigo(codAutoridad);
		// Respuesta
		ResponseGenerico<TitAutoridad> response = new ResponseGenerico<>();
		response.setObjeto(titAutoridad);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
	
	 /** REST para guardar o actualizar autoridad
	 * 
	 * @return guardar
	 */
	@PostMapping(value = "guardarAutoridad")
	public ResponseGenerico<TitAutoridad> guardarAutoridad(@RequestBody TitAutoridad titAutoridad){
		TitAutoridad titAutoridadAux = autoridadServicio.registrar(titAutoridad) ;
		// Respuesta
		ResponseGenerico<TitAutoridad> response = new ResponseGenerico<>();
		response.setObjeto(titAutoridadAux);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * Metodo para eliminar (baja lógica) un registro
	 * 
	 * @return objeto response
	 */
	@DeleteMapping(value = "eliminarAutoridadPorId/{codAutoridad}")
	public ResponseGenerico<TitAutoridad> eliminarAutoridad(@PathVariable("codAutoridad") Long codAutoridad){
		TitAutoridad titAutoridad = autoridadServicio.buscarAutoridadPorCodigo(codAutoridad);
		titAutoridad.setStsEstado(Constantes.REGISTRO_INACTIVO_NUM);	
		autoridadServicio.registrar(titAutoridad);
		// Respuesta
		ResponseGenerico<TitAutoridad> response = new ResponseGenerico<>();
		response.setObjeto(titAutoridad);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

}
