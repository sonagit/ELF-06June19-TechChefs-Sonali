package com.techchefs.springboot.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@SuppressWarnings("serial")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonRootName(value = "employee-info")
@Entity
@Table(name = "employee_info")
public class EmployeeInfoBean implements Serializable {

	@JsonProperty(value = "other-info")
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "infoBean")
	protected EmployeeOtherInfoBean otherInfo;
	
	@JsonProperty(value = "addressInfoBeans")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "addressPKBean.infoBean", fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	protected List<EmployeeAddressInfoBean> addressInfoBeans;
	
	@JsonProperty(value = "experienceInfoBeans")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "experiencePKBean.infoBean")
	@LazyCollection(LazyCollectionOption.FALSE)
	protected List<EmployeeExperienceInfoBean> experienceInfoBeans;
	
	@JsonProperty(value = "educationInfoBeans")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "educationPKBean.infoBean")
	@LazyCollection(LazyCollectionOption.FALSE)
	protected List<EmployeeEducationInfoBean> educationInfoBeans;
	
	@JsonProperty(value = "trainingInfoBeans")
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "infoBeans")
	@LazyCollection(LazyCollectionOption.FALSE)
	protected List<TrainingInfoBean> trainingInfoBeans;
	
	public EmployeeOtherInfoBean getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(EmployeeOtherInfoBean otherInfo) {
		this.otherInfo = otherInfo;
	}

	public List<EmployeeAddressInfoBean> getAddressInfoBeans() {
		return addressInfoBeans;
	}

	public void setAddressInfoBeans(List<EmployeeAddressInfoBean> addressInfoBeans) {
		this.addressInfoBeans = addressInfoBeans;
	}

	public List<EmployeeExperienceInfoBean> getExperienceInfoBeans() {
		return experienceInfoBeans;
	}

	public void setExperienceInfoBeans(List<EmployeeExperienceInfoBean> experienceInfoBeans) {
		this.experienceInfoBeans = experienceInfoBeans;
	}

	public List<EmployeeEducationInfoBean> getEducationInfoBeans() {
		return educationInfoBeans;
	}

	public void setEducationInfoBeans(List<EmployeeEducationInfoBean> educationInfoBeans) {
		this.educationInfoBeans = educationInfoBeans;
	}

	public List<TrainingInfoBean> getTrainingInfoBeans() {
		return trainingInfoBeans;
	}

	public void setTrainingInfoBeans(List<TrainingInfoBean> trainingInfoBeans) {
		this.trainingInfoBeans = trainingInfoBeans;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public EmployeeInfoBean getMngrId() {
		return mngrId;
	}

	public void setMngrId(EmployeeInfoBean mngrId) {
		this.mngrId = mngrId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private Integer age;
	@Column(name = "gender")
	private String gender;
	@Column(name = "salary")
	private double salary;
	@Column(name = "phone")
	private long phone;
	@Column(name = "joining_date")
	private Date joiningDate;
	@Column(name = "account_number")
	private long accountNumber;
	@Column(name = "email")
	private String email;
	@Column(name = "designation")
	private String designation;
	@Column(name = "dob")
	private Date dob;
	@Column(name = "dept_id")
	private Integer departmentId;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JsonProperty(value = "mngr_id") 
	@JoinColumn(name = "mngr_id", referencedColumnName = "id")
	private EmployeeInfoBean mngrId;
	
	@Column(name = "password")
	private String password;
}
