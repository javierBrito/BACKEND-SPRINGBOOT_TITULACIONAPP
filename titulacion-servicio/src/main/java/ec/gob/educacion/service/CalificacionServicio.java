package ec.gob.educacion.service;

import ec.gob.educacion.model.TitCalificacion;
import ec.gob.educacion.model.TitPromedio;

import java.util.List;

public interface CalificacionServicio {

	List<TitCalificacion> listarTodosCalificacion();

	/**
	 * Permite listar TitPromedio
	 * 
	 * @param insCodigo, reanleCodigo
	 * @return lista TitPromedio
	 */
	List<TitCalificacion> listarCalificacionPorEstudiante(Long estCodigo, Integer proEstado);

	/**
	 * Permite obtener TitCalificacion
	 * 
	 * @param calCodigo
	 * @return TitCalificacion
	 */
	TitCalificacion buscarCalificacionPorCodigo(Long calCodigo);

	/**
	 * Permite guardar o actualizar TitCalificacion por DTO
	 * 
	 * @param TitCalificacionDTO a guarda/actualizar
	 * @return TitCalificacion guardado
	 */
	TitCalificacion guardarCalificacion(TitCalificacion titCalificacion);

}
