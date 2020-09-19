package com.biz.bow;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.biz.bow.sevice.FinalFrameServiceImpl;
import com.biz.bow.sevice.FrameService;

public class FinalFrameTest {
	
	private FrameService finalFrame;

	@Before
	public void setUp() {
		finalFrame = new FinalFrameServiceImpl();
	}
	
	@Test
	public void 마지막_프레임_스트라이크_획득_3개_턴() {
		finalFrame.playBow(10);
		assertThat(finalFrame.playerTurn(), is(true));
		
		finalFrame.playBow(2);
		assertThat(finalFrame.playerTurn(), is(true));
		
		// 마지막 턴은 없다
		finalFrame.playBow(2);
		assertThat(finalFrame.playerTurn(), is(true));
	}
	
	@Test
	public void 마지막_프레임_스트라이크_스페어_못했을시_턴_2개() {
		finalFrame.playBow(2);
		assertThat(finalFrame.playerTurn(), is(true));
		
		// 스페어 처리 했을시 턴이 true가 되어야한다 
		finalFrame.playBow(8);
		assertThat(finalFrame.playerTurn(), is(false));
	}

}
