package ec.gob.educacion.service;

import ec.gob.educacion.model.TitConsejoEjec;
import java.util.List;

public interface ConsejoEjecServicio {

	List<TitConsejoEjec> listarTodosConsejoEjec();

	/**
	 * Permite listar TitConsejoEjec
	 * 
	 * @param insCodigo, reanleCodigo
	 * @return lista TitConsejoEjec
	 */
	List<TitConsejoEjec> listarConsejosEjecPorInstitucionYAnioLectivo(Long insCodigo, Long reanleCodigo, Integer cejEstado);

	/**
	 * Permite obtener TitConsejoEjec
	 * 
	 * @param cejCodigo
	 * @return TitConsejoEjec
	 */
	TitConsejoEjec buscarConsejoEjecPorCodigo(Long cejCodigo);

	/**
	 * Permite guardar o actualizar TitConsejoEjec por DTO
	 * 
	 * @param TitConsejoEjecDTO a guarda/actualizar
	 * @return TitConsejoEjec guardado
	 */
	TitConsejoEjec guardarConsejoEjec(TitConsejoEjec titConsejoEjec);
	
	/**
	 * Permite registrar TitConsejoEjec
	 * 
	 * @param TitConsejoEjec
	 * @return TitConsejoEjec
	 */
	TitConsejoEjec registrar(TitConsejoEjec titConsejoEjec);


}
