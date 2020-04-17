package com.bhoomi.userServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhoomi.userServices.entity.UserInfo;
/**
 * JPA for UserInfo table
 * 
 * @filename UserInfoRepository.java
 *
 * @author Chaitanya Bhoomireddy
 * 
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Long>{
}