package ec.gob.educacion.service.impl;

import ec.gob.educacion.model.TitPromedio;
import ec.gob.educacion.repositorio.PromedioRepositorio;
import ec.gob.educacion.service.PromedioServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromedioServicioImpl implements PromedioServicio {

	@Autowired
	private PromedioRepositorio promedioRepositorio;

	@Override
	public List<TitPromedio> listarTodosPromedio() {
		return promedioRepositorio.findAll();
	}

	@Override
	public List<TitPromedio> listarPromedioPorEstudiante(Long estCodigo, Integer proEstado) {
		return promedioRepositorio.findByEstCodigoAndProEstado(estCodigo, proEstado);
	}

	@Override
	public List<TitPromedio> listarPromedioPorEstudianteYNemonico(Long estCodigo, String mprNemonico) {
		return promedioRepositorio.listarPromedioPorEstudianteYNemonico(estCodigo, mprNemonico);
	}
	
	@Override
	public TitPromedio buscarPromedioPorCodigo(Long proCodigo) {
		return promedioRepositorio.findByProCodigo(proCodigo);
	}
	
	public TitPromedio guardarPromedio(TitPromedio titPromedio) {
		return promedioRepositorio.save(titPromedio);
	}
}
