package itstep.blog.controllers;

import com.sun.jdi.event.StepEvent;
import itstep.blog.data.DataContext;
import itstep.blog.data.PostDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AdminController {

    @GetMapping("/admin/login")
    public String login() {
        return "/admin/login";
    }

    @PostMapping("/admin/login")
    public String loginHandler(HttpServletResponse response, String name, String password) {
        var author = DataContext.authorizeAuthorOrNull(name, password);

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

        DataContext.createPost(new PostDto(title, details, authorId));

        model.addAttribute("pushes", "Пост создан успешно!");

        return "/admin/panel";
    }
}
