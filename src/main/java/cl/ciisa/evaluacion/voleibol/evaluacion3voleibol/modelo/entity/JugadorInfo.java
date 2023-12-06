package cl.ciisa.evaluacion.voleibol.evaluacion3voleibol.modelo.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "jugador_info")
@Data
public class JugadorInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "nacionalidad")
    private String nacionalidad;

    @Column(name = "numero_camiseta")
    private int numeroCamiseta;

    private Posicion posi;

    private boolean active;

    private LocalDate created = LocalDate.now();

    private LocalDate updated = LocalDate.now();

}
