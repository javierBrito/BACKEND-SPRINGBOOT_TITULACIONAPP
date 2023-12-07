package ec.gob.educacion.repositorio;

import ec.gob.educacion.model.TitCalificacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalificacionRepositorio extends JpaRepository<TitCalificacion, Long> {

	List<TitCalificacion> findByEstCodigoAndCalEstado(Long estCodigo, Integer proEstado);

	TitCalificacion findByCalCodigo(Long calCodigo);
}
