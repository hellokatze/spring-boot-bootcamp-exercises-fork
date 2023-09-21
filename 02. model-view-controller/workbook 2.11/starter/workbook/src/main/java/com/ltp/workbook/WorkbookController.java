package com.ltp.workbook;


import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorkbookController {

  List<Record> records = Arrays.asList(
        new Record("Chair", 20.99, 5.99),
        new Record("Table", 40.99, 8.99),
        new Record("Couch", 100.99, 105.99),
        new Record("Fridge", 200.99, 59.99),
        new Record("Bed", 150.99, 205.99)
    );

    @GetMapping(value="/")
    public String getSales(Model model) {
        model.addAttribute("records", records);
        return "records";
    }


}
