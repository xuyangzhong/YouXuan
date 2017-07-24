package com.yx.model;

/**
 * School entity. @author MyEclipse Persistence Tools
 */

public class School implements java.io.Serializable {

	// Fields

	private String sid;
	private String sname;

	// Constructors

	/** default constructor */
	public School() {
	}

	/** minimal constructor */
	public School(String sid) {
		this.sid = sid;
	}

	/** full constructor */
	public School(String sid, String sname) {
		this.sid = sid;
		this.sname = sname;
	}

	// Property accessors

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

}