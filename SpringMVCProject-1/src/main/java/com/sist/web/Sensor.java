package com.sist.web;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sensor {
	private String DeviceName;
	private String Value;
	private Date RegTime;
	private String Cate;
	
	
}
