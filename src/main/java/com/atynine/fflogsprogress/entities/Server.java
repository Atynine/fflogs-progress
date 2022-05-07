package com.atynine.fflogsprogress.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Server {
	@Id
	private Integer id;
	private String name;
}
