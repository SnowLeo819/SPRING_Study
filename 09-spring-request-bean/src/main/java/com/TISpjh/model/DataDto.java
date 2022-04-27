package com.TISpjh.model;

import org.springframework.stereotype.Component;

// 자동주입 진행을 위한 import
@Component  
//@Data
public class DataDto {
	private String data01;
	private String data02;
	
	public String getdata01() {
		return data01;
	}
	public void setdata01(String data01) {
		this.data01 = data01;
	}
	public String getdata02() {
		return data02;
	}
	public void setdata02(String data02) {
		this.data02 = data02;
	}
	@Override
	public String toString() {
		return "DataDto [data01=" + data01 + ", data02=" + data02 + "]";
	}
	
	
}
