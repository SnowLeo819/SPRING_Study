package com.TISpjh.model;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@Setter
@Getter
@ToString
public class BoardDto {
	private int no;
	private String subject;
	private String name;
	private String email;
	private String password;
	private String regDate;
	private int reGroup;
	private int reLevel;
	private int reStep;
	private int hit;
	private String contents;
	private int num;
}
