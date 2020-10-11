package itstep.blog.data;

import itstep.blog.models.Author;
import itstep.blog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;

public class DataContext {
    @Autowired
    private static PostsRepository postsRepository;

    public static Iterable<Post> getPosts() {
        return postsRepository.findAll();
    }

    public static Author getAuthorOrNull(int id) {


        return null;
    }

    public static Author authorizeAuthorOrNull(String name, String password) {

        return null;
    }

    public static void createPost(PostDto post) {
        postsRepository.save(new Post(1, post.getTitle(),
                post.getDetails(), 1));
    }
}
