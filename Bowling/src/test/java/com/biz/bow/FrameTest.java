package com.biz.bow;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.biz.bow.sevice.FinalFrameServiceImpl;

public class FrameTest {
	
	private FinalFrameServiceImpl nomalFrame;
	private FinalFrameServiceImpl finalFrame;
	
	// Test annotation보다 먼저 실행
	@Before
	public void setUp(){
		nomalFrame = new FinalFrameServiceImpl(0);
		finalFrame = new FinalFrameServiceImpl(9);
	}
	
	@Test
	public void 점수_계산_후_턴_확인() {
		nomalFrame.setScore(1);
//		nomalFrame.calScore(2);
		assertThat(nomalFrame.playerTurn(),is(false));
		
	}

	public void 마지막_프레임_턴_3번투구_가능() {
		finalFrame.setScore(0);
		finalFrame.setScore(0);
		
		assertThat(finalFrame.playerTurn(), is(true));

		// 마지막 투구 확인		
//		finalFrame.calScore(0);
		assertThat(finalFrame.playerTurn(),is(false));
	}
}
