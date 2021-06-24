package com.cmr.prj.util;

public class ItemsRecord {
	private int itemid;
	private String itemname;
	private int itemsleft;
	public ItemsRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemsRecord(int itemid, String itemname, int itemsleft) {
		super();
		this.itemid = itemid;
		this.itemname = itemname;
		this.itemsleft = itemsleft;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public int getItemsleft() {
		return itemsleft;
	}
	public void setItemsleft(int itemsleft) {
		this.itemsleft = itemsleft;
	}
	

}
