package com.biz.bow.service;

import java.util.List;

import com.biz.bow.dao.BowDao;
import com.biz.bow.domain.PlayerVO;

public class PlayerService {
	
	// 플레이어의 정보를 설정해주는 클래스
	
	private String name;

	
	// player 이름 주기
	public  PlayerService(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	
	public String getName() {
		PlayerVO playerVO = new PlayerVO();
		
		return name;
	}


}
