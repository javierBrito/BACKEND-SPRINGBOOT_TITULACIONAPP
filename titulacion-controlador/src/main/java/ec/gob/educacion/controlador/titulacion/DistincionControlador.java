package ec.gob.educacion.controlador.titulacion;

import ec.gob.educacion.model.TitDistincion;
import ec.gob.educacion.model.constantes.Constantes;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.DistincionServicio;
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
public class DistincionControlador {

	@Autowired
	private DistincionServicio distincionServicio;

	@GetMapping(value = "listarTodosDistincion")
	public ResponseGenerico<TitDistincion> listarTodosDistincion() {
		List<TitDistincion> listaDistincion = distincionServicio.listarTodosDistincion();
		// Respuesta
		ResponseGenerico<TitDistincion> response = new ResponseGenerico<>();
		response.setListado(listaDistincion);
		response.setTotalRegistros((long) listaDistincion.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para obtener TitDistincion
	 * 
	 * @return TitDistincion
	 */
	@GetMapping(value = "buscarDistincionPorCodigo/{carCodigo}")
	public ResponseGenerico<TitDistincion> buscarDistincionPorCodigo(@PathVariable("carCodigo") Long carCodigo) {
		TitDistincion titDistincion = distincionServicio.buscarDistincionPorCodigo(carCodigo);
		// Respuesta
		ResponseGenerico<TitDistincion> response = new ResponseGenerico<>();
		response.setObjeto(titDistincion);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
	
	
	 /** REST para guardar o actualizar Distincion
	 * 
	 * @return guardar
	 */
	@PostMapping(value = "guardarDistincion")
	public ResponseGenerico<TitDistincion> guardarDistincion(@RequestBody TitDistincion titDistincion){
		TitDistincion titDistincionAux = distincionServicio.registrar(titDistincion) ;
		// Respuesta
		ResponseGenerico<TitDistincion> response = new ResponseGenerico<>();
		response.setObjeto(titDistincionAux);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * Metodo para eliminar (baja lógica) un registro
	 * 
	 * @return objeto response
	 */
	@DeleteMapping(value = "eliminarDistincionPorId/{codDistincion}")
	public ResponseGenerico<TitDistincion> eliminarDistincion(@PathVariable("codDistincion") Long codDistincion){
		TitDistincion titDistincion = distincionServicio.buscarDistincionPorCodigo(codDistincion);
		//titDistincion.set(Constantes.REGISTRO_INACTIVO_NUM);	
		distincionServicio.registrar(titDistincion);	
		// Respuesta
		ResponseGenerico<TitDistincion> response = new ResponseGenerico<>();
		response.setObjeto(titDistincion);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
}
