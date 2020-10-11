package itstep.blog.data;

import itstep.blog.models.Author;
import itstep.blog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;

public class DataContext {
    public static Iterable<Post> getPosts(PostsRepository postsRepository) {
        return postsRepository.findAll();
    }

    public static Author getAuthorOrNull(AuthorsRepository authorsRepository, int id) {
        var author = authorsRepository.findById(id);

        return author.get();
    }

    public static Author authorizeAuthorOrNull(AuthorsRepository authorsRepository, String name, String password) {
        var authors = authorsRepository.findAll();

        for (var author: authors) {
            if (author.getName().equals(name) && author.getPassword().equals(password)) {
                return author;
            }
        }

        return null;
    }

    public static void createPost(PostsRepository postsRepository, PostDto post) {
        postsRepository.save(new Post(1, post.getTitle(),
                post.getDetails(), post.getAuthorId()));
    }
}
