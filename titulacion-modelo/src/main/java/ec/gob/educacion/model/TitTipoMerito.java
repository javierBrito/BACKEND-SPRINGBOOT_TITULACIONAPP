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
@Table(name = "TIT_TIPO_MERITO")
@SequenceGenerator(name = "TIT_TIPO_MERITO_GENERATOR", sequenceName = "SEQ_TIT_TIPO_MERITO", allocationSize = 1)
public class TitTipoMerito {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIT_TIPO_MERITO_GENERATOR")
	@Column(name = "COD_TIPO_MERITO", nullable = false)
	private Long codTipoMerito;

	@Size(max = 100)
	@Column(name = "TME_NOMBRE", length = 100)
	private String tmeNombre;

	public TitTipoMerito() {
	}

	public Long getCodTipoMerito() {
		return codTipoMerito;
	}

	public void setCodTipoMerito(Long codTipoMerito) {
		this.codTipoMerito = codTipoMerito;
	}

	public String getTmeNombre() {
		return tmeNombre;
	}

	public void setTmeNombre(String tmeNombre) {
		this.tmeNombre = tmeNombre;
	}

}
