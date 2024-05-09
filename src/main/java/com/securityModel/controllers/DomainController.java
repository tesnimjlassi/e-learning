package com.securityModel.controllers;


import com.securityModel.models.Domain;

import com.securityModel.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("domains")
@CrossOrigin("*")
public class DomainController {
    @Autowired
    private DomainService domainService;
    @PostMapping("/add")
    public Domain createDomain(@RequestBody Domain domain){
        return domainService.createDomain(domain);

    }
    @GetMapping("/all")
    public List<Domain> domainList(){
        return domainService.allDomains();
    }
    @GetMapping("getone/{id}")
    public Domain domainById(@PathVariable Long id){
        return domainService.domainById(id);
    }
    @PutMapping("update/{id}")
    public Domain updateDomain(@PathVariable Long id,@RequestBody Domain domain){
        return domainService.updateDomain(id,domain);
    }
    @DeleteMapping("delete/{id}")
    public HashMap<String,String> deleteDomain(@PathVariable Long id){
        Domain ad=domainService.domainById(id);
        HashMap message=new HashMap();
        if (ad!=null){
            try {
                domainService.deleteDomain(id);
                message.put("etat"," Domain deleted");
                return message;
            }catch (Exception e){
                message.put("etat","Error"+e.getMessage());
                return message;
            }
        }else {
            message.put("etat","domain not found");
            return message;
        }
    }
}
