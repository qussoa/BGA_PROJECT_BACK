package com.biz.bow.sevice;

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
	
	@Override
	public int[] getScore() {
		return score.getShotScore();
	}

	
	@Override
	public int getTotalScore() {
		return score.getTotalScore();
	}

	@Override
	public int getFramenumber() {
		return frameNum;
	}

	@Override
	public String getState() {
		return score.getState();
	}

	
	// 플레이어 차례
	@Override
	public boolean playerTurn() {
		return turn > 0;
	}

	@Override
	public void playBow(int pinCnt) {
		setScore(pinCnt);
		setTurn(pinCnt);

	}

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
