package com.biz.bow;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;

import com.biz.bow.sevice.ScoreService;

public class ScoreTest {
	
	private ScoreService nmlFrmScore;
	private ScoreService fnlFrmScore;

	@Before
	public void setUp() {
		fnlFrmScore = new ScoreService(3);
		nmlFrmScore = new ScoreService(2);
	}
	
	/*
	 * NoSuchFieldException 지정된 필드가 없을때
	 * IllegalAccessException 배열이외의 인스턴스 작성 필드의 설정 메서드 호출 시도시
	 */
	@Test
	public void 마지막_프레임_점수_저장() 
			throws NoSuchFieldException, IllegalAccessException{
		fnlFrmScore.setScore(4, 3);
		fnlFrmScore.setScore(5, 2);
		fnlFrmScore.setScore(6, 1);

		Field fstShot = fnlFrmScore.getClass().getDeclaredField("fstShot");
		Field sndShot = fnlFrmScore.getClass().getDeclaredField("sndShot");
		Field fnlShot = fnlFrmScore.getClass().getDeclaredField("finalShot");
		
		fstShot.setAccessible(true);
		sndShot.setAccessible(true);
		fnlShot.setAccessible(true);
		
		int resultFst = (int) fstShot.get(fnlFrmScore);
		int resultSnd = (int) sndShot.get(fnlFrmScore);
		int resultFnl = (int) fnlShot.get(fnlFrmScore);
		
		assertThat(resultFst, is(4));
		assertThat(resultSnd, is(5));
		assertThat(resultFnl, is(6));
	}
	
	@Test
	public void 마지막_프레임_스트라이크_스페어_획득_실패시() {
		fnlFrmScore.setScore(4, 3);
		fnlFrmScore.setScore(5, 2);
		
		assertThat(fnlFrmScore.hasFinalTurn(), is(false));
	}
	
	@Test
	public void 마지막_프레임_스트라이크() {
		fnlFrmScore.setScore(10, 3);
		
		// 턴 2개가 남았음
		assertThat(fnlFrmScore.hasFinalTurn(), is(true));
	}
	
	@Test
	public void 마지막_프레임_스페어() {
		
		// 첫번째 턴에서 스페어 또는 스트라이크 아니면 3번 던질 기회가 없음
		fnlFrmScore.setScore(8, 3);
		assertThat(fnlFrmScore.hasFinalTurn(), is(false));
		
		// 스페어 처리를 해서 3번째 투구가 가능함
		fnlFrmScore.setScore(2, 2);
		assertThat(fnlFrmScore.hasFinalTurn(), is(true));
	}
	
	@Test
	public void 노말_프레임_점수_저장_확인()
			throws NoSuchFieldException, IllegalAccessException{
		nmlFrmScore.setScore(5, 2);
		nmlFrmScore.setScore(6, 1);
		
		Field fstShot = nmlFrmScore.getClass().getDeclaredField("fstShot");
		Field sndShot = nmlFrmScore.getClass().getDeclaredField("sndShot");
		
		fstShot.setAccessible(true);
		sndShot.setAccessible(true);
		
		int resultFst = (int) fstShot.get(nmlFrmScore);
		int resultSnd = (int) sndShot.get(nmlFrmScore);
		
		assertThat(resultFst, is(5));
		assertThat(resultSnd, is(6));
	}
	

}









