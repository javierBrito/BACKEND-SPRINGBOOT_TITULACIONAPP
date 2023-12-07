package ec.gob.educacion.service.impl;

import ec.gob.educacion.model.TitRefrendacion;
import ec.gob.educacion.repositorio.RefrendacionRepositorio;
import ec.gob.educacion.service.ParticipacionEstServicio;
import ec.gob.educacion.service.RefrendacionServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RefrendacionServicioImpl implements RefrendacionServicio {

	@Autowired
	private RefrendacionRepositorio refrendacionRepositorio;
	@Autowired
	private ParticipacionEstServicio participacionEstServicio;

	@Override
	public List<TitRefrendacion> listarTodosRefrendacion() {
		return refrendacionRepositorio.findAll();
	}

	@Override
	public List<TitRefrendacion> listarRefrendacionPorCodigo(Long codigo) {
		return refrendacionRepositorio.findByCodigo(codigo);
	}

	@Override
	public TitRefrendacion buscarRefrendacionPorCodigo(Long refCodigo) {
		return refrendacionRepositorio.findByRefCodigo(refCodigo);
	}

	@Override
	public TitRefrendacion registrar(TitRefrendacion titRefrendacion) {
		if (titRefrendacion.getPesCodigo() != null) {
			titRefrendacion.setTitParticipacionEst(participacionEstServicio.buscarParticipacionEstPorCodigo(titRefrendacion.getPesCodigo()));
		}
		return refrendacionRepositorio.save(titRefrendacion);
	}
}
