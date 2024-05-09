package com.securityModel.service.Impl;

import com.securityModel.models.Admin;
import com.securityModel.repository.AdminRepository;
import com.securityModel.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminiRepository;
    @Override
    public Admin createAdmin(Admin admin){ return adminiRepository.save(admin);}
    @Override
    public List<Admin> allAdmins(){ return adminiRepository.findAll();}
    @Override
    public Admin adminById(Long id){ return adminiRepository.findById(id).orElseThrow(null);}
    @Override
    public Admin updateAdmin(Long id,Admin admin){
        Admin ad=adminiRepository.findById(id).orElseThrow(null);
        if(ad!=null){
            admin.setId(id);
            return adminiRepository.save(admin);
        }else {
            throw new RuntimeException("Error!");
        }
    }
    @Override
    public void deleteAdmin(Long id){
        adminiRepository.deleteById(id);
    }
}
