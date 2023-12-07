package ec.gob.educacion.controlador.titulacion;

import ec.gob.educacion.model.TitInstitucion;
import ec.gob.educacion.model.constantes.Constantes;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.InstitucionServicio;
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
public class InstitucionControlador {

	@Autowired
	private InstitucionServicio institucionServicio;

	@GetMapping(value = "listarTodosInstitucion")
	public ResponseGenerico<TitInstitucion> listarTodosInstitucion() {
		List<TitInstitucion> listaInstitucion = institucionServicio.listarTodosInstitucion();
		// Respuesta
		ResponseGenerico<TitInstitucion> response = new ResponseGenerico<>();
		response.setListado(listaInstitucion);
		response.setTotalRegistros((long) listaInstitucion.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para listar TitInstitucion
	 * 
	 * @return lista de TitInstitucion
	 */
	@GetMapping(value = "listarInstitucionPorAmie/{codAmie}")
	public ResponseGenerico<TitInstitucion> listarInstitucionPorInstitucion(
			@PathVariable("codAmie") String codAmie) {
		List<TitInstitucion> listaInstitucion = institucionServicio.listarInstitucionPorAmie(codAmie);
		ResponseGenerico<TitInstitucion> response = new ResponseGenerico<>();
		response.setListado(listaInstitucion);
		response.setTotalRegistros((long) (listaInstitucion.size()));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para listar TitInstitucion
	 * 
	 * @return lista de TitInstitucion
	 */
	@GetMapping(value = "listarInstitucionPorNombre/{nomInstitucion}")
	public ResponseGenerico<TitInstitucion> listarInstitucionPorNombre(
			@PathVariable("nomInstitucion") String nomInstitucion) {
		List<TitInstitucion> listaInstitucion = institucionServicio.listarInstitucionPorNombre(nomInstitucion);
		// Respuesta
		ResponseGenerico<TitInstitucion> response = new ResponseGenerico<>();
		response.setListado(listaInstitucion);
		response.setTotalRegistros((long) (listaInstitucion.size()));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
	
	/**
	 * REST para obtener TitInstitucion
	 * 
	 * @return TitInstitucion
	 */
	@GetMapping(value = "buscarInstitucionPorCodigo/{codInstitucion}")
	public ResponseGenerico<TitInstitucion> buscarInstitucionPorCodigo(@PathVariable("codInstitucion") Long codInstitucion) {
		TitInstitucion titInstitucion = institucionServicio.buscarInstitucionPorCodigo(codInstitucion);
		// Respuesta
		ResponseGenerico<TitInstitucion> response = new ResponseGenerico<>();
		response.setObjeto(titInstitucion);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
	
	 /** REST para guardar o actualizar Institucion
	 * 
	 * @return guardar
	 */
	@PostMapping(value = "guardarInstitucion")
	public ResponseGenerico<TitInstitucion> guardarInstitucion(@RequestBody TitInstitucion titInstitucion){
		TitInstitucion titInstitucionAux = institucionServicio.registrar(titInstitucion) ;
		// Respuesta
		ResponseGenerico<TitInstitucion> response = new ResponseGenerico<>();
		response.setObjeto(titInstitucionAux);
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
	@DeleteMapping(value = "eliminarInstitucionPorId/{codInstitucion}")
	public ResponseGenerico<TitInstitucion> eliminarInstitucion(@PathVariable("codInstitucion") Long codInstitucion){
		TitInstitucion titInstitucion = institucionServicio.buscarInstitucionPorCodigo(codInstitucion);
		titInstitucion.setStsEstado(Constantes.REGISTRO_INACTIVO_NUM);	
		institucionServicio.registrar(titInstitucion);	
		// Respuesta
		ResponseGenerico<TitInstitucion> response = new ResponseGenerico<>();
		response.setObjeto(titInstitucion);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
}
