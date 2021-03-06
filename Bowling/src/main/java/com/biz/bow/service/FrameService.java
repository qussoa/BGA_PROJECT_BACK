package com.biz.bow.service;

public interface FrameService {
	
	/*  1. 점수계산, 플레이어의 차례, 볼링 핀의 상태 체크
	 *  2. frame = 10회 투구수 = 2회
	 *  3. 프레임과 투구 끝 프레임의 점수에 따라 추가 점수 획득
	 *  4. 마지막 프레임 투구수 = 3회
	 *  
	 *  점수 계산
	 *  1. 첫번째 투구, 두번째 투구에 대한 점수
	 *  2. firstShot, secondShot 변수를 추가하고 생성자 초기화
	 *  3. 해당 프레임에서 획득한 점수가 Strike인지 SPAIRE인지 확인
	 *  
	 */
	
	// 턴인가 아닌가
	boolean playerTurn();
	
	// 핀 갯수
	void playBow(int pinCnt);
	
	int[] getScore();
	
	int getTotalScore();
	
	int getFramenumber();
	
	String getState();
}
