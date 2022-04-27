package com.TISpjh.model;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Component
public class TodoDto {
	private int no;
	private String todo;
	private String done;
	private String pickedDate;
}
