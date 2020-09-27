package com.biz.bow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.bow.dao.BowDao;
import com.biz.bow.domain.PlayerVO;
import com.biz.bow.domain.RankVO;

@Service
public class RecordService {
	
	@Autowired
	private BowDao bDao;
	
	
	public List<PlayerVO> selectAll(){
		return bDao.selectAll();
	}
	
	public PlayerVO findByPlayerName(String playerName) {
		PlayerVO playerVO = bDao.findPlayerName(playerName);
		return playerVO;
	}
	
	public int insert(PlayerVO playerVO) {
		int ret = bDao.insert(playerVO);
		return ret;	
	}
	
	public List<RankVO> selectRnk(){
		return bDao.selectRnk();
	}
}
