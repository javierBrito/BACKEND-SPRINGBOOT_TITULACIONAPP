package ec.gob.educacion.service;

import ec.gob.educacion.model.TitParticipacionEst;
import java.util.List;

public interface ParticipacionEstServicio {

	List<TitParticipacionEst> listarTodosParticipacionEst();

	/**
	 * Permite obtener TitParticipacionEst
	 * 
	 * @param codEstado
	 * @return TitParticipacionEst
	 */
	TitParticipacionEst buscarParticipacionEstPorCodigo(Long codEstado);

	/**
	 * Permite registrar TitParticipacionEst
	 * 
	 * @param TitParticipacionEst
	 * @return TitParticipacionEst
	 */
	TitParticipacionEst registrar(TitParticipacionEst titParticipacionEst);
}
