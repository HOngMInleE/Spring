package com.indie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.indie.dto.PlaylistVO;

public class PlaylistDAO {

	// SingleTornPattern
	private static PlaylistDAO instance = new PlaylistDAO();
	private PlaylistDAO() {
	}
	public static PlaylistDAO getInstance() {
		return instance;
	}

	// DBCP 객체 초기화
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	ResultSet rs = null;

//CRUD
	
//Read 
	// id값이 같은 플레이리스트불러오기
	public void getPlaylistById(String mb_id) {
		// mb_id값 받아와 해당 id값을 가진 모든 컬럼 (title은 distinct:고유값출력) 받아옴
	}
	
//Create  
	// 플레이리스트 생성하기
	public void insertPlaylist(String pl_id) {
		// num:pl_id,pl_id, pl_num, pl_num이 일치시 증가.
	}
	
//Creat 
	// 플레이리스트에 해당 곡 담기 
	public void addPlaylist(String m_id) {
		// 노래 담기버튼-> 플레이리스트 선택시 실행 메소드
		// pl_id,pl_id, pl_num, pl_num이 일치시 추가
		// 해당 곡 정보-> playlist table 에 저장
	}
	
//Read  
	// 플레이리스트 재생(전체 재생)
	public void playPlaylist() {
		// playlist play하는 메소드
	}
	
//Read<list>  
	// 해당 플레이리스트 상세보기
	public List<PlaylistVO> getPlaylistDetail(String pl_id, String pl_num) {
		// insert와 같은 원리, m_id값(List타입)만 받아옴
		return null;
	}
	
//Read<List> 
	// 해당 플레이리스트에 노래 정보 불러오기
	public List<PlaylistVO> getPlaylistSongs(String m_id) {
		// m_id 값 대입, 해당 곡 정보 받아오기 (musicVO통해서)
		// playlist_songs return.
		return null;
	}
	
//Delete 
	// 해당 플레이리스트 삭제하기
	public void deletePlaylist(String pl_id,int pl_num) {
		// pl_id, pl_num 일치시 삭제
	}
	
//Delete 
	// 해당 플레이리스트내 해당 곡 삭제
	public void deleteSongsInPlaylist(String m_id) {
		// insert와 같은 원리, pl_id,pl_id, pl_num, pl_num이 일치시 해당 컬럼 삭제 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
