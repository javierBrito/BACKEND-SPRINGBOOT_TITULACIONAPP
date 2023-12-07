package ec.gob.educacion.service;

import ec.gob.educacion.model.TitComision;
import java.util.List;

public interface ComisionServicio {

	List<TitComision> listarTodosComision();

	/**
	 * Permite listar TitComision
	 * 
	 * @param codInstitucion, codIncAnioLectivo
	 * @return lista TitComision
	 */
	List<TitComision> listarComisionPorInstitucionYAnioLectivo(Long codInstitucion, Long codIncAnioLectivo);

	/**
	 * Permite buscar TitComision
	 * 
	 * @param codComision
	 * @return TitComision
	 */
	TitComision buscarComisionPorCodigo(Long codComision);
	
	/**
	 * Permite registrar TitComision
	 * 
	 * @param TitComision
	 * @return TitComision
	 */
	TitComision registrar(TitComision titComision);

}
