package ManueleSeretti.u5w2d3.Repository;

import ManueleSeretti.u5w2d3.Entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<BlogPost, Long> {
}
