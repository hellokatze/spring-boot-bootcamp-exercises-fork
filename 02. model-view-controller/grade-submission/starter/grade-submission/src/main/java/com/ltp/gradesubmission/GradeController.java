package com.ltp.gradesubmission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GradeController {
  // studentGrades list will be populated with data ONLY when GradeController is initialized.
  List<Grade> studentGrades = new ArrayList<>();

  @GetMapping("/grades")
  public String getGrades(Model model) {
    model.addAttribute("grades", studentGrades); // stores data in Model attribute
    return "grades";
  }

  @PostMapping("/handleSubmit")
  public String submitGrade(Grade grade) { // BTS Spring Boot creates empty Grade object using empty constructor and setters to update field with payload from POST request.
    studentGrades.add(grade);
    return "redirect:/grades";
  }

  @GetMapping("/")
  public String gradeForm(Model model) {
    model.addAttribute("grade", new Grade());
    return "form";
  }
}
