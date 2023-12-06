package cl.ciisa.evaluacion.voleibol.evaluacion3voleibol.modelo.dao;

import cl.ciisa.evaluacion.voleibol.evaluacion3voleibol.modelo.entity.JugadorInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JugadorInfoDao extends CrudRepository<JugadorInfo, Long> {

    List<JugadorInfo> findAllByActiveOrderByIdDesc(boolean active);

    Optional<JugadorInfo> findByIdAndActive(Long id, boolean active);

}
