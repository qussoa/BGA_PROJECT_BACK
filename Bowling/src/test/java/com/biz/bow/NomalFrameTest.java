package com.biz.bow;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.biz.bow.sevice.FrameService;
import com.biz.bow.sevice.NmlFrameServiveImpl;

public class NomalFrameTest {
	
	private FrameService nmlFrame;
	
	@Before
	public void setUp() {
		nmlFrame = new NmlFrameServiveImpl();
	}
	

	@Test
	public void 점수계산후_턴이_감소() {
		// 한번 투구
		nmlFrame.playBow(0);
		// 두번 투구
		nmlFrame.playBow(0);
		assertThat(nmlFrame.playerTurn(), is(false));
	}
	
	@Test
	public void 스트라이크시_턴이_감소() {
		// 한번 투구시 스트라이크이면 턴 종료
		nmlFrame.playBow(10); 
		assertThat(nmlFrame.playerTurn(), is(false));
	}
}
