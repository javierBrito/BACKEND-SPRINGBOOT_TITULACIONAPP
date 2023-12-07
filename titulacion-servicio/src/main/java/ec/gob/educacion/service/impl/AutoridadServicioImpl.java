package ec.gob.educacion.service.impl;

import ec.gob.educacion.model.TitAutoridad;
import ec.gob.educacion.repositorio.AutoridadRepositorio;
import ec.gob.educacion.service.AutoridadServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoridadServicioImpl implements AutoridadServicio {

	@Autowired
	private AutoridadRepositorio autoridadRepositorio;

	@Override
	public List<TitAutoridad> listarTodosAutoridad() {
		return autoridadRepositorio.findAll();
	}

	@Override
	public List<TitAutoridad> listarAutoridadPorInstitucion(Long codInstitucion) {
		return autoridadRepositorio.findByCodInstitucion(codInstitucion);
	}

	@Override
	public TitAutoridad buscarAutoridadPorCodigo(Long codAutoridad) {
		return autoridadRepositorio.findByCodAutoridad(codAutoridad);
	}
	
	@Override
	public TitAutoridad registrar(TitAutoridad titAutoridad) {
		return autoridadRepositorio.save(titAutoridad);
	}

}
