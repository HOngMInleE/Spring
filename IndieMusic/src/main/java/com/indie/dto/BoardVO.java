
package com.indie.dto;

import java.io.File;
import java.sql.Timestamp;

public class BoardVO {

	private int b_num; // 글 번호 (primary key, sequence) // 수정 불가
	private String adm_num; // 관리자 번호 // CUD 권한부여
	
	private String b_category; // 카테고리 (글 종류)
	private String b_title; // 글 제목
	private String b_content; // 내용
	private int b_readCnt; // 조회수 // 수정 불가 예정
	private Timestamp b_regDate; // 글 등록일
	private Timestamp b_upDate; // 글 수정일
	
	private File b_picture1; // 게시글 사진1
	private File b_picture2; // 게시글 사진2
	private File b_picture3; // 게시글 사진3
	private File b_picture4; // 게시글 사진4
	private File b_picture5; // 게시글 사진5
	
	public File getB_picture1() {
		return b_picture1;
	}
	public void setB_picture1(File b_picture1) {
		this.b_picture1 = b_picture1;
	}
	public File getB_picture2() {
		return b_picture2;
	}
	public void setB_picture2(File b_picture2) {
		this.b_picture2 = b_picture2;
	}
	public File getB_picture3() {
		return b_picture3;
	}
	public void setB_picture3(File b_picture3) {
		this.b_picture3 = b_picture3;
	}
	public File getB_picture4() {
		return b_picture4;
	}
	public void setB_picture4(File b_picture4) {
		this.b_picture4 = b_picture4;
	}
	public File getB_picture5() {
		return b_picture5;
	}
	public void setB_picture5(File b_picture5) {
		this.b_picture5 = b_picture5;
	}
	public int getB_num() {
		return b_num;
	}
	public void setB_num(int bn_num) {
		this.b_num = bn_num;
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
	public Timestamp getB_regDate() {
		return b_regDate;
	}
	public void setB_regDate(Timestamp b_regDate) {
		this.b_regDate = b_regDate;
	}
	public Timestamp getB_upDate() {
		return b_upDate;
	}
	public void setB_upDate(Timestamp b_upDate) {
		this.b_upDate = b_upDate;
	}
	
	
}
