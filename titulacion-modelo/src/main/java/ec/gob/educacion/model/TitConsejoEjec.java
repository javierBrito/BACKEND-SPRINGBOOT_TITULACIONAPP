package ec.gob.educacion.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "TIT_CONSEJO_EJEC")
@SequenceGenerator(name = "TIT_CONSEJO_EJEC_GENERATOR", sequenceName = "SEQ_TIT_CONSEJO_EJEC", allocationSize = 1)
public class TitConsejoEjec {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIT_CONSEJO_EJEC_GENERATOR")
	@Column(name = "CEJ_CODIGO", nullable = false)
	private Long cejCodigo;

	@Column(name = "CAR_CODIGO")
	private Long carCodigo;

	@Size(max = 10)
	@Column(name = "CEJ_CEDULA", length = 10)
	private String cejCedula;

	@Size(max = 100)
	@Column(name = "CEJ_NOMBRE", length = 100)
	private String cejNombre;

	@NotNull
	@Column(name = "INS_CODIGO", nullable = false)
	private Long insCodigo;

	@NotNull
	@Column(name = "REANLE_CODIGO", nullable = false)
	private Long reanleCodigo;

	@Column(name = "CEJ_ESTADO")
	private Integer cejEstado;

	@JsonIgnore
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CAR_CODIGO", nullable = false, insertable = false, updatable = false)
	private TitCargo titCargo;

	public TitConsejoEjec() {
	}

	public Long getCejCodigo() {
		return cejCodigo;
	}

	public void setCejCodigo(Long cejCodigo) {
		this.cejCodigo = cejCodigo;
	}

	public Long getCarCodigo() {
		return carCodigo;
	}

	public void setCarCodigo(Long carCodigo) {
		this.carCodigo = carCodigo;
	}

	public String getCejCedula() {
		return cejCedula;
	}

	public void setCejCedula(String cejCedula) {
		this.cejCedula = cejCedula;
	}

	public String getCejNombre() {
		return cejNombre;
	}

	public void setCejNombre(String cejNombre) {
		this.cejNombre = cejNombre;
	}

	public Long getInsCodigo() {
		return insCodigo;
	}

	public void setInsCodigo(Long insCodigo) {
		this.insCodigo = insCodigo;
	}

	public Long getReanleCodigo() {
		return reanleCodigo;
	}

	public Integer getCejEstado() {
		return cejEstado;
	}

	public void setCejEstado(Integer cejEstado) {
		this.cejEstado = cejEstado;
	}

	public void setReanleCodigo(Long reanleCodigo) {
		this.reanleCodigo = reanleCodigo;
	}

	public TitCargo getTitCargo() {
		return titCargo;
	}

	public void setTitCargo(TitCargo titCargo) {
		this.titCargo = titCargo;
	}

}
