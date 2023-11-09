package ManueleSeretti.u5w2d3.Service;

import ManueleSeretti.u5w2d3.Entities.Utente;
import ManueleSeretti.u5w2d3.Repository.UtenteRepository;
import ManueleSeretti.u5w2d3.exceptions.BadRequestException;
import ManueleSeretti.u5w2d3.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;

    public Utente save(Utente body) {
        utenteRepository.findByEmail(body.getEmail()).ifPresent(user -> {
            throw new BadRequestException("L'email " + user.getEmail() + " è già utilizzata!");
        });
        body.setAvatar("http://ui-avatars.com/api/?name=" + body.getName() + "+" + body.getCognome());

        return utenteRepository.save(body);
    }

    public Page<Utente> getUtente(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return utenteRepository.findAll(pageable);
    }

    public Utente findById(long id) {
        return utenteRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(long id) {
        Utente u = this.findById(id);
        utenteRepository.delete(u);
    }

    public Utente findByIdAndUpdate(long id, Utente body) {
        Utente found = this.findById(id);

        found.setId(id);
        found.setName(body.getName());
        found.setCognome(body.getCognome());
        found.setEmail(body.getEmail());
        found.setAvatar(body.getAvatar());
        found.setData(body.getData());

        return utenteRepository.save(found);

    }
}

