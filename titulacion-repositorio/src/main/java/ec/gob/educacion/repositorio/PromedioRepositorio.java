package ec.gob.educacion.repositorio;

import ec.gob.educacion.model.TitPromedio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PromedioRepositorio extends JpaRepository<TitPromedio, Long> {
	
	List<TitPromedio> findByEstCodigoAndProEstado(Long estCodigo, Integer proEstado);

	TitPromedio findByProCodigo(Long proCodigo);

	@Query(nativeQuery = false, value = "select tp from TitPromedio tp where tp.estCodigo =:estCodigo and tp.titModeloPromedio.mprNemonico =:mprNemonico and tp.proEstado = 1")
	List<TitPromedio> listarPromedioPorEstudianteYNemonico(@Param("estCodigo") Long estCodigo, @Param("mprNemonico") String mprNemonico);

}
