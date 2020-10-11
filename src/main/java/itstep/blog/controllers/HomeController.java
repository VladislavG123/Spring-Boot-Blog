package itstep.blog.controllers;

import itstep.blog.data.DataContext;
import itstep.blog.data.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private PostsRepository postsRepository;

    @GetMapping("/")
    public String index(Model model) {
        var posts = DataContext.getPosts(postsRepository);
        model.addAttribute("posts", posts);

        return "index";
    }

}
