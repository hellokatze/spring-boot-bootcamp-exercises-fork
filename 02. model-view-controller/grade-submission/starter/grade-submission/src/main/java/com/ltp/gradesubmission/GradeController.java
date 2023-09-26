package com.ltp.gradesubmission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    int index = getGradeIndex(grade.getId());
    if (index == Constants.NOT_FOUND) {
      studentGrades.add(grade);
    } else {
      studentGrades.set(index, grade);
    }
    return "redirect:/grades";
  }

  @GetMapping("/")
  public String gradeForm(Model model, @RequestParam(required = false) String id) {
    int index= getGradeIndex(id);
    model.addAttribute("grade", index == Constants.NOT_FOUND ? new Grade() : studentGrades.get(index));
    return "form";
  }

  public Integer getGradeIndex(String id) {
    for (int i = 0; i < studentGrades.size(); i++) {
      if (studentGrades.get(i).getId().equals(id)) return i;
    }
    return Constants.NOT_FOUND;
  }
}
