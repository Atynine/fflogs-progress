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
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;
	private String name;
	private Float averageItemLevel;
	private Float startTime;
	private Timestamp startTimestamp;
	private Float endTime;
	private Timestamp endTimestamp;
	private Integer encounterId;
	private Boolean completeRaid;
	private Float bossPercentage;
	private Float fightPercentage;
	private Integer lastPhase;
	private Integer lastPhaseAsAbsoluteIndex;
	private Boolean lastPhaseIsIntermission;
	private Boolean hasEcho;
	@JsonProperty("kill")
	private Boolean wasKilled;
	private Integer size;
	private Boolean standardComposition;
}
