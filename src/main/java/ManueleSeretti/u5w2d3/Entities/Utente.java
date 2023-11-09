package ManueleSeretti.u5w2d3.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Utente {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String cognome;
    private String email;
    private LocalDate data;
    private String avatar;

}
