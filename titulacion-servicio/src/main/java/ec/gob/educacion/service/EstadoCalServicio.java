package ec.gob.educacion.service;

import ec.gob.educacion.model.TitEstadoCal;
import java.util.List;

public interface EstadoCalServicio {

	List<TitEstadoCal> listarTodosEstadoCal();

	/**
	 * Permite obtener TitEstadoCal
	 * 
	 * @param codEstado
	 * @return TitEstadoCal
	 */
	TitEstadoCal buscarEstadoCalPorCodigo(Long codEstado);

	/**
	 * Permite registrar TitEstadoCal
	 * 
	 * @param TitEstadoCal
	 * @return TitEstadoCal
	 */
	TitEstadoCal registrar(TitEstadoCal titEstadoCal);

}
