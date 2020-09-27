package com.biz.bow.service;

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
	
	// 점수 내보낼때
	public int getTotalScore() {
		return totalScore;
	}
	
	// 배열에 담긴 점수 더함
	public void calTotalScore(int[] shotScores) {
		totalScore += Arrays.stream(shotScores).sum();
	}
	
	// 현재 프레임에서 스트라이크나 스페어가 나왔을시에 다음 프레임에서 점수를 한번더 더함
	public void calScoreWithNextFrame(String state, FrameService frame, FrameService nextFrame, FrameService secondFrame) {
		
		// 스테이트가 스트라이크일경우
		if(state.equals("STRIKE")) {
			// 다음으로 올 프레임이 10일경우
			if(nextFrame.getFramenumber() == 10) {
				// 다음 프레임의 점수를 선언된 nextFrameScore에 담음
				int nextFrameScore = nextFrame.getScore()[0];
				nextFrameScore += nextFrame.getScore()[1];
				// 다음 프레임의 첫번째 던진 투를 담음 
				int[] nextFirstSocre = nextFrame.getScore();
				
				// 총 점수에 다음 프레임 점수를 더함
				totalScore += nextFrameScore;
				// 다음 프레임의 첫번째 구 점수를 담음
				totalScore += nextFirstSocre[FIRST_TURN_GET_SCORE];
				return;
			}else if(nextFrame.getState() == "STRIKE"){
				// 마지막프레임이 아닐 경우
				// 다음 프레임의 점수를 nextFrameScore에 담음
				int nextFrameScore = nextFrame.getTotalScore();
				// 첫번째 던진 점수를 다음 프레임 점수에 담음
				int[] nextFirstSocre = secondFrame.getScore();
				// 담은 총점수를 더함
				totalScore += nextFrameScore;
				//다음 프레임의 첫 구의 점수를 더함 
				totalScore += nextFirstSocre[FIRST_TURN_GET_SCORE];
				return;
			}else{
				// 마지막프레임이 아닐 경우
				// 다음 프레임의 점수를 nextFrameScore에 담음
				int nextFrameScore = nextFrame.getTotalScore();
				// 담은 총점수를 더함
				totalScore += nextFrameScore;
				return;
			}
		}
		
		// 스페어일 경우
		if(state.equals("SPAIRE")) {
			// 다음프레임점수를 선언된 배열에 담음
			int[] nextFrameScore = nextFrame.getScore();
			// 점수에 다음 프레임의 첫구의 점수를 더함
			totalScore += nextFrameScore[FIRST_TURN_GET_SCORE];
			return;
		}
	}
	
public void calNineScoreWithNextFrame(String state, FrameService nextFrame) {
		
		// 스테이트가 스트라이크일경우
		if(state.equals("STRIKE")) {
			// 다음으로 올 프레임이 10일경우
			if(nextFrame.getFramenumber() == 10) {
				// 다음 프레임의 점수를 선언된 nextFrameScore에 담음
				int nextFrameScore = nextFrame.getScore()[0];
				
				// 다음 프레임의 첫번째 던진 투를 담음 
				int[] nextFirstSocre = nextFrame.getScore();
				
				// 총 점수에 다음 프레임 점수를 더함
				totalScore += nextFrameScore;
				// 다음 프레임의 첫번째 구 점수를 담음
				totalScore += nextFirstSocre[FIRST_TURN_GET_SCORE];
				return;
			}else{
				// 마지막프레임이 아닐 경우
				// 다음 프레임의 점수를 nextFrameScore에 담음
				int nextFrameScore = nextFrame.getTotalScore();
				// 담은 총점수를 더함
				totalScore += nextFrameScore;
				return;
			}
		}
		
		// 스페어일 경우
		if(state.equals("SPAIRE")) {
			// 다음프레임점수를 선언된 배열에 담음
			int[] nextFrameScore = nextFrame.getScore();
			// 점수에 다음 프레임의 첫구의 점수를 더함
			totalScore += nextFrameScore[FIRST_TURN_GET_SCORE];
			return;
		}
	}
	
}
