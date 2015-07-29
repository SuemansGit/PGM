package com.pga.ro;

import com.pga.eo.UserEO;

public class UserRO {

	private int userId;
	private int pgId;
	private String name;
	private String role;
	private String password;

	public UserRO(UserEO user) {
		super();
		this.userId = user.getUserId();
		this.pgId = user.getPgId();
		this.name = user.getName();
		this.role = user.getRole();
		this.password = user.getPassword();
	}

	public UserRO(int userId, int pgId, String name, String role,
			String password) {
		super();
		this.userId = userId;
		this.pgId = pgId;
		this.name = name;
		this.role = role;
		this.password = password;
	}

	public UserRO(int pgId, String name, String role, String password) {
		super();
		this.name = name;
		this.pgId = pgId;
		this.role = role;
		this.password = password;
	}

	public UserRO() {
		super();
	}

	public UserEO getEntityObject() {
		UserEO user = new UserEO();
		user.setPgId(pgId);
		user.setUserId(userId);
		user.setName(name);
		user.setRole(role);
		user.setPassword(password);
		return user;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPgId() {
		return pgId;
	}

	public void setPgId(int pgId) {
		this.pgId = pgId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserRO [userId=" + userId + ", pgId=" + pgId + ", name=" + name
				+ ", role=" + role + ", password=" + password + "]";
	}

}
