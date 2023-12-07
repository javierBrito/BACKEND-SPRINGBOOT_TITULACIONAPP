package ec.gob.educacion.repositorio;

import ec.gob.educacion.model.TitComision;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComisionRepositorio extends JpaRepository<TitComision, Long> {
	
	List<TitComision> findByCodInstitucionAndCodIncAnioLectivo(Long codInstitucion, Long codIncAnioLectivo);
	
	TitComision findByCodComision(Long codComision);
	
}
