package ec.gob.educacion.service.impl;

import ec.gob.educacion.model.TitParticipacionEst;
import ec.gob.educacion.repositorio.ParticipacionEstRepositorio;
import ec.gob.educacion.service.ParticipacionEstServicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipacionEstServicioImpl implements ParticipacionEstServicio {

	@Autowired
	private ParticipacionEstRepositorio participacionEstRepositorio;

	@Override
	public List<TitParticipacionEst> listarTodosParticipacionEst() {
		return participacionEstRepositorio.findAll();
	}

	@Override
	public TitParticipacionEst buscarParticipacionEstPorCodigo(Long pesCodigo) {
		return participacionEstRepositorio.findByPesCodigo(pesCodigo);
	}

	@Override
	public TitParticipacionEst registrar(TitParticipacionEst titParticipacionEst) {
		return participacionEstRepositorio.save(titParticipacionEst);
	}
}
