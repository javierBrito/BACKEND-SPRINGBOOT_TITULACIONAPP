package ec.gob.educacion.repositorio;

import ec.gob.educacion.model.TitModeloCalificacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloCalificacionRepositorio extends JpaRepository<TitModeloCalificacion, Long> {
	
	List<TitModeloCalificacion> findByReanleCodigoAndTipeduCodigoAndMcaEstadoOrderByMcaDenominacionAsc(Long reanleCodigo, Long tipeduCodigo, Integer mcaEstado);
	
	List<TitModeloCalificacion> findByReanleCodigoAndMcaEstado(Long reanleCodigo, Integer mcaEstado);

	TitModeloCalificacion findByMcaCodigo(Long mcaCodigo);
}
