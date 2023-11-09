package ManueleSeretti.u5w2d3;

import ManueleSeretti.u5w2d3.Service.BlogPostService;
import ManueleSeretti.u5w2d3.Service.UtenteService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Random;

@Component
public class RunnerPost implements CommandLineRunner {
    @Autowired
    private BlogPostService blogPostService;

    @Autowired
    private UtenteService utenteService;
    private Faker faker = new Faker(Locale.ITALY);

    @Override
    public void run(String... args) throws Exception {
        Random rndm = new Random();
//        for (int i = 0; i < 50; i++) {
//            Utente u = utenteService.findById(rndm.nextInt(1, 20));
//            blogPostService.save(new BlogPost(
//                    faker.book().genre(),
//                    faker.book().title(),
//                    "...",
//                    faker.superhero().descriptor(),
//                    rndm.nextInt(3, 10),
//                    u));
//        }

    }
}
