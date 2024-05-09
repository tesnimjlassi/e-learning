package com.securityModel.controllers;

import com.securityModel.models.Cours;
import com.securityModel.service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("courses")
@CrossOrigin("*")
public class CoursController {
  @Autowired
    private CoursService coursService;
  @PostMapping("/add")
    public Cours createcours(@RequestBody Cours cours){
      return coursService.createCours(cours);
  }
  @GetMapping("/all")

  public List<Cours> coursList(){return coursService.allCourses();}
  @GetMapping("/getone/{id}")
    public Cours coursById(@PathVariable Long id){return coursService.coursById(id);}

  @PutMapping("/update/{id}")
  public Cours updateCours(@PathVariable Long id,@RequestBody Cours cours){return coursService.updateCours(id,cours);}
    @DeleteMapping("/delete/{id}")
  public HashMap<String,String>  deleteCours(@PathVariable Long id){
      Cours cs=coursService.coursById(id);
      HashMap message=new HashMap();
      if (cs!=null){
          try {
              coursService.deleteCours(id);
              message.put("etat","cours deleted");
              return message;
          }catch (Exception e){
              message.put("etat","cours not found ");
              return message;
          }
      }else {
          message.put("etat","cours not found");
          return message;
      }
    }
}
