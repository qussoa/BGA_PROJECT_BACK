package com.biz.bow.service;

import java.util.Arrays;

// 점수 계산
public class ScoreService {

	// 한 프레임의 턴에서 첫구 두번째 구 세번째 구
	private static final int FIRST_SHOT = 0;
	private static final int SECOND_SHOT = 1;
	private static final int FINAL_SHOT = 2;

	// 보통의 프레임 1~9까지의 프레임은 2번의 턴만 가짐
	private static final int NOMAL_FRAME = 2;

	// 마지막 프레임에서 스트라이크나 스페어 처리가 되면 3번을 가짐
	private static final int FINAL_FRAME = 3;
	// 1~9번째 프레임 첫 투구
	private static final int NOML_FRAME_FST_TURN = 2;

	// 마지막 프레임의 첫 투구
	private static final int FINAL_FRAME_FST_TURN = 3;
	// 마지막 프레임의 두번째 투구
	private static final int FINAL_FRAME_SND_TURN = 2;

	// 던진 점수들을 배열로 저장
	private int[] shotScores;

	// 상태 스트라이크인가 스페어인가 거터인가를 담는 변수
	private String state;

	public ScoreService(int frameState) {

		// 마지막 프레임일때 점수를 배열로 저장
		if (frameState == FINAL_FRAME) {
			shotScores = new int[FINAL_FRAME];
			state = "FINAL";
		}else {
			shotScores = new int[NOMAL_FRAME];
			state = "NOMAL";	
		}
		
	}

	// 상태를 다른 클래스에서 사용할때 씀
	public String getState() {
		return state;
	}

	// 점수들을 내보낼때 사용
	public int[] getShotScore() {
		return shotScores;
	}

	// 점수들을 세팅해주는 메서드
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
		// 마지막 프레임의 첫턴을 담음
		case FINAL_FRAME_FST_TURN:
			shotScores[FIRST_SHOT] = pinCnt;
			break;
		// 두번째 턴을 담음
		case FINAL_FRAME_SND_TURN:
			shotScores[SECOND_SHOT] = pinCnt;
			break;
		default:
			// 만약 첫번째나 두번째에서 스트라이크나 스페어가 처리 되었을 시에 한 턴을 더 부여
			shotScores[FINAL_SHOT] = pinCnt;
			break;
		}
	}

	// 1~9까지 프레임 점수
	private void nmlFrameSetScore(int pinCnt, int turn) {
		switch (turn) {
		// 1~9까지의 첫번째 턴을 담음
		case NOML_FRAME_FST_TURN:
			shotScores[FIRST_SHOT] = pinCnt;
			break;
		default:
			// 첫번째 투구가 아닌 두번째 턴의 점수를 담음
			shotScores[SECOND_SHOT] = pinCnt;
			break;
		}
	}

	// 상태를 정해줌 첫번째에 다 넣으면 스트라이크
	// 두턴을 더해서 10이면 스페어
	public void calState() {
		// 첫번째 샷에서 10이 나오면 상태를 스트라이크 state 값에 담음
		if (shotScores[FIRST_SHOT] == 10) {
			// 상태 설정 스트라이크
			state = "STRIKE";
			return;
		}
		// 두번째 투구에서 첫번째 샷과 두번째 샷이 합산하여 10일 경우 스페어를 state 값에 담음
		if (shotScores[FIRST_SHOT] + shotScores[SECOND_SHOT] == 10) {
			// 상태 설정 스페어
			state = "SPAIRE";
			return;
		}
	}

}
