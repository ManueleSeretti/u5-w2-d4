package ManueleSeretti.u5w2d3.Service;

import ManueleSeretti.u5w2d3.Entities.BlogPost;
import ManueleSeretti.u5w2d3.Repository.PostRepository;
import ManueleSeretti.u5w2d3.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogPostService {
    @Autowired
    private PostRepository postRepository;

    public BlogPost save(BlogPost body) {

        body.setCover("https://picsum.photos/200/300");

        return postRepository.save(body);
    }

    public Page<BlogPost> getPost(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return postRepository.findAll(pageable);
    }

    public BlogPost findById(long id) {
        return postRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(long id) {
        BlogPost post = this.findById(id);
    }

    public BlogPost findByIdAndUpdate(long id, BlogPost body) {
        BlogPost found = this.findById(id);

        found.setId(id);
        found.setCover(body.getCover());
        found.setTitle(body.getTitle());
        found.setCategory(body.getCategory());
        found.setContenuto(body.getContenuto());
        found.setTempoLettura(body.getTempoLettura());


        return postRepository.save(found);

    }
}
