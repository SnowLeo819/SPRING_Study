package com.TISpjh.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoardDao implements BoardService {

	@Autowired
	public SqlSessionFactory sqlSessionFactory;
	
	@Override
	public int insertBoard(BoardDto boardDto) {
		return 0;
	}

	@Override
	public int getMaxRegroup() {
		return 0;
	}

	@Override
	public List<BoardDto> getAllList(int start, int end) {
		List<BoardDto> boardList = null;

		HashMap<String, Object> pageMap = new HashMap<>();
		pageMap.put("start", start);
		pageMap.put("end", end);
//		pageMap.put("searchSelect", search_select);
//		pageMap.put("searchWord", search_word);

		SqlSession sqlSession = sqlSessionFactory.openSession();
		boardList = sqlSession.selectList("getAllList", pageMap);
		// 마이바티스에서는 매서드는 매개변수 1개만 넘길 수 있음...
		// Dto 를 새로 만들던지 map을 구성 해서 넘기면 활용가능

		sqlSession.close();
		return boardList;
	}

	@Override
	public List<BoardDto> getSearchAllList(String search_select, String search_word) {
		return null;
	}

	@Override
	public BoardDto getSelectOne(int no) {
		return null;
	}

	@Override
	public BoardDto getPrevSelect(int num) {
		return null;
	}

	@Override
	public BoardDto getNextSelect(int num) {
		return null;
	}

	@Override
	public int updateHit(int no) {
		return 0;
	}

	@Override
	public int getTotal() {
		return 0;
	}
}
