package com.biz.bow.sevice;

import java.util.Arrays;

// 점수 계산
public class ScoreService {

	private static final int FIRST_SHOT = 0;
	private static final int SECOND_SHOT = 1;
	private static final int FINAL_SHOT = 2;

	private static final int NOMAL_FRAME = 2;
	private static final int FINAL_FRAME = 3;
	// 1~9번째 프레임 첫 투구
	private static final int NOML_FRAME_FST_TURN = 2;

	// 마지막 프레임의 첫 투구
	private static final int FINAL_FRAME_FST_TURN = 3;
	// 마지막 프레임의 두번째 투구
	private static final int FINAL_FRAME_SND_TURN = 2;

	private int[] shotScores;
	private String state;

	public ScoreService(int frameState) {

		// 마지막 프레임일때 점수를 배열로 저장
		if (frameState == FINAL_FRAME) {
			shotScores = new int[FINAL_FRAME];
		}

		shotScores = new int[NOMAL_FRAME];
		state = "NOMAL";
	}

	public String getState() {
		return state;
	}

	public int[] getShotScore() {
		return shotScores;
	}

	public void setScore(int pinCnt, int turn) {
		if (shotScores.length == FINAL_FRAME) {
			fnlFrameSetScore(pinCnt, turn);
			return;
		}
		nmlFrameSetScore(pinCnt, turn);
	}

	// 점수 총점
	public int getTotalScore() {
		// 1.8버전 컬렉션의 요소를 하나씩 참조해서 람다식으로 처리할 수 있는 반복자
		return Arrays.stream(shotScores).sum();
	}

	// 마지막 프레임의 턴이 10보다 크면 한번더 투구수를 줌
	public boolean hasFinalTurn() {
		return shotScores[FIRST_SHOT] + shotScores[SECOND_SHOT] >= 10;
	}

	// 마지막 프레임 점수
	private void fnlFrameSetScore(int pinCnt, int turn) {
		switch (turn) {
		case FINAL_FRAME_FST_TURN:
			shotScores[FIRST_SHOT] = pinCnt;
			break;
		case FINAL_FRAME_SND_TURN:
			shotScores[SECOND_SHOT] = pinCnt;
			break;
		default:
			shotScores[FINAL_SHOT] = pinCnt;
			break;
		}
	}

	// 1~9까지 프레임 점수
	private void nmlFrameSetScore(int pinCnt, int turn) {
		switch (turn) {
		case NOML_FRAME_FST_TURN:
			shotScores[FIRST_SHOT] = pinCnt;
			break;
		default:
			shotScores[SECOND_SHOT] = pinCnt;
			break;
		}
	}

	public void calState() {
		if (shotScores[FIRST_SHOT] == 10) {
			state = "STRIKE";
			return;
		}

		if (shotScores[FIRST_SHOT] + shotScores[SECOND_SHOT] == 10) {
			state = "SPAIRE";
			return;
		}
	}

}