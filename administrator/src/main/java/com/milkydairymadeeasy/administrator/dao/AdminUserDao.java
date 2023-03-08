/**
 * 
 */
package com.milkydairymadeeasy.administrator.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.milkydairymadeeasy.administrator.entity.AdminUser;
import com.milkydairymadeeasy.administrator.repository.AdminRepository;

/**
 * @author Sunil Singh
 *
 */
@Component
public class AdminUserDao {
	
	@Autowired
	AdminRepository adminRepository;
	
	public AdminUser createAdminUser(AdminUser adminUser) {
		return adminRepository.save(adminUser);
	}
	
	public List<AdminUser> getAllAdminUserList() {
		return adminRepository.findAll();
	}
	
	public AdminUser updateAdminUser(AdminUser adminUser) {

		return adminRepository.save(adminUser);
	}
	
	public Optional<AdminUser> getAdminUserById(Long adminUserId) {

		return adminRepository.findById(adminUserId);
	}

}
