package ec.gob.educacion.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "TIT_FECHA_TITULACION")
@SequenceGenerator(name = "TIT_FECHA_TITULACION_GENERATOR", sequenceName = "SEQ_TIT_FECHA_TITULACION", allocationSize = 1)
public class TitFechaTitulacion {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIT_FECHA_TITULACION_GENERATOR")
	@Column(name = "FTI_CODIGO", nullable = false)
	private Long ftiCodigo;

	@NotNull
	@Column(name = "REANLE_CODIGO", nullable = false)
	private Long reanleCodigo;

	@NotNull
	@Column(name = "TIPEDU_CODIGO", nullable = false)
	private Long tipeduCodigo;

	@Column(name = "FTI_INICIO_GENERAL")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "es-EC", timezone = "America/Lima")
	private Date ftiInicioGeneral;

	@Column(name = "FTI_FIN_GENERAL")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "es-EC", timezone = "America/Lima")
	private Date ftiFinGeneral;

	@Column(name = "FTI_INICIO_EXONERADO")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "es-EC", timezone = "America/Lima")
	private Date ftiInicioExonerado;

	@Column(name = "FTI_FIN_EXONERADO")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "es-EC", timezone = "America/Lima")
	private Date ftiFinExonerado;

	@Column(name = "FTI_FECHA_GRADO")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "es-EC", timezone = "America/Lima")
	private Date ftiFechaGrado;

	@Column(name = "FTI_ESTADO")
	private Integer ftiEstado;

	public TitFechaTitulacion() {
	}

	public Long getFtiCodigo() {
		return ftiCodigo;
	}

	public void setFtiCodigo(Long ftiCodigo) {
		this.ftiCodigo = ftiCodigo;
	}

	public Long getReanleCodigo() {
		return reanleCodigo;
	}

	public void setReanleCodigo(Long reanleCodigo) {
		this.reanleCodigo = reanleCodigo;
	}

	public Long getTipeduCodigo() {
		return tipeduCodigo;
	}

	public void setTipeduCodigo(Long tipeduCodigo) {
		this.tipeduCodigo = tipeduCodigo;
	}

	public Date getFtiInicioGeneral() {
		return ftiInicioGeneral;
	}

	public void setFtiInicioGeneral(Date ftiInicioGeneral) {
		this.ftiInicioGeneral = ftiInicioGeneral;
	}

	public Date getFtiFinGeneral() {
		return ftiFinGeneral;
	}

	public void setFtiFinGeneral(Date ftiFinGeneral) {
		this.ftiFinGeneral = ftiFinGeneral;
	}

	public Date getFtiInicioExonerado() {
		return ftiInicioExonerado;
	}

	public void setFtiInicioExonerado(Date ftiInicioExonerado) {
		this.ftiInicioExonerado = ftiInicioExonerado;
	}

	public Date getFtiFinExonerado() {
		return ftiFinExonerado;
	}

	public void setFtiFinExonerado(Date ftiFinExonerado) {
		this.ftiFinExonerado = ftiFinExonerado;
	}

	public Integer getFtiEstado() {
		return ftiEstado;
	}

	public void setFtiEstado(Integer ftiEstado) {
		this.ftiEstado = ftiEstado;
	}

	public Date getFtiFechaGrado() {
		return ftiFechaGrado;
	}

	public void setFtiFechaGrado(Date ftiFechaGrado) {
		this.ftiFechaGrado = ftiFechaGrado;
	}
	
}
