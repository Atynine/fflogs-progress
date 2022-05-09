package com.atynine.fflogsprogress.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Fight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("internalId")
	private Integer id;
	@JsonProperty("id")
	private Integer fflogsId;
	private String name;
	private Float bossPercentage;
	private Boolean completeRaid;
	private Integer encounterID;
	private Long startTime;
	private Long startTimestamp;
	private Long endTime;
	private Long endTimestamp;
	private Float fightPercentage;
	private Boolean hasEcho;
	private Integer lastPhase;
	private Integer lastPhaseAsAbsoluteIndex;
	private Boolean lastPhaseIsIntermission;
	private Integer size;
	private Boolean standardComposition;
	@JsonProperty("kill")
	private Boolean wasKilled;
	private Integer guildID;
	private String reportCode;
}
