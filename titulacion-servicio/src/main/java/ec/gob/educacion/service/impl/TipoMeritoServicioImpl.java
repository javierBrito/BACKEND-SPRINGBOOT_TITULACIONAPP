package ec.gob.educacion.service.impl;

import ec.gob.educacion.model.TitTipoMerito;
import ec.gob.educacion.repositorio.TipoMeritoRepositorio;
import ec.gob.educacion.service.TipoMeritoServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoMeritoServicioImpl implements TipoMeritoServicio {

	@Autowired
	private TipoMeritoRepositorio tipoMeritoRepositorio;

	@Override
	public List<TitTipoMerito> listarTodosTipoMerito() {
		return tipoMeritoRepositorio.findAll();
	}

	@Override
	public TitTipoMerito buscarTipoMeritoPorCodigo(Long codTipoMerito) {
		return tipoMeritoRepositorio.findByCodTipoMerito(codTipoMerito);
	}

	@Override
	public TitTipoMerito registrar(TitTipoMerito titTipoMerito) {
		return tipoMeritoRepositorio.save(titTipoMerito);
	}
}
