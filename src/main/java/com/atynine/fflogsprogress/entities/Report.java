package com.atynine.fflogsprogress.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Report {
	@Id
	private String code;
	private Long startTime;
	private Long endTime;
	@OneToMany(cascade = {CascadeType.ALL})
	private Set<Fight> fights;
	@ManyToOne(cascade = {CascadeType.ALL})
	private Guild guild;
	@ManyToMany(cascade = {CascadeType.ALL})
	private Set<Player> players;
	@Transient
	private MasterData masterData;
}