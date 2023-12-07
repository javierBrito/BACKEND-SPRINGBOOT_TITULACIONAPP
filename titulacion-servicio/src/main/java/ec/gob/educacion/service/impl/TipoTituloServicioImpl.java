package ec.gob.educacion.service.impl;

import ec.gob.educacion.model.TitTipoTitulo;
import ec.gob.educacion.repositorio.TipoTituloRepositorio;
import ec.gob.educacion.service.TipoTituloServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoTituloServicioImpl implements TipoTituloServicio {

	@Autowired
	private TipoTituloRepositorio tipoTituloRepositorio;

	@Override
	public List<TitTipoTitulo> listarTodosTipoTitulo() {
		return tipoTituloRepositorio.findAll();
	}

	@Override
	public TitTipoTitulo buscarTipoTituloPorCodigo(Long codTipoTitulo) {
		return tipoTituloRepositorio.findByCodTipoTitulo(codTipoTitulo);
	}

	@Override
	public TitTipoTitulo registrar(TitTipoTitulo titTipoTitulo) {
		return tipoTituloRepositorio.save(titTipoTitulo);
	}
}
