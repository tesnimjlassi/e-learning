package com.securityModel.controllers;

import com.securityModel.models.Admin;
import com.securityModel.models.Enseignants;
import com.securityModel.service.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("enseignants")
@CrossOrigin("*")
public class EnseignantController {
    @Autowired
    private EnseignantService enseignantService;
    @PostMapping("/add")
    public Enseignants createEnseignant(@RequestBody Enseignants enseignants){
        return enseignantService.createEnseignant(enseignants);

    }
    @GetMapping("/all")
    public List<Enseignants> enseignantsList(){
        return enseignantService.allEnseignants();
    }
    @GetMapping("getone/{id}")
    public Enseignants enseignantById(@PathVariable Long id){
        return enseignantService.enseignantById(id);
    }
    @PutMapping("update/{id}")
    public Enseignants updateEnseignant(@PathVariable Long id,@RequestBody Enseignants enseignants){
        return enseignantService.updateEnseignant(id,enseignants);
    }
    @DeleteMapping("delete/{id}")
    public HashMap<String,String> deleteEnseignant(@PathVariable Long id) {
        Enseignants ad = enseignantService.enseignantById(id);
        HashMap message = new HashMap();
        if (ad != null) {
            try {
                enseignantService.deleteEnseignant(id);
                message.put("etat", " Enseignants deleted");
                return message;
            } catch (Exception e) {
                message.put("etat", "Error" + e.getMessage());
                return message;
            }
        } else {
            message.put("etat", "Enseignants not found");
            return message;
        }

    }}
