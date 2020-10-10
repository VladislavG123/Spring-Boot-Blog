package itstep.blog.data;

import itstep.blog.models.Author;
import itstep.blog.models.Post;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataContext {
    private static ArrayList<Author> authorList;
    private static int lastAuthorId;

    private static ArrayList<Post> postList;
    private static int lastPostId;


    static {
        authorList = new ArrayList<>(Collections.singletonList(
                new Author(1, "admin", "123123")
        ));
        lastAuthorId = 1;

        postList = new ArrayList<>(Collections.singletonList(
                new Post(1, "Title test", "Some details", authorList.get(0))
        ));
    }


    public static ArrayList<Post> getPosts() {
        return postList;
    }

    public static Author getAuthorOrNull(int id) {
        for (var author: authorList) {
            if (author.getId() == id) {
                return author;
            }
        }

        return null;
    }


    public static Author authorizeAuthorOrNull(String name, String password) {
        for (var author: authorList) {
            if (author.getName().equals(name) &&
                    author.getPassword().equals(password)) {
                return author;
            }
        }
        return null;
    }

    public static void createPost(PostDto post) {
        postList.add(new Post(++lastPostId, post.getTitle(),
                post.getDetails(), getAuthorOrNull(post.getAuthorId())));
    }
}
