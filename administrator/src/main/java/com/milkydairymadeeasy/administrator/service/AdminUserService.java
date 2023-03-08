/**
 * 
 */
package com.milkydairymadeeasy.administrator.service;

import java.util.List;
import java.util.Optional;

import com.milkydairymadeeasy.administrator.entity.AdminUser;

/**
 * @author Sunil Singh
 *
 */
public interface AdminUserService {
	
	public AdminUser createAdminUser(AdminUser adminUser);
	public AdminUser updateAdminUser(AdminUser adminUser,Long adminUserId);
	public List<AdminUser> getAllAdminUserList();
	public  Optional<AdminUser> getAdminUserById(Long adminUserId);

}
