package com.springbook.biz.board;

import java.sql.Date;

import org.springframework.stereotype.Repository;

public class BoardVO {

	private int seq; // 글 번호
	private String title; // 제목
	private String writer; // 작성자
	private String content; // 내용
	private Date regDate; // 작성일
	private int cnt; // ? count로 추정 / default : 0
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "BoardVo [ seq = " + seq + ", title = " + title + ", writer = " + writer +
				", content = " + content + ", regDate = " + regDate + ", cnt = " + cnt + " ]";
		
	}


	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	public int getCnt() {
		return cnt;
	}


	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
	
}
