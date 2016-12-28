package com.codecoop.myuniversity.core.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codecoop.myuniversity.core.dao.DepartmentsDao;
import com.codecoop.myuniversity.core.dao.EventSocialBadgeDao;
import com.codecoop.myuniversity.core.dao.LoboBadgeDao;
import com.codecoop.myuniversity.core.dao.SkillBadgeDao;
import com.codecoop.myuniversity.core.dao.SocialBadgePointsDao;
import com.codecoop.myuniversity.core.dao.SocialBadgesDao;
import com.codecoop.myuniversity.core.dao.SocialBadgesDeptDao;
import com.codecoop.myuniversity.core.domain.Departments;
import com.codecoop.myuniversity.core.domain.EventSocialBadge;
import com.codecoop.myuniversity.core.domain.LoboBadge;
import com.codecoop.myuniversity.core.domain.SkillBadges;
import com.codecoop.myuniversity.core.domain.SocialBadgePoints;
import com.codecoop.myuniversity.core.domain.SocialBadges;
import com.codecoop.myuniversity.core.domain.SocialBadgesDept;
import com.codecoop.myuniversity.core.dto.AllSocialBadgeDto;
import com.codecoop.myuniversity.core.dto.CatWisePointsDto;
import com.codecoop.myuniversity.core.dto.CatWisePointsFinalDto;
import com.codecoop.myuniversity.core.dto.CategoryPointsFinal;
import com.codecoop.myuniversity.core.dto.DepartmentsDto;
import com.codecoop.myuniversity.core.dto.EventsSocialBadgesPoints;
import com.codecoop.myuniversity.core.dto.EventsSocialBadgesPointsFinal;
import com.codecoop.myuniversity.core.dto.FinalSocialBadgePoints;
import com.codecoop.myuniversity.core.dto.SkillBadgeDto;
import com.codecoop.myuniversity.core.dto.SkillPointsDto;
import com.codecoop.myuniversity.core.dto.SkillScoreDto;
import com.codecoop.myuniversity.core.dto.SocialBadgePointsDto;
import com.codecoop.myuniversity.core.dto.SocialBadgesDto;

@Service
public class BadgeService {

	@Autowired
	SocialBadgePointsDao socialBadgePointsDao;

	@Autowired
	SocialBadgesDao socialBadgesDao;

	@Autowired
	DepartmentsDao departmentDao;

	@Autowired
	SocialBadgesDeptDao socialDeptDao;

	@Autowired
	SkillBadgeDao skillBadgeDao;

	@Autowired
	EventSocialBadgeDao eventSocialBadgeDao;

	@Autowired
	LoboBadgeService loboBadgeService;

	@Autowired
	LoboBadgeDao loboBadgeDao;

	@Transactional
	public String createSocialBadges(AllSocialBadgeDto socialBadgeDto) {
		String status = "";
		try {

			SocialBadges socialBadge = new SocialBadges();

			socialBadge
					.setBadgeName(socialBadgeDto.getGeneral().getBadgeName());
			socialBadge.setBadgeDescription(socialBadgeDto.getGeneral()
					.getBadgeDescription());
			socialBadge.setNumberOfEvents(socialBadgeDto.getGeneral()
					.getNumberOfEvents());
			socialBadgesDao.saveOrUpdate(socialBadge);

			Long socialBadgeId = socialBadge.getId();

			for (Long deptId : socialBadgeDto.getDepartments()) {
				SocialBadgesDept badgeDept = new SocialBadgesDept();
				badgeDept.setSocialBadgeId(socialBadgeId);
				badgeDept.setDepartmentId(deptId);
				socialDeptDao.save(badgeDept);
			}

			status = "Social badge created successfully";

		} catch (Exception e) {

			e.printStackTrace();
			status = "Error while creating social badge";
		}

		return status;
	}

	@Transactional
	public String deleteSocialBadge(Long id) {
		String status = "";

		try {
			SocialBadges socialBadges = socialBadgesDao.getById(id);

			List<SocialBadgesDept> socialBadgesDept = socialDeptDao
					.getBySocialId(id);
			List<EventSocialBadge> eventSocialBadges = eventSocialBadgeDao
					.getBySocialId(id);

			if (socialBadges == null || socialBadgesDept == null) {
				status = "Social badge does not exist";
			} else {

				for (EventSocialBadge eventSocialBadge : eventSocialBadges) {
					eventSocialBadgeDao.delete(eventSocialBadge);
				}
				for (SocialBadgesDept dept : socialBadgesDept) {
					socialDeptDao.delete(dept);
				}
				socialBadgesDao.delete(socialBadges);

				status = "Social badge deleted successfully";
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "Error while deleting social badge";
		}
		return status;

	}

	@Transactional
	public String updateSocialBadges(AllSocialBadgeDto socialBadgeDto) {
		String status = "";
		try {

			SocialBadges socialBadge = socialBadgesDao.getById(socialBadgeDto
					.getGeneral().getId());

			socialBadge
					.setBadgeName(socialBadgeDto.getGeneral().getBadgeName());
			socialBadge.setBadgeDescription(socialBadgeDto.getGeneral()
					.getBadgeDescription());
			socialBadge.setNumberOfEvents(socialBadgeDto.getGeneral()
					.getNumberOfEvents());
			socialBadgesDao.saveOrUpdate(socialBadge);

			Long socialBadgeId = socialBadge.getId();

			// deleting badges which are there in db but unselected now
			List<SocialBadgesDept> tempbadges = socialDeptDao
					.getByBadgeId(socialBadgeId);

			for (SocialBadgesDept tempbadge : tempbadges) {
				boolean badgeexist = false;

				for (Long deptId : socialBadgeDto.getDepartments()) {
					if (tempbadge.getDepartmentId() == deptId) {
						badgeexist = true;
						break;
					}
				}
				//
				if (!badgeexist) {
					socialDeptDao.delete(tempbadge);
				}

			}
			//

			for (Long deptId : socialBadgeDto.getDepartments()) {
				SocialBadgesDept badgeDept = socialDeptDao
						.getByBadgeIdAndDepartmentId(socialBadgeId, deptId);

				if (badgeDept == null) {
					badgeDept = new SocialBadgesDept();
				}

				badgeDept.setSocialBadgeId(socialBadgeId);
				badgeDept.setDepartmentId(deptId);
				socialDeptDao.saveOrUpdate(badgeDept);
			}

			status = "Social badge updated successfully";

		} catch (Exception e) {

			e.printStackTrace();
			status = "Error while updating social badge";
		}

		return status;
	}

	@Transactional
	public List<SocialBadgePointsDto> getSocialBadgePoints(Long universityId)
			throws IllegalAccessException, InvocationTargetException {

		List<SocialBadgePoints> socialBadgePoints = socialBadgePointsDao
				.getSocialBadgePointData(universityId);
		List<SocialBadgePointsDto> badgeDto = new ArrayList<SocialBadgePointsDto>();
		for (SocialBadgePoints BadgePoints : socialBadgePoints) {

			SocialBadgePointsDto BadgePointsDto = new SocialBadgePointsDto();
			BeanUtils.copyProperties(BadgePointsDto, BadgePoints);
			badgeDto.add(BadgePointsDto);

		}
		return badgeDto;

	}

	@Transactional
	public List<SkillBadgeDto> getAllSkillBadgePoints(Long universityId)
			throws IllegalAccessException, InvocationTargetException {

		List<SkillBadges> badge = skillBadgeDao.getSkillBadgeData(universityId);
		List<SkillBadgeDto> badgeDto = new ArrayList<SkillBadgeDto>();
		for (SkillBadges skillBadge : badge) {

			SkillBadgeDto skillDto = new SkillBadgeDto();
			BeanUtils.copyProperties(skillDto, skillBadge);
			badgeDto.add(skillDto);

		}
		return badgeDto;

	}

	@Transactional
	public String createSkillBadge(List<SkillBadgeDto> skillBadgeDto) {
		String status = "";
		try {
			for (SkillBadgeDto skillDto : skillBadgeDto) {

				SkillBadges badge = skillBadgeDao
						.getByBadgeNameAndUniversityId(
								skillDto.getSkillBadgeName(),
								skillDto.getUniversityId());
				if (badge == null) {
					badge = new SkillBadges();
					badge.setSkillBadgeName(skillDto.getSkillBadgeName());
					badge.setSkillBadgePoints(skillDto.getSkillBadgePoints());
					badge.setUniversityId(skillDto.getUniversityId());
					skillBadgeDao.saveOrUpdate(badge);
					status = "Skill badges saved successfully.";
				} else {
					badge.setSkillBadgePoints(skillDto.getSkillBadgePoints());
					skillBadgeDao.saveOrUpdate(badge);
					status = "Skill badges updated successfully.";
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			status = "Error while creating skill badge";

		}

		return status;

	}

	/*
	 * creating social badge points
	 */
	@Transactional
	public String createSocialBadgePoints(
			List<SocialBadgePointsDto> socialBadgePointsDto) {
		String status = "";
		try {
			for (SocialBadgePointsDto socialDto : socialBadgePointsDto) {

				SocialBadgePoints socialBadgePoints = socialBadgePointsDao
						.getSocialPoints(socialDto.getSocialBadgeName(),
								socialDto.getUniversityId());

				if (socialBadgePoints == null) {
					socialBadgePoints = new SocialBadgePoints();
					socialBadgePoints.setSocialBadgeName(socialDto
							.getSocialBadgeName());
					socialBadgePoints.setSocialBadgePoints(socialDto
							.getSocialBadgePoints());
					socialBadgePoints.setUniversityId(socialDto
							.getUniversityId());
					socialBadgePointsDao.saveOrUpdate(socialBadgePoints);
					status = "Social badge points saved successfully.";
				} else {
					socialBadgePoints.setSocialBadgePoints(socialDto
							.getSocialBadgePoints());
					socialBadgePointsDao.saveOrUpdate(socialBadgePoints);
					status = "Social badge points updated successfully.";
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			status = "Error while creating social badge points";

		}

		return status;

	}

	@Transactional
	public List<SocialBadgesDto> getSocialBadges()
			throws IllegalAccessException, InvocationTargetException {

		List<SocialBadges> socialBadge = socialBadgesDao.getSocialBadges();
		List<SocialBadgesDto> socialDto = new ArrayList<SocialBadgesDto>();

		for (SocialBadges badge : socialBadge) {
			List<SocialBadgesDept> depts = socialDeptDao.getBySocialId(badge
					.getId());
			List<Long> deptTemp = new ArrayList<Long>();

			for (SocialBadgesDept dept : depts) {
				deptTemp.add(dept.getDepartmentId());
			}

			SocialBadgesDto bagdeDto = new SocialBadgesDto();
			// BeanUtils.copyProperties(bagdeDto, badge);
			bagdeDto.setBadgeDescription(badge.getBadgeDescription());
			bagdeDto.setBadgeName(badge.getBadgeName());
			bagdeDto.setDepartments(deptTemp);
			bagdeDto.setId(badge.getId());
			bagdeDto.setNumberOfEvents(badge.getNumberOfEvents());

			socialDto.add(bagdeDto);

		}
		return socialDto;

	}

	@Transactional
	public List<DepartmentsDto> getAllDeparments()
			throws IllegalAccessException, InvocationTargetException {

		List<Departments> department = departmentDao.getAllDepartments();
		List<DepartmentsDto> deptDto = new ArrayList<DepartmentsDto>();

		for (Departments dep : department) {

			DepartmentsDto departDto = new DepartmentsDto();
			BeanUtils.copyProperties(departDto, dep);
			deptDto.add(departDto);

		}
		return deptDto;

	}

	@Transactional
	public String createDepartment(DepartmentsDto departmentsDto) {
		String status = "";
		Departments dept = new Departments();

		try {
			dept.setDepName(departmentsDto.getDepName());
			dept.setValid(departmentsDto.getValid());
			dept.setUniversityId(departmentsDto.getUniversityId());
			departmentDao.save(dept);
			status = "Department saved successfully";
		} catch (Exception e) {
			e.printStackTrace();
			status = "Error while creating Department";
		}
		return status;
	}

	@Transactional
	public CatWisePointsFinalDto getSkillsPoints(Long userId) {
		List<SkillScoreDto> dto = skillBadgeDao.getSkillPoints(userId);
		CatWisePointsFinalDto dto1 = new CatWisePointsFinalDto();

		List<CatWisePointsDto> category = new ArrayList<CatWisePointsDto>();

		Long categoryId = dto.get(0).getCategoryId();
		CatWisePointsDto catWisePointsDto = new CatWisePointsDto();
		catWisePointsDto.setCategoryId(dto.get(0).getCategoryId());
		catWisePointsDto.setCategoryName(dto.get(0).getCategoryName());
		List<SkillPointsDto> skills = new ArrayList<SkillPointsDto>();

		for (int i = 0; i < dto.size(); i++) {
			if (dto.get(i).getCategoryId() == categoryId) {
				SkillPointsDto skl = new SkillPointsDto();
				skl.setSkillId(dto.get(i).getSkillId());
				skl.setSkillName(dto.get(i).getSkillName());
				skl.setPoints(dto.get(i).getPoints() == null ? 0 : dto.get(i)
						.getPoints());

				skills.add(skl);
			} else {
				catWisePointsDto.setSkills(skills);
				category.add(catWisePointsDto);

				catWisePointsDto = new CatWisePointsDto();
				catWisePointsDto.setCategoryId(dto.get(i).getCategoryId());
				catWisePointsDto.setCategoryName(dto.get(i).getCategoryName());

				skills = new ArrayList<SkillPointsDto>();
				categoryId = dto.get(i).getCategoryId();

				SkillPointsDto skl = new SkillPointsDto();
				skl.setSkillId(dto.get(i).getSkillId());
				skl.setSkillName(dto.get(i).getSkillName());
				skl.setPoints(dto.get(i).getPoints() == null ? 0 : dto.get(i)
						.getPoints());

				skills.add(skl);
			}
			if (i == dto.size() - 1) {
				catWisePointsDto.setCategoryId(dto.get(i).getCategoryId());
				catWisePointsDto.setCategoryName(dto.get(i).getCategoryName());

				catWisePointsDto.setSkills(skills);
				category.add(catWisePointsDto);
			}
		}
		dto1.setCategory(category);

		return dto1;
	}

	@Transactional
	public CategoryPointsFinal getCategoryPoints(Long userId) {
		// algorithm for calculating lobo badges
		CategoryPointsFinal finalresponse = new CategoryPointsFinal();
		String loboabdgeName = "No Badge found";
		CatWisePointsFinalDto dto = getSkillsPoints(userId);
		List<LoboBadge> lbadge = loboBadgeDao.findAll();
		double collbrationPont = 0.0, criticalThinkingPoints = 0.0, effectiveCommunicationPoints = 0.0, professionlismPoints = 0.0, researchAndAnalysisPoint = 0.0;

		// System.out.println(dto.toString());
		// getting category by info
		System.out.println("badges");
		for (LoboBadge lobobadge : lbadge) {
			double basicPoints = skillBadgeDao.findById(
					lobobadge.getCollaborationMedal()).getSkillBadgePoints();

			collbrationPont = 0.0;
			criticalThinkingPoints = 0.0;
			effectiveCommunicationPoints = 0.0;
			professionlismPoints = 0.0;
			researchAndAnalysisPoint = 0.0;
			// badges for communication
			if (dto.getCategory().get(0).getSkills().get(0).getPoints() > basicPoints) {
				effectiveCommunicationPoints++;
			}
			if (dto.getCategory().get(0).getSkills().get(1).getPoints() > basicPoints) {
				effectiveCommunicationPoints++;
			}
			if (dto.getCategory().get(0).getSkills().get(2).getPoints() > basicPoints) {
				effectiveCommunicationPoints++;
			}
			if (dto.getCategory().get(0).getSkills().get(3).getPoints() > basicPoints) {
				effectiveCommunicationPoints++;
			}
			if (dto.getCategory().get(0).getSkills().get(4).getPoints() > basicPoints) {
				effectiveCommunicationPoints++;
			}
			// badges for collabration

			if (dto.getCategory().get(1).getSkills().get(0).getPoints() > basicPoints) {
				collbrationPont++;
			}
			if (dto.getCategory().get(1).getSkills().get(1).getPoints() > basicPoints) {
				collbrationPont++;
			}
			if (dto.getCategory().get(1).getSkills().get(2).getPoints() > basicPoints) {
				collbrationPont++;
			}
			if (dto.getCategory().get(1).getSkills().get(3).getPoints() > basicPoints) {
				collbrationPont++;
			}
			if (dto.getCategory().get(1).getSkills().get(4).getPoints() > basicPoints) {
				collbrationPont++;
			}

			// badges for critical thinking
			if (dto.getCategory().get(2).getSkills().get(0).getPoints() > basicPoints) {
				criticalThinkingPoints++;
			}
			if (dto.getCategory().get(2).getSkills().get(1).getPoints() > basicPoints) {
				criticalThinkingPoints++;
			}
			if (dto.getCategory().get(2).getSkills().get(2).getPoints() > basicPoints) {
				criticalThinkingPoints++;
			}
			if (dto.getCategory().get(2).getSkills().get(3).getPoints() > basicPoints) {
				criticalThinkingPoints++;
			}
			if (dto.getCategory().get(2).getSkills().get(4).getPoints() > basicPoints) {
				criticalThinkingPoints++;
			}

			// badges for professionalism
			if (dto.getCategory().get(3).getSkills().get(0).getPoints() > basicPoints) {
				professionlismPoints++;
			}
			if (dto.getCategory().get(3).getSkills().get(1).getPoints() > basicPoints) {
				professionlismPoints++;
			}
			if (dto.getCategory().get(3).getSkills().get(2).getPoints() > basicPoints) {
				professionlismPoints++;
			}
			if (dto.getCategory().get(3).getSkills().get(3).getPoints() > basicPoints) {
				professionlismPoints++;
			}
			if (dto.getCategory().get(3).getSkills().get(4).getPoints() > basicPoints) {
				professionlismPoints++;
			}

			// badge for research and analysis

			if (dto.getCategory().get(4).getSkills().get(0).getPoints() > basicPoints) {
				researchAndAnalysisPoint++;
			}
			if (dto.getCategory().get(4).getSkills().get(1).getPoints() > basicPoints) {
				researchAndAnalysisPoint++;
			}
			if (dto.getCategory().get(4).getSkills().get(2).getPoints() > basicPoints) {
				researchAndAnalysisPoint++;
			}
			if (dto.getCategory().get(4).getSkills().get(3).getPoints() > basicPoints) {
				researchAndAnalysisPoint++;
			}
			if (dto.getCategory().get(4).getSkills().get(4).getPoints() > basicPoints) {
				researchAndAnalysisPoint++;
			}

			// checking if badge is earned
			System.out.println(collbrationPont + "," + criticalThinkingPoints
					+ "," + effectiveCommunicationPoints + ","
					+ professionlismPoints + "," + researchAndAnalysisPoint);
			if (Double.parseDouble(lobobadge.getCollaboration()) <= collbrationPont
					&& Double.parseDouble(lobobadge.getCriticalThinking()) <= criticalThinkingPoints
					&& Double
							.parseDouble(lobobadge.getEffectiveCommunication()) <= effectiveCommunicationPoints
					&& Double.parseDouble(lobobadge.getProfessinalism()) <= professionlismPoints
					&& Double.parseDouble(lobobadge.getResearchAnalysis()) <= researchAndAnalysisPoint) {
				loboabdgeName = lobobadge.getLoboBadgeName();
			}

		}

		finalresponse.setLoboBadgeName(loboabdgeName);
		finalresponse
				.setCategoryPoints(skillBadgeDao.getCategoryPoints(userId));
		return finalresponse;

	}

	// get social badge points for user
	@Transactional
	public FinalSocialBadgePoints getEventsSocialBadgesPointsForUser(Long userId) {

		FinalSocialBadgePoints socialBadges = new FinalSocialBadgePoints();

		List<EventsSocialBadgesPoints> tempBadges = socialBadgePointsDao
				.getEventsSocialBadgesPoints(userId);
		Double bronze = socialBadgePointsDao.getSocialPointsByBadgeName(
				"bronze").getSocialBadgePoints();
		Double silver = socialBadgePointsDao.getSocialPointsByBadgeName(
				"silver").getSocialBadgePoints();
		Double gold = socialBadgePointsDao.getSocialPointsByBadgeName("gold")
				.getSocialBadgePoints();
		List<EventsSocialBadgesPointsFinal> finalBadges = new ArrayList<EventsSocialBadgesPointsFinal>();

		//
		Double silverBadges = 0.0D, brozeBadges = 0.0D, goldBadges = 0.0D;

		for (EventsSocialBadgesPoints temp : tempBadges) {
			EventsSocialBadgesPointsFinal myTemp = new EventsSocialBadgesPointsFinal();
			Double badges = 0.0D;

			if (Math.floor(temp.getPoints() / gold) > 0) {
				badges = Math.floor(temp.getPoints() / gold);
				goldBadges++;
			} else if (Math.floor(temp.getPoints() / silver) > 0) {
				badges = Math.floor(temp.getPoints() / silver);
				silverBadges++;
			} else if (Math.floor(temp.getPoints() / bronze) > 0) {
				badges = Math.floor(temp.getPoints() / bronze);
				brozeBadges++;
			}

			// get departments
			List<SocialBadgesDept> depts = socialDeptDao.getByBadgeId(temp
					.getId());
			List<String> departmets = new ArrayList<String>();

			for (int i = 0; i < depts.size(); i++) {
				departmets.add(departmentDao.findById(
						depts.get(i).getDepartmentId()).getDepName());

			}

			myTemp.setId(temp.getId());
			myTemp.setBadgeDescription(temp.getBadgeDescription());
			myTemp.setBadgeName(temp.getBadgeName());
			myTemp.setNoOfBadges(badges);
			myTemp.setDepartmets(departmets);

			finalBadges.add(myTemp);
		}

		socialBadges.setGoldBadges(goldBadges);
		socialBadges.setSilverBadges(silverBadges);
		socialBadges.setBronzeBadges(brozeBadges);
		socialBadges.setSocialBadges(finalBadges);

		return socialBadges;
	}
}
