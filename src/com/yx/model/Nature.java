package com.yx.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Nature entity. @author MyEclipse Persistence Tools
 */

public class Nature implements java.io.Serializable {

	// Fields

	private String nid;
	private String nname;
	private Set minformations = new HashSet(0);

	// Constructors

	/** default constructor */
	public Nature() {
	}

	/** minimal constructor */
	public Nature(String nid, String nname) {
		this.nid = nid;
		this.nname = nname;
	}

	/** full constructor */
	public Nature(String nid, String nname, Set minformations) {
		this.nid = nid;
		this.nname = nname;
		this.minformations = minformations;
	}

	// Property accessors

	public String getNid() {
		return this.nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getNname() {
		return this.nname;
	}

	public void setNname(String nname) {
		this.nname = nname;
	}

	public Set getMinformations() {
		return this.minformations;
	}

	public void setMinformations(Set minformations) {
		this.minformations = minformations;
	}

}