package ManueleSeretti.u5w2d3.Controller;

import ManueleSeretti.u5w2d3.Entities.BlogPost;
import ManueleSeretti.u5w2d3.Service.BlogPostService;
import ManueleSeretti.u5w2d3.exceptions.BadRequestException;
import ManueleSeretti.u5w2d3.payloads.newPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/blogPosts")
public class BlogController {
    @Autowired
    private BlogPostService postService;

    // 1. GET http://localhost:3001/post (+ query params opzionali)
    @GetMapping("")
    public Page<BlogPost> getUtente(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        return postService.getPost(page, size);
    }

    // 2. POST http://localhost:3001/post (+ body)
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED) // <-- 201
    public BlogPost saveUtente(@RequestBody @Validated newPostDTO body, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        } else {
            try {
                return postService.save(body);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // 3. GET http://localhost:3001/post/:id
    @GetMapping("/{id}")
    public BlogPost findById(@PathVariable int id) {
        return postService.findById(id);
    }

    // 4. PUT http://localhost:3001/post/:id (+ body)
    @PutMapping("/{id}")
    public BlogPost findByIdAndUpdate(@PathVariable int id, @RequestBody BlogPost body) {
        return postService.findByIdAndUpdate(id, body);
    }

    // 5. DELETE http://localhost:3001/post/:id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
    public void findByIdAndDelete(@PathVariable int id) {
        postService.findByIdAndDelete(id);
    }
}
