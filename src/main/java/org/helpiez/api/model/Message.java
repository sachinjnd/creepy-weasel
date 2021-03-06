package org.helpiez.api.model;

import java.sql.Timestamp;

public class Message {
	
	private long msgid;
	private long userid; // user who wrote message
	private String message; //5000 chars
	private int thread; // Message between two user
	private Timestamp timestamp;
	private short viewed; // 1 - not viewed 2- viewed 
	private long userto;
	
	// For sender information
	private String userimg;
	private String userlink;
	private String username;
	
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserimg() {
		return userimg;
	}
	public void setUserimg(String userimg) {
		this.userimg = userimg;
	}
	public String getUserlink() {
		return userlink;
	}
	public void setUserlink(String userlink) {
		this.userlink = userlink;
	}
	public short getViewed() {
		return viewed;
	}
	public void setViewed(short viewed) {
		this.viewed = viewed;
	}
	public long getMsgid() {
		return msgid;
	}
	public void setMsgid(long msgid) {
		this.msgid = msgid;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getThread() {
		return thread;
	}
	public void setThread(int thread) {
		this.thread = thread;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public long getUserto() {
		return userto;
	}
	public void setUserto(long userto) {
		this.userto = userto;
	}

}
