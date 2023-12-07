package ec.gob.educacion.service;

import ec.gob.educacion.model.TitCargo;
import java.util.List;

public interface CargoServicio {

	/**
	 * Permite listar TitCargo
	 * 
	 * @param null
	 * @return lista TitCargo
	 */
	List<TitCargo> listarTodosCargo();

	/**
	 * Permite listar TitCargo Activo
	 * 
	 * @param null
	 * @return lista TitCargo
	 */
	List<TitCargo> listarCargoActivo(Integer carEstado);
	
	/**
	 * Permite obtener TitCargo
	 * 
	 * @param codCargo
	 * @return TitCargo
	 */
	TitCargo buscarCargoPorCodigo(Long carCodigo);
	
	/**
	 * Permite registrar TitCargo
	 * 
	 * @param TitCargo
	 * @return TitCargo
	 */
	TitCargo registrar(TitCargo titCargo);

}
