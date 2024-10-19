package co.com.tyba.challenge.devops.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import co.com.tyba.challenge.devops.service.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class CatController {

    private final CatService catService;

    @GetMapping("/cat")
    public String getCat(Model model) {
        String cat = catService.getCat();
        String title = "Here is your random cat";
        model.addAttribute("title", title);
        model.addAttribute("cat", cat);
        return "cat-view";
    }

    @GetMapping("/cat/random")
    public String getCatWithRandomText(Model model) {
        String title = "Here is your random cat with a random text";
        model.addAttribute("title", title);
        String cat = catService.getCatWithRandomText();
        model.addAttribute("cat", cat);
        return "cat-view";
    }
}
