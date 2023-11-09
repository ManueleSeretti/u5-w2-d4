package ManueleSeretti.u5w2d3.payloads;

import ManueleSeretti.u5w2d3.Entities.Utente;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record newPostDTO(
        @NotEmpty(message = "La categoria è un campo obbligatorio!")
        String category,
        @NotEmpty(message = "Il titolo è un campo obbligatorio!")
        String title,
        @NotEmpty(message = "Il contenuto è un campo obbligatorio!")
        String contenuto,
        @NotNull(message = "tempo di lettura è un campo obbligatorio!")
        int tempoLettura,
        @NotNull(message = "L'autore è un campo obbligatorio!")
        Utente utente

) {
}
