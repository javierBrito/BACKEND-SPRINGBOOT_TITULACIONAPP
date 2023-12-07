package ec.gob.educacion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
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
@Table(name = "TIT_COMISION")
@SequenceGenerator(name = "TIT_COMISION_GENERATOR", sequenceName = "SEQ_TIT_COMISION", allocationSize = 1)
public class TitComision {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIT_COMISION_GENERATOR")
	@Column(name = "COD_COMISION", nullable = false)
	private Long codComision;

	@NotNull
	@Column(name = "COD_INSTITUCION", nullable = false)
	private Long codInstitucion;

	@NotNull
	@Column(name = "COD_INC_ANIO_LECTIVO", nullable = false)
	private Long codIncAnioLectivo;

	@NotNull
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CAR_CODIGO", nullable = false, insertable = false, updatable = false)
	private TitCargo titCargo;

	@Column(name = "CAR_CODIGO")
	private Long carCodigo;

	@NotNull
	@Column(name = "COD_JORNADA", nullable = false)
	private Long codJornada;

	@Size(max = 20)
	@Column(name = "NOM_CEDULA", length = 20)
	private String nomCedula;

	@Size(max = 80)
	@Column(name = "NOM_COMISION", length = 80)
	private String nomComision;

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

	public Long getCodComision() {
		return codComision;
	}

	public void setCodComision(Long id) {
		this.codComision = id;
	}

	public Long getCodInstitucion() {
		return codInstitucion;
	}

	public void setCodInstitucion(Long codInstitucion) {
		this.codInstitucion = codInstitucion;
	}

	public Long getCodIncAnioLectivo() {
		return codIncAnioLectivo;
	}

	public void setCodIncAnioLectivo(Long codIncAnioLectivo) {
		this.codIncAnioLectivo = codIncAnioLectivo;
	}

	public TitCargo getTitCargo() {
		return titCargo;
	}

	public void setTitCargo(TitCargo titCargo) {
		this.titCargo = titCargo;
	}

	public Long getCarCodigo() {
		return carCodigo;
	}

	public void setCarCodigo(Long carCodigo) {
		this.carCodigo = carCodigo;
	}

	public Long getCodJornada() {
		return codJornada;
	}

	public void setCodJornada(Long codJornada) {
		this.codJornada = codJornada;
	}

	public String getNomCedula() {
		return nomCedula;
	}

	public void setNomCedula(String nomCedula) {
		this.nomCedula = nomCedula;
	}

	public String getNomComision() {
		return nomComision;
	}

	public void setNomComision(String nomComision) {
		this.nomComision = nomComision;
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
