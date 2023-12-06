package cl.ciisa.evaluacion.voleibol.evaluacion3voleibol.service.impl;

import cl.ciisa.evaluacion.voleibol.evaluacion3voleibol.exception.NotFoundException;
import cl.ciisa.evaluacion.voleibol.evaluacion3voleibol.modelo.dao.JugadorInfoDao;
import cl.ciisa.evaluacion.voleibol.evaluacion3voleibol.modelo.entity.JugadorInfo;
import cl.ciisa.evaluacion.voleibol.evaluacion3voleibol.service.JugadorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JugadorInfoServiceImpl implements JugadorInfoService {

    @Autowired
    private JugadorInfoDao jugadorInfoDao;

    @Override
    public JugadorInfo getJugadorInfo(Long id) {
        return jugadorInfoDao.findByIdAndActive(id, true).orElseThrow(NotFoundException::new);
    }

    @Override
    public JugadorInfo createJugadorInfo(JugadorInfo jugadorInfo) {
        return jugadorInfoDao.save(jugadorInfo);
    }

    @Override
    public List<JugadorInfo> getAllJugadorInfo() {
        return jugadorInfoDao.findAllByActiveOrderByIdDesc(true);
    }

    @Override
    public JugadorInfo updateJugadorInfo(Long id, JugadorInfo request) {
        JugadorInfo fromDB = getJugadorInfo(id);
        fromDB.setNombre(request.getNombre());
        fromDB.setApellido(request.getApellido());
        fromDB.setNacionalidad(request.getNacionalidad());
        fromDB.setNumeroCamiseta(request.getNumeroCamiseta());
        fromDB.setPosi(request.getPosi());
        fromDB.setActive(request.isActive());
        fromDB.setUpdated(LocalDate.now());

        return jugadorInfoDao.save(fromDB);
    }

    @Override
    public void deleteJugadorInfo(Long id) {
        JugadorInfo fromDB = getJugadorInfo(id);
        fromDB.setActive(false);
        jugadorInfoDao.save(fromDB);
    }
}
