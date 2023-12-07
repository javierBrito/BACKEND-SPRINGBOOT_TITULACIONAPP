package ec.gob.educacion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TIT_CALIFICACION")
@SequenceGenerator(name = "TIT_CALIFICACION_GENERATOR", sequenceName = "SEQ_TIT_CALIFICACION", allocationSize = 1)
public class TitCalificacion {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIT_CALIFICACION_GENERATOR")
	@Column(name = "CAL_CODIGO", nullable = false)
	private Long calCodigo;

	@NotNull
	@Column(name = "MCA_CODIGO", nullable = false)
	private Long mcaCodigo;

	@NotNull
	@Column(name = "EST_CODIGO", nullable = false)
	private Long estCodigo;

	@NotNull
	@Column(name = "CAL_VALOR")
	private Float calValor;

	@Column(name = "CAL_ESTADO")
	private Integer calEstado;

	public TitCalificacion() {
	}

	public Long getCalCodigo() {
		return calCodigo;
	}

	public void setCalCodigo(Long calCodigo) {
		this.calCodigo = calCodigo;
	}

	public Long getMcaCodigo() {
		return mcaCodigo;
	}

	public void setMcaCodigo(Long mcaCodigo) {
		this.mcaCodigo = mcaCodigo;
	}

	public Long getEstCodigo() {
		return estCodigo;
	}

	public void setEstCodigo(Long estCodigo) {
		this.estCodigo = estCodigo;
	}

	public Float getCalValor() {
		return calValor;
	}

	public void setCalValor(Float calValor) {
		this.calValor = calValor;
	}

	public Integer getCalEstado() {
		return calEstado;
	}

	public void setCalEstado(Integer calEstado) {
		this.calEstado = calEstado;
	}
}
