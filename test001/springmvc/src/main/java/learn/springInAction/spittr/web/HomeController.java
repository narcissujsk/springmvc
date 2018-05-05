package learn.springInAction.spittr.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("spitter")
@RequestMapping({"/spitter","/s"})

public class HomeController {

@RequestMapping(method = GET)
  public String home(Model model) {
    return "spitter/home";
  }

}
