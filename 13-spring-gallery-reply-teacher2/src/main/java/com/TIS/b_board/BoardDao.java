package com.TIS.b_board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoardDao {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	//insert,upate,delete
	public int insert(BoardDto galleryDto) {
		int result = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		result = sqlSession.insert("insertGallery",galleryDto);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	public List<BoardDto> getAllList() {
		List<BoardDto>  galleryList = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		galleryList = sqlSession.selectList("getAllList");
		sqlSession.close();
		return galleryList;
	}
}






