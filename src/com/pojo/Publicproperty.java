package com.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Publicproperty entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "publicproperty", catalog = "dhy_propertymanagement")
public class Publicproperty implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userid;
	private String dname;	
	private String bulb;
	private String airconditioning;
	private String waterheater;
	private String faucet;
	private String outlet;
	private String toilet;
	private String loker;
	private String clothesrods;
	private String startdate;
	private String enddate;
	private String status;
	private String remark;
	private String price;

	// Constructors

	/** default constructor */
	public Publicproperty() {
	}

	/** full constructor */
	public Publicproperty(String userid,String dname, String bulb, String airconditioning,
			String waterheater, String faucet, String outlet, String toilet,
			String loker, String clothesrods, String startdate, String enddate,
			String status, String remark, String price) {
		this.userid = userid;
		this.dname = dname;
		this.bulb = bulb;
		this.airconditioning = airconditioning;
		this.waterheater = waterheater;
		this.faucet = faucet;
		this.outlet = outlet;
		this.toilet = toilet;
		this.loker = loker;
		this.clothesrods = clothesrods;
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
	
	@Column(name = "dname", length = 100)	
	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}	

	@Column(name = "bulb", length = 100)
	public String getBulb() {
		return this.bulb;
	}

	public void setBulb(String bulb) {
		this.bulb = bulb;
	}

	@Column(name = "airconditioning", length = 100)
	public String getAirconditioning() {
		return this.airconditioning;
	}

	public void setAirconditioning(String airconditioning) {
		this.airconditioning = airconditioning;
	}

	@Column(name = "waterheater", length = 100)
	public String getWaterheater() {
		return this.waterheater;
	}

	public void setWaterheater(String waterheater) {
		this.waterheater = waterheater;
	}

	@Column(name = "faucet", length = 100)
	public String getFaucet() {
		return this.faucet;
	}

	public void setFaucet(String faucet) {
		this.faucet = faucet;
	}

	@Column(name = "outlet", length = 100)
	public String getOutlet() {
		return this.outlet;
	}

	public void setOutlet(String outlet) {
		this.outlet = outlet;
	}

	@Column(name = "toilet", length = 100)
	public String getToilet() {
		return this.toilet;
	}

	public void setToilet(String toilet) {
		this.toilet = toilet;
	}

	@Column(name = "loker", length = 100)
	public String getLoker() {
		return this.loker;
	}

	public void setLoker(String loker) {
		this.loker = loker;
	}

	@Column(name = "clothesrods", length = 100)
	public String getClothesrods() {
		return this.clothesrods;
	}

	public void setClothesrods(String clothesrods) {
		this.clothesrods = clothesrods;
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