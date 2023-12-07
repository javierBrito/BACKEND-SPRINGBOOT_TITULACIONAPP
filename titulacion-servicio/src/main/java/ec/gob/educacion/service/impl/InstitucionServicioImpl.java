package ec.gob.educacion.service.impl;

import ec.gob.educacion.model.TitInstitucion;
import ec.gob.educacion.repositorio.InstitucionRepositorio;
import ec.gob.educacion.service.InstitucionServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstitucionServicioImpl implements InstitucionServicio {

	@Autowired
	private InstitucionRepositorio institucionRepositorio;

	@Override
	public List<TitInstitucion> listarTodosInstitucion() {
		return institucionRepositorio.findAll();
	}

	public List<TitInstitucion> listarInstitucionPorAmie(String codAmie) {
		return institucionRepositorio.findByCodAmie(codAmie);
	}

	public List<TitInstitucion> listarInstitucionPorNombre(String nomInstitucion) {
		return institucionRepositorio.findByNomInstitucion(nomInstitucion);
	}
	
	@Override
	public TitInstitucion buscarInstitucionPorCodigo(Long codInstitucion) {
		return institucionRepositorio.findByCodInstitucion(codInstitucion);
	}

	@Override
	public TitInstitucion registrar(TitInstitucion titInstitucion) {
		return institucionRepositorio.save(titInstitucion);
	}
}
