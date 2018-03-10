package otm_fk;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * 学生类
 * @author Administrator
 *
 */
@Entity
public class Students {
	@Id
	@GeneratedValue
	private int sid;
	private String cname;
	private String gender;
	private Date birthday;
	private String major;
	
	public Students() {
	}

	public Students(String cname, String gender, Date birthday, String major) {
		this.cname = cname;
		this.gender = gender;
		this.birthday = birthday;
		this.major = major;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
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
