package ec.gob.educacion.controlador.titulacion;

import ec.gob.educacion.model.TitEspecialidad;
import ec.gob.educacion.model.constantes.Constantes;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.EspecialidadServicio;
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
public class EspecialidadControlador {

	@Autowired
	private EspecialidadServicio especialidadServicio;

	@GetMapping(value = "listarTodosEspecialidad")
	public ResponseGenerico<TitEspecialidad> listarTodosEspecialidad() {
		List<TitEspecialidad> listaEspecialidad = especialidadServicio.listarTodosEspecialidad();
		// Respuesta
		ResponseGenerico<TitEspecialidad> response = new ResponseGenerico<>();
		response.setListado(listaEspecialidad);
		response.setTotalRegistros((long) listaEspecialidad.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para listar TitEspecialidad
	 * 
	 * @return lista de TitEspecialidad
	 */
	@GetMapping(value = "listarEspecialidadPorTitulo/{codTitulo}")
	public ResponseGenerico<TitEspecialidad> listarEspecialidadPorTitulo(
			@PathVariable("codTitulo") Long codTitulo) {
		List<TitEspecialidad> listaEspecialidad = especialidadServicio.listarEspecialidadPorTitulo(codTitulo);
		// Respuesta
		ResponseGenerico<TitEspecialidad> response = new ResponseGenerico<>();
		response.setListado(listaEspecialidad);
		response.setTotalRegistros((long) (listaEspecialidad.size()));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
	
	/**
	 * REST para obtener TitEspecialidad
	 * 
	 * @return TitEspecialidad
	 */
	@GetMapping(value = "buscarEspecialidadPorCodigo/{codEspecialidad}")
	public ResponseGenerico<TitEspecialidad> buscarEspecialidadPorCodigo(@PathVariable("codEspecialidad") Long codEspecialidad) {
		TitEspecialidad titEspecialidad = especialidadServicio.buscarEspecialidadPorCodigo(codEspecialidad);
		// Respuesta
		ResponseGenerico<TitEspecialidad> response = new ResponseGenerico<>();
		response.setObjeto(titEspecialidad);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
	
	 /** REST para guardar o actualizar Especialidad
	 * 
	 * @return guardar
	 */
	@PostMapping(value = "guardarEspecialidad")
	public ResponseGenerico<TitEspecialidad> guardarEspecialidad(@RequestBody TitEspecialidad titEspecialidad){
		TitEspecialidad titEspecialidadAux = especialidadServicio.registrar(titEspecialidad) ;
		// Respuesta
		ResponseGenerico<TitEspecialidad> response = new ResponseGenerico<>();
		response.setObjeto(titEspecialidadAux);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * Metodo para eliminar (baja lógica) un registro
	 * 
	 * @return objeto response
	 */
	@DeleteMapping(value = "eliminarEspecialidadPorId/{codEspecialidad}")
	public ResponseGenerico<TitEspecialidad> eliminarEspecialidad(@PathVariable("codEspecialidad") Long codEspecialidad){
		TitEspecialidad titEspecialidad = especialidadServicio.buscarEspecialidadPorCodigo(codEspecialidad);
		titEspecialidad.setStsEstado(Constantes.REGISTRO_INACTIVO_NUM);	
		especialidadServicio.registrar(titEspecialidad);	
		// Respuesta
		ResponseGenerico<TitEspecialidad> response = new ResponseGenerico<>();
		response.setObjeto(titEspecialidad);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
}
