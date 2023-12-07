package ec.gob.educacion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TIT_REFRENDACION")
@SequenceGenerator(name = "TIT_REFRENDACION_GENERATOR", sequenceName = "SEQ_TIT_REFRENDACION", allocationSize = 1)
public class TitRefrendacion {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIT_REFRENDACION_GENERATOR")
	@Column(name = "REF_CODIGO", nullable = false)
	private Long refCodigo;

	@NotNull
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PES_CODIGO", nullable = false, insertable = false, updatable = false)
	private TitParticipacionEst titParticipacionEst;

	@Column(name = "PES_CODIGO")
	private Long pesCodigo;

	@NotNull
	@Column(name = "CODIGO", nullable = false)
	private Long codigo;

	@Column(name = "REF_CALIFUNO")
	private Float refCalifuno;

	@Column(name = "REF_CALIFDOS")
	private Float refCalifdos;

	@Column(name = "REF_CALIFTRES")
	private Float refCaliftres;

	@Column(name = "REF_CALIFCUATRO")
	private Float refCalifcuatro;

	@Column(name = "REF_PROMEDIO")
	private Float refPromedio;

	@Column(name = "REF_ENES")
	private Long refEnes;

	@Column(name = "REF_VALUNO")
	private Long refValuno;

	@Column(name = "REF_VALDOS")
	private Long refValdos;

	@Column(name = "REF_VALTRES")
	private Long refValtres;

	@Column(name = "REF_VALCUATRO")
	private Long refValcuatro;

	@Column(name = "REF_VALCINCO")
	private Long refValcinco;

	@Column(name = "REF_IMPRESION")
	private Long refImpresion;

	@Column(name="REF_FECHA_GRADO")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "es-EC", timezone = "America/Lima")
	private Date refFechaGrado;
	
	@Column(name="REF_FECHA_REFRENDACION")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "es-EC", timezone = "America/Lima")
	private Date refFechaRefrendacion;
	
	@Size(max = 50)
	@Column(name = "REF_CODIGO_REF", length = 50)
	private String refCodigoRef;

	@Size(max = 250)
	@Column(name = "REF_PROMEDIO_LETRAS", length = 250)
	private String refPromedioLetras;

	@Column(name = "APRUEBA_PPE")
	private Boolean apruebaPpe;

	@Column(name = "NUM_RECTIFICACION")
	private Long numRectificacion;

	@Column(name = "NUM_REZAGADO")
	private Long numRezagado;

	@Column(name = "REF_EXONERADO")
	private Long refExonerado;

	@Column(name = "REF_CALIFQUINTA")
	private Float refCalifquinta;

	public TitRefrendacion() {
	}

	public Long getRefCodigo() {
		return refCodigo;
	}

	public void setRefCodigo(Long id) {
		this.refCodigo = id;
	}

	public TitParticipacionEst getTitParticipacionEst() {
		return titParticipacionEst;
	}

	public void setTitParticipacionEst(TitParticipacionEst titParticipacionEst) {
		this.titParticipacionEst = titParticipacionEst;
	}

	public Long getPesCodigo() {
		return pesCodigo;
	}

	public void setPesCodigo(Long pesCodigo) {
		this.pesCodigo = pesCodigo;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Float getRefCalifuno() {
		return refCalifuno;
	}

	public void setRefCalifuno(Float refCalifuno) {
		this.refCalifuno = refCalifuno;
	}

	public Float getRefCalifdos() {
		return refCalifdos;
	}

	public void setRefCalifdos(Float refCalifdos) {
		this.refCalifdos = refCalifdos;
	}

	public Float getRefCaliftres() {
		return refCaliftres;
	}

	public void setRefCaliftres(Float refCaliftres) {
		this.refCaliftres = refCaliftres;
	}

	public Float getRefCalifcuatro() {
		return refCalifcuatro;
	}

	public void setRefCalifcuatro(Float refCalifcuatro) {
		this.refCalifcuatro = refCalifcuatro;
	}

	public Float getRefPromedio() {
		return refPromedio;
	}

	public void setRefPromedio(Float refPromedio) {
		this.refPromedio = refPromedio;
	}

	public Long getRefEnes() {
		return refEnes;
	}

	public void setRefEnes(Long refEnes) {
		this.refEnes = refEnes;
	}

	public Long getRefValuno() {
		return refValuno;
	}

	public void setRefValuno(Long refValuno) {
		this.refValuno = refValuno;
	}

	public Long getRefValdos() {
		return refValdos;
	}

	public void setRefValdos(Long refValdos) {
		this.refValdos = refValdos;
	}

	public Long getRefValtres() {
		return refValtres;
	}

	public void setRefValtres(Long refValtres) {
		this.refValtres = refValtres;
	}

	public Long getRefValcuatro() {
		return refValcuatro;
	}

	public void setRefValcuatro(Long refValcuatro) {
		this.refValcuatro = refValcuatro;
	}

	public Long getRefValcinco() {
		return refValcinco;
	}

	public void setRefValcinco(Long refValcinco) {
		this.refValcinco = refValcinco;
	}

	public Long getRefImpresion() {
		return refImpresion;
	}

	public void setRefImpresion(Long refImpresion) {
		this.refImpresion = refImpresion;
	}

	public Date getRefFechaGrado() {
		return refFechaGrado;
	}

	public void setRefFechaGrado(Date refFechaGrado) {
		this.refFechaGrado = refFechaGrado;
	}

	public Date getRefFechaRefrendacion() {
		return refFechaRefrendacion;
	}

	public void setRefFechaRefrendacion(Date refFechaRefrendacion) {
		this.refFechaRefrendacion = refFechaRefrendacion;
	}

	public String getRefCodigoRef() {
		return refCodigoRef;
	}

	public void setRefCodigoRef(String refCodigoRef) {
		this.refCodigoRef = refCodigoRef;
	}

	public String getRefPromedioLetras() {
		return refPromedioLetras;
	}

	public void setRefPromedioLetras(String refPromedioLetras) {
		this.refPromedioLetras = refPromedioLetras;
	}

	public Boolean getApruebaPpe() {
		return apruebaPpe;
	}

	public void setApruebaPpe(Boolean apruebaPpe) {
		this.apruebaPpe = apruebaPpe;
	}

	public Long getNumRectificacion() {
		return numRectificacion;
	}

	public void setNumRectificacion(Long numRectificacion) {
		this.numRectificacion = numRectificacion;
	}

	public Long getNumRezagado() {
		return numRezagado;
	}

	public void setNumRezagado(Long numRezagado) {
		this.numRezagado = numRezagado;
	}

	public Long getRefExonerado() {
		return refExonerado;
	}

	public void setRefExonerado(Long refExonerado) {
		this.refExonerado = refExonerado;
	}

	public Float getRefCalifquinta() {
		return refCalifquinta;
	}

	public void setRefCalifquinta(Float refCalifquinta) {
		this.refCalifquinta = refCalifquinta;
	}

}
