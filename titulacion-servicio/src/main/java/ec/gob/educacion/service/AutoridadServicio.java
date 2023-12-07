package ec.gob.educacion.service;

import ec.gob.educacion.model.TitAutoridad;
import java.util.List;

public interface AutoridadServicio {

	/**
	 * Permite listar TitAutoridad
	 * 
	 * @param null
	 * @return lista TitAutoridad
	 */
	List<TitAutoridad> listarTodosAutoridad();

	/**
	 * Permite listar TitAutoridad
	 * 
	 * @param codInstitucion
	 * @return lista TitAutoridad
	 */
	List<TitAutoridad> listarAutoridadPorInstitucion(Long codInstitucion);

	/**
	 * Permite obtener TitAutoridad
	 * 
	 * @param codAutoridad
	 * @return TitAutoridad
	 */
	TitAutoridad buscarAutoridadPorCodigo(Long codAutoridad);

	/**
	 * Permite registrar TitAutoridad
	 * 
	 * @param TitAutoridad
	 * @return TitAutoridad
	 */
	TitAutoridad registrar(TitAutoridad titAutoridad);

}
