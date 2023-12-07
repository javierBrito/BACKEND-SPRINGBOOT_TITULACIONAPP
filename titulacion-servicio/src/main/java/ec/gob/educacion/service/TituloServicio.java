package ec.gob.educacion.service;

import ec.gob.educacion.model.TitTitulo;
import java.util.List;

public interface TituloServicio {

	List<TitTitulo> listarTodosTitulo();

	/**
	 * Permite obtener TitTitulo
	 * 
	 * @param codTitulo
	 * @return TitTitulo
	 */
	TitTitulo buscarTituloPorCodigo(Long codTitulo);

	/**
	 * Permite registrar TitTitulo
	 * 
	 * @param TitTitulo
	 * @return TitTitulo
	 */
	TitTitulo registrar(TitTitulo titTitulo);

}
