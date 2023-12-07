package ec.gob.educacion.service.impl;

import ec.gob.educacion.model.TitCalificacion;
import ec.gob.educacion.model.TitPromedio;
import ec.gob.educacion.repositorio.CalificacionRepositorio;
import ec.gob.educacion.service.CalificacionServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalificacionServicioImpl implements CalificacionServicio {

	@Autowired
	private CalificacionRepositorio calificacionRepositorio;

	@Override
	public List<TitCalificacion> listarTodosCalificacion() {
		return calificacionRepositorio.findAll();
	}

	@Override
	public List<TitCalificacion> listarCalificacionPorEstudiante(Long estCodigo, Integer proEstado) {
		return calificacionRepositorio.findByEstCodigoAndCalEstado(estCodigo, proEstado);
	}
	
	@Override
	public TitCalificacion buscarCalificacionPorCodigo(Long calCodigo) {
		return calificacionRepositorio.findByCalCodigo(calCodigo);
	}
	
	public TitCalificacion guardarCalificacion(TitCalificacion titCalificacion) {
		return calificacionRepositorio.save(titCalificacion);
	}
}
