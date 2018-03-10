package oto_bfk;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
/**
 * 学生类
 * @author Administrator
 *
 */
@Entity
public class Student {
	@Id
	@GeneratedValue
	private int sid;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="pid")
	private IdCard card;
	private String gender;
	private Date birthday;
	private String major;

	public Student() {
	}

	public Student(IdCard card, String gender, Date birthday, String major) {
		this.card = card;
		this.gender = gender;
		this.birthday = birthday;
		this.major = major;
	}

	public IdCard getCard() {
		return card;
	}

	public void setCard(IdCard card) {
		this.card = card;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

}
