package com.boardmall.pro.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.boardmall.pro.dto.GameVO;
import com.boardmall.pro.util.SqlSessionFactoryBean;

public class GameDAO {
	
	private SqlSession mybatis;
	
	public GameDAO() {
		mybatis  = SqlSessionFactoryBean.getSqlSessionInstance();
	}
	
	public List<GameVO> getMainList(){
		return mybatis.selectList("GameDAO.getMainList");
	}
	
	public List<GameVO> getImageSliderList(){
		return mybatis.selectList("GameDAO.getImageSliderList");
	}
	
	public GameVO getGameBySeq(int seq){
		return mybatis.selectOne("GameDAO.getGameBySeq", seq);
	}
	
	public List<String> getGameGerneBySeq(int seq){
		return mybatis.selectList("GameDAO.getGameGerneBySeq", seq);
	}
	
	public List<String> getGameSystemBySeq(int seq){
		return mybatis.selectList("GameDAO.getGameSystemBySeq", seq);
	}
	
	public List<String> getGameDescImgBySeq(int seq){
		return mybatis.selectList("GameDAO.getGameDescImgBySeq", seq);
	}
}
