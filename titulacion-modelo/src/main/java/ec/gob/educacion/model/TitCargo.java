package ec.gob.educacion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TIT_CARGO")
@SequenceGenerator(name = "TIT_CARGO_GENERATOR", sequenceName = "SEQ_TIT_CARGO", allocationSize = 1)
public class TitCargo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIT_CARGO_GENERATOR")
	@Column(name = "CAR_CODIGO", nullable = false)
	private Long carCodigo;

	@Size(max = 50)
	@Column(name = "CAR_NOMBRE", length = 50)
	private String carNombre;

	@Column(name = "CAR_ESTADO")
	private Integer carEstado;

	public Long getCarCodigo() {
		return carCodigo;
	}

	public void setCarCodigo(Long id) {
		this.carCodigo = id;
	}

	public String getCarNombre() {
		return carNombre;
	}

	public void setCarNombre(String carNombre) {
		this.carNombre = carNombre;
	}

	public Integer getCarEstado() {
		return carEstado;
	}

	public void setCarEstado(Integer carEstado) {
		this.carEstado = carEstado;
	}

}
