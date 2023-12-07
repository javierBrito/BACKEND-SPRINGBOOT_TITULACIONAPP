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
@Table(name = "TIT_DISTINCION")
@SequenceGenerator(name = "TIT_DISTINCION_GENERATOR", sequenceName = "SEQ_TIT_DISTINCION", allocationSize = 1)
public class TitDistincion {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIT_DISTINCION_GENERATOR")
	@Column(name = "COD_DISTINCION", nullable = false)
	private Long codDistincion;

	@Size(max = 50)
	@Column(name = "DIS_NOMBRE", length = 50)
	private String disNombre;

	@NotNull
	@Column(name = "NUM_ORDINAL", nullable = false)
	private Long numOrdinal;

	public TitDistincion() {
	}

	public Long getCodDistincion() {
		return codDistincion;
	}

	public void setCodDistincion(Long codDistincion) {
		this.codDistincion = codDistincion;
	}

	public String getDisNombre() {
		return disNombre;
	}

	public void setDisNombre(String disNombre) {
		this.disNombre = disNombre;
	}

	public Long getNumOrdinal() {
		return numOrdinal;
	}

	public void setNumOrdinal(Long numOrdinal) {
		this.numOrdinal = numOrdinal;
	}

}
