package com.securityModel.controllers;

import com.securityModel.models.Admin;
import com.securityModel.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("admins")
@CrossOrigin("*")
public class AdminController {
    @Autowired
    private AdminService  adminService;
    @PostMapping("/add")
    public Admin createAdmin(@RequestBody Admin admin){
        return adminService.createAdmin(admin);

    }
    @GetMapping("/all")
    public List<Admin> administrateurList(){
        return adminService.allAdmins();
    }
    @GetMapping("getone/{id}")
    public Admin adminById(@PathVariable Long id){
        return adminService.adminById(id);
    }
    @PutMapping("update/{id}")
    public Admin updateAdmin(@PathVariable Long id,@RequestBody Admin admin){
        return adminService.updateAdmin(id,admin);
    }
    @DeleteMapping("delete/{id}")
    public HashMap<String,String> deleteAdmin(@PathVariable Long id){
        Admin ad=adminService.adminById(id);
        HashMap message=new HashMap();
        if (ad!=null){
            try {
                adminService.deleteAdmin(id);
                message.put("etat"," admin deleted");
                return message;
            }catch (Exception e){
                message.put("etat","Error"+e.getMessage());
                return message;
            }
        }else {
            message.put("etat","admin not found");
            return message;
        }
    }
}
