package ec.gob.educacion.service;

import java.util.List;

public interface ReporteServicio {

	/**
	 * Permite obtener reporte Titulación 25
	 * 
	 * @param null
	 * @return reporte generado Titulación 25
	 */
	List<String> obtenerReporteTitulo25(Long repCodigo);
}
