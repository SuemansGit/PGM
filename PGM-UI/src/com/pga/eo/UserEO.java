package com.pga.eo;

import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "USER")
@NamedQueries({
@NamedQuery(name = "FIND_USER_BY_NAME", query = "SELECT user FROM UserEO user where user.name = :name"),
@NamedQuery(name = "FIND_USER_BY_ROLE", query = "SELECT user FROM UserEO user where user.role = :role")
})
@XmlRootElement
public class UserEO {
	
    private int userId;
    private int pgId;
	private String name;
	private String role;
	private String password;
	private List<PgEO> pg;
	
	
	@Id //signifies the primary key
    @Column(name = "USER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Column(name = "PG_ID")
	public int getPgId() {
		return pgId;
	}
	public void setPgId(int pgId) {
		this.pgId = pgId;
	}
	@Column(name = "NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "ROLE")
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@ManyToMany 
    @JoinTable(name="PG_USER", 
          joinColumns=@JoinColumn(name="USER_ID",referencedColumnName="USER_ID"),
          inverseJoinColumns=@JoinColumn(name="PG_ID",referencedColumnName="PG_ID"))
	public List<PgEO> getPg(){
		return pg;
	}
	public void setPg(List<PgEO> pg) {
		this.pg = pg;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("UserEO [userId=" + userId).append( ", pgId=" + pgId).append(", name=" + name)
				.append(", role=" + role).append( ", password=" + password  + "]").append("\n");
	return sb.toString();
	}
	
    
	
    

}
