package com.yx.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Goal entity. @author MyEclipse Persistence Tools
 */

public class Goal implements java.io.Serializable {

	// Fields

	private String gid;
	private String y2014;
	private String y2015;
	private String y2016;
	private Set minformations = new HashSet(0);
	private Set minformations_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Goal() {
	}

	/** minimal constructor */
	public Goal(String gid) {
		this.gid = gid;
	}

	/** full constructor */
	public Goal(String gid, String y2014, String y2015, String y2016,
			Set minformations, Set minformations_1) {
		this.gid = gid;
		this.y2014 = y2014;
		this.y2015 = y2015;
		this.y2016 = y2016;
		this.minformations = minformations;
		this.minformations_1 = minformations_1;
	}

	// Property accessors

	public String getGid() {
		return this.gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getY2014() {
		return this.y2014;
	}

	public void setY2014(String y2014) {
		this.y2014 = y2014;
	}

	public String getY2015() {
		return this.y2015;
	}

	public void setY2015(String y2015) {
		this.y2015 = y2015;
	}

	public String getY2016() {
		return this.y2016;
	}

	public void setY2016(String y2016) {
		this.y2016 = y2016;
	}

	public Set getMinformations() {
		return this.minformations;
	}

	public void setMinformations(Set minformations) {
		this.minformations = minformations;
	}

	public Set getMinformations_1() {
		return this.minformations_1;
	}

	public void setMinformations_1(Set minformations_1) {
		this.minformations_1 = minformations_1;
	}

}