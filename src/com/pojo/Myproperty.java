package com.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Myproperty entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "myproperty", catalog = "dhy_propertymanagement")
public class Myproperty implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userid;
	private String bed;
	private String desk;
	private String chair;
	private String cupboard;
	private String startdate;
	private String enddate;
	private String status;
	private String remark;
	private String price;

	// Constructors

	/** default constructor */
	public Myproperty() {
	}

	/** full constructor */
	public Myproperty(String userid, String bed, String desk, String chair,
			String cupboard, String startdate, String enddate, String status,
			String remark, String price) {
		this.userid = userid;
		this.bed = bed;
		this.desk = desk;
		this.chair = chair;
		this.cupboard = cupboard;
		this.startdate = startdate;
		this.enddate = enddate;
		this.status = status;
		this.remark = remark;
		this.price = price;
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

	@Column(name = "userid", length = 100)
	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Column(name = "bed", length = 100)
	public String getBed() {
		return this.bed;
	}

	public void setBed(String bed) {
		this.bed = bed;
	}

	@Column(name = "desk", length = 100)
	public String getDesk() {
		return this.desk;
	}

	public void setDesk(String desk) {
		this.desk = desk;
	}

	@Column(name = "chair", length = 100)
	public String getChair() {
		return this.chair;
	}

	public void setChair(String chair) {
		this.chair = chair;
	}

	@Column(name = "cupboard", length = 100)
	public String getCupboard() {
		return this.cupboard;
	}

	public void setCupboard(String cupboard) {
		this.cupboard = cupboard;
	}

	@Column(name = "startdate", length = 100)
	public String getStartdate() {
		return this.startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	@Column(name = "enddate", length = 100)
	public String getEnddate() {
		return this.enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	@Column(name = "status", length = 100)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "price", length = 100)
	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}