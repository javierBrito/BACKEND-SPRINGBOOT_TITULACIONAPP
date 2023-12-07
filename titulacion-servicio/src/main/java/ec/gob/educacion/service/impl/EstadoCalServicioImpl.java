package ec.gob.educacion.service.impl;

import ec.gob.educacion.model.TitEstadoCal;
import ec.gob.educacion.repositorio.EstadoCalRepositorio;
import ec.gob.educacion.service.EstadoCalServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoCalServicioImpl implements EstadoCalServicio {

	@Autowired
	private EstadoCalRepositorio estadoCalRepositorio;

	@Override
	public List<TitEstadoCal> listarTodosEstadoCal() {
		return estadoCalRepositorio.findAll();
	}

	@Override
	public TitEstadoCal buscarEstadoCalPorCodigo(Long codEstado) {
		return estadoCalRepositorio.findByCodEstado(codEstado);
	}

	@Override
	public TitEstadoCal registrar(TitEstadoCal titEstadoCal) {
		return estadoCalRepositorio.save(titEstadoCal);
	}
}
