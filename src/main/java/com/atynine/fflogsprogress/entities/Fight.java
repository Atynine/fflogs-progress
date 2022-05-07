package com.atynine.fflogsprogress.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
public class Fight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Float bossPercentage;
	private Boolean completeRaid;
	private Integer encounterID;
	private Float startTime;
	private Timestamp startTimestamp;
	private Float endTime;
	private Timestamp endTimestamp;
	private Float fightPercentage;
	private Boolean hasEcho;
	private Integer lastPhase;
	private Integer lastPhaseAsAbsoluteIndex;
	private Boolean lastPhaseIsIntermission;
	private Integer size;
	private Boolean standardComposition;
	@JsonProperty("kill")
	private Boolean wasKilled;
}
