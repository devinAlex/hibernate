package oto_bfk;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

/**
 * 身份证
 * @author Administrator
 *
 */
@Entity
public class IdCard {
	@Id
	@GeneratedValue(generator="pid")
	@GenericGenerator(name="pid",strategy="assigned")
	@Column(length=18)
	private String pid;
	private String sname;
	
	@OneToOne(mappedBy="card")
	private Student stu;
	
	public IdCard() {
	}
	public IdCard(String pid, String sname) {
		this.pid = pid;
		this.sname = sname;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	
}
