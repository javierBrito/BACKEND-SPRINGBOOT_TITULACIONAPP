package ec.gob.educacion.service.impl;

import ec.gob.educacion.model.TitParametro;
import ec.gob.educacion.repositorio.ParametroRepositorio;
import ec.gob.educacion.service.ParametroServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParametroServicioImpl implements ParametroServicio {

	@Autowired
	private ParametroRepositorio parametroRepositorio;

	@Override
	public List<TitParametro> listarTodosParametro() {
		return parametroRepositorio.findAll();
	}

	@Override
	public List<TitParametro> listarParametroActivo(Integer parEstado) {
		return parametroRepositorio.findByParEstado(parEstado);
	}
	
	@Override
	public TitParametro buscarParametroPorCodigo(Long parCodigo) {
		return parametroRepositorio.findByParCodigo(parCodigo);
	}
	
	public TitParametro guardarParametro(TitParametro titParametro) {
		return parametroRepositorio.save(titParametro);
	}
	
	@Override
	public TitParametro registrar(TitParametro titParametro) {
		return parametroRepositorio.save(titParametro);
	}
}
