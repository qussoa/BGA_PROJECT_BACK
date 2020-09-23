package com.biz.bow.sevice;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import com.biz.bow.domain.FrameVO;


public class GameService {
	// game 흐름 파악
	

	private static final int FINAL_FRAME = 10;
	
	private PlayerService player;
	private List<FrameService> frames;
	private ViewService view;
	
	
	public GameService(PlayerService player) {
		this.player = player;
		view = new ViewService();
		frames = new ArrayList<FrameService>();
		setFrames();
	}
	
	public void startGame(List<Object> inputScore) {
//		for(FrameService frame : frames) {
//			playGame(frame);
//		}
		
		for (int i = 0; i < frames.size(); i++) {
			List<Integer> turnScore = (List<Integer>) inputScore.get(i);
			setPlayGameScore(frames.get(i),turnScore);
		}
		
		view.showBowGame(frames, player);
	}
	
	private void playGame(FrameService frame) {
		PinsService pin = new PinsService();
		while(frame.playerTurn()) {
			int pinCnt = pin.rollingBall();
			frame.playBow(pinCnt);
		}
		pin.resetPin();
	}
	
	private void setPlayGameScore(FrameService frame, List<Integer> inputScore) {
		int index = 0;
		while(frame.playerTurn()) {
			int pinCnt = inputScore.get(index);
			frame.playBow(pinCnt);
			index++;
		}
	}
	
	private void setFrames() {
		for(int i = 1; i<=FINAL_FRAME; i++) {
			if(i == FINAL_FRAME) {
				frames.add(new FinalFrameServiceImpl(i));
				return;
			}
			frames.add(new NmlFrameServiveImpl(i));
		}
	}
}
