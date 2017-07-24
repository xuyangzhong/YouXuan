package com.yx.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Province entity. @author MyEclipse Persistence Tools
 */

public class Province implements java.io.Serializable {

	// Fields

	private String pid;
	private String pname;
	private Set minformations = new HashSet(0);

	// Constructors

	/** default constructor */
	public Province() {
	}

	/** minimal constructor */
	public Province(String pid) {
		this.pid = pid;
	}

	/** full constructor */
	public Province(String pid, String pname, Set minformations) {
		this.pid = pid;
		this.pname = pname;
		this.minformations = minformations;
	}

	// Property accessors

	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Set getMinformations() {
		return this.minformations;
	}

	public void setMinformations(Set minformations) {
		this.minformations = minformations;
	}

}