package learn.springInAction.spittr.tiles;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import learn.springInAction.spittr.Spitter;
import learn.springInAction.spittr.data.SpitterRepository;


@Controller("tilesSpitterController")
@RequestMapping("/spitter/tiles")
public class SpitterController {

  private SpitterRepository spitterRepository;

  @Autowired
  public SpitterController(SpitterRepository spitterRepository) {
    this.spitterRepository = spitterRepository;
  }
  
  @RequestMapping(value="/register", method=GET)
  public String showRegistrationForm(Model model) {
    model.addAttribute(new Spitter());
    return "t/registerForm";
  }
  
  @RequestMapping(value="/register", method=POST)
  public String processRegistration(
      @Valid Spitter spitter, 
      Errors errors) {
    if (errors.hasErrors()) {
      return "t/registerForm";
    }
    
    spitterRepository.save(spitter);
    return "redirect:/spitter/tiles/" + spitter.getUsername();
  }
  
  @RequestMapping(value="/{username}", method=GET)
  public String showSpitterProfile(@PathVariable String username, Model model) {
    Spitter spitter = spitterRepository.findByUsername(username);
    model.addAttribute(spitter);
    return "t/profile";
  }
  
}
