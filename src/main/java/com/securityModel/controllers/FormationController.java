package com.securityModel.controllers;


import com.securityModel.models.Formation;
import com.securityModel.service.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("formations")
@CrossOrigin("*")
public class FormationController {
    @Autowired
    private FormationService formationService;
    @PostMapping("/add")
    public Formation createFormation(@RequestBody Formation formation){
        return formationService.createFormation(formation);
    }
    @GetMapping("/all")

    public List<Formation> allFormations(){return formationService.allFormations();}
    @GetMapping("/getone/{id}")
    public Formation formationById(@PathVariable Long id){return formationService.formationById(id);}

    @PutMapping("/update/{id}")
    public Formation formationById(@PathVariable Long id,@RequestBody Formation formation){return formationService.updateFormation(id,formation);}
    @DeleteMapping("/delete/{id}")
    public HashMap<String,String> deleteFormation(@PathVariable Long id){
        Formation ad=formationService.formationById(id);
        HashMap message=new HashMap();
        if (ad!=null){
            try {
                formationService.deleteFormation(id);
                message.put("etat"," Formation deleted");
                return message;
            }catch (Exception e){
                message.put("etat","Error"+e.getMessage());
                return message;
            }
        }else {
            message.put("etat","Formation not found");
            return message;
        }
    }
}
