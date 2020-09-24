package com.biz.bow.sevice;

public class PinsService {
	
	// 랜덤으로 핀을 설정해주는 클래스 
	
	// 한 프레임에 볼링핀은 10개
	private static final int MAX_BOW_PIN = 10;
	
	private int bowPins;
	
	public PinsService() {
		resetPin();	
	}

	// 플레이어가 공을 던지는 메시지 수신
	public int rollingBall() {	
		int rndNum = (int)(Math.random() * bowPins) +1;
		hitBowPin(rndNum);
		return rndNum;
	}
	
	// 다음 판 프레임 초기화 세팅
	public void resetPin() {
		this.bowPins = MAX_BOW_PIN;
	}
	
	// 친 볼링 갯수 
	public void hitBowPin(int hitBowPinCnt) {
		this.bowPins -= hitBowPinCnt;
	}
}

