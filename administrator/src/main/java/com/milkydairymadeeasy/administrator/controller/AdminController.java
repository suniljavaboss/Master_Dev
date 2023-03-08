/**
 * 
 */
package com.milkydairymadeeasy.administrator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.milkydairymadeeasy.administrator.entity.AdminUser;
import com.milkydairymadeeasy.administrator.service.AdminUserService;

/**
 * @author Sunil Singh
 *
 */

@RestController
@RequestMapping("/admin/user")
public class AdminController {

	@Autowired
	AdminUserService adminUserService;
	
	@PostMapping("/createadminuser")
	public AdminUser createAdminUser(@RequestBody AdminUser adminUser) {
		
		return adminUserService.createAdminUser(adminUser);
	}
	
	@GetMapping("/userlist")
	public List<AdminUser> getAdminUserList(){
		
		return adminUserService.getAllAdminUserList();
	}
}
