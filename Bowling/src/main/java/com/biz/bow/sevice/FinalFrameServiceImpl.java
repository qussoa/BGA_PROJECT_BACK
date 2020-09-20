package com.biz.bow.sevice;

public class FinalFrameServiceImpl implements FrameService {

	private static final int FINAL_FRAME = 3;
	private static final int SECOND_TURN = 2;


	private int turn;
	private ScoreService score;
	private int frameNum;
	
	// 초기화
	public FinalFrameServiceImpl(int frameNum) {
		this.frameNum = frameNum;
		turn = FINAL_FRAME;
		score = new ScoreService(turn);
	}
	
	// 한 프레임 점수
	@Override
	public int[] getScore() {
		return score.getShotScore();
	}

	// 총점
	@Override
	public int getTotalScore() {
		return score.getTotalScore();
	}

	// 몇번째 프레임
	@Override
	public int getFramenumber() {
		return frameNum;
	}

	// 한프레임의 상태
	@Override
	public String getState() {
		return score.getState();
	}

	// 턴 횟수
	@Override
	public boolean playerTurn() {
		return turn > 0; 
	}
	
	// 한프레임의 점수와 턴 
	@Override
	public void playBow(int pinCnt) {
		setScore(pinCnt);
		setTurn();
	}
	
	// 점수설정
	private void setScore(int pinCnt) {
		score.setScore(pinCnt, turn);
	}	
	
	// 턴 설정
	private void setTurn() {
		if(turn == SECOND_TURN && !score.hasFinalTurn()) {
			turn -=2;
		}
		turn --;
	}


}
