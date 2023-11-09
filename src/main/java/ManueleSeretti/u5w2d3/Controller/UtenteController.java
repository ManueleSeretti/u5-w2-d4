package ManueleSeretti.u5w2d3.Controller;

import ManueleSeretti.u5w2d3.Entities.Utente;
import ManueleSeretti.u5w2d3.Service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/utenti")
public class UtenteController {
    @Autowired
    private UtenteService usersService;

    @GetMapping("")
    public Page<Utente> getUtente(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        return usersService.getUtente(page, size);
    }

    // 2. POST http://localhost:3001/users (+ body)
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED) // <-- 201
    public Utente saveUtente(@RequestBody Utente body) {
        return usersService.save(body);
    }

    // 3. GET http://localhost:3001/users/:id
    @GetMapping("/{id}")
    public Utente findById(@PathVariable int id) {
        return usersService.findById(id);
    }

    // 4. PUT http://localhost:3001/users/:id (+ body)
    @PutMapping("/{id}")
    public Utente findByIdAndUpdate(@PathVariable int id, @RequestBody Utente body) {
        return usersService.findByIdAndUpdate(id, body);
    }

    // 5. DELETE http://localhost:3001/users/:id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
    public void findByIdAndDelete(@PathVariable int id) {
        usersService.findByIdAndDelete(id);
    }
}
