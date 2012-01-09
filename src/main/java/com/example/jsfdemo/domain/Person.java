package com.example.jsfdemo.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Person {
	
	private String name = "unknown";
	private int yob = 1900;
	@NotNull
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Min(value=1900)
	@NotNull
	public int getYob() {
		return yob;
	}
	public void setYob(int yob) {
		this.yob = yob;
	}
	boolean editable;
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}

}
