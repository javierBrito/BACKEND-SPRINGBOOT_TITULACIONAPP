package ec.gob.educacion.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "TIT_PARAMETRO")
@SequenceGenerator(name = "TIT_PARAMETRO_GENERATOR", sequenceName = "SEQ_TIT_PARAMETRO", allocationSize = 1)
public class TitParametro implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIT_PARAMETRO_GENERATOR")
	@Column(name = "PAR_CODIGO", nullable = false)
	private Long parCodigo;

	@NotNull
	@Size(max = 20)
	@Column(name = "PAR_NOMBRE", length = 20)
	private String parNombre;

	@NotNull
	@Size(max = 100)
	@Column(name = "PAR_VALOR", length = 100)
	private String parValor;

	@Size(max = 200)
	@Column(name = "PAR_DESCRIPCION", length = 200)
	private String parDescripcion;

	@Column(name = "PAR_ESTADO")
	private Integer parEstado;

	@Column(name = "PAR_FEC_FIN")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "es-EC", timezone = "America/Lima")
	private Date parFecFin;

	@Column(name = "PAR_FEC_INICIO")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "es-EC", timezone = "America/Lima")
	private Date parFecInicio;

	public TitParametro() {
	}

	public Long getParCodigo() {
		return parCodigo;
	}

	public void setParCodigo(Long parCodigo) {
		this.parCodigo = parCodigo;
	}

	public String getParNombre() {
		return parNombre;
	}

	public void setParNombre(String parNombre) {
		this.parNombre = parNombre;
	}

	public String getParValor() {
		return parValor;
	}

	public void setParValor(String parValor) {
		this.parValor = parValor;
	}

	public String getParDescripcion() {
		return parDescripcion;
	}

	public void setParDescripcion(String parDescripcion) {
		this.parDescripcion = parDescripcion;
	}

	public Integer getParEstado() {
		return parEstado;
	}

	public void setParEstado(Integer parEstado) {
		this.parEstado = parEstado;
	}

	public Date getParFecFin() {
		return parFecFin;
	}

	public void setParFecFin(Date parFecFin) {
		this.parFecFin = parFecFin;
	}

	public Date getParFecInicio() {
		return parFecInicio;
	}

	public void setParFecInicio(Date parFecInicio) {
		this.parFecInicio = parFecInicio;
	}
}
