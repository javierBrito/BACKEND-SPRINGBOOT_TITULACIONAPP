package ec.gob.educacion.service;

import ec.gob.educacion.model.TitRefrendacion;
import java.util.List;

public interface RefrendacionServicio {

	List<TitRefrendacion> listarTodosRefrendacion();

	/**
	 * Permite listar TitRefrendacion
	 * 
	 * @param codigo
	 * @return lista TitRefrendacion
	 */
	List<TitRefrendacion> listarRefrendacionPorCodigo(Long codigo);
	
	/**
	 * Permite obtener TitRefrendacion
	 * 
	 * @param refCodigo
	 * @return TitRefrendacion
	 */
	TitRefrendacion buscarRefrendacionPorCodigo(Long refCodigo);

	/**
	 * Permite registrar TitRefrendacion
	 * 
	 * @param TitRefrendacion
	 * @return TitRefrendacion
	 */
	TitRefrendacion registrar(TitRefrendacion titRefrendacion);

}
