package ec.gob.educacion.controlador.titulacion;

import ec.gob.educacion.model.TitComision;
import ec.gob.educacion.model.constantes.Constantes;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.ComisionServicio;
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
public class ComisionControlador {

	@Autowired
	private ComisionServicio comisionServicio;

	@GetMapping(value = "listarTodosComision")
	public ResponseGenerico<TitComision> listarTodosComision() {
		List<TitComision> listaComision = comisionServicio.listarTodosComision();
		// Respuesta
		ResponseGenerico<TitComision> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		response.setListado(listaComision);
		response.setTotalRegistros((long) listaComision.size());
		return response;
	}

	/**
	 * REST para listar TitComision
	 * 
	 * @return lista de TitComision
	 */
	@GetMapping(value = "listarComisionPorInstitucionYAnioLectivo/{codInstitucion}/{codIncAnioLectivo}")
	public ResponseGenerico<TitComision> listarComisionPorInstitucionYAnioLectivo(
			@PathVariable("codInstitucion") Long codInstitucion,
			@PathVariable("codIncAnioLectivo") Long codIncAnioLectivo) {
		List<TitComision> lista = comisionServicio.listarComisionPorInstitucionYAnioLectivo(codInstitucion, codIncAnioLectivo);
		// Respuesta
		ResponseGenerico<TitComision> response = new ResponseGenerico<>();
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		response.setListado(lista);
		response.setTotalRegistros((long) (lista.size()));
		return response;
	}
	
	/**
	 * REST para buscar TitComision
	 * 
	 * @return TitComision
	 */
	@GetMapping(value = "buscarComisionPorCodigo/{codComision}")
	public ResponseGenerico<TitComision> buscarComisionPorCodigo(
			@PathVariable("codComision") Long codComision) {
		TitComision titComision = comisionServicio.buscarComisionPorCodigo(codComision);
		// Respuesta
		ResponseGenerico<TitComision> response = new ResponseGenerico<>();
		response.setObjeto(titComision);;
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
	
	 /** REST para guardar o actualizar comision
	 * 
	 * @return guardar
	 */
	@PostMapping(value = "guardarComision")
	public ResponseGenerico<TitComision> guardarComision(@RequestBody TitComision titComision){
		 TitComision titComisionAux = comisionServicio.registrar(titComision);
		// Respuesta
		ResponseGenerico<TitComision> response = new ResponseGenerico<>();
		response.setObjeto(titComisionAux);
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
	@DeleteMapping(value = "eliminarComisionPorId/{codComision}")
	public ResponseGenerico<TitComision> eliminarComision(@PathVariable("codComision") Long codComision){
		TitComision titComision = comisionServicio.buscarComisionPorCodigo(codComision);
		titComision.setStsEstado(Constantes.REGISTRO_INACTIVO_NUM);	
		comisionServicio.registrar(titComision);	
		// Respuesta
		ResponseGenerico<TitComision> response = new ResponseGenerico<>();
		response.setObjeto(titComision);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
}
