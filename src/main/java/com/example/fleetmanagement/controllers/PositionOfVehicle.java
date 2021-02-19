package com.example.fleetmanagement.controllers;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PositionOfVehicle {
	
	private BigDecimal latitute;
	private BigDecimal longitude;
	private Date timeStamp;
	public BigDecimal getLatitute() {
		return latitute;
	}
	public void setLatitute(BigDecimal latitute) {
		this.latitute = latitute;
	}
	public BigDecimal getLongitude() {
		return longitude;
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	

}
