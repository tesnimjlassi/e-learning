package com.securityModel.controllers;

import com.securityModel.models.Condidat;
import com.securityModel.service.CondidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@RestController
@RequestMapping("condidats")
@CrossOrigin("*")
public class CondidatController {

    @Autowired
    private CondidatService condidatService;
    @PostMapping("/add")
    public Condidat createCondidat(@RequestBody Condidat condidat){return condidatService.createCondidat(condidat);}
    @GetMapping("/all")
    public List<Condidat> condidatList(){
        return condidatService.allCondidats();
    }
    @GetMapping("getone/{id}")
    public Condidat condidatById(@PathVariable Long id){return condidatService.condidatById(id);}
    @PutMapping("update/{id}")
    public Condidat updatecondidat(@PathVariable Long id ,@RequestBody Condidat condidat){
        return condidatService.updatecondidat(id,condidat);
    }
    @DeleteMapping("delete/{id}")
    public HashMap<String,String> deletecondidat(@PathVariable Long id){
        Condidat cdd=condidatService.condidatById(id);
        HashMap message=new HashMap();
        if (cdd !=null){
            try{
                condidatService.deletecondidat(id);
                message.put("etat","condidat deleted");
                return  message;
            }catch (Exception e){
                message.put("etat","Error" +e.getMessage());
                return  message;
            }
        }else {
            message.put("etat","condidat not found !");
            return message;
        }
    }
}


