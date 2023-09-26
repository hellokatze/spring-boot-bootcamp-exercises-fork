package com.ltp.globalsuperstore;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GlobalSuperstoreController {

  List<Item> items = new ArrayList<Item>(); // create an empty ArrayList to which item objects can be added.

  @GetMapping("/") // Map a get request on path / to a handler method
  public String getForm(Model model) {
    model.addAttribute("item", new Item()); // maps attribute "item" to new item object.
    model.addAttribute("categories", Constants.CATEGORIES);
    return "form";
  }

  @GetMapping("/inventory")
  public String getInventory(Model model) {
    model.addAttribute("items", items); // populate the inventory table with data from the datastore.
    return "inventory";
  }

  @PostMapping("/submitItem")
  public String handleSubmit(Item item) {
    items.add(item);
    return "redirect:/inventory";
  }

  @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
}
