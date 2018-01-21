package gr.hua.dit.models;

import java.io.Serializable;

public class Vehicle implements Serializable {
	
	private static final long serialVersionUID = -1355807851822025659L;
	
	//this class is used for managing vehicles
	private String licenseNumber;
	private String Owner;
	private String Model;
	private String Type;
	private int fine;
	private String insuranceExpires;
	private String lastCheck;
	private String nextCheck;
	private String password;
	
	public Vehicle(String licenseNumber, String owner, String model, String type, int fine, String insuranceExpires,
			String lastCheck, String nextCheck, String password) {
		super();
		this.licenseNumber = licenseNumber;
		Owner = owner;
		Model = model;
		Type = type;
		this.fine = fine;
		this.insuranceExpires = insuranceExpires;
		this.lastCheck = lastCheck;
		this.nextCheck = nextCheck;
		this.password = password;
	}

	public Vehicle() {
		super();
	}


	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public String getOwner() {
		return Owner;
	}
	public void setOwner(String owner) {
		Owner = owner;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public int getFine() {
		return fine;
	}
	public void setFine(int fine) {
		this.fine = fine;
	}
	public String getInsuranceExpires() {
		return insuranceExpires;
	}
	public void setInsuranceExpires(String insuranceExpires) {
		this.insuranceExpires = insuranceExpires;
	}
	public String getLastCheck() {
		return lastCheck;
	}
	public void setLastCheck(String lastCheck) {
		this.lastCheck = lastCheck;
	}
	public String getNextCheck() {
		return nextCheck;
	}
	public void setNextCheck(String nextCheck) {
		this.nextCheck = nextCheck;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "Vehicle [licenseNumber=" + licenseNumber + ", Owner=" + Owner + ", Model=" + Model + ", Type=" + Type
				+ ", fine=" + fine + ", insuranceExpires=" + insuranceExpires + ", lastCheck=" + lastCheck
				+ ", nextCheck=" + nextCheck + ", password=" + password + "]";
	}

	

}
