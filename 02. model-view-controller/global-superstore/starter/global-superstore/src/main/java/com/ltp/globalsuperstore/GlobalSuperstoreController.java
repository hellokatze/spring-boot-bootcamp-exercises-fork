package com.ltp.globalsuperstore;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GlobalSuperstoreController {

  @GetMapping("/") // Map a get request on path / to a handler method
  public String getForm(Model model) {
    model.addAttribute("categories", Constants.CATEGORIES);
    return "form";
  }

  @GetMapping("/inventory")
  public String getInventory() {
    return "inventory";
  }
}
