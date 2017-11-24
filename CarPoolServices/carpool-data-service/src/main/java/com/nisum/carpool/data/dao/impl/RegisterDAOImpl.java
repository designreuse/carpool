package com.nisum.carpool.data.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.nisum.carpool.data.dao.api.RegisterDAO;
import com.nisum.carpool.data.domain.RegisterDomain;
import com.nisum.carpool.data.repository.RegisterRepository;

@Configuration
public class RegisterDAOImpl implements RegisterDAO {

	private static Logger logger = LoggerFactory.getLogger(RegisterDAOImpl.class);
	@Autowired
	RegisterRepository registerRepository;
	@Override
	public RegisterDomain registerDriverorRider(RegisterDomain registerDomain)    {
		try{
			logger.info("RegisterDAOImpl: registerDriver ::");
			registerRepository.save(registerDomain);
		}catch (Exception e) {
			e.printStackTrace();
		}
		 return registerDomain;
	}
	
	/**
	 * @author Harish Kumar Gudivada
	 * 
	 * This method is used to load the rider driver details by userid
	 */
	@Override
	public List<RegisterDomain> findUserRegistrationByUserId(String userId) {
		logger.info("UserRegistrationDaoImpl :: findUserRegistrationByUserId :: Finding user by userId");
		return registerRepository.findByUserId(userId);
	}


}
