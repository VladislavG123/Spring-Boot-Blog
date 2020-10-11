package itstep.blog.data;

import itstep.blog.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostsRepository extends CrudRepository<Post, Integer> {

}
