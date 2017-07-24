package com.yx.model;

/**
 * Minformation entity. @author MyEclipse Persistence Tools
 */

public class Minformation implements java.io.Serializable {

	// Fields

	private String sid;
	private Province province;
	private Goal goal;
	private Nature nature;
	private String sadd;
	private String sintro;
	private String surl;

	// Constructors

	/** default constructor */
	public Minformation() {
	}

	/** full constructor */
	public Minformation(String sid, Province province, Goal goal,
			Nature nature, String sadd, String sintro, String surl) {
		this.sid = sid;
		this.province = province;
		this.goal = goal;
		this.nature = nature;
		this.sadd = sadd;
		this.sintro = sintro;
		this.surl = surl;
	}

	// Property accessors

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public Province getProvince() {
		return this.province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public Goal getGoal() {
		return this.goal;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}

	public Nature getNature() {
		return this.nature;
	}

	public void setNature(Nature nature) {
		this.nature = nature;
	}

	public String getSadd() {
		return this.sadd;
	}

	public void setSadd(String sadd) {
		this.sadd = sadd;
	}

	public String getSintro() {
		return this.sintro;
	}

	public void setSintro(String sintro) {
		this.sintro = sintro;
	}

	public String getSurl() {
		return this.surl;
	}

	public void setSurl(String surl) {
		this.surl = surl;
	}

}