package com.bhoomi.userServices.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhoomi.userServices.entity.UserInfo;
import com.bhoomi.userServices.repository.UserInfoRepository;
import com.bhoomi.userServices.services.UserService;
import com.google.gson.Gson;
/**
 * UserService implementation 
 * 
 * @filename UserServiceImpl.java
 *
 * @author Chaitanya Bhoomireddy
 * 
 */
@Service
public class UserServiceImpl implements UserService{
	private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserInfoRepository userInfoRepository;
	
	@Autowired
	Gson gson;
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<UserInfo> getAllUsers() {
		List<UserInfo> userInfo = userInfoRepository.findAll();
		logger.debug("All Users List {}", gson.toJson(userInfo));
		return userInfo;
	}

	@Override
	public List<UserInfo> getRequiredData(Map<String, Object> searchCriteria) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<UserInfo> cq = cb.createQuery(UserInfo.class);
		Root<UserInfo> root = cq.from(UserInfo.class);
		List<Predicate> pr = new ArrayList<>();
		
		searchCriteria.forEach((key,value) ->
		{
			if ("minAge".equalsIgnoreCase(key))  {
				pr.add(cb.greaterThan(root.get("age"), (int) value));
			}
			else if ("maxAge".equalsIgnoreCase(key)) {
				pr.add(cb.lessThan(root.get("age"), (int) value));
			}
			else {
				pr.add(cb.equal(root.get(key), value));
			
			}
		});
		cq.select(root).where(pr.toArray(new Predicate[pr.size()]));
		return em.createQuery(cq).getResultList();
	}
	
}
