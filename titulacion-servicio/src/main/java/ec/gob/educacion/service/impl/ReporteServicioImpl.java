package ec.gob.educacion.service.impl;

import ec.gob.educacion.model.TitCargo;
import ec.gob.educacion.service.ReporteServicio;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ReporteServicioImpl implements ReporteServicio {
	// Obtener valores desde application.properties
	@Value("${spring.profiles.active}")
    private String ambienteActivo;
	
	// Variables tratar valores de parámetros
	private String urlBackground;
	private String pattern = "###.00";
	private String valCalificacion;

	// Pruebas Reportes jbrito-20230217
	@Override
	public List<String> obtenerReporteTitulo25(Long repCodigo) {
		System.out.println("ReporteServicioImpl - obtenerReporteTitulo25()");
		
		// Mostrar imagen del fondo del título, según el ambiente
		this.ambienteActivo = (this.ambienteActivo == null) ? "nulo" : this.ambienteActivo;
		if (this.ambienteActivo.equals("prod")) {
			urlBackground = "/img/fondotitulo.png";
		} else {
			urlBackground = "/img/fondo_titulo.png";
		}
		
		// Instanciar la clase para pruebas
		TitCargo titCargo = new TitCargo();
		titCargo.setCarCodigo(99L);
		titCargo.setCarEstado(1);
		titCargo.setCarNombre("Pruebas NOMBRE CARGO");

		// Formatear nota
		Double valNotaDouble = 10.00;
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		valCalificacion = decimalFormat.format(valNotaDouble);

		//System.out.println("Inicia listaCargo");
		//List<TitCargo> listaCargo = cargoServicio.listarCargoActivo(EstadoEnum.ACTIVO.getCodigo());

		// Para pasar el reporte pdf en base 64
		List<String> reporteBase64 = new ArrayList<>();
		
		try {
			// Variable parametro, para pasar todo tipo de variable: normal, list, map, collection.
			Map<String, Object> parametro = new HashMap<String, Object>();
			
			// Mapear registro, pasarlo como parametro. (En irepot se lo define como: java.util.Map)
			Map<String, String> titCargoMap = BeanUtils.describe(titCargo);
			parametro.put("titCargo", titCargoMap);

			// Pasar variables normales tipo String. (En irepot se lo define como: java.util.String)
			parametro.put("URL_BACKGROUND", urlBackground);
			parametro.put("NOM_INSTITUCION", "NOMBRE INSTITUCIÓN");
			parametro.put("PROVINCIA", "PROVINCIA DE PRUEBA");
			parametro.put("CERTIFICADO", "1707025746");
			parametro.put("NOM_TITULADO", "JAVIER BRITO");
			parametro.put("RECTOR", "RECTOR");
			parametro.put("SECRETARIA", "SECRETARIA");
			parametro.put("VAL_CALIFICACION", valCalificacion);
			parametro.put("LETRAS", "NOTA EN LETRAS");
			
			// Bloque funcionando jbrito-20230223
			/*
			System.out.println("Inicia JasperReport");
			JasperReport jasperReport = (JasperReport) JRLoader
					.loadObject(getClass().getResourceAsStream("/reporte/titulo25/CertificadoTituloDuplicado.jasper"));
			
			System.out.println("Inicia JasperPrint");
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro,
					new JREmptyDataSource());
			*/
			// Bloque CESLI
			System.out.println("Inicia Bloque CESLI - jasperReport");
			JasperReport jasperReport = (JasperReport) JRLoader
					.loadObject(getClass().getResourceAsStream("/reporte/titulo25/CertificadoTituloDuplicado.jasper"));
			System.out.println("Inicia Bloque CESLI - jasperPrint");
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, new JREmptyDataSource());
			// Cuando se pasa una lista, en ireport se lo define en el apartado de FIELDS cada campo.
			//JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro,
			//		new JRBeanCollectionDataSource(listaCargo));

			System.out.println("Inicia Bloque CESLI - bytes");
			byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint);
			
			System.out.println("Inicia Bloque CESLI - reporteBase64");
			reporteBase64.add(Base64.getEncoder().encodeToString(bytes));

			System.out.println("Fin Bloque CESLI");

			// Exporta, guarda en una carpeta, el informe en PDF jbrito-20230217 OK
			System.out.println("Inicia JasperExportManager");
			JasperExportManager.exportReportToPdfFile(jasperPrint, "D:\\upload\\CertificadoTituloDuplicado.pdf");
			
			
			// Para visualizar el pdf directamente desde java
			//System.out.println("Para visualizar el pdf directamente desde java");
			//JasperViewer.viewReport(jasperPrint, true);
			
			//System.out.println("Inicia vista previa");
			//JasperPrintManager.printReport(jasperPrint, true);
			
			// Bloque para mostrar el reporte directamente
			/*
			System.out.println("Inicia JasperViewer");
			JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
			System.out.println("Inicia visualiza.setTitle()");
			jasperViewer.setTitle("Reporte de Cargos");
			System.out.println("Inicia visualiza.setVisible()");
			jasperViewer.setVisible(true);
			*/
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("e.getMessage() = "+e.getMessage());
			// mensaje = "ERROR al generar el PDF. " + e.getMessage();
		}
	
		return reporteBase64;
	}
}
