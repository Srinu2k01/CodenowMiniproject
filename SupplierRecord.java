package com.cmr.prj.util;

public class SupplierRecord {
	private int supplierid;
	private String suppliername;
	public SupplierRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SupplierRecord(int supplierid, String suppliername) {
		super();
		this.supplierid = supplierid;
		this.suppliername = suppliername;
	}
	public int getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	
	
}

