package com.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Dormitory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dormitory", catalog = "dhy_propertymanagement")
public class Dormitory implements java.io.Serializable {

	// Fields

	private Integer id;
	private String dname;
	private String dnumber;
	private String userid;

	// Constructors

	/** default constructor */
	public Dormitory() {
	}

	/** full constructor */
	public Dormitory(String dname, String dnumber, String userid) {
		this.dname = dname;
		this.dnumber = dnumber;
		this.userid = userid;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "dname")
	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	@Column(name = "dnumber")
	public String getDnumber() {
		return this.dnumber;
	}

	public void setDnumber(String dnumber) {
		this.dnumber = dnumber;
	}

	@Column(name = "userid", length = 100)
	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}