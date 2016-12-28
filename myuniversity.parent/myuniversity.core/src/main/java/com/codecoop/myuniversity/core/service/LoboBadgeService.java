package com.codecoop.myuniversity.core.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codecoop.myuniversity.core.dao.LoboBadgeDao;
import com.codecoop.myuniversity.core.domain.LoboBadge;
import com.codecoop.myuniversity.core.dto.LoboBadgeDto;

@Service
public class LoboBadgeService {

	@Autowired
	LoboBadgeDao loboBadgeDao;

	/*
	 * creation of lobo badge
	 */
	@Transactional
	public String saveLoboBadges(List<LoboBadgeDto> logoBadges) {
		String status = "";
		try {
			for (LoboBadgeDto badge : logoBadges) {
				LoboBadge lbadge = loboBadgeDao.getByLoboBadgeName(badge
						.getLoboBadgeName());
				if (lbadge == null) {
					lbadge = new LoboBadge();
				}

				lbadge.setCollaboration(badge.getCollaboration());
				lbadge.setCollaborationMedal(badge.getCollaborationMedal());
				lbadge.setCriticalThinking(badge.getCriticalThinking());
				lbadge.setCriticalThinkingMedal(badge
						.getCriticalThinkingMedal());
				lbadge.setEffectiveCommunication(badge
						.getEffectiveCommunication());
				lbadge.setEffectiveCommunicationMedal(badge
						.getEffectiveCommunicationMedal());
				lbadge.setLoboBadgeName(badge.getLoboBadgeName());
				lbadge.setProfessinalism(badge.getProfessinalism());
				lbadge.setProfessionalismMedal(badge.getProfessionalismMedal());
				lbadge.setResearchAnalysis(badge.getResearchAnalysis());
				lbadge.setResearchAnalysisMedal(badge
						.getResearchAnalysisMedal());

				loboBadgeDao.saveOrUpdate(lbadge);
			}
			status = "Lobo badge updated successfully..";
		} catch (Exception e) {
			status = "Error while saving lobo badges";
		}

		return status;
	}

	// getting all the lobo badges
	@Transactional
	public List<LoboBadgeDto> getAllLoboBadges() {

		List<LoboBadge> lbadge = loboBadgeDao.findAll();
		List<LoboBadgeDto> badges = new ArrayList<LoboBadgeDto>();

		try {
			for (LoboBadge badge : lbadge) {
				LoboBadgeDto loboBadgeDto = new LoboBadgeDto();

				loboBadgeDto.setCollaboration(badge.getCollaboration());
				loboBadgeDto.setCollaborationMedal(badge
						.getCollaborationMedal());
				loboBadgeDto.setCriticalThinking(badge.getCriticalThinking());
				loboBadgeDto.setCriticalThinkingMedal(badge
						.getCriticalThinkingMedal());
				loboBadgeDto.setEffectiveCommunication(badge
						.getEffectiveCommunication());
				loboBadgeDto.setEffectiveCommunicationMedal(badge
						.getEffectiveCommunicationMedal());
				loboBadgeDto.setLoboBadgeName(badge.getLoboBadgeName());
				loboBadgeDto.setProfessinalism(badge.getProfessinalism());
				loboBadgeDto.setProfessionalismMedal(badge
						.getProfessionalismMedal());
				loboBadgeDto.setResearchAnalysis(badge.getResearchAnalysis());
				loboBadgeDto.setResearchAnalysisMedal(badge
						.getResearchAnalysisMedal());

				badges.add(loboBadgeDto);
			}
		} catch (Exception e) {

		}

		return badges;
	}

}
