package ec.gob.educacion.controlador.titulacion;

import ec.gob.educacion.model.TitParametro;
import ec.gob.educacion.model.constantes.Constantes;
import ec.gob.educacion.model.enumerator.EstadoEnum;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.ParametroServicio;
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
public class ParametroControlador {

	@Autowired
	private ParametroServicio parametroServicio;

	@GetMapping(value = "listarTodosParametro")
	public ResponseGenerico<TitParametro> listarTodosParametro() {
		List<TitParametro> listaParametro = parametroServicio.listarTodosParametro();
		// Respuesta
		ResponseGenerico<TitParametro> response = new ResponseGenerico<>();
		response.setListado(listaParametro);
		response.setTotalRegistros((long) listaParametro.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
	
	@GetMapping(value = "listarParametroActivo")
	public ResponseGenerico<TitParametro> listarParametroActivo() {
		List<TitParametro> listaParametro = parametroServicio.listarParametroActivo(EstadoEnum.ACTIVO.getCodigo());
		// Respuesta
		ResponseGenerico<TitParametro> response = new ResponseGenerico<>();
		response.setListado(listaParametro);
		response.setTotalRegistros((long) listaParametro.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
	
	/**
	 * REST para buscar TitParametro
	 * 
	 * @return TitParametro
	 */
	@GetMapping(value = "buscarParametroPorCodigo/{parCodigo}")
	public ResponseGenerico<TitParametro> buscarParametroPorCodigo(
			@PathVariable("parCodigo") Long parCodigo) {
		TitParametro titParametro = parametroServicio.buscarParametroPorCodigo(parCodigo);
		// Respuesta
		ResponseGenerico<TitParametro> response = new ResponseGenerico<>();
		response.setObjeto(titParametro);;
		response.setTotalRegistros((long) 1);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para guardar o actualizar TitParametro por DTO
	 * 
	 * @return TitParametro DTO a guardar
	 */
	@PostMapping(value = "guardarParametro")
	public ResponseGenerico<TitParametro> guardarParametro(@RequestBody TitParametro TitParametro) {
		TitParametro titParametroAux = parametroServicio.guardarParametro(TitParametro);
		// Respuesta
		ResponseGenerico<TitParametro> response = new ResponseGenerico<>();
		response.setObjeto(titParametroAux);
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
	@DeleteMapping(value = "eliminarParametroPorId/{parCodigo}")
	public ResponseGenerico<TitParametro> eliminarParametro(@PathVariable("parCodigo") Long parCodigo){
		TitParametro titParametro = parametroServicio.buscarParametroPorCodigo(parCodigo);
		titParametro.setParEstado(EstadoEnum.INACTIVO.getCodigo());	
		parametroServicio.registrar(titParametro);	
		// Respuesta
		ResponseGenerico<TitParametro> response = new ResponseGenerico<>();
		response.setObjeto(titParametro);
		response.setTotalRegistros((long) 1);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_ELIMINADO);
		return response;
	}
}
