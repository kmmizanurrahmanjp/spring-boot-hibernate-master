package com.example.springboothibernatemaster.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboothibernatemaster.entity.Patient;
import com.example.springboothibernatemaster.service.PatientServiceImp;

@RestController
@RequestMapping(value="/patient")
public class PatientController {

	@Autowired
	PatientServiceImp patientServiceImp;
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST)
	public Map<String, Object> insetPatient(@RequestBody Patient patient){
		Map<String, Object> response = new HashMap<String, Object>();
		 int pat = patientServiceImp.insetPatient(patient);
		 if(pat == 0){
			 response.put("Success", false);
			 response.put("data", patient);
			 response.put("massage", "There are no Patient");
		 }else{
			 response.put("Success", true);
			 response.put("data", patient);
			 response.put("massage", "Select All Patient");
		 }
		 return response;
	}
	
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.PUT)
	public Map<String, Object> updatePatient(@RequestBody Patient patient){
		Map<String, Object> response = new HashMap<String, Object>();
		 Patient pat = patientServiceImp.updatePatient(patient);
		 if(pat == null){
			 response.put("Success", false);
			 response.put("data", pat);
			 response.put("massage", "There are no Patient");
		 }else{
			 response.put("Success", true);
			 response.put("data", pat);
			 response.put("massage", "Patient Updated");
		 }
		 return response;
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public Map<String, Object> deletePatient(@PathVariable int id){
		Map<String, Object> response = new HashMap<String, Object>();
		if(patientServiceImp.deletePatient(id) == true) {
			response.put("Success", true);
			response.put("massage", "Patient Deleted");
		}else {
			response.put("Success", false);
			response.put("massage", "Patient not found");
		}
		 return response;
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public Map<String, Object> selectAllPatient(){
		Map<String, Object> response = new HashMap<String, Object>();
		 List<Patient> pat = patientServiceImp.selectAllPatient();
		 if(pat.isEmpty()){
			 response.put("Success", false);
			 response.put("data", pat);
			 response.put("massage", "There are no Patient");
		 }else{
			 response.put("Success", true);
			 response.put("data", pat);
			 response.put("massage", "Select All Patient");
		 }
		 return response;
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Map<String, Object> searchPatientById(@PathVariable int id){
		Map<String, Object> response = new HashMap<String, Object>();
		List<Patient> patient = patientServiceImp.searchPatientById(id);
		if(patient.isEmpty()) {
			response.put("Success", false);
			response.put("data", patient);
			response.put("massage", "Patient not present");
		}else {
			response.put("Success", true);
			response.put("data", patient);
			response.put("massage", "Patient is found");
		}
		 return response;
	}
	
	@ResponseBody
	@RequestMapping(value = "search", method = RequestMethod.GET)
    public Map<String, Object> selectPatientByCriteria(
    		@RequestHeader("id") String patientId, 
    		@RequestHeader("name") String patientName, 
    		@RequestHeader("address") String patientAddress, 
    		@RequestHeader("phone") String patientPhone) {
		Map<String, Object> response = new HashMap<String, Object>();
		
		Patient patient = new Patient();
		if(patientId != ""){
			patient.setPatientId(Integer.valueOf(patientId));
		}else{
			patient.setPatientId(0);
		}
		patient.setPatientName(patientName);
		patient.setPatientAddress(patientAddress);
		patient.setPatientPhone(patientPhone);
		List<Patient> query = patientServiceImp.selectPatientByCriteria(patient);
		if(query.isEmpty()) {
			response.put("Success", false);
			response.put("data", query);
			response.put("massage", "Patient not found");
		}else {
			response.put("Success", true);
			response.put("data", query);
			response.put("massage", "Patient found");
		}
        return response;
    }
	
}
