package com.TISpjh.model;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//VO, DTO, BEAN
@Setter
@Getter			
@ToString
@Component
public class MemberDto {
	private int no;
	private String id;
	private String password;
	private String name;
	private String email;
	private String phoneFirst;
	private String phoneMiddle;
	private String phoneLast;
	private String phone;
	private int zipCode;
	private String address;
	private String address01;
	private String address02;
	private String regDate;
	
	private String img;
	private String realImg;
	private String thumb;
}
