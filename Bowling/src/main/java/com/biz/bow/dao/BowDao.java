package com.biz.bow.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.biz.bow.domain.PlayerVO;
import com.biz.bow.domain.RankVO;

@Repository
public interface BowDao{
	
	public List<PlayerVO> selectAll();
	
	public PlayerVO findPlayerName(String name);
	
	public int insert(PlayerVO playerVO);
	
	public List<RankVO> selectRnk();
}
