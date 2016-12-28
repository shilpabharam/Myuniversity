package com.codecoop.myuniversity.core.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codecoop.myuniversity.core.dao.InterestDao;
import com.codecoop.myuniversity.core.dao.UsersInterstDao;
import com.codecoop.myuniversity.core.domain.UserInterests;
import com.codecoop.myuniversity.core.dto.InterestDto;

@Service
public class InterestService {

	@Autowired
	InterestDao interestDao;
	@Autowired
	UsersInterstDao userInterestDao;

	/*
	 * creation of interest
	 */
	@Transactional
	public void saveInterest(String interestName) {
		interestDao.saveInterest(interestName);
	}

	/*
	 * saving particular users interests
	 */
	@Transactional
	public void saveInterestId(List<Long> interestId, long userId) {
		List<UserInterests> usersInterests = userInterestDao
				.getUserInterests(userId);
		
		System.out.println(usersInterests);
		boolean flag = true;

		// remove which are already there but no more selected by user
		for (UserInterests userinterest : usersInterests) {
			flag = true;
			for (Long intr : interestId) {
				if (userinterest.getInterestId() == intr) {
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.println("deleted");
				userInterestDao.delete(userinterest);
			}
		}
		// add newly given interest
		for (Long intr : interestId) {
			flag = true;
			for (UserInterests userinterest : usersInterests) {
				if (intr == userinterest.getInterestId()) {
					flag = false;
					break;
				}
			}
			if (flag) {
				userInterestDao.saveInterestId(intr, userId);
			}
		}

	}

	/*
	 * getting all interests.
	 */
	@Transactional
	public List<InterestDto> getAllInterest(long userId) {
		List<InterestDto> interest = interestDao.getInterest(userId);
		return interest;
	}

}
