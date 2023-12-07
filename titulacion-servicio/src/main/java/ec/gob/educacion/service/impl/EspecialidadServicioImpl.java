package ec.gob.educacion.service.impl;

import ec.gob.educacion.model.TitEspecialidad;
import ec.gob.educacion.repositorio.EspecialidadRepositorio;
import ec.gob.educacion.service.EspecialidadServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EspecialidadServicioImpl implements EspecialidadServicio {

	@Autowired
	private EspecialidadRepositorio especialidadRepositorio;

	@Override
	public List<TitEspecialidad> listarTodosEspecialidad() {
		return especialidadRepositorio.findAll();
	}

	@Override
	public List<TitEspecialidad> listarEspecialidadPorTitulo(Long codTitulo) {
		return especialidadRepositorio.findByCodTitulo(codTitulo);
	}

	@Override
	public TitEspecialidad buscarEspecialidadPorCodigo(Long codEspecialidad) {
		return especialidadRepositorio.findByCodEspecialidad(codEspecialidad);
	}

	@Override
	public TitEspecialidad registrar(TitEspecialidad titEspecialidad) {
		return especialidadRepositorio.save(titEspecialidad);
	}
}
