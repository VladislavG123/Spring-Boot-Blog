package itstep.blog.controllers;

import itstep.blog.data.AuthorsRepository;
import itstep.blog.data.DataContext;
import itstep.blog.data.PostDto;
import itstep.blog.data.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AdminController {

    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private AuthorsRepository authorsRepository;


    @GetMapping("/admin/login")
    public String login() {
        return "/admin/login";
    }

    @PostMapping("/admin/login")
    public String loginHandler(HttpServletResponse response, String name, String password) {
        var author = DataContext.authorizeAuthorOrNull(authorsRepository, name, password);

        if(author == null) {
            return "/admin/login";
        }

        Cookie cookie = new Cookie("id", String.valueOf(author.getId()));
        response.addCookie(cookie);

        return "/admin/panel";
    }

    private int getAuthorId(HttpServletRequest request) {
        int authorId = -1;

        var cookies = request.getCookies();

        if (cookies == null) {
            return authorId;
        }

        for (var cookie: cookies) {
            if (cookie.getName().equals("id")) {
                authorId = Integer.parseInt(cookie.getValue());
            }
        }

        return authorId;
    }

    @GetMapping("/admin/panel")
    public String adminPanel(HttpServletRequest request) {
        if (getAuthorId(request) == -1) {
            return "/admin/login";
        }

        return "/admin/panel";
    }


    @PostMapping("/admin/createPost")
    public String createPost(Model model, HttpServletRequest request, String title, String details) {
        int authorId = getAuthorId(request);

        if (authorId == -1) {
            return "/admin/login";
        }

        DataContext.createPost(postsRepository, new PostDto(title, details, authorId));

        model.addAttribute("pushes", "Пост создан успешно!");

        return "/admin/panel";
    }
}
