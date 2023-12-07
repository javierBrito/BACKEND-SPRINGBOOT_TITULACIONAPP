package ec.gob.educacion.repositorio;

import ec.gob.educacion.model.TitModeloPromedio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloPromedioRepositorio extends JpaRepository<TitModeloPromedio, Long> {
	
	List<TitModeloPromedio> findByReanleCodigoAndTipeduCodigoAndMprEstadoOrderByMprDenominacionAsc(Long reanleCodigo, Long tipeduCodigo, Integer mprEstado);
	
	List<TitModeloPromedio> findByReanleCodigoAndMprEstado(Long reanleCodigo, Integer mprEstado);

	TitModeloPromedio findByMprCodigo(Long mprCodigo);
}
