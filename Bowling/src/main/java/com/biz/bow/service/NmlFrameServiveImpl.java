package com.biz.bow.service;

public class NmlFrameServiveImpl implements FrameService {

	private static final int NOMAL_FRAME = 2;
	private static final int TOTAL_PIN = 10;

	private int turn;
	private ScoreService score;
	private int frameNum;

	// 1~9까지 한 프레임당 2번의 턴을 가짐
	public NmlFrameServiveImpl(int frameNum) {
		this.frameNum = frameNum;
		turn = NOMAL_FRAME;
		score = new ScoreService(turn);
	}
	
	// 보통의 프레임의 점수를 내보낼 메서드
	@Override
	public int[] getScore() {
		return score.getShotScore();
	}

	
	// 총점을 내보낼 메서드
	@Override
	public int getTotalScore() {
		return score.getTotalScore();
	}

	// 몇번째 프레임인가를 내보낼 메서드
	@Override
	public int getFramenumber() {
		return frameNum;
	}

	// 스트라이크인가 스페어인가를 내보낼 메서드
	@Override
	public String getState() {
		return score.getState();
	}

	
	// 플레이어 차례
	@Override
	public boolean playerTurn() {
		return turn > 0;
	}

	// 한 프레임의 점수와 턴을 담는 메서드
	@Override
	public void playBow(int pinCnt) {
		setScore(pinCnt);
		setTurn(pinCnt);

	}

	// 한턴에 점수를 담음
	public void setScore(int pinCnt) {
		score.setScore(pinCnt, turn);
	}
	
	// 턴
	private void setTurn(int pinCnt) {
		score.calState();
		// 핀 카운트가 10이 되면 투구를 없앰
		if (pinCnt == TOTAL_PIN) {
			turn -= 2;
			return;
		}
		// 그렇지 않으면 턴 한 회씩 소모
		turn--;
	}




}
