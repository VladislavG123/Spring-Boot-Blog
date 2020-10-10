package itstep.blog.data;

import itstep.blog.models.Author;

public class PostDto {
    private String title;
    private String details;

    private int authorId;

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

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public PostDto() {
    }

    public PostDto(String title, String details, int authorId) {
        this.title = title;
        this.details = details;
        this.authorId = authorId;
    }
}
