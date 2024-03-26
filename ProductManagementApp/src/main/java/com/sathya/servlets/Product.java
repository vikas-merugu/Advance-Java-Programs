package com.sathya.servlets;

import java.io.InputStream;
import java.sql.Date;
import java.util.Base64;

public class Product {

	private String proId;
	private String proName;
	private double proPrice;
	private String proBrand;
	private String proMadeIn;
	private Date proMfg;
	private Date proExp;
	private byte[] proImage;
	
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public double getProPrice() {
		return proPrice;
	}
	public void setProPrice(double proPrice) {
		this.proPrice = proPrice;
	}
	public String getProBrand() {
		return proBrand;
	}
	public void setProBrand(String proBrand) {
		this.proBrand = proBrand;
	}
	public String getProMadeIn() {
		return proMadeIn;
	}
	public void setProMadeIn(String proMadeIn) {
		this.proMadeIn = proMadeIn;
	}
	public Date getProMfg() {
		return proMfg;
	}
	public void setProMfg(Date proMfg) {
		this.proMfg = proMfg;
	}
	public Date getProExp() {
		return proExp;
	}
	public void setProExp(Date proExp) {
		this.proExp = proExp;
	}
	public byte[] getProImage() {
		return proImage;
	}
	public void setProImage(byte[] proImage) {
		this.proImage = proImage;
	}
	
	
	}


