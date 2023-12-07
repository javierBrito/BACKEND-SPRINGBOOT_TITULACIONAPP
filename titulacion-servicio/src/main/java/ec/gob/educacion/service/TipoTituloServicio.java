package ec.gob.educacion.service;

import ec.gob.educacion.model.TitTipoTitulo;
import java.util.List;

public interface TipoTituloServicio {

	List<TitTipoTitulo> listarTodosTipoTitulo();

	/**
	 * Permite obtener TitTipoTitulo
	 * 
	 * @param codTipoTitulo
	 * @return TitTipoTitulo
	 */
	TitTipoTitulo buscarTipoTituloPorCodigo(Long codTipoTitulo);

	/**
	 * Permite registrar TitTipoTitulo
	 * 
	 * @param TitTipoTitulo
	 * @return TitTipoTitulo
	 */
	TitTipoTitulo registrar(TitTipoTitulo titTipoTitulo);

}
