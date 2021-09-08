package indie.project;

import java.sql.Date;

public class BoardVO {

	// admin_id (관리자 id로 로그인시 수정 가능)
	
	private int boardNum; // 글 번호 (primary key, sequence) // 수정 불가
	private String category; // 글 종류 (분류)
	private String title; // 글 제목
	private String content; // 내용
	private int readCnt; // 조회수 // 수정 불가
	private Date regDate; // 글 등록일
	
	// artist 사진, 노래들. 추가예정
}
