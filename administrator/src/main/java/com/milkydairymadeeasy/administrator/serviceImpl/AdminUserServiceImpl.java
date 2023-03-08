/**
 * 
 */
package com.milkydairymadeeasy.administrator.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milkydairymadeeasy.administrator.dao.AdminUserDao;
import com.milkydairymadeeasy.administrator.entity.AdminUser;
import com.milkydairymadeeasy.administrator.exception.UserException;
import com.milkydairymadeeasy.administrator.service.AdminUserService;

/**
 * @author Sunil Singh
 *
 */

@Service
public class AdminUserServiceImpl implements AdminUserService {

	private static final Logger LOGGER = LogManager.getLogger(AdminUserServiceImpl.class);
	
	@Autowired
	AdminUserDao adminUserDao;

	@Override
	public AdminUser createAdminUser(AdminUser adminUser) {
		try {
			if (checkUsernameExists(adminUser.getUserName())) {
				return adminUserDao.createAdminUser(adminUser);
			} else {
				throw new UserException("unseName already exist");
			}
		} catch (UserException e) {
            LOGGER.error("unseName already exist", e);  
		}
		return adminUser;

	}

	@Override
	public AdminUser updateAdminUser(AdminUser adminUser, Long adminUserId) {
       
		try {
			Optional<AdminUser> adminUsers=adminUserDao.getAdminUserById(adminUserId);
			if (adminUsers.isPresent()) {
				adminUser.setAdminUserId(adminUsers.get().getAdminUserId());
				adminUserDao.updateAdminUser(adminUser);
			}else {
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return adminUserDao.updateAdminUser(adminUser);
	}

	@Override
	public List<AdminUser> getAllAdminUserList() {

		return adminUserDao.getAllAdminUserList();
	}

	@Override
	public Optional<AdminUser> getAdminUserById(Long adminUserId) {

		return adminUserDao.getAdminUserById(adminUserId);
	}

	public boolean checkUsernameExists(String username) {
		List<AdminUser> adminUsers = adminUserDao.getAllAdminUserList();
		for (AdminUser admin : adminUsers) {
			if (username.equals(admin.getUserName())) {
				return false;
			}
		}
		return true;
	}

}
