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

	// 턴 횟수
	@Override
	public boolean playerTurn() {
		return turn > 0; 
	}
	
	@Override
	public void playBow(int pinCnt) {
		setScore(pinCnt);
		setTurn();
	}
	
	private void setScore(int pinCnt) {
		score.setScore(pinCnt, turn);
	}	
	
	private void setTurn() {
		if(turn == SECOND_TURN && !score.hasFinalTurn()) {
			turn -=2;
		}
		turn --;
	}


}
