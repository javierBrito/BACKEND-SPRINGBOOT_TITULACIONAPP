package ec.gob.educacion.service.impl;

import ec.gob.educacion.model.TitModeloPromedio;
import ec.gob.educacion.repositorio.ModeloPromedioRepositorio;
import ec.gob.educacion.service.ModeloPromedioServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModeloPromedioServicioImpl implements ModeloPromedioServicio {

	@Autowired
	private ModeloPromedioRepositorio modeloPromedioRepositorio;

	@Override
	public List<TitModeloPromedio> listarTodosModeloPromedio() {
		return modeloPromedioRepositorio.findAll();
	}

	@Override
	public List<TitModeloPromedio> listarModeloPromedioPorRegAniLecYTipoEducacion(Long reanleCodigo,
			Long tipeduCodigo, Integer mprEstado) {
		return modeloPromedioRepositorio.findByReanleCodigoAndTipeduCodigoAndMprEstadoOrderByMprDenominacionAsc(reanleCodigo, tipeduCodigo, mprEstado);
	}

	@Override
	public List<TitModeloPromedio> listarModeloPromedioPorRegAniLec(Long reanleCodigo, Integer mprEstado) {
		return modeloPromedioRepositorio.findByReanleCodigoAndMprEstado(reanleCodigo, mprEstado);
	}
	
	@Override
	public TitModeloPromedio buscarModeloPromedioPorCodigo(Long mprCodigo) {
		return modeloPromedioRepositorio.findByMprCodigo(mprCodigo);
	}
	
	public TitModeloPromedio guardarModeloPromedio(TitModeloPromedio titModeloPromedio) {
		return modeloPromedioRepositorio.save(titModeloPromedio);
	}
}
