package cl.ciisa.evaluacion.voleibol.evaluacion3voleibol.controller;

import cl.ciisa.evaluacion.voleibol.evaluacion3voleibol.modelo.entity.JugadorInfo;
import cl.ciisa.evaluacion.voleibol.evaluacion3voleibol.service.JugadorInfoService;
import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class JugadorInfoController {

    @Autowired
    private JugadorInfoService jugadorInfoService;

    @GetMapping(value = {"jugador", "/"})
    public String getJugadores(Model model){
        List<JugadorInfo> jugadores = jugadorInfoService.getAllJugadorInfo();
        model.addAttribute("jugadores", jugadores);
        model.addAttribute("jugadorInfo", new JugadorInfo());
        return "jugadores";
    }

    @PostMapping("/jugador")
    public RedirectView crearJugador(RedirectAttributes redirectAttributes, @ModelAttribute JugadorInfo jugadorInfo) {
        jugadorInfo.setActive(true);
        jugadorInfoService.createJugadorInfo(jugadorInfo);
        String message = "Jugador <b>" + jugadorInfo.getNombre() + " " + jugadorInfo.getApellido() + "</b> a sido agregado al equipo!";
        RedirectView redirectView = new RedirectView("/jugador", true);
        redirectAttributes.addFlashAttribute("jugadorMessage", message);
        return redirectView;
    }

    @GetMapping("/jugador/{id}")
    public String getJugador(Model model, @PathVariable("id") Long id) {
        JugadorInfo jugadorInfo = jugadorInfoService.getJugadorInfo(id);
        model.addAttribute("jugadorInfo", jugadorInfo);
        return "edit";
    }

    @PostMapping(path = "/jugador/{id}")
    public RedirectView updateJugador(RedirectAttributes redirectAttributes, @PathVariable("id") Long id, @ModelAttribute JugadorInfo jugadorInfo) {
        jugadorInfoService.updateJugadorInfo(id, jugadorInfo);
        String message = "Se ha " + (jugadorInfo.isActive() ? "modificado " : "eliminado ") + " al jugador <b>" + jugadorInfo.getNombre() + " " + jugadorInfo.getApellido() + "</b>.";
        RedirectView redirectView = new RedirectView("/jugador", true);
        redirectAttributes.addFlashAttribute("jugadorMessage", message);
        return redirectView;
    }

}
