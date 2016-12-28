package com.codecoop.myuniversity.core.dto;

import java.io.Serializable;

public class LoboBadgeDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String loboBadgeName;
	private String effectiveCommunication;
	private Long effectiveCommunicationMedal;
	private String collaboration;
	private Long collaborationMedal;
	private String criticalThinking;
	private Long criticalThinkingMedal;
	private String professinalism;
	private Long professionalismMedal;
	private String researchAnalysis;
	private Long researchAnalysisMedal;

	public LoboBadgeDto() {
	}

	public LoboBadgeDto(Long id, String loboBadgeName,
			String effectiveCommunication, Long effectiveCommunicationMedal,
			String collaboration, Long collaborationMedal,
			String criticalThinking, Long criticalThinkingMedal,
			String professinalism, Long professionalismMedal,
			String researchAnalysis, Long researchAnalysisMedal) {
		super();
		this.id = id;
		this.loboBadgeName = loboBadgeName;
		this.effectiveCommunication = effectiveCommunication;
		this.effectiveCommunicationMedal = effectiveCommunicationMedal;
		this.collaboration = collaboration;
		this.collaborationMedal = collaborationMedal;
		this.criticalThinking = criticalThinking;
		this.criticalThinkingMedal = criticalThinkingMedal;
		this.professinalism = professinalism;
		this.professionalismMedal = professionalismMedal;
		this.researchAnalysis = researchAnalysis;
		this.researchAnalysisMedal = researchAnalysisMedal;
	}

	@Override
	public String toString() {
		return "LoboBadgeDto [id=" + id + ", loboBadgeName=" + loboBadgeName
				+ ", effectiveCommunication=" + effectiveCommunication
				+ ", effectiveCommunicationMedal="
				+ effectiveCommunicationMedal + ", collaboration="
				+ collaboration + ", collaborationMedal=" + collaborationMedal
				+ ", criticalThinking=" + criticalThinking
				+ ", criticalThinkingMedal=" + criticalThinkingMedal
				+ ", professinalism=" + professinalism
				+ ", professionalismMedal=" + professionalismMedal
				+ ", researchAnalysis=" + researchAnalysis
				+ ", researchAnalysisMedal=" + researchAnalysisMedal + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoboBadgeName() {
		return loboBadgeName;
	}

	public void setLoboBadgeName(String loboBadgeName) {
		this.loboBadgeName = loboBadgeName;
	}

	public String getEffectiveCommunication() {
		return effectiveCommunication;
	}

	public void setEffectiveCommunication(String effectiveCommunication) {
		this.effectiveCommunication = effectiveCommunication;
	}

	public Long getEffectiveCommunicationMedal() {
		return effectiveCommunicationMedal;
	}

	public void setEffectiveCommunicationMedal(
			Long effectiveCommunicationMedal) {
		this.effectiveCommunicationMedal = effectiveCommunicationMedal;
	}

	public String getCollaboration() {
		return collaboration;
	}

	public void setCollaboration(String collaboration) {
		this.collaboration = collaboration;
	}

	public Long getCollaborationMedal() {
		return collaborationMedal;
	}

	public void setCollaborationMedal(Long collaborationMedal) {
		this.collaborationMedal = collaborationMedal;
	}

	public String getCriticalThinking() {
		return criticalThinking;
	}

	public void setCriticalThinking(String criticalThinking) {
		this.criticalThinking = criticalThinking;
	}

	public Long getCriticalThinkingMedal() {
		return criticalThinkingMedal;
	}

	public void setCriticalThinkingMedal(Long criticalThinkingMedal) {
		this.criticalThinkingMedal = criticalThinkingMedal;
	}

	public String getProfessinalism() {
		return professinalism;
	}

	public void setProfessinalism(String professinalism) {
		this.professinalism = professinalism;
	}

	public Long getProfessionalismMedal() {
		return professionalismMedal;
	}

	public void setProfessionalismMedal(Long professionalismMedal) {
		this.professionalismMedal = professionalismMedal;
	}

	public String getResearchAnalysis() {
		return researchAnalysis;
	}

	public void setResearchAnalysis(String researchAnalysis) {
		this.researchAnalysis = researchAnalysis;
	}

	public Long getResearchAnalysisMedal() {
		return researchAnalysisMedal;
	}

	public void setResearchAnalysisMedal(Long researchAnalysisMedal) {
		this.researchAnalysisMedal = researchAnalysisMedal;
	}
	

}
