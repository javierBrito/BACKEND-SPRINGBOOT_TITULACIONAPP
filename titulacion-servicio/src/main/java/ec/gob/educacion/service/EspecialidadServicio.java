package ec.gob.educacion.service;

import ec.gob.educacion.model.TitEspecialidad;
import java.util.List;

public interface EspecialidadServicio {

  List<TitEspecialidad> listarTodosEspecialidad();
  
  /**
	 * Permite listar TitEspecialidad 
	 * @param codTitulo
	 * @return lista TitEspecialidad
	 */
	List<TitEspecialidad> listarEspecialidadPorTitulo(Long codTitulo);
	
	/**
	 * Permite obtener TitEspecialidad
	 * 
	 * @param codEspecialidad
	 * @return TitEspecialidad
	 */
	TitEspecialidad buscarEspecialidadPorCodigo(Long codEspecialidad);
	
	/**
	 * Permite registrar TitEspecialidad
	 * 
	 * @param TitEspecialidad
	 * @return TitEspecialidad
	 */
	TitEspecialidad registrar(TitEspecialidad titEspecialidad);

}
