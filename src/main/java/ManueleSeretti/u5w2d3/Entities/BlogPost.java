package ManueleSeretti.u5w2d3.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class BlogPost {
    @Id
    @GeneratedValue
    private long id;
    private String category;
    private String title;
    private String cover;
    private String contenuto;
    private int tempoLettura;
    @CreationTimestamp
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "utente_id_id")
    private Utente utenteId;


    public BlogPost(String category, String title, String cover, String contenuto, int tempoLettura, Utente utenteId) {
        this.category = category;
        this.title = title;
        this.cover = cover;
        this.contenuto = contenuto;
        this.tempoLettura = tempoLettura;
        this.utenteId = utenteId;
    }
}
