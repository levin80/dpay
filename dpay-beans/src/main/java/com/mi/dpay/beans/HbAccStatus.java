package com.mi.dpay.beans;

/**
 * HbAccStatus entity. @author MyEclipse Persistence Tools
 */

public class HbAccStatus implements java.io.Serializable {

	// Fields

	private String status;
	private String name;
	private String flag;

	// Constructors

	/** default constructor */
	public HbAccStatus() {
	}

	/** minimal constructor */
	public HbAccStatus(String status) {
		this.status = status;
	}

	/** full constructor */
	public HbAccStatus(String status, String name, String flag) {
		this.status = status;
		this.name = name;
		this.flag = flag;
	}

	// Property accessors

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}