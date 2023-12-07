package ec.gob.educacion.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "TIT_INSTITUCION")
@SequenceGenerator(name = "TIT_INSTITUCION_GENERATOR", sequenceName = "SEQ_TIT_INSTITUCION", allocationSize = 1)
public class TitInstitucion {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIT_INSTITUCION_GENERATOR")
	@Column(name = "COD_INSTITUCION", nullable = false)
	private Long codInstitucion;

	@Size(max = 10)
	@Column(name = "COD_AMIE", length = 10)
	private String codAmie;

	@Size(max = 150)
	@Column(name = "NOM_INSTITUCION", length = 150)
	private String nomInstitucion;

	@Size(max = 5)
	@Column(name = "STS_ESTADO", length = 5)
	private String stsEstado;

	@Size(max = 5)
	@Column(name = "STE_ACTIVA", length = 5)
	private String steActiva;

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

	public TitInstitucion() {
	}

	public Long getCodInstitucion() {
		return codInstitucion;
	}

	public void setCodInstitucion(Long codInstitucion) {
		this.codInstitucion = codInstitucion;
	}

	public String getCodAmie() {
		return codAmie;
	}

	public void setCodAmie(String codAmie) {
		this.codAmie = codAmie;
	}

	public String getNomInstitucion() {
		return nomInstitucion;
	}

	public void setNomInstitucion(String nomInstitucion) {
		this.nomInstitucion = nomInstitucion;
	}

	public String getStsEstado() {
		return stsEstado;
	}

	public void setStsEstado(String stsEstado) {
		this.stsEstado = stsEstado;
	}

	public String getSteActiva() {
		return steActiva;
	}

	public void setSteActiva(String steActiva) {
		this.steActiva = steActiva;
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
