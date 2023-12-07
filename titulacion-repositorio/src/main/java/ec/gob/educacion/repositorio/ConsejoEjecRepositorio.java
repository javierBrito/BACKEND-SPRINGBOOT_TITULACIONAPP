package ec.gob.educacion.repositorio;

import ec.gob.educacion.model.TitConsejoEjec;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsejoEjecRepositorio extends JpaRepository<TitConsejoEjec, Long> {
	
	List<TitConsejoEjec> findByInsCodigoAndReanleCodigoAndCejEstado(Long insCodigo, Long reanleCodigo, Integer cejEstado);

	TitConsejoEjec findByCejCodigo(Long cejCodigo);
}
