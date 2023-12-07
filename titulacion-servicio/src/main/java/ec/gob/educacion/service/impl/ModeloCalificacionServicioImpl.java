package ec.gob.educacion.service.impl;

import ec.gob.educacion.model.TitModeloCalificacion;
import ec.gob.educacion.repositorio.ModeloCalificacionRepositorio;
import ec.gob.educacion.service.ModeloCalificacionServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModeloCalificacionServicioImpl implements ModeloCalificacionServicio {

	@Autowired
	private ModeloCalificacionRepositorio modeloCalificacionRepositorio;

	@Override
	public List<TitModeloCalificacion> listarTodosModeloCalificacion() {
		return modeloCalificacionRepositorio.findAll();
	}

	@Override
	public List<TitModeloCalificacion> listarModeloCalificacionPorRegAniLecYTipoEducacion(Long reanleCodigo,
			Long tipeduCodigo, Integer mcaEstado) {
		return modeloCalificacionRepositorio.findByReanleCodigoAndTipeduCodigoAndMcaEstadoOrderByMcaDenominacionAsc(reanleCodigo, tipeduCodigo, mcaEstado);
	}

	@Override
	public List<TitModeloCalificacion> listarModeloCalificacionPorRegAniLec(Long reanleCodigo, Integer mcaEstado) {
		return modeloCalificacionRepositorio.findByReanleCodigoAndMcaEstado(reanleCodigo, mcaEstado);
	}	
	@Override
	public TitModeloCalificacion buscarModeloCalificacionPorCodigo(Long mcaCodigo) {
		return modeloCalificacionRepositorio.findByMcaCodigo(mcaCodigo);
	}
	
	public TitModeloCalificacion guardarModeloCalificacion(TitModeloCalificacion titModeloCalificacion) {
		return modeloCalificacionRepositorio.save(titModeloCalificacion);
	}

}
