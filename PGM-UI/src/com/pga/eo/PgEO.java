package com.pga.eo;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

//@NamedNativeQueries({
//	@NamedNativeQuery(name = "query_name", query = "select child_rsrc_id from resources_x where rsrc_id = ?1")	
//})

//@NamedQueries({
//	@NamedQuery(name = Pg.FIND_PG_BY_ADDRESS, query = "SELECT pg FROM Pg pg where pg.name = :name"),
//	@NamedQuery(name = ResourceEO.FIND_RESOURCES_FOR_TS_APPROVAL_MANAGER, query = "SELECT resource FROM ResourceEO resource where resource.timesheetApproveUser.userId = :approveManagerUserId and resource.applicationUser.userId is not null"),
//	@NamedQuery(name = ResourceEO.SEARCH_RESOURCES_BY_RESOURCE_NAME_BY_TYPE, query = "SELECT resource FROM ResourceEO resource WHERE resource.resourceType = :resourceType AND UPPER(resource.resourceName) LIKE UPPER(:query)"),
//	@NamedQuery(name = ResourceEO.FIND_RESOURCES_BY_PARENT_BY_TYPE, query = "SELECT resource FROM ResourceEO resource WHERE resource.parentResource.resourceId = :parentId AND resource.resourceType = :resourceType"),
//	@NamedQuery(name = ResourceEO.FIND_ALL_PARENT_RESOURCES_BY_TYPE, query = "SELECT resource FROM ResourceEO resource WHERE resource.parentResource IS NULL AND resource.resourceType = :resourceType"),
//	@NamedQuery(name = ResourceEO.FIND_RESOURCES_BY_ROLE_ID_QUERY, query = "SELECT resource FROM ResourceEO resource WHERE resource.role.roleId IN :roleIds AND resource.isActive = true"),
//	@NamedQuery(name = ResourceEO.SEARCH_RESOURCES_BY_RESOURCE_NAME_AND_ROLE_ID, query = "SELECT resource FROM ResourceEO resource WHERE resource.role.roleId IN :roleIds AND resource.isActive = true AND (UPPER(resource.resourceName) LIKE UPPER(:query) OR UPPER(resource.resourceCode) LIKE UPPER(:query))")
//})

@Entity
@Table(name = "PG")
@NamedQueries({ @NamedQuery(name = "FIND_PG_BY_NAME", query = "SELECT pg FROM PgEO pg where pg.name = :name") })
@XmlRootElement
public class PgEO {

	private int pgId;
	private String name;
	private String address;
	private String category;	
	private List<RoomEO> roomList;
	private List<UserEO> userList;
	private List<LogEO> logList;

	@Id
	@Column(name = "PG_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@Column(name = "ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name="CATEGORY")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	
//	public String getSex() {
//		return sex;
//	}
//
//	public void setSex(String sex) {
//		this.sex = sex;
//	}

	@OneToMany(mappedBy = "pg", targetEntity = RoomEO.class, fetch = FetchType.LAZY)
	public List<RoomEO> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<RoomEO> roomList) {
		this.roomList = roomList;
	}

	@ManyToMany(mappedBy = "pg", targetEntity = UserEO.class, fetch = FetchType.LAZY)
	public List<UserEO> getUserList() {
		return userList;
	}

	public void setUserList(List<UserEO> userList) {
		this.userList = userList;
		}
    
	@OneToMany(mappedBy = "pg", targetEntity = LogEO.class, fetch = FetchType.LAZY)
	public List<LogEO> getLogList() {
		return logList;
	}

	public void setLogList(List<LogEO> logList) {
		this.logList = logList;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("PgEO [pgId=" + pgId).append(", name=" + name)
				.append(", address=" + address + "]").append("\n");

		if (this.getRoomList() != null) {
			int index = 1;
			for (RoomEO room : this.getRoomList()) {
				sb.append("RoomEO " + index++).append("-\n").append(room)
						.append("\n");
			}
		}
		if (this.getUserList() != null) {
			int index = 1;
			for (UserEO user : this.getUserList()) {
				sb.append("UserEO " + index++).append("-\n").append(user)
						.append("\n");
			}
		}

		if (this.getLogList() != null) {
			int index = 1;
			for (LogEO log : this.getLogList()) {
				sb.append("LogEO " + index++).append("-\n").append(log)
						.append("\n");
			}
		}

		return sb.toString();
	}

}
