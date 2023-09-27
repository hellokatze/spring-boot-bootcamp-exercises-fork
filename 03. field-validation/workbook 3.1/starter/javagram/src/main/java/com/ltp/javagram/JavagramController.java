package com.ltp.javagram;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class JavagramController {

  @GetMapping("/")
  public String getForm(Model model) {
    return "sign-up";
  }

  @GetMapping("/result")
  public String getResult() {
    return "result";
  }
}
