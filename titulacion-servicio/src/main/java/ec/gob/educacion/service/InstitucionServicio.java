package ec.gob.educacion.service;

import ec.gob.educacion.model.TitInstitucion;
import java.util.List;

public interface InstitucionServicio {

	List<TitInstitucion> listarTodosInstitucion();

	/**
	 * Permite listar TitInstitucion
	 * 
	 * @param codAmie
	 * @return lista TitInstitucion
	 */
	List<TitInstitucion> listarInstitucionPorAmie(String codAmie);

	/**
	 * Permite listar TitInstitucion
	 * 
	 * @param nomInstitucion
	 * @return lista TitInstitucion
	 */
	List<TitInstitucion> listarInstitucionPorNombre(String nomInstitucion);
	
	/**
	 * Permite obtener TitInstitucion
	 * 
	 * @param codInstitucion
	 * @return TitInstitucion
	 */
	TitInstitucion buscarInstitucionPorCodigo(Long codInstitucion);
	
	/**
	 * Permite registrar TitInstitucion
	 * 
	 * @param TitInstitucion
	 * @return TitInstitucion
	 */
	TitInstitucion registrar(TitInstitucion titInstitucion);
}
