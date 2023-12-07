package ec.gob.educacion.service.impl;

import ec.gob.educacion.model.TitComision;
import ec.gob.educacion.repositorio.ComisionRepositorio;
import ec.gob.educacion.service.CargoServicio;
import ec.gob.educacion.service.ComisionServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComisionServicioImpl implements ComisionServicio {

	@Autowired
	private ComisionRepositorio comisionRepositorio;
	@Autowired
	private CargoServicio cargoServicio;
	
	@Override
	public List<TitComision> listarTodosComision() {
		return comisionRepositorio.findAll();
	}

	@Override
	public List<TitComision> listarComisionPorInstitucionYAnioLectivo(Long codInstitucion, Long codIncAnioLectivo) {
		return comisionRepositorio.findByCodInstitucionAndCodIncAnioLectivo(codInstitucion, codIncAnioLectivo);
	}
	
	@Override
	public TitComision buscarComisionPorCodigo(Long codComision) {
		return comisionRepositorio.findByCodComision(codComision);
	}
	
	@Override
	public TitComision registrar(TitComision titComision) {
		if (titComision.getCarCodigo() != null) {
			titComision.setTitCargo(cargoServicio.buscarCargoPorCodigo(titComision.getCarCodigo()));
		}
		return comisionRepositorio.save(titComision);
	}
}
