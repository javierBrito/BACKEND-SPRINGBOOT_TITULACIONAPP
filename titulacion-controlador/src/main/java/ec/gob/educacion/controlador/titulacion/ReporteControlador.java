package ec.gob.educacion.controlador.titulacion;

import ec.gob.educacion.model.constantes.Constantes;
import ec.gob.educacion.model.response.ResponseGenerico;
import ec.gob.educacion.service.ReporteServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("private/")
public class ReporteControlador {
	@Autowired
	private ReporteServicio reporteServicio;

	/**
	 * REST para obtener Reporte Titulación 25
	 * 
	 * @return ResponseGenerico (reporte generado)
	 */
	@GetMapping(value = "obtenerReporteTitulo25/{repCodigo}")
	public ResponseGenerico<String> obtenerReporteTitulo25(@PathVariable("repCodigo") Long repCodigo) {
		System.out.println("Controlador - obtenerReporteTitulo25()");
		// Pruebas Reportes jbrito-20230217
		List<String> reporteBase64 = reporteServicio.obtenerReporteTitulo25(repCodigo);
		System.out.println("reporteBase64.size() = "+reporteBase64.size());
		// Respuesta
		ResponseGenerico<String> response = new ResponseGenerico<>();
		response.setListado(reporteBase64);
		response.setTotalRegistros((long) reporteBase64.size());
		response.setCodigoRespuesta(Constantes.CODIGO_RESPUESTA_OK);
		response.setMensaje(Constantes.MENSAJE_OK);
	
		return response;	
	}
}
