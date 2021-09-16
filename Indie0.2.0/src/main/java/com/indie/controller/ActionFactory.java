package com.indie.controller;

import com.indie.controller.action.Action;
import com.indie.controller.action.IndexAction;
import com.indie.controller.action.admin.AdminIndexAction;
import com.indie.controller.action.admin.AdminLoginAction;
import com.indie.controller.action.admin.AdminLoginFormAction;
import com.indie.controller.action.admin.ManageAdminAction;
import com.indie.controller.action.admin.ManageBoardAction;
import com.indie.controller.action.admin.ManageMemberAction;
import com.indie.controller.action.admin.ManageMemberDetailAction;
import com.indie.controller.action.admin.ManageMemberInsertAction;
import com.indie.controller.action.admin.ManageMusicAction;
import com.indie.controller.action.admin.ManageMusicDeleteAction;
import com.indie.controller.action.admin.ManageMusicDetailAction;
import com.indie.controller.action.admin.ManageMusicInsertAction;
import com.indie.controller.action.admin.ManageMusicUpdateAction;
import com.indie.controller.action.board.BoardDeleteAction;
import com.indie.controller.action.board.BoardDetail_FormAction;
import com.indie.controller.action.board.BoardInsertAction;
import com.indie.controller.action.board.BoardListAll_FormAction;
import com.indie.controller.action.board.BoardListCategory_FormAction;
import com.indie.controller.action.board.BoardUpdateAction;
import com.indie.controller.action.member.JoinAction;
import com.indie.controller.action.member.LoginAction;
import com.indie.controller.action.member.LogoutAction;
import com.indie.controller.action.music.AddListAction;
import com.indie.controller.action.music.AllBalladMusicAction;
import com.indie.controller.action.music.AllDanceMusicAction;
import com.indie.controller.action.music.AllHiphopMusicAction;
import com.indie.controller.action.music.AllIndieMusicAction;
import com.indie.controller.action.music.AllNewMusicAction;
import com.indie.controller.action.music.AllPopMusicAction;
import com.indie.controller.action.music.ForBalladMusicAction;
import com.indie.controller.action.music.ForDanceMusicAction;
import com.indie.controller.action.music.ForHiphopMusicAction;
import com.indie.controller.action.music.ForIndieMusicAction;
import com.indie.controller.action.music.ForNewMusicAction;
import com.indie.controller.action.music.ForPopMusicAction;
import com.indie.controller.action.music.KorBalladMusicAction;
import com.indie.controller.action.music.KorDanceMusicAction;
import com.indie.controller.action.music.KorHiphopMusicAction;
import com.indie.controller.action.music.KorIndieMusicAction;
import com.indie.controller.action.music.KorNewMusicAction;
import com.indie.controller.action.music.KorPopMusicAction;
import com.indie.controller.action.music.MusicDetailAction;
import com.indie.controller.action.playlist.Add_Song_Playlist_FormAction;
import com.indie.controller.action.playlist.Play_PlaylistAction;
import com.indie.controller.action.playlist.Playlist_DeleteAction;
import com.indie.controller.action.playlist.Playlist_Delete_SongAction;
import com.indie.controller.action.playlist.Playlist_Detail_FormAction;
import com.indie.controller.action.playlist.Playlist_InsertAction;
import com.indie.controller.action.playlist.Playlist_Insert_FormAction;
import com.indie.controller.action.playlist.Playlist_My_FormAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory(); 
	
	private ActionFactory() {
		
	}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory에 요청 사항 : "+ command);
		
		if(command.equals("index")) {
			action = new IndexAction();
		}
		// admin part
		else if(command.equals("admin_login_form")) {
			action = new AdminLoginFormAction();
		} else if(command.equals("admin_login")) {
			action = new AdminLoginAction();
		} else if(command.equals("admin_index")) {
			action = new AdminIndexAction();
		} else if(command.equals("manage_member")) {
			action = new ManageMemberAction();
		} else if(command.equals("member_insert")) {
			action = new ManageMemberInsertAction();
		} else if(command.equals("member_detail")) {
			action = new ManageMemberDetailAction();
		} else if(command.equals("manage_music")) {
			action = new ManageMusicAction();
		} else if(command.equals("music_insert")) {
			action = new ManageMusicInsertAction();
		} else if(command.equals("music_detail")) {
			action = new ManageMusicDetailAction();
		} else if(command.equals("music_update")) {
			action = new ManageMusicUpdateAction();
		} else if(command.equals("music_delete")) {
			action = new ManageMusicDeleteAction();
		} else if(command.equals("manage_board")) {
			action = new ManageBoardAction();
		} else if(command.equals("manage_admin")) {
			action = new ManageAdminAction();
		}
		// music part
		else if(command.equals("index")) {
			action = new IndexAction();
		}else if(command.equals("AllPopular")) {
			action = new AllPopMusicAction();
		}else if(command.equals("KorPopular")) {
			action = new KorPopMusicAction();
		}else if(command.equals("ForPopular")) {
			action = new ForPopMusicAction();
		}else if(command.equals("AllNewest")) {
			action = new AllNewMusicAction();
		}else if(command.equals("KorNewest")) {
			action = new KorNewMusicAction();
		}else if(command.equals("ForNewest")) {
			action = new ForNewMusicAction();
		}else if(command.equals("KorBallad")) {
			action = new KorBalladMusicAction();
		}else if(command.equals("KorDance")) {
			action = new KorDanceMusicAction();
		}else if(command.equals("KorHiphop")) {
			action = new KorHiphopMusicAction();
		}else if(command.equals("KorIndie")) {
			action = new KorIndieMusicAction();
		}else if(command.equals("ForBallad")) {
			action = new ForBalladMusicAction();
		}else if(command.equals("ForDance")) {
			action = new ForDanceMusicAction();
		}else if(command.equals("ForHiphop")) {
			action = new ForHiphopMusicAction();
		}else if(command.equals("ForIndie")) {
			action = new ForIndieMusicAction();
		}else if(command.equals("AllBallad")) {
			action = new AllBalladMusicAction();
		}else if(command.equals("AllDance")) {
			action = new AllDanceMusicAction();
		}else if(command.equals("AllHiphop")) {
			action = new AllHiphopMusicAction();
		}else if(command.equals("AllIndie")) {
			action = new AllIndieMusicAction();
		}else if(command.equals("music_detail")) {
			action = new MusicDetailAction();
		}
		// join part
		else if(command.equals("login")) {
			action = new LoginAction();
		}else if(command.equals("join")) {
			action = new JoinAction();
		}
		// board
		else if(command.equals("BoardList_All_form")) {
			action = new BoardListAll_FormAction();
		}else if(command.equals("BoardList_Category_form")) {
			action = new BoardListCategory_FormAction();
		}else if(command.equals("Board_Detail_form")) {
			action = new BoardDetail_FormAction();
		}else if(command.equals("Board_Delete")) {
			action = new BoardDeleteAction();
		}else if(command.equals("Board_Insert")) {
			action = new BoardInsertAction();
		}else if(command.equals("Board_Update")) {
			action = new BoardUpdateAction();
		}
		// playlist
		else if(command.equals("Playlist_My_Form")) { // 나의 플레이리스트 보기
			action = new Playlist_My_FormAction();
		}else if(command.equals("Playlist_Insert_Form")) { // 플레이리스트 생성 form
			action = new Playlist_Insert_FormAction();
		}else if(command.equals("Playlist_InsertAction")) { // 플레이리스트 생성
			action = new Playlist_InsertAction();
		}else if(command.equals("Playlist_Detail_Form")) { // 플레이리스트 상세보기 form
			action = new Playlist_Detail_FormAction();
		}else if(command.equals("Play_PlaylistAction")) { // 플레이리스트 전곡재생
			action = new Play_PlaylistAction();
		}else if(command.equals("Playlist_DeleteAction")) { // 플레이리스트 삭제
			action = new Playlist_DeleteAction();
		}else if(command.equals("Play_Delete_SongAction")) { // 플레이리스트 해당 곡 삭제
			action = new Playlist_Delete_SongAction();
		}else if(command.equals("Add_Song_Playlist_Form")) { // 플레이리스트 곡 추가 Form
			action = new Add_Song_Playlist_FormAction();
		}else if(command.equals("AddListAction")) { // 플레이리스트에 곡 담기
			action = new AddListAction();
		}
		// member
		else if(command.equals("login")) {
			action = new LoginAction();
		}else if(command.equals("join")) {
			action = new JoinAction();
		}else if(command.equals("logout")) {
			action = new LogoutAction();
		}
		
		return action;
	}
}
