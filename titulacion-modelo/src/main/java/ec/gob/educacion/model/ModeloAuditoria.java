package ec.gob.educacion.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class ModeloAuditoria {

	@CreatedBy
	@Column(name = "NOM_USUARIO_CRC")
	protected String creadoPor;

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FEC_CREACION")
	protected Date fechaHoraCreacion;

	@LastModifiedBy
	@Column(name = "NOM_USUARIO_ACT")
	protected String ultimaActualizacionPor;

	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FEC_ACTUALIZACION")
	protected Date fechaHoraUltimaActualizacion;

}
