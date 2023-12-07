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
@Table(name = "TIT_TITULO")
@SequenceGenerator(name = "TIT_TITULO_GENERATOR", sequenceName = "SEQ_TIT_TITULO", allocationSize = 1)
public class TitTitulo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIT_TITULO_GENERATOR")
	@Column(name = "COD_TITULO", nullable = false)
	private Long codTitulo;

	@NotNull
	@Column(name = "COD_TIPO_TITULO", nullable = false)
	private Long codTipoTitulo;

	@Size(max = 150)
	@Column(name = "NOM_TITULO", length = 150)
	private String nomTitulo;

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

	public TitTitulo() {
	}

	public Long getCodTitulo() {
		return codTitulo;
	}

	public void setCodTitulo(Long codTitulo) {
		this.codTitulo = codTitulo;
	}

	public Long getCodTipoTitulo() {
		return codTipoTitulo;
	}

	public void setCodTipoTitulo(Long codTipoTitulo) {
		this.codTipoTitulo = codTipoTitulo;
	}

	public String getNomTitulo() {
		return nomTitulo;
	}

	public void setNomTitulo(String nomTitulo) {
		this.nomTitulo = nomTitulo;
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
