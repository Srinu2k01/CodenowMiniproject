package com.cmr.prj.util;

public class InventoryRecord {
	private int id;
	private int supplierid;
	private int itemid;
	private int itemssupplied;
	public InventoryRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InventoryRecord(int id, int supplierid, int itemid, int itemssupplied) {
		super();
		this.id = id;
		this.supplierid = supplierid;
		this.itemid = itemid;
		this.itemssupplied = itemssupplied;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getItemssupplied() {
		return itemssupplied;
	}
	public void setItemssupplied(int itemssupplied) {
		this.itemssupplied = itemssupplied;
	}
	
	
	
}
