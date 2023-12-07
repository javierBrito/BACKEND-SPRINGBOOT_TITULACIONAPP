package ec.gob.educacion.service.impl;

import ec.gob.educacion.model.TitTitulo;
import ec.gob.educacion.repositorio.TituloRepositorio;
import ec.gob.educacion.service.TituloServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TituloServicioImpl implements TituloServicio {

	@Autowired
	private TituloRepositorio tituloRepositorio;

	@Override
	public List<TitTitulo> listarTodosTitulo() {
		return tituloRepositorio.findAll();
	}

	@Override
	public TitTitulo buscarTituloPorCodigo(Long codTitulo) {
		return tituloRepositorio.findByCodTitulo(codTitulo);
	}

	@Override
	public TitTitulo registrar(TitTitulo titTitulo) {
		return tituloRepositorio.save(titTitulo);
	}
}
