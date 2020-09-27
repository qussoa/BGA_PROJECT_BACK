package com.biz.bow.sevice;

import java.util.ArrayList;
import java.util.List;

import com.biz.bow.domain.FrameVO;
import com.biz.bow.domain.PlayerVO;

public class ViewService {

	// 웹으로 보여주는 곳

	// 콘솔창으로 확인할때
	public static final String STRIKE = "X";
	public static final String SPAIRE = " / ";
	public static final String GUTTER = " - ";

	private static final int FINAL_FRAME = 10;

	private String round;
	private String score;
	private String totalScore;
	private ResultScoreService resultScore;
	private PlayerVO playerVO;

	public ViewService() {
		round = "";
		score = "";
		totalScore = "";
		resultScore = new ResultScoreService();
		playerVO = new PlayerVO();
	}

	public PlayerVO showBowGame(List<FrameService> frames, PlayerService player) {
		playerVO.setFrameList(new ArrayList<FrameVO>());
		playerVO.setName(player.getName());
		for (int i = 0; i < frames.size(); i++) {
			FrameVO frameVO = new FrameVO();
			FrameService frame = frames.get(i);

			setRound(frame.getFramenumber());
			playerVO.getFrameList().add(frameVO);

			resultScore.calTotalScore(frame.getScore());

			if (frame.getState() != "NOMAL") {
				if(i != 9) {
					resultScore.calScoreWithNextFrame(frame.getState(), frames.get(i + 1));
				}
			}
			setScore(frame.getScore(), frame.getState());
			
			frameVO.setTurnScore(frame.getScore());
			frameVO.setState(frame.getState());
			frameVO.setFrameScore(resultScore.getTotalScore());

			setTotalScore(resultScore.getTotalScore());
		}

		System.out.println("Player : " + player.getName());
		System.out.println(round);
		System.out.println(score);
		System.out.println(totalScore);

		return playerVO;
	}

	// 콘솔에서 스트라이크일때 x 스페어일때 / 거터일때- 표시 해주는 부분
	private void setScore(int[] scores, String state) {
		for (int i = 0; i < scores.length; i++) {
			String convertScore = String.valueOf(scores[i]);

			if (scores[i] == 0) {
				convertScore = GUTTER;
			}
			if (state.equals("STRIKE") && i == 0) {
				convertScore = STRIKE;
			}

			if (state.equals("SPAIRE") && i == scores.length - 1) {
				convertScore = SPAIRE;
			}

			score += convertScore + "\t";
		}
		score += "||\t";
	}

	private void setTotalScore(int totalScore) {
		this.totalScore += totalScore + "\t\t||      ";
	}

	private void setRound(int frameNum) {
		String thisRound = frameNum + " FRAME\t\t|| ";

		round += thisRound;
		round.trim();
	}

}