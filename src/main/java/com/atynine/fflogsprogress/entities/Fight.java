package com.atynine.fflogsprogress.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Fight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;
	private String name;
	private Boolean completeRaid;
	private Float bossPercentage;
	private Float fightPercentage;
	private Integer lastPhase;
	private Integer lastPhaseAsAbsoluteIndex;
	private Boolean lastPhaseIsIntermission;
}
