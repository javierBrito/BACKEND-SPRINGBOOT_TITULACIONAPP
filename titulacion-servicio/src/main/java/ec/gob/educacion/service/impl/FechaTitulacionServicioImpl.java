package ec.gob.educacion.service.impl;

import ec.gob.educacion.model.TitFechaTitulacion;
import ec.gob.educacion.repositorio.FechaTitulacionRepositorio;
import ec.gob.educacion.service.FechaTitulacionServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FechaTitulacionServicioImpl implements FechaTitulacionServicio {

	@Autowired
	private FechaTitulacionRepositorio fechaTitulacionRepositorio;

	@Override
	public List<TitFechaTitulacion> listarTodosFechaTitulacion() {
		return fechaTitulacionRepositorio.findAll();
	}

	@Override
	public List<TitFechaTitulacion> listarFechaTitulacionActivo(Integer ftiEstado) {
		return fechaTitulacionRepositorio.findByFtiEstado(ftiEstado);	
	}
	
	@Override
	public List<TitFechaTitulacion> listarFechaTitulacionPorRegAniLecYTipoEducacion(Long reanleCodigo,
			Long tipeduCodigo, Integer ftiEstado) {
		return fechaTitulacionRepositorio.findByReanleCodigoAndTipeduCodigoAndFtiEstado(reanleCodigo, tipeduCodigo, ftiEstado);
	}
	
	@Override
	public TitFechaTitulacion buscarFechaTitulacionPorCodigo(Long ftiCodigo) {
		return fechaTitulacionRepositorio.findByFtiCodigo(ftiCodigo);
	}
	
	public TitFechaTitulacion guardarFechaTitulacion(TitFechaTitulacion titFechaTitulacion) {
		return fechaTitulacionRepositorio.save(titFechaTitulacion);
	}
	
	@Override
	public TitFechaTitulacion registrar(TitFechaTitulacion titFechaTitulacion) {
		return fechaTitulacionRepositorio.save(titFechaTitulacion);
	}

}
