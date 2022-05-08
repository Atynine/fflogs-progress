package com.atynine.fflogsprogress.entities;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Player {
	@Id
	private Integer id;
	private Integer canonicalID;
	private Integer lodestoneID;
	private String name;
	@ManyToOne(cascade = {CascadeType.PERSIST})
	private Server server;
}
