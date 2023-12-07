package ec.gob.educacion.repositorio;

import ec.gob.educacion.model.TitInstitucion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitucionRepositorio extends JpaRepository<TitInstitucion, Long> {
	
	List<TitInstitucion> findByCodAmie(String codAmie);
	
	List<TitInstitucion> findByNomInstitucion(String nomInstitucion);
	
	TitInstitucion findByCodInstitucion(Long codInstitucion);

}
