package ec.gob.educacion.service.impl;

import ec.gob.educacion.model.TitTitulado;
import ec.gob.educacion.repositorio.TituladoRepositorio;
import ec.gob.educacion.service.TituladoServicio;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TituladoServicioImpl implements TituladoServicio {

	@Autowired
	private TituladoRepositorio tituladoRepositorio;

	@Override
	public List<TitTitulado> listarTodosTitulado() {
		return tituladoRepositorio.findAll();
	}

	@Override
	public TitTitulado buscarTituladoPorCodigo(Long codTitulado) {
		return tituladoRepositorio.findByCodTitulado(codTitulado);
	}

	@Override
	public TitTitulado registrar(TitTitulado titTitulado) {
		if (titTitulado.getCodTitulado() == null || titTitulado.getCodTitulado() == 0) {
			// Crear registro
			titTitulado.setFecCreacion(new Date());
		} else {
			// Actualizar registro
			titTitulado.setFecActualizacion(new Date());
		}
		return tituladoRepositorio.save(titTitulado);
	}
}
