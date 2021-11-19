package org.doofinder.servicios.users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.doofinder.dao.repositorios.users.UserDetailsDao;
import org.doofinder.modelo.entities.users.UserDetails;
import org.doofinder.pojos.users.UserDetailsVO;
import org.doofinder.servicios.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UserDetailsDao userDetailsDao;

	public UserDetailsVO findOneById(UserDetailsVO userDetailsVO) {
		UserDetails userDetails = userDetailsDao.findOneById(userDetailsVO.getIdUser());
		if (userDetails == null) {
			throw new ServiceException("UserDetails not exists");
		}

		userDetailsVO = new UserDetailsVO();
		userDetailsVO.setIdUser(userDetails.getIdUser());
		userDetailsVO.setUsername(userDetails.getUsername());
		userDetailsVO.setPassword(userDetails.getPassword());
		userDetailsVO.setCreateDate(userDetails.getCreateDate());
		userDetailsVO.setUpdateDate(userDetails.getUpdateDate());

		return userDetailsVO;
	}

	public UserDetailsVO findOneByUsername(UserDetailsVO userDetailsVO) {
		UserDetails userDetails = userDetailsDao.findOneByUsername(userDetailsVO.getUsername());
		if (userDetails == null) {
			throw new ServiceException("UserDetails not exists");
		}

		userDetailsVO = new UserDetailsVO();
		userDetailsVO.setIdUser(userDetails.getIdUser());
		userDetailsVO.setUsername(userDetails.getUsername());
		userDetailsVO.setPassword(userDetails.getPassword());
		userDetailsVO.setCreateDate(userDetails.getCreateDate());
		userDetailsVO.setUpdateDate(userDetails.getUpdateDate());

		return userDetailsVO;
	}

	public List<UserDetailsVO> findAll() {
		List<UserDetailsVO> userDetailsListVO = new ArrayList<>();

		for (UserDetails userDetails : userDetailsDao.findAll()) {
			UserDetailsVO userDetailsVO = new UserDetailsVO();
			userDetailsVO.setIdUser(userDetails.getIdUser());
			userDetailsVO.setUsername(userDetails.getUsername());
			userDetailsVO.setPassword(userDetails.getPassword());
			userDetailsVO.setCreateDate(userDetails.getCreateDate());
			userDetailsVO.setUpdateDate(userDetails.getUpdateDate());

			userDetailsListVO.add(userDetailsVO);
		}

		return userDetailsListVO;
	}

	public Boolean existsOneById(UserDetailsVO userDetailsVO) {
		UserDetails userDetails = userDetailsDao.findOneById(userDetailsVO.getIdUser());

		return userDetails != null;
	}

	public Boolean existsOneByUsername(UserDetailsVO userDetailsVO) {
		UserDetails userDetails = userDetailsDao.findOneByUsername(userDetailsVO.getUsername());

		return userDetails != null;
	}

	public UserDetailsVO createOne(UserDetailsVO userDetailsVO) {
		UserDetails userDetails = new UserDetails();
		userDetails.setUsername(userDetailsVO.getUsername());
		userDetails.setPassword(userDetailsVO.getPassword());
		userDetails.setCreateDate(new Date());

		userDetails = userDetailsDao.save(userDetails);

		userDetailsVO = new UserDetailsVO();
		userDetailsVO.setIdUser(userDetails.getIdUser());
		userDetailsVO.setUsername(userDetails.getUsername());
		userDetailsVO.setPassword(userDetails.getPassword());
		userDetailsVO.setCreateDate(userDetails.getCreateDate());
		userDetailsVO.setUpdateDate(userDetails.getUpdateDate());

		return userDetailsVO;
	}

	public UserDetailsVO updateOne(UserDetailsVO userDetailsVO) {
		UserDetails userDetails = userDetailsDao.findOneById(userDetailsVO.getIdUser());
		if (userDetails == null) {
			throw new ServiceException("UserDetails not exists");
		}

		userDetails.setPassword(userDetailsVO.getPassword());
		userDetails.setUpdateDate(new Date());

		userDetails = userDetailsDao.save(userDetails);

		userDetailsVO = new UserDetailsVO();
		userDetailsVO.setIdUser(userDetails.getIdUser());
		userDetailsVO.setUsername(userDetails.getUsername());
		userDetailsVO.setPassword(userDetails.getPassword());
		userDetailsVO.setCreateDate(userDetails.getCreateDate());
		userDetailsVO.setUpdateDate(userDetails.getUpdateDate());

		return userDetailsVO;
	}

	public void deleteOneById(UserDetailsVO userDetailsVO) {
		UserDetails userDetails = userDetailsDao.findOneById(userDetailsVO.getIdUser());
		if (userDetails == null) {
			throw new ServiceException("UserDetails not exists");
		}

		userDetailsDao.delete(userDetails);
	}

}