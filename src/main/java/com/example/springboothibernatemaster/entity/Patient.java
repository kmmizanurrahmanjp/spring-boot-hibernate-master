package com.example.springboothibernatemaster.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="patient")
public class Patient {

	@Id
	//@SequenceGenerator(name="pat_seq", sequenceName="patients_sequence")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int patientId;
	@Column(name="name")
	private String patientName;
	@Column(name="address")
	private String patientAddress;
	@Column(name="phone")
	private String patientPhone;
	
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientAddress() {
		return patientAddress;
	}
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	public String getPatientPhone() {
		return patientPhone;
	}
	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}
	
	
	
	
}
