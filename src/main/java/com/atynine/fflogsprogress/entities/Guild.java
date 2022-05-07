package com.atynine.fflogsprogress.entities;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Guild {
	@Id
	private Integer id;
	private String name;
	@ManyToOne(cascade = {CascadeType.ALL})
	private Server server;
}
