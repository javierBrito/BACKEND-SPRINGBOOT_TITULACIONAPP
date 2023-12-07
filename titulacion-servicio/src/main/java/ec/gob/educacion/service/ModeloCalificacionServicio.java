package ec.gob.educacion.service;

import ec.gob.educacion.model.TitModeloCalificacion;
import java.util.List;

public interface ModeloCalificacionServicio {

	List<TitModeloCalificacion> listarTodosModeloCalificacion();

	/**
	 * Permite listar TitModeloCalificacion
	 * 
	 * @param reanleCodigo, tipeduCodigo
	 * @return lista TitModeloCalificacion
	 */
	List<TitModeloCalificacion> listarModeloCalificacionPorRegAniLecYTipoEducacion(Long reanleCodigo, Long tipeduCodigo, Integer mcaEstado);

	/**
	 * Permite listar TitModeloCalificacion
	 * 
	 * @param reanleCodigo
	 * @return lista TitModeloCalificacion
	 */
	List<TitModeloCalificacion> listarModeloCalificacionPorRegAniLec(Long reanleCodigo, Integer mcaEstado);

	/**
	 * Permite obtener TitModeloCalificacion
	 * 
	 * @param autCodigo
	 * @return TitModeloCalificacion
	 */
	TitModeloCalificacion buscarModeloCalificacionPorCodigo(Long mcaCodigo);

	/**
	 * Permite guardar o actualizar TitModeloCalificacion por DTO
	 * 
	 * @param TitModeloCalificacionDTO a guarda/actualizar
	 * @return TitModeloCalificacion guardado
	 */
	TitModeloCalificacion guardarModeloCalificacion(TitModeloCalificacion titModeloCalificacion);

}
