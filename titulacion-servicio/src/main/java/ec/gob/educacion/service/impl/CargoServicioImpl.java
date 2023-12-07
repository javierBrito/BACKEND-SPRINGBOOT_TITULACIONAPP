package ec.gob.educacion.service.impl;

import ec.gob.educacion.model.TitCargo;
import ec.gob.educacion.repositorio.CargoRepositorio;
import ec.gob.educacion.service.CargoServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargoServicioImpl implements CargoServicio {

	@Autowired
	private CargoRepositorio cargoRepositorio;

	@Override
	public List<TitCargo> listarTodosCargo() {
		return cargoRepositorio.findAll();
	}

	@Override
	public List<TitCargo> listarCargoActivo(Integer carEstado) {
		return cargoRepositorio.findByCarEstado(carEstado);
	}
	
	@Override
	public TitCargo buscarCargoPorCodigo(Long carCodigo) {
		return cargoRepositorio.findByCarCodigo(carCodigo);
	}
	
	@Override
	public TitCargo registrar(TitCargo titCargo) {
		return cargoRepositorio.save(titCargo);
	}
}
