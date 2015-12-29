package org.helpiez.api.model;

import java.sql.Timestamp;


public class Post {
	private long id;
	private String name; // 5000 words Title in blog, internship, event
	private String type; // INTERN, VOLUNTEER, JOB, EVENT, STORY
	private String extra;
	private short status; // 1- created visible only to creator 2- active (visible to all) 3- deleted (only shown to administrator)
	private long groupid;  //
	private Timestamp timestamp;
	private String url;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	public short getStatus() {
		return status;
	}
	public void setStatus(short status) {
		this.status = status;
	}
	public long getGroupid() {
		return groupid;
	}
	public void setGroupid(long groupid) {
		this.groupid = groupid;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}


