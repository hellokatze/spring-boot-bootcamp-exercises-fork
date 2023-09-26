package com.ltp.globalsuperstore;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GlobalSuperstoreController {

  List<Item> items = new ArrayList<Item>(); // create an empty ArrayList to which item objects can be added.

  @GetMapping("/") // Map a get request on path / to a handler method
  public String getForm(Model model, @RequestParam(required = false) String id) {
    int index = getIndexFromId(id);
    model.addAttribute("item", (index == Constants.NOT_FOUND ? new Item() : items.get(index))); // maps attribute "item" to new item object.
    model.addAttribute("categories", Constants.CATEGORIES);
    System.out.println("id: " + id);
    return "form";
  }

  @GetMapping("/inventory")
  public String getInventory(Model model) {
    model.addAttribute("items", items); // populate the inventory table with data from the datastore.
    return "inventory";
  }

  @PostMapping("/submitItem")
  public String handleSubmit(Item item, RedirectAttributes redirectAttributes) {
    int index = getIndexFromId(item.getId());
    if (index == Constants.NOT_FOUND) {
      items.add(item);
    } else {
      items.set(index, item);
    }
    redirectAttributes.addFlashAttribute("status", Constants.SUCCESS_STATUS);
    return "redirect:/inventory";
  }

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date date;

  public int getIndexFromId(String id) {
    for (int i = 0; i < items.size(); i++) {
      if (items.get(i).getId().equals(id)) return i;
    }
    return Constants.NOT_FOUND;
  }
}
