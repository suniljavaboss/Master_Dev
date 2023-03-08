/**
 * 
 */
package com.milkydairymadeeasy.administrator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.milkydairymadeeasy.administrator.entity.AdminUser;

/**
 * @author Sunil Singh
 *
 */

@Repository
public interface AdminRepository extends JpaRepository<AdminUser, Long> {

}
