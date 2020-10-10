package itstep.blog.models;

public class Post {
    private int id;
    private String title;
    private String details;

    private Author author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Post() {
    }

    public Post(int id, String title, String details, Author author) {
        this.id = id;
        this.title = title;
        this.details = details;
        this.author = author;
    }
}
