package ec.gob.educacion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TIT_MODELO_CALIFICACION")
@SequenceGenerator(name = "TIT_MODELO_CALIFICACION_GENERATOR", sequenceName = "SEQ_TIT_MODELO_CALIFICACION", allocationSize = 1)
public class TitModeloCalificacion {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIT_MODELO_CALIFICACION_GENERATOR")
	@Column(name = "MCA_CODIGO", nullable = false)
	private Long mcaCodigo;

	@NotNull
	@Column(name = "REANLE_CODIGO", nullable = false)
	private Long reanleCodigo;

	@Size(max = 150)
	@Column(name = "MCA_DENOMINACION", length = 150)
	private String mcaDenominacion;

	@Size(max = 100)
	@Column(name = "MCA_FORMULA", length = 150)
	private String mcaFormula;

	@NotNull
	@Column(name = "TIPEDU_CODIGO", nullable = false)
	private Long tipeduCodigo;

	@NotNull
	@Column(name = "MCA_DESDE")
	private Float mcaDesde;

	@NotNull
	@Column(name = "MCA_HASTA")
	private Float mcaHasta;

	@NotNull
	@Column(name = "MCA_PORCENTAJE")
	private Float mcaPorcentaje;

	@Column(name = "MCA_ESTADO")
	private Integer mcaEstado;

	public TitModeloCalificacion() {
	}

	public Long getMcaCodigo() {
		return mcaCodigo;
	}

	public void setMcaCodigo(Long mcaCodigo) {
		this.mcaCodigo = mcaCodigo;
	}

	public Long getReanleCodigo() {
		return reanleCodigo;
	}

	public void setReanleCodigo(Long reanleCodigo) {
		this.reanleCodigo = reanleCodigo;
	}

	public String getMcaDenominacion() {
		return mcaDenominacion;
	}

	public void setMcaDenominacion(String mcaDenominacion) {
		this.mcaDenominacion = mcaDenominacion;
	}

	public Long getTipeduCodigo() {
		return tipeduCodigo;
	}

	public void setTipeduCodigo(Long tipeduCodigo) {
		this.tipeduCodigo = tipeduCodigo;
	}

	public Float getMcaDesde() {
		return mcaDesde;
	}

	public void setMcaDesde(Float mcaDesde) {
		this.mcaDesde = mcaDesde;
	}

	public Float getMcaHasta() {
		return mcaHasta;
	}

	public void setMcaHasta(Float mcaHasta) {
		this.mcaHasta = mcaHasta;
	}

	public Float getMcaPorcentaje() {
		return mcaPorcentaje;
	}

	public void setMcaPorcentaje(Float mcaPorcentaje) {
		this.mcaPorcentaje = mcaPorcentaje;
	}

	public Integer getMcaEstado() {
		return mcaEstado;
	}

	public void setMcaEstado(Integer mcaEstado) {
		this.mcaEstado = mcaEstado;
	}

	public String getMcaFormula() {
		return mcaFormula;
	}

	public void setMcaFormula(String mcaFormula) {
		this.mcaFormula = mcaFormula;
	}
}
