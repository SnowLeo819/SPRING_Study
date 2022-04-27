package com.TISpjh.model;

import java.util.List;

public interface BoardService {
	
	public int insertBoard(BoardDto boardDto);
	public int getMaxRegroup() ;
	public List<BoardDto> getAllList(int start, int end);
	public List<BoardDto> getSearchAllList(String search_select, String search_word) ;
	public BoardDto getSelectOne(int no) ;
	public BoardDto getPrevSelect(int num) ;
	public BoardDto getNextSelect(int num) ;
	public int updateHit(int no) ;
	public int getTotal() ;
}
