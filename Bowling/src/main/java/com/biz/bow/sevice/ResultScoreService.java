package com.biz.bow.sevice;

import java.util.Arrays;

public class ResultScoreService {
	
	// 결과 점수
	
	// 첫번째 턴 값 초기화
	private static final int FIRST_TURN_GET_SCORE = 0;
	
	// 총점수
	private int totalScore;
	
	// 총 점수 초기화
	public ResultScoreService() {
		totalScore = 0;
	}
	
	public int getTotalScore() {
		return totalScore;
	}
	
	// 배열에 담긴 점수 더함
	public void calTotalScore(int[] shotScores) {
		totalScore += Arrays.stream(shotScores).sum();
	}
	
	public void calScoreWithNextFrame(String state, FrameService nextFrame) {
		if(state.equals("STRIKE")) {
			int nextFrameScore = nextFrame.getTotalScore();
			totalScore += nextFrameScore;
			return;
		}
		
		if(state.equals("SPAIRE")) {
			int[] nextFrameScore = nextFrame.getScore();
			totalScore += nextFrameScore[FIRST_TURN_GET_SCORE];
			return;
		}
	}
	
}
