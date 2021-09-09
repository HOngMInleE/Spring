
package com.indie.dto;

import java.sql.Date;

public class BoardVO {

	// artist 사진, 노래들. 추가예정
	// 0909(목) 수업 후 검색기능 도입 예정
	
	// admin_id (관리자 id로 로그인시 수정 가능)
	
	private int bn_num; // 글 번호 (primary key, sequence) // 수정 불가
	private String adm_num; // 관리자 번호 // 값 일치 후 확인
	
	private String b_category; // 글 종류 (분류)
	private String b_title; // 글 제목
	private String b_content; // 내용
	private int b_readCnt; // 조회수 // 수정 불가 예정
	private Date b_regDate; // 글 등록일
	private Date b_upDate; // 글 수정일
	
	
	public int getBn_num() {
		return bn_num;
	}
	public void setBn_num(int bn_num) {
		this.bn_num = bn_num;
	}
	public String getAdm_num() {
		return adm_num;
	}
	public void setAdm_num(String adm_num) {
		this.adm_num = adm_num;
	}
	public String getB_category() {
		return b_category;
	}
	public void setB_category(String b_category) {
		this.b_category = b_category;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public int getB_readCnt() {
		return b_readCnt;
	}
	public void setB_readCnt(int b_readCnt) {
		this.b_readCnt = b_readCnt;
	}
	public Date getB_regDate() {
		return b_regDate;
	}
	public void setB_regDate(Date b_regDate) {
		this.b_regDate = b_regDate;
	}
	public Date getB_upDate() {
		return b_upDate;
	}
	public void setB_upDate(Date b_upDate) {
		this.b_upDate = b_upDate;
	}
	
	
}
