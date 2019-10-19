package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;
/**
 * 
 * @author Soumyadip Chowdhury
 * @github soumyadip007
 *
 */
@Entity
@Table(name = "ams")
public class AMS {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "year")
	private String year;
	
	@Column(name = "course")
	private String course;
	
	@Column(name = "dept")
	private String dept;
	
	@Column(name = "enrl")
	private String enrl;
	
	@Column(name = "dgpa")
	private String dgpa;
	

	@Column(name = "chapter")
	private String chapter;
	
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "ph")
	private String ph;
	

	@Column(name = "achivements")
	private String achivements;
	
	@Column(name = "placed")
	private String placed;
	
	@Column(name = "image")
	private String image;
	

	@Column(name = "click")
	@Transient
	private int click;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	public String getEnrl() {
		return enrl;
	}


	public void setEnrl(String enrl) {
		this.enrl = enrl;
	}


	public String getDgpa() {
		return dgpa;
	}


	public void setDgpa(String dgpa) {
		this.dgpa = dgpa;
	}


	public String getChapter() {
		return chapter;
	}


	public void setChapter(String chapter) {
		this.chapter = chapter;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPh() {
		return ph;
	}


	public void setPh(String ph) {
		this.ph = ph;
	}


	public String getAchivements() {
		return achivements;
	}


	public void setAchivements(String achivements) {
		this.achivements = achivements;
	}


	public String getPlaced() {
		return placed;
	}


	public void setPlaced(String placed) {
		this.placed = placed;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public int getClick() {
		return click;
	}


	public void setClick(int click) {
		this.click = click;
	}


	@Override
	public String toString() {
		return "AMS [id=" + id + ", year=" + year + ", course=" + course + ", dept=" + dept + ", enrl=" + enrl
				+ ", dgpa=" + dgpa + ", chapter=" + chapter + ", email=" + email + ", address=" + address + ", ph=" + ph
				+ ", achivements=" + achivements + ", placed=" + placed + ", image=" + image + ", click=" + click + "]";
	}

	



}