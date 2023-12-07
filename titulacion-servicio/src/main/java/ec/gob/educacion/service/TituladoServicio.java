package ec.gob.educacion.service;

import ec.gob.educacion.model.TitTitulado;
import java.util.List;

public interface TituladoServicio {

	List<TitTitulado> listarTodosTitulado();

	/**
	 * Permite obtener TitTitulado
	 * 
	 * @param codTitulado
	 * @return TitTitulado
	 */
	TitTitulado buscarTituladoPorCodigo(Long codTitulado);

	/**
	 * Permite registrar TitTitulado
	 * 
	 * @param TitTitulado
	 * @return TitTitulado
	 */
	TitTitulado registrar(TitTitulado titTitulado);

}
