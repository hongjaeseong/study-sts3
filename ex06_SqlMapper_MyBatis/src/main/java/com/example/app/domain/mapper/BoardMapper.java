package com.example.app.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.app.domain.dto.BoardDto;

public interface BoardMapper {
	
	// BoardMapper.xml
	public int Insert(BoardDto boardDto);
	public int Update(BoardDto boardDto);
	public int Delete(long id);
	public BoardDto SelectOne(long id);
	public List<BoardDto> SelectAll();
}
