package ec.gob.educacion.service;

import ec.gob.educacion.model.TitParametro;
import java.util.List;

public interface ParametroServicio {

	List<TitParametro> listarTodosParametro();

	List<TitParametro> listarParametroActivo(Integer parEstado);

	/**
	 * Permite obtener TitParametro
	 * 
	 * @param autCodigo
	 * @return TitParametro
	 */
	TitParametro buscarParametroPorCodigo(Long parCodigo);

	/**
	 * Permite guardar o actualizar TitParametro por DTO
	 * 
	 * @param TitParametroDTO a guarda/actualizar
	 * @return TitParametro guardado
	 */
	TitParametro guardarParametro(TitParametro titParametro);
	
	/**
	 * Permite registrar TitParametro
	 * 
	 * @param TitParametro
	 * @return TitParametro
	 */
	TitParametro registrar(TitParametro titParametro);


}
