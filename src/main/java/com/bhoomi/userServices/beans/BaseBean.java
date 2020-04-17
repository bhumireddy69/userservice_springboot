package com.bhoomi.userServices.beans;

import javax.xml.bind.annotation.XmlTransient;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

@XmlTransient
public class BaseBean {
	
	@Autowired
	private Gson gson;

	/**
	 * New toString() implementation using Gson library,
	 * converts object into JSON string
	 */
	@Override 
	public String toString() { 
	    return gson.toJson(this);
	}
}
