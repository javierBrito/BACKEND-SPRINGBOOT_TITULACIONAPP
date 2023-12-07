package ec.gob.educacion.service;

import ec.gob.educacion.model.TitDistincion;
import java.util.List;

public interface DistincionServicio {

  List<TitDistincion> listarTodosDistincion();
  
  /**
	 * Permite obtener TitDistincion 
	 * @param codDistincion
	 * @return TitDistincion
	 */
	TitDistincion buscarDistincionPorCodigo(Long codDistincion);

	/**
	 * Permite registrar TitDistincion
	 * 
	 * @param TitDistincion
	 * @return TitDistincion
	 */
	TitDistincion registrar(TitDistincion titDistincion);

}
