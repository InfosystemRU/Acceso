package org.doofinder.app.users;

import java.io.Serializable;
import java.util.List;

import org.doofinder.pojos.users.RequestDetailsVO;
import org.doofinder.pojos.users.ResponseDetailsVO;
import org.doofinder.pojos.users.UserDetailsVO;
import org.doofinder.servicios.users.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDetailsRest implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UserDetailsService userDetailsService;

	@PostMapping(produces = "application/json", consumes = "application/json", value = "/userDetails/findOneById")
	public ResponseEntity<ResponseDetailsVO> findOneById(RequestEntity<RequestDetailsVO> requestEntityVO) {
		RequestDetailsVO requestDetailsVO = requestEntityVO.getBody();

		UserDetailsVO userDetailsVO = null;

		userDetailsVO = userDetailsService.findOneById(requestDetailsVO.getUserDetails());

		ResponseDetailsVO responseDetailsVO = new ResponseDetailsVO();
		responseDetailsVO.setUserDetails(userDetailsVO);

		return ResponseEntity.ok(responseDetailsVO);
	}

	@PostMapping(produces = "application/json", consumes = "application/json", value = "/userDetails/findOneByUsername")
	public ResponseEntity<ResponseDetailsVO> findOneByUsername(RequestEntity<RequestDetailsVO> requestEntityVO) {
		RequestDetailsVO requestDetailsVO = requestEntityVO.getBody();

		UserDetailsVO userDetailsVO = null;

		userDetailsVO = userDetailsService.findOneByUsername(requestDetailsVO.getUserDetails());

		ResponseDetailsVO responseDetailsVO = new ResponseDetailsVO();
		responseDetailsVO.setUserDetails(userDetailsVO);

		return ResponseEntity.ok(responseDetailsVO);
	}

	@PostMapping(produces = "application/json", consumes = "application/json", value = "/userDetails/findAll")
	public ResponseEntity<ResponseDetailsVO> findAll(RequestEntity<RequestDetailsVO> requestEntityVO) {
		RequestDetailsVO requestDetailsVO = requestEntityVO.getBody();

		List<UserDetailsVO> userDetailsListVO = null;

		userDetailsListVO = userDetailsService.findAll();

		ResponseDetailsVO responseDetailsVO = new ResponseDetailsVO();
		responseDetailsVO.setUserDetailsList(userDetailsListVO);

		return ResponseEntity.ok(responseDetailsVO);
	}

	@PostMapping(produces = "application/json", consumes = "application/json", value = "/userDetails/createOne")
	public ResponseEntity<ResponseDetailsVO> createOne(RequestEntity<RequestDetailsVO> requestEntityVO) {
		RequestDetailsVO requestDetailsVO = requestEntityVO.getBody();

		UserDetailsVO userDetailsVO = null;

		userDetailsVO = userDetailsService.createOne(requestDetailsVO.getUserDetails());

		ResponseDetailsVO responseDetailsVO = new ResponseDetailsVO();
		responseDetailsVO.setUserDetails(userDetailsVO);

		return ResponseEntity.ok(responseDetailsVO);
	}

	@PostMapping(produces = "application/json", consumes = "application/json", value = "/userDetails/updateOne")
	public ResponseEntity<ResponseDetailsVO> updateOne(RequestEntity<RequestDetailsVO> requestEntityVO) {
		RequestDetailsVO requestDetailsVO = requestEntityVO.getBody();

		UserDetailsVO userDetailsVO = null;

		userDetailsVO = userDetailsService.updateOne(requestDetailsVO.getUserDetails());

		ResponseDetailsVO responseDetailsVO = new ResponseDetailsVO();
		responseDetailsVO.setUserDetails(userDetailsVO);

		return ResponseEntity.ok(responseDetailsVO);
	}

	@PostMapping(produces = "application/json", consumes = "application/json", value = "/userDetails/existsOneById")
	public ResponseEntity<ResponseDetailsVO> existsOneById(RequestEntity<RequestDetailsVO> requestEntityVO) {
		RequestDetailsVO requestDetailsVO = requestEntityVO.getBody();

		Boolean existsVO = null;

		existsVO = userDetailsService.existsOneById(requestDetailsVO.getUserDetails());

		ResponseDetailsVO responseDetailsVO = new ResponseDetailsVO();
		responseDetailsVO.setExists(existsVO);

		return ResponseEntity.ok(responseDetailsVO);
	}

	@PostMapping(produces = "application/json", consumes = "application/json", value = "/userDetails/existsOneByUsername")
	public ResponseEntity<ResponseDetailsVO> existsOneByUsername(RequestEntity<RequestDetailsVO> requestEntityVO) {
		RequestDetailsVO requestDetailsVO = requestEntityVO.getBody();

		Boolean existsVO = null;

		existsVO = userDetailsService.existsOneByUsername(requestDetailsVO.getUserDetails());

		ResponseDetailsVO responseDetailsVO = new ResponseDetailsVO();
		responseDetailsVO.setExists(existsVO);

		return ResponseEntity.ok(responseDetailsVO);
	}

	@PostMapping(produces = "application/json", consumes = "application/json", value = "/userDetails/deleteOneById")
	public ResponseEntity<ResponseDetailsVO> deleteOneById(RequestEntity<RequestDetailsVO> requestEntityVO) {
		RequestDetailsVO requestDetailsVO = requestEntityVO.getBody();

		userDetailsService.deleteOneById(requestDetailsVO.getUserDetails());

		ResponseDetailsVO responseDetailsVO = new ResponseDetailsVO();

		return ResponseEntity.ok(responseDetailsVO);
	}

}
