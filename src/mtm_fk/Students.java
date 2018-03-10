package mtm_fk;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	@ManyToMany
	@JoinTable(
			name="teachers_students",
			joinColumns={@JoinColumn(name="sid")},
			inverseJoinColumns={@JoinColumn(name="tid")}
			)
	private Set<Teachers> teachers;
	
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

	public Set<Teachers> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teachers> teachers) {
		this.teachers = teachers;
	}

}
