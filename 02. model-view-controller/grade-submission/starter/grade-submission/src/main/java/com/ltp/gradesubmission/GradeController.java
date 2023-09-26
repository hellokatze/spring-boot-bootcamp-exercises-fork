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
    int index = getGradeIndex(grade.getName());
    if (index == -1000) {
      studentGrades.add(grade);
    } else {
      studentGrades.set(index, grade);
    }
    return "redirect:/grades";
  }

  @GetMapping("/")
  public String gradeForm(Model model, @RequestParam(required = false) String name) {
    Grade grade;
    if (getGradeIndex(name) == -1000) {
      grade = new Grade();
    } else {
      grade = studentGrades.get(getGradeIndex(name));
    }
    model.addAttribute("grade", getGradeIndex(name)   == -1000 ? new Grade() : grade);
    return "form";
  }

  public Integer getGradeIndex(String name) {
    for (int i = 0; i < studentGrades.size(); i++) {
      if (studentGrades.get(i).getName().equals(name)) return i;
    }
    return -1000;
  }
}
