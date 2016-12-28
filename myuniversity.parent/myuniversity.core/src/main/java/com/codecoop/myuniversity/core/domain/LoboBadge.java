package com.codecoop.myuniversity.core.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOBO_BADGES")
public class LoboBadge implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "LOBO_BADGE_NAME")
	private String loboBadgeName;

	@Column(name = "EFFECTIVE_COMMUNICATION")
	private String effectiveCommunication;

	@Column(name = "EFFECTIVE_COMMUNICATION_MEDAL")
	private Long effectiveCommunicationMedal;

	@Column(name = "COLLABORATION")
	private String collaboration;

	@Column(name = "COLLABORATION_MEDAL")
	private Long collaborationMedal;

	@Column(name = "CRITICAL_THINKING")
	private String criticalThinking;

	@Column(name = "CRITICAL_THINKING_MEDAL")
	private Long criticalThinkingMedal;

	@Column(name = "PROFESSIONALISM")
	private String professinalism;

	@Column(name = "PROFESSIONALISM_MEDAL")
	private Long professionalismMedal;

	@Column(name = "REASEARCH_ANALYSIS")
	private String researchAnalysis;

	@Column(name = "REASEARCH_ANALYSIS_MEDAL")
	private Long researchAnalysisMedal;

	public LoboBadge() {
	}

	public LoboBadge(Long id, String loboBadgeName,
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
		return "LoboBadge [id=" + id + ", loboBadgeName=" + loboBadgeName
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

	public void setEffectiveCommunicationMedal(Long effectiveCommunicationMedal) {
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
