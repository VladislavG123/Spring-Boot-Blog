package itstep.blog.data;

import itstep.blog.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorsRepository extends CrudRepository<Author, Integer> {
}
