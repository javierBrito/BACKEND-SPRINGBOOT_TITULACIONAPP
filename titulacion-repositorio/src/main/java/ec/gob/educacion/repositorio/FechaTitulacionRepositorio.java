package ec.gob.educacion.repositorio;

import ec.gob.educacion.model.TitFechaTitulacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FechaTitulacionRepositorio extends JpaRepository<TitFechaTitulacion, Long> {
	
	List<TitFechaTitulacion> findByReanleCodigoAndTipeduCodigoAndFtiEstado(Long reanleCodigo, Long tipeduCodigo, Integer ftiEstado);

	TitFechaTitulacion findByFtiCodigo(Long ftiCodigo);
	
	List<TitFechaTitulacion> findByFtiEstado(Integer ftiEstado);
}
