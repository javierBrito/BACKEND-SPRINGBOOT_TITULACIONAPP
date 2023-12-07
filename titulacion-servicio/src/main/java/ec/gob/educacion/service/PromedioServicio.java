package ec.gob.educacion.service;

import ec.gob.educacion.model.TitPromedio;
import java.util.List;

public interface PromedioServicio {

	List<TitPromedio> listarTodosPromedio();

	/**
	 * Permite listar TitPromedio
	 * 
	 * @param estCodigo
	 * @return lista TitPromedio
	 */
	List<TitPromedio> listarPromedioPorEstudiante(Long estCodigo, Integer proEstado);

	/**
	 * Permite listar TitPromedio
	 * 
	 * @param estCodigo, mprNemonico
	 * @return lista TitPromedio
	 */
	List<TitPromedio> listarPromedioPorEstudianteYNemonico(Long estCodigo, String mprNemonico);

	/**
	 * Permite obtener TitPromedio
	 * 
	 * @param proCodigo
	 * @return TitPromedio
	 */
	TitPromedio buscarPromedioPorCodigo(Long proCodigo);

	/**
	 * Permite guardar o actualizar TitPromedio por DTO
	 * 
	 * @param TitPromedioDTO a guarda/actualizar
	 * @return TitPromedio guardado
	 */
	TitPromedio guardarPromedio(TitPromedio titPromedio);

}
