package com.codecoop.myuniversity.web.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.codecoop.myuniversity.core.dto.InterestDto;
import com.codecoop.myuniversity.core.dto.UsersDto;
import com.codecoop.myuniversity.core.service.InterestService;
import com.codecoop.myuniversity.core.service.MailService;
import com.codecoop.myuniversity.core.service.UsersService;
import com.codecoop.myuniversity.web.bean.ForgotPwdRequest;
import com.codecoop.myuniversity.web.bean.GetInterestRequest;
import com.codecoop.myuniversity.web.bean.LoginRequst;
import com.codecoop.myuniversity.web.bean.LoginResponse;
import com.codecoop.myuniversity.web.bean.RegistrationRequst;
import com.codecoop.myuniversity.web.bean.SaveInterestIdRequest;
import com.codecoop.myuniversity.web.bean.SaveInterestRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/userRegistration")
public class UsersController {

	@Autowired
	UsersService usersService;
	@Autowired
	InterestService interestService;
	@Autowired
	MailService mailService;

/*
 * Registration of the user.
 */
	@RequestMapping(value = "/registration", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String userRegistration(
			@RequestBody RegistrationRequst registrationRequest)
			throws Exception {

		String fullName = registrationRequest.getFullName();
		String email = registrationRequest.getEmail();
		String password = registrationRequest.getPassword();
		Integer phoneNumber = registrationRequest.getPhoneNumber();
		Integer deviceId = registrationRequest.getDeviceId();
		String deviceType = registrationRequest.getDeviceType();
		String deviceAppToken = registrationRequest.getDeviceAppToken();
		Double appVersion = registrationRequest.getAppVersion();
		Double deviceOsVersion = registrationRequest.getDeviceOsVersion();

		UsersDto userDto = new UsersDto();
		userDto.setFullName(fullName);
		userDto.setEmail(email);
		userDto.setPassword(password);
		userDto.setPhoneNumber(phoneNumber);
		userDto.setDeviveId(deviceId);
		userDto.setDeviceAppToken(deviceAppToken);
		userDto.setAppVersion(appVersion);
		userDto.setDeviceOsVersion(deviceOsVersion);
		userDto.setDeviceType(deviceType);

		if (usersService.isUserExist(userDto)) {
			return "Email already registered";
		} else {

			String encodedEmail = new String(Base64.encode(userDto.getEmail()
					.getBytes()));
			String decodedEmail = new String(Base64.decode(encodedEmail
					.getBytes()));
			System.out.println(decodedEmail);

			userDto = usersService.saveUser(userDto);
			String subject = "Activation link for MyUniversity";
			String body = "<p>Hi "
					+ userDto.getFullName()
					+ " ,</p><br/>"
					+ "<p>Please use this link to activate your account :<a href=\"http://dev2.codecoop.net/myuniversity/userRegistration/activate/"
					+ encodedEmail + "\">" + "Activate Account</a></p>";
			String receiver = userDto.getEmail();
			String from = "kadharedeva87@gmail.com";
			try {

				mailService.sendMailHtml(subject, body, receiver, from);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "Success";
		}
	}
/*
 * Encoding and decoding of users credentials.
 */
	@RequestMapping(value = "/activate/{email}", method = RequestMethod.GET)
	public ModelAndView active(@PathVariable(value = "email") String email,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String decodedEmail = new String(Base64.decode(email.getBytes()));
		usersService.activateUser(decodedEmail);
		ModelAndView model = new ModelAndView("AcivePage");
		return model;
	}
/*
 * Login to the application
 */
	@RequestMapping(value = "/login", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String login(@RequestBody LoginRequst loginRequest)
			throws Exception {
		LoginResponse loginResponse = new LoginResponse();
		ObjectMapper mapper = new ObjectMapper();
		String email = loginRequest.getEmailId();
		String password = loginRequest.getPassword();
		UsersDto userdto = usersService.login(email, password);
		loginResponse.setStatus(userdto.getStatus());
		loginResponse.setUserId(userdto.getId());
		loginResponse.setUserName(userdto.getFullName());

		return mapper.writeValueAsString(loginResponse);
	}
	/*
	 * Getting all the interest.
	 */

	@RequestMapping(value = "/getInterest", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String getInterest(
			@RequestBody GetInterestRequest getInterestRequest)
			throws Exception {
		Long userId = getInterestRequest.getUserId();
		ObjectMapper mapper = new ObjectMapper();
		List<InterestDto> interestDto = interestService.getAllInterest(userId);
		String response = mapper.writeValueAsString(interestDto);
		return response;
	}

	/*
	 * creation of interest
	 */
	@RequestMapping(value = "/saveInterest", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String saveInterest(
			@RequestBody SaveInterestRequest interestRequest) throws Exception {
		String interestName = interestRequest.getInterestName();
		interestService.saveInterest(interestName);
		return "Success";
	}
/*
 * creation of particular user's interest.
 */
	@RequestMapping(value = "/saveInterestId", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String saveInterestId(
			@RequestBody SaveInterestIdRequest interestIdRequest)
			throws Exception {
		List<String> interestId = interestIdRequest.getInterestId();
		String userId = interestIdRequest.getUserId();
		List<Long> intrst = new ArrayList<Long>();
		for (String interest : interestId) {
			intrst.add(Long.parseLong(interest));
		}

		interestService.saveInterestId(intrst, Long.parseLong(userId));
		return "Success";
	}
/*
 * service for getting password at the time of forgot password.
 */
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
	public @ResponseBody String forgotPassword(
			@RequestBody ForgotPwdRequest passwordRequest) throws Exception {
		String email = passwordRequest.getEmail();
		UsersDto userdto = usersService.forgotpwd(email,
				passwordRequest.getType());
		// if status is ok then send the email of password
		if (userdto.getStatusCode() == 200) {
			String subject = "Myuniversity Password";
			String body = "Your account password is : " + userdto.getPassword();
			String receiver = userdto.getEmail();
			String from = "kadharedeva87@gmail.com";
			try {
				mailService.sendMail(subject, body, receiver, from);
			} catch (Exception e) {
				
			}
		}
		return userdto.getStatus();
	}

}
