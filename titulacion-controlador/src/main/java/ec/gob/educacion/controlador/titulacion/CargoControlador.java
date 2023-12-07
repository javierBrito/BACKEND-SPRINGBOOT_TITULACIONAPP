package ec.gob.educacion.controlador.titulacion;

import ec.gob.educacion.model.TitCargo;
import ec.gob.educacion.model.constantes.Constantes;
import ec.gob.educacion.model.enumerator.EstadoEnum;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.CargoServicio;
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
public class CargoControlador {

	@Autowired
	private CargoServicio cargoServicio;

	@GetMapping(value = "listarTodosCargo")
	public ResponseGenerico<TitCargo> listarTodosCargo() {
		List<TitCargo> listaCargo = cargoServicio.listarTodosCargo();
		// Respuesta
		ResponseGenerico<TitCargo> response = new ResponseGenerico<>();
		response.setListado(listaCargo);
		response.setTotalRegistros((long) listaCargo.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	@GetMapping(value = "listarCargoActivo")
	public ResponseGenerico<TitCargo> listarCargoActivo() {
		List<TitCargo> listaCargo = cargoServicio.listarCargoActivo(EstadoEnum.ACTIVO.getCodigo());
		// Respuesta
		ResponseGenerico<TitCargo> response = new ResponseGenerico<>();
		response.setListado(listaCargo);
		response.setTotalRegistros((long) listaCargo.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}

	/**
	 * REST para obtener TitCargo
	 * 
	 * @return TitCargo
	 */
	@GetMapping(value = "buscarCargoPorCodigo/{carCodigo}")
	public ResponseGenerico<TitCargo> buscarCargoPorCodigo(@PathVariable("carCodigo") Long carCodigo) {
		TitCargo titCargo = cargoServicio.buscarCargoPorCodigo(carCodigo);
		// Respuesta
		ResponseGenerico<TitCargo> response = new ResponseGenerico<>();
		response.setObjeto(titCargo);
		response.setTotalRegistros((long) (1));
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
		return response;
	}
	
	 /** REST para guardar o actualizar cargo
	 * 
	 * @return guardar
	 */
	@PostMapping(value = "guardarCargo")
	public ResponseGenerico<TitCargo> guardarCargo(@RequestBody TitCargo titCargo) {
		TitCargo titCargoAux = cargoServicio.registrar(titCargo);
		// Respuesta
		ResponseGenerico<TitCargo> response = new ResponseGenerico<>();
		response.setObjeto(titCargoAux);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_CREADO);
		return response;
	}

	/**
	 * Metodo para eliminar (baja lógica) un registro
	 * 
	 * @return objeto response
	 */
	@DeleteMapping(value = "eliminarCargoPorId/{codCargo}")
	public ResponseGenerico<TitCargo> eliminarCargo(@PathVariable("codCargo") Long codCargo) {
		TitCargo titCargo = cargoServicio.buscarCargoPorCodigo(codCargo);
		titCargo.setCarEstado(EstadoEnum.INACTIVO.getCodigo());
		cargoServicio.registrar(titCargo);
		// Respuesta
		ResponseGenerico<TitCargo> response = new ResponseGenerico<>();
		response.setObjeto(titCargo);
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK_ELIMINADO);
		return response;
	}
}
