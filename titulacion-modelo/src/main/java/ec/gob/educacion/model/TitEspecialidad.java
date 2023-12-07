package ec.gob.educacion.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "TIT_ESPECIALIDAD")
@SequenceGenerator(name = "TIT_ESPECIALIDAD_GENERATOR", sequenceName = "SEQ_TIT_ESPECIALIDAD", allocationSize = 1)
public class TitEspecialidad {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIT_ESPECIALIDAD_GENERATOR")
	@Column(name = "COD_ESPECIALIDAD", nullable = false)
	private Long codEspecialidad;

	@NotNull
	@Column(name = "COD_TITULO", nullable = false)
	private Long codTitulo;

	@Size(max = 100)
	@Column(name = "NOM_ESPECIALIDAD", length = 100)
	private String nomEspecialidad;

	@Size(max = 5)
	@Column(name = "STS_ESTADO", length = 5)
	private String stsEstado;

	@Column(name = "FEC_CREACION")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "es-EC", timezone = "America/Lima")
	private LocalDate fecCreacion;

	@Size(max = 100)
	@Column(name = "NOM_USUARIO_CRC", length = 100)
	private String nomUsuarioCrc;

	@Column(name = "FEC_ACTUALIZACION")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "es-EC", timezone = "America/Lima")
	private LocalDate fecActualizacion;

	@Size(max = 50)
	@Column(name = "NOM_USUARIO_ACT", length = 50)
	private String nomUsuarioAct;

	@Size(max = 100)
	@Column(name = "NOM_APLICACION", length = 100)
	private String nomAplicacion;

	public TitEspecialidad() {
	}

	public Long getCodEspecialidad() {
		return codEspecialidad;
	}

	public void setCodEspecialidad(Long codEspecialidad) {
		this.codEspecialidad = codEspecialidad;
	}

	public Long getCodTitulo() {
		return codTitulo;
	}

	public void setCodTitulo(Long codTitulo) {
		this.codTitulo = codTitulo;
	}

	public String getNomEspecialidad() {
		return nomEspecialidad;
	}

	public void setNomEspecialidad(String nomEspecialidad) {
		this.nomEspecialidad = nomEspecialidad;
	}

	public String getStsEstado() {
		return stsEstado;
	}

	public void setStsEstado(String stsEstado) {
		this.stsEstado = stsEstado;
	}

	public LocalDate getFecCreacion() {
		return fecCreacion;
	}

	public void setFecCreacion(LocalDate fecCreacion) {
		this.fecCreacion = fecCreacion;
	}

	public String getNomUsuarioCrc() {
		return nomUsuarioCrc;
	}

	public void setNomUsuarioCrc(String nomUsuarioCrc) {
		this.nomUsuarioCrc = nomUsuarioCrc;
	}

	public LocalDate getFecActualizacion() {
		return fecActualizacion;
	}

	public void setFecActualizacion(LocalDate fecActualizacion) {
		this.fecActualizacion = fecActualizacion;
	}

	public String getNomUsuarioAct() {
		return nomUsuarioAct;
	}

	public void setNomUsuarioAct(String nomUsuarioAct) {
		this.nomUsuarioAct = nomUsuarioAct;
	}

	public String getNomAplicacion() {
		return nomAplicacion;
	}

	public void setNomAplicacion(String nomAplicacion) {
		this.nomAplicacion = nomAplicacion;
	}
}
