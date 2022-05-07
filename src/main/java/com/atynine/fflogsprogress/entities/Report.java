package com.atynine.fflogsprogress.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Data
public class Report {
	@Id
	public String code;
	public Timestamp startTime;
	public Timestamp endTime;
	@ManyToOne(cascade = {CascadeType.ALL})
	public Guild guild;
	@OneToMany(cascade = {CascadeType.ALL})
	public Set<Fight> fights;
}