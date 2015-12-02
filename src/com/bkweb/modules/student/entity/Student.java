package com.bkweb.modules.student.entity;

import org.hibernate.validator.constraints.Length;

public class Student {
	@Length(min = 2, max = 4, message = "名字长度必须介于2 和 4 之间")
	private String name;
	@Length(min = 1, max = 1, message = "性别长度必须是1")
	private String sex;
	private int age;
	private String[] hobby;
	private String school;
	// 传值使用
	private Student[] students;

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

}
