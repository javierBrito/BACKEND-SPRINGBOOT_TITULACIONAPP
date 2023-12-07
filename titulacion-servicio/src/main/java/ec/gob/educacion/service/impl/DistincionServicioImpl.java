package ec.gob.educacion.service.impl;

import ec.gob.educacion.model.TitDistincion;
import ec.gob.educacion.repositorio.DistincionRepositorio;
import ec.gob.educacion.service.DistincionServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistincionServicioImpl implements DistincionServicio {

	@Autowired
	private DistincionRepositorio distincionRepositorio;

	@Override
	public List<TitDistincion> listarTodosDistincion() {
		return distincionRepositorio.findAll();
	}

	@Override
	public TitDistincion buscarDistincionPorCodigo(Long codDistincion) {
		return distincionRepositorio.findByCodDistincion(codDistincion);
	}

	@Override
	public TitDistincion registrar(TitDistincion titDistincion) {
		return distincionRepositorio.save(titDistincion);
	}
}
