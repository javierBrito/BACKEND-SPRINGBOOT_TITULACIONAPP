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
@Table(name = "TIT_MODELO_PROMEDIO")
@SequenceGenerator(name = "TIT_MODELO_PROMEDIO_GENERATOR", sequenceName = "SEQ_TIT_MODELO_PROMEDIO", allocationSize = 1)
public class TitModeloPromedio {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIT_MODELO_PROMEDIO_GENERATOR")
	@Column(name = "MPR_CODIGO", nullable = false)
	private Long mprCodigo;

	@NotNull
	@Column(name = "REANLE_CODIGO", nullable = false)
	private Long reanleCodigo;

	@NotNull
	@Column(name = "TIPEDU_CODIGO", nullable = false)
	private Long tipeduCodigo;
	
	@NotNull
	@Column(name = "GRA_CODIGO", nullable = false)
	private Long graCodigo;

	@Size(max = 50)
	@Column(name = "MPR_DENOMINACION", length = 50)
	private String mprDenominacion;
	
	@NotNull
	@Column(name = "MPR_DESDE")
	private Float mprDesde;

	@NotNull
	@Column(name = "MPR_HASTA")
	private Float mprHasta;

	@Column(name = "MPR_ESTADO")
	private Integer mprEstado;

	@Size(max = 10)
	@Column(name = "MPR_NEMONICO", length = 10)
	private String mprNemonico;

	public TitModeloPromedio() {
	}

	public Long getMprCodigo() {
		return mprCodigo;
	}

	public void setMprCodigo(Long mprCodigo) {
		this.mprCodigo = mprCodigo;
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

	public Long getGraCodigo() {
		return graCodigo;
	}

	public void setGraCodigo(Long graCodigo) {
		this.graCodigo = graCodigo;
	}

	public String getMprDenominacion() {
		return mprDenominacion;
	}

	public void setMprDenominacion(String mprDenominacion) {
		this.mprDenominacion = mprDenominacion;
	}

	public Float getMprDesde() {
		return mprDesde;
	}

	public void setMprDesde(Float mprDesde) {
		this.mprDesde = mprDesde;
	}

	public Float getMprHasta() {
		return mprHasta;
	}

	public void setMprHasta(Float mprHasta) {
		this.mprHasta = mprHasta;
	}

	public Integer getMprEstado() {
		return mprEstado;
	}

	public void setMprEstado(Integer mprEstado) {
		this.mprEstado = mprEstado;
	}

	public String getMprNemonico() {
		return mprNemonico;
	}

	public void setMprNemonico(String mprNemonico) {
		this.mprNemonico = mprNemonico;
	}
}
