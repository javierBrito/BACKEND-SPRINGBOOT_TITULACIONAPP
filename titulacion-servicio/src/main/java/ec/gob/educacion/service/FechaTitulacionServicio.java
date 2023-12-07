package ec.gob.educacion.service;

import ec.gob.educacion.model.TitFechaTitulacion;
import java.util.List;

public interface FechaTitulacionServicio {

	/**
	 * Permite listar TitFechaTitulacion
	 * 
	 * @param null
	 * @return lista TitFechaTitulacion
	 */
	List<TitFechaTitulacion> listarTodosFechaTitulacion();

	/**
	 * Permite listar TitFechaTitulacion Activo
	 * 
	 * @param null
	 * @return lista TitFechaTitulacion
	 */	
	List<TitFechaTitulacion> listarFechaTitulacionActivo(Integer ftiEstado);

	/**
	 * Permite listar TitFechaTitulacion
	 * 
	 * @param codInstitucion, codIncAnioLectivo
	 * @return lista TitFechaTitulacion
	 */
	List<TitFechaTitulacion> listarFechaTitulacionPorRegAniLecYTipoEducacion(Long reanleCodigo, Long tipeduCodigo, Integer ftiEstado);

	/**
	 * Permite obtener TitFechaTitulacion
	 * 
	 * @param autCodigo
	 * @return TitFechaTitulacion
	 */
	TitFechaTitulacion buscarFechaTitulacionPorCodigo(Long ftiCodigo);

	/**
	 * Permite guardar o actualizar TitFechaTitulacion por DTO
	 * 
	 * @param TitFechaTitulacionDTO a guarda/actualizar
	 * @return TitFechaTitulacion guardado
	 */
	TitFechaTitulacion guardarFechaTitulacion(TitFechaTitulacion titFechaTitulacion);
	
	/**
	 * Permite registrar TitFechaTitulacion
	 * 
	 * @param TitFechaTitulacion
	 * @return TitFechaTitulacion
	 */
	TitFechaTitulacion registrar(TitFechaTitulacion titFechaTitulacion);


}
