package com.securityModel.service;

import com.securityModel.models.Admin;

import java.util.List;

public interface AdminService {
    Admin createAdmin(Admin admin);
    List<Admin> allAdmins();
    Admin adminById(Long id);
    Admin updateAdmin(Long id,Admin admin);
    void deleteAdmin(Long id);
}
