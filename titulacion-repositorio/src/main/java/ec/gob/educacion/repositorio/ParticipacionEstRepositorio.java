package ec.gob.educacion.repositorio;

import ec.gob.educacion.model.TitParticipacionEst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipacionEstRepositorio extends JpaRepository<TitParticipacionEst, Long> {

	TitParticipacionEst findByPesCodigo(Long pesCodigo);

}
