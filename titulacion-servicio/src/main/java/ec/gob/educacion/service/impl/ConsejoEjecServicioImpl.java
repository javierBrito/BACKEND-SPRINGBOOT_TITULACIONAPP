package ec.gob.educacion.service.impl;

import ec.gob.educacion.model.TitConsejoEjec;
import ec.gob.educacion.repositorio.ConsejoEjecRepositorio;
import ec.gob.educacion.service.CargoServicio;
import ec.gob.educacion.service.ConsejoEjecServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsejoEjecServicioImpl implements ConsejoEjecServicio {

	@Autowired
	private ConsejoEjecRepositorio consejoEjecRepositorio;
	@Autowired
	private CargoServicio cargoServicio;

	@Override
	public List<TitConsejoEjec> listarTodosConsejoEjec() {
		return consejoEjecRepositorio.findAll();
	}

	@Override
	public List<TitConsejoEjec> listarConsejosEjecPorInstitucionYAnioLectivo(Long insCodigo,
			Long reanleCodigo, Integer cejEstado) {
		return consejoEjecRepositorio.findByInsCodigoAndReanleCodigoAndCejEstado(insCodigo, reanleCodigo, cejEstado);
	}
	
	@Override
	public TitConsejoEjec buscarConsejoEjecPorCodigo(Long cejCodigo) {
		return consejoEjecRepositorio.findByCejCodigo(cejCodigo);
	}
	
	public TitConsejoEjec guardarConsejoEjec(TitConsejoEjec titConsejoEjec) {
		if(titConsejoEjec.getCarCodigo() != null) {
			titConsejoEjec.setTitCargo(cargoServicio.buscarCargoPorCodigo(titConsejoEjec.getCarCodigo()));
		}
		return consejoEjecRepositorio.save(titConsejoEjec);
	}
	
	@Override
	public TitConsejoEjec registrar(TitConsejoEjec titConsejoEjec) {
		return consejoEjecRepositorio.save(titConsejoEjec);
	}
}
