package itstep.blog.controllers;

import itstep.blog.data.DataContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        var posts = DataContext.getPosts();
        model.addAttribute("posts", posts);

        return "index";
    }

}
