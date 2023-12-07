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
@Table(name = "TIT_TITULADO")
@SequenceGenerator(name = "TIT_TITULADO_GENERATOR", sequenceName = "SEQ_TIT_TITULADO", allocationSize = 1)
public class TitTitulado {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIT_TITULADO_GENERATOR")
	@Column(name = "COD_TITULADO", nullable = false)
	private Long codTitulado;

	@NotNull
	@Column(name = "COD_INSTITUCION", nullable = false)
	private Long codInstitucion;

	@NotNull
	@Column(name = "COD_ESPECIALIDAD", nullable = false)
	private Long codEspecialidad;

	@Size(max = 15)
	@Column(name = "NOM_CEDULA", length = 15)
	private String nomCedula;

	@Size(max = 80)
	@Column(name = "NOM_TITULADO", length = 80)
	private String nomTitulado;

	@Column(name = "FEC_FECHA_GRADO")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "es-EC", timezone = "America/Lima")
	private Date fecFechaGrado;

	@Size(max = 20)
	@Column(name = "COD_REFRENDACION", length = 20)
	private String codRefrendacion;

	@NotNull
	@Column(name = "VAL_CALIFICACION", nullable = false)
	private Long valCalificacion;

	@Size(max = 5)
	@Column(name = "STS_TIPO", length = 5)
	private String stsTipo;

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

	@Size(max = 50)
	@Column(name = "TIT_NUM_REFRENDACION_25", length = 50)
	private String titNumRefrendacion25;

	@NotNull
	@Column(name = "COD_TIPO_IDENTIFICACION", nullable = false)
	private Long codTipoIdentificacion;

	@NotNull
	@Column(name = "COD_DISTRITO", nullable = false)
	private Long codDistrito;

	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_AUTORIZACION_EDICION")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "es-EC", timezone = "America/Lima")
	private Date fechaAutorizacionEdicion;

	@Size(max = 50)
	@Column(name = "OBSERVACION_EDICION", length = 50)
	private String observacionEdicion;

	public TitTitulado() {
	}

	public Long getCodTitulado() {
		return codTitulado;
	}

	public void setCodTitulado(Long codTitulado) {
		this.codTitulado = codTitulado;
	}

	public Long getCodInstitucion() {
		return codInstitucion;
	}

	public void setCodInstitucion(Long codInstitucion) {
		this.codInstitucion = codInstitucion;
	}

	public Long getCodEspecialidad() {
		return codEspecialidad;
	}

	public void setCodEspecialidad(Long codEspecialidad) {
		this.codEspecialidad = codEspecialidad;
	}

	public String getNomCedula() {
		return nomCedula;
	}

	public void setNomCedula(String nomCedula) {
		this.nomCedula = nomCedula;
	}

	public String getNomTitulado() {
		return nomTitulado;
	}

	public void setNomTitulado(String nomTitulado) {
		this.nomTitulado = nomTitulado;
	}

	public Date getFecFechaGrado() {
		return fecFechaGrado;
	}

	public void setFecFechaGrado(Date fecFechaGrado) {
		this.fecFechaGrado = fecFechaGrado;
	}

	public String getCodRefrendacion() {
		return codRefrendacion;
	}

	public void setCodRefrendacion(String codRefrendacion) {
		this.codRefrendacion = codRefrendacion;
	}

	public Long getValCalificacion() {
		return valCalificacion;
	}

	public void setValCalificacion(Long valCalificacion) {
		this.valCalificacion = valCalificacion;
	}

	public String getStsTipo() {
		return stsTipo;
	}

	public void setStsTipo(String stsTipo) {
		this.stsTipo = stsTipo;
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

	public String getTitNumRefrendacion25() {
		return titNumRefrendacion25;
	}

	public void setTitNumRefrendacion25(String titNumRefrendacion25) {
		this.titNumRefrendacion25 = titNumRefrendacion25;
	}

	public Long getCodTipoIdentificacion() {
		return codTipoIdentificacion;
	}

	public void setCodTipoIdentificacion(Long codTipoIdentificacion) {
		this.codTipoIdentificacion = codTipoIdentificacion;
	}

	public Long getCodDistrito() {
		return codDistrito;
	}

	public void setCodDistrito(Long codDistrito) {
		this.codDistrito = codDistrito;
	}

	public Date getFechaAutorizacionEdicion() {
		return fechaAutorizacionEdicion;
	}

	public void setFechaAutorizacionEdicion(Date fechaAutorizacionEdicion) {
		this.fechaAutorizacionEdicion = fechaAutorizacionEdicion;
	}

	public String getObservacionEdicion() {
		return observacionEdicion;
	}

	public void setObservacionEdicion(String observacionEdicion) {
		this.observacionEdicion = observacionEdicion;
	}

}
