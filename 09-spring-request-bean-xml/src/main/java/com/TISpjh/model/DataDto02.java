package com.TISpjh.model;

import org.springframework.stereotype.Component;

// 자동주입 진행을 위한 import
@Component  
//@Data
public class DataDto02 {
	private String data0201;
	private String data0202;
	
	public String getdata0201() {
		return data0201;
	}
	public void setdata0201(String data0201) {
		this.data0201 = data0201;
	}
	public String getdata0202() {
		return data0202;
	}
	public void setdata0202(String data0202) {
		this.data0202 = data0202;
	}
	@Override
	public String toString() {
		return "DataDto [data0201=" + data0201 + ", data0202=" + data0202 + "]";
	}
	
	
}
