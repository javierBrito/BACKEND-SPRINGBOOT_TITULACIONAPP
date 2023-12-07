package ec.gob.educacion.model;

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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TIT_PROMEDIO")
@SequenceGenerator(name = "TIT_PROMEDIO_GENERATOR", sequenceName = "SEQ_TIT_PROMEDIO", allocationSize = 1)
public class TitPromedio {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIT_PROMEDIO_GENERATOR")
	@Column(name = "PRO_CODIGO", nullable = false)
	private Long proCodigo;

	@JsonIgnore
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "MPR_CODIGO", nullable = false, insertable = false, updatable = false)
	private TitModeloPromedio titModeloPromedio;

	@Transient
	private Long mprCodigo;

	@NotNull
	@Column(name = "PRO_VALOR")
	private Float proValor;

	@Column(name = "PRO_ESTADO")
	private Integer proEstado;

	@NotNull
	@Column(name = "EST_CODIGO", nullable = false)
	private Long estCodigo;

	public TitPromedio() {
	}

	public Long getProCodigo() {
		return proCodigo;
	}

	public void setProCodigo(Long proCodigo) {
		this.proCodigo = proCodigo;
	}

	public Long getMprCodigo() {
		if (titModeloPromedio != null) {
			mprCodigo = titModeloPromedio.getMprCodigo(); 
		}
		return mprCodigo;
	}

	public void setMprCodigo(Long mprCodigo) {
		this.mprCodigo = mprCodigo;
	}

	public Long getEstCodigo() {
		return estCodigo;
	}

	public void setEstCodigo(Long estCodigo) {
		this.estCodigo = estCodigo;
	}

	public Float getProValor() {
		return proValor;
	}

	public void setProValor(Float proValor) {
		this.proValor = proValor;
	}

	public Integer getProEstado() {
		return proEstado;
	}

	public void setProEstado(Integer proEstado) {
		this.proEstado = proEstado;
	}

	public TitModeloPromedio getTitModeloPromedio() {
		return titModeloPromedio;
	}

	public void setTitModeloPromedio(TitModeloPromedio titModeloPromedio) {
		this.titModeloPromedio = titModeloPromedio;
	}
}
