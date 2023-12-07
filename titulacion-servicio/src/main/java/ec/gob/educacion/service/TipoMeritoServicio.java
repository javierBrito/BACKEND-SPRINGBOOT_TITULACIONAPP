package ec.gob.educacion.service;

import ec.gob.educacion.model.TitTipoMerito;
import java.util.List;

public interface TipoMeritoServicio {

	List<TitTipoMerito> listarTodosTipoMerito();

	/**
	 * Permite obtener TitTipoMerito
	 * 
	 * @param codTipoMerito
	 * @return TitTipoMerito
	 */
	TitTipoMerito buscarTipoMeritoPorCodigo(Long codTipoMerito);

	/**
	 * Permite registrar TitTipoMerito
	 * 
	 * @param TitTipoMerito
	 * @return TitTipoMerito
	 */
	TitTipoMerito registrar(TitTipoMerito titTipoMerito);

}
