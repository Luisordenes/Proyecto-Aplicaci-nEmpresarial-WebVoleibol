package cl.ciisa.evaluacion.voleibol.evaluacion3voleibol.service;

import cl.ciisa.evaluacion.voleibol.evaluacion3voleibol.modelo.entity.JugadorInfo;

import java.util.List;

public interface JugadorInfoService {

    JugadorInfo getJugadorInfo(Long id);

    JugadorInfo createJugadorInfo(JugadorInfo jugadorInfo);

    List<JugadorInfo> getAllJugadorInfo();

    JugadorInfo updateJugadorInfo(Long id, JugadorInfo jugadorInfo);

    void deleteJugadorInfo(Long id);

}
