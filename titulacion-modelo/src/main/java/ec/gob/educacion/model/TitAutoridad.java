package ec.gob.educacion.model;

import java.util.Date;

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
@Table(name = "TIT_AUTORIDAD")
@SequenceGenerator(name = "TIT_AUTORIDAD_GENERATOR", sequenceName = "SEQ_TIT_AUTORIDAD", allocationSize = 1)
public class TitAutoridad {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIT_AUTORIDAD_GENERATOR")
	@Column(name = "COD_AUTORIDAD", nullable = false)
	private Long codAutoridad;

	@NotNull
	@Column(name = "COD_INSTITUCION", nullable = false)
	private Long codInstitucion;

	@Size(max = 20)
	@Column(name = "NOM_CEDULA", length = 20)
	private String nomCedula;

	@Size(max = 80)
	@Column(name = "NOM_AUTORIDAD", length = 80)
	private String nomAutoridad;

	@Size(max = 80)
	@Column(name = "NOM_CARGO", length = 80)
	private String nomCargo;

	@Size(max = 5)
	@Column(name = "STS_ESTADO", length = 5)
	private String stsEstado;

	@Column(name = "FEC_CREACION")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "es-EC", timezone = "America/Lima")
	private Date fecCreacion;

	@Size(max = 100)
	@Column(name = "NOM_USUARIO_CRC", length = 100)
	private String nomUsuarioCrc;

	@Column(name = "FEC_ACTUALIZACION")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "es-EC", timezone = "America/Lima")
	private Date fecActualizacion;

	@Size(max = 50)
	@Column(name = "NOM_USUARIO_ACT", length = 50)
	private String nomUsuarioAct;

	@Size(max = 100)
	@Column(name = "NOM_APLICACION", length = 100)
	private String nomAplicacion;

	public Long getCodAutoridad() {
		return codAutoridad;
	}

	public void setCodAutoridad(Long codAutoridad) {
		this.codAutoridad = codAutoridad;
	}

	public Long getCodInstitucion() {
		return codInstitucion;
	}

	public void setCodInstitucion(Long codInstitucion) {
		this.codInstitucion = codInstitucion;
	}

	public String getNomCedula() {
		return nomCedula;
	}

	public void setNomCedula(String nomCedula) {
		this.nomCedula = nomCedula;
	}

	public String getNomAutoridad() {
		return nomAutoridad;
	}

	public void setNomAutoridad(String nomAutoridad) {
		this.nomAutoridad = nomAutoridad;
	}

	public String getNomCargo() {
		return nomCargo;
	}

	public void setNomCargo(String nomCargo) {
		this.nomCargo = nomCargo;
	}

	public String getStsEstado() {
		return stsEstado;
	}

	public void setStsEstado(String stsEstado) {
		this.stsEstado = stsEstado;
	}

	public Date getFecCreacion() {
		return fecCreacion;
	}

	public void setFecCreacion(Date fecCreacion) {
		this.fecCreacion = fecCreacion;
	}

	public String getNomUsuarioCrc() {
		return nomUsuarioCrc;
	}

	public void setNomUsuarioCrc(String nomUsuarioCrc) {
		this.nomUsuarioCrc = nomUsuarioCrc;
	}

	public Date getFecActualizacion() {
		return fecActualizacion;
	}

	public void setFecActualizacion(Date fecActualizacion) {
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
