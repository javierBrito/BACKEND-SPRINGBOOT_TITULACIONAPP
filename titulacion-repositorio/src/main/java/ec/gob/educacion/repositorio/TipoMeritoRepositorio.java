package ec.gob.educacion.repositorio;

import ec.gob.educacion.model.TitTipoMerito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoMeritoRepositorio extends JpaRepository<TitTipoMerito, Long> {
	
	TitTipoMerito findByCodTipoMerito(Long codTipoMerito);

}
