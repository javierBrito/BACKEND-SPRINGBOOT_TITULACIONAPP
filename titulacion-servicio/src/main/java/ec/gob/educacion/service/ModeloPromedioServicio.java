package ec.gob.educacion.service;

import ec.gob.educacion.model.TitModeloPromedio;
import java.util.List;

public interface ModeloPromedioServicio {

	List<TitModeloPromedio> listarTodosModeloPromedio();

	/**
	 * Permite listar TitModeloPromedio
	 * 
	 * @param reanleCodigo, tipeduCodigo
	 * @return lista TitModeloPromedio
	 */
	List<TitModeloPromedio> listarModeloPromedioPorRegAniLecYTipoEducacion(Long reanleCodigo, Long tipeduCodigo, Integer mprEstado);

	/**
	 * Permite listar TitModeloPromedio
	 * 
	 * @param reanleCodigo
	 * @return lista TitModeloPromedio
	 */
	List<TitModeloPromedio> listarModeloPromedioPorRegAniLec(Long reanleCodigo, Integer mprEstado);

	/**
	 * Permite obtener TitModeloPromedio
	 * 
	 * @param mprCodigo
	 * @return TitModeloPromedio
	 */
	TitModeloPromedio buscarModeloPromedioPorCodigo(Long mprCodigo);

	/**
	 * Permite guardar o actualizar TitModeloPromedio por DTO
	 * 
	 * @param TitModeloPromedioDTO a guarda/actualizar
	 * @return TitModeloPromedio guardado
	 */
	TitModeloPromedio guardarModeloPromedio(TitModeloPromedio titModeloPromedio);

}
