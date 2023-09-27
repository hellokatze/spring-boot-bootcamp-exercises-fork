package com.ltp.javagram;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.ui.Model;

@Controller
public class JavagramController {

  @GetMapping("/")
  public String getForm(Model model) {
    model.addAttribute("user", new User());
    return "sign-up";
  }

  @GetMapping("/result")
  public String getResult() {
    return "result";
  }

  @PostMapping("/submitForm")
  public String handleSubmit(User user) {
    return "redirect:/result";
  }
}
