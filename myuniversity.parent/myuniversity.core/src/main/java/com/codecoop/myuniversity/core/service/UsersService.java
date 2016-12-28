package com.codecoop.myuniversity.core.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codecoop.myuniversity.core.dao.RolesDao;
import com.codecoop.myuniversity.core.dao.UsersDao;
import com.codecoop.myuniversity.core.domain.Roles;
import com.codecoop.myuniversity.core.domain.Users;
import com.codecoop.myuniversity.core.dto.UserLOGDetailDto;
import com.codecoop.myuniversity.core.dto.UsersDto;

@Service
public class UsersService {

	@Autowired
	UsersDao usersDao;

	@Autowired
	RolesDao rolesDao;

	/*
	 * checking whether user is exists or not.
	 */
	@Transactional
	public boolean isUserExist(UsersDto userDto) {
		Users user = usersDao.isUserExist(userDto.getEmail());
		if (user != null) {
			return true;
		}
		return false;
	}

	/*
	 * creation of new user.
	 */
	@Transactional
	public UsersDto saveUser(UsersDto usersDto) {

		Roles role = rolesDao.findByRoleName("STUDENT");

		Users user = new Users();
		user.setFullName(usersDto.getFullName());
		user.setEmail(usersDto.getEmail());
		user.setPassword(usersDto.getPassword());
		user.setPhoneNumber(usersDto.getPhoneNumber());
		user.setDeviveId(usersDto.getDeviveId());
		user.setDeviceAppToken(usersDto.getDeviceAppToken());
		user.setAppVersion(usersDto.getAppVersion());
		user.setDeviceOsVersion(usersDto.getDeviceOsVersion());
		user.setDeviceType(usersDto.getDeviceType());
		user.setActive(false);
		user.setUserRole(role.getId());
		//Passing static university ID
		user.setUniversityId(1L);
		usersDao.addOrUpdateUser(user);

		usersDto.setId(user.getId());
		return usersDto;
	}

	/*
	 * login for the user
	 */
	@Transactional
	public UsersDto login(String username, String password) {
		Users user = usersDao.login(username, password);
		UsersDto userDto = new UsersDto();

		if (user != null) {
			if (user.isActive()) {
				userDto.setId(user.getId());
				userDto.setStatusCode(200);
				userDto.setFullName(user.getFullName());
				userDto.setStatus("Success");
				return userDto;

			} else {

				userDto.setStatusCode(201);
				userDto.setStatus("User is not activated");
			}

		} else {
			userDto.setStatusCode(202);
			userDto.setStatus("Failed");
		}

		return userDto;
	}

	/*
	 * getting logged userName.
	 */
	@Transactional
	public UserLOGDetailDto getLoggedUser(String email) {

		Users user = usersDao.getUserByEmail(email);
		UserLOGDetailDto userLog = new UserLOGDetailDto();
		userLog.setUserId(user.getId());
		userLog.setFullName(user.getFullName());
		userLog.setUniversityId(user.getUniversityId());
		return userLog;
	}

	/*
	 * getting logged userID.
	 */
	@Transactional
	public Long getLoggedUserID(String email) {

		Users user = usersDao.getUserByEmail(email);
		return user.getId();
	}

	/*
	 * once user created activating it.
	 */
	@Transactional
	public void activateUser(String email) {
		Users user = usersDao.getUserByEmail(email);
		System.out.println("1");
		user.setActive(true);
		System.out.println("2");
		usersDao.saveOrUpdate(user);
		System.out.println("3");
	}

	/*
	 * forgot password
	 */
	@Transactional
	public UsersDto forgotpwd(String email, String type) {
		UsersDto userDto = new UsersDto();
		if ("web".equals(type)) {
			Users user = usersDao.forgotPasswordWeb(email);

			if (user != null) {
				userDto.setEmail(user.getEmail());
				userDto.setPassword(user.getPassword());
				userDto.setId(user.getId());
				userDto.setStatusCode(200);
				userDto.setStatus("successfully sent password");

			} else {
				userDto.setStatusCode(201);
				userDto.setStatus("Please enter valid admin Email..");
			}
		} else if ("mobile".equals(type)) {
			Users user = usersDao.forgotPasswordMob(email);
			if (user != null) {
				userDto.setEmail(user.getEmail());
				userDto.setPassword(user.getPassword());
				userDto.setId(user.getId());
				userDto.setStatusCode(200);
				userDto.setStatus("successfully sent password");

			} else {
				userDto.setStatusCode(201);
				userDto.setStatus("Please enter valid student Email..");
			}
		}
		return userDto;
	}
}
