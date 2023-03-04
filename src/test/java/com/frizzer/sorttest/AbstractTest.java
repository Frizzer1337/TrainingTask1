package com.frizzer.sorttest;

import com.frizzer.ballsort.entity.Ball;
import com.frizzer.ballsort.entity.BallType;
import com.frizzer.ballsort.entity.BasketballBall;
import com.frizzer.ballsort.entity.Color;
import com.frizzer.ballsort.service.SortService;
import java.util.List;

public abstract class AbstractTest {

  static final SortService sortService = new SortService();
  final List<Ball> ballsTestSet = List.of(
      new BasketballBall[]{
          new BasketballBall(12, new Color("red", "deep"), BallType.BASKETBALL)
          , new BasketballBall(11, new Color("red", "light"), BallType.BASKETBALL)
          , new BasketballBall(10, new Color("red", "deep"), BallType.FOOTBALL)
          , new BasketballBall(13, new Color("blue", "light"), BallType.FOOTBALL)
          , new BasketballBall(12, new Color("blue", "deep"), BallType.TENNIS)
          , new BasketballBall(14, new Color("blue", "light"), BallType.TENNIS)
          , new BasketballBall(12, new Color("green", "deep"), BallType.BASKETBALL)
          , new BasketballBall(15, new Color("green", "light"), BallType.BASKETBALL)
          , new BasketballBall(10, new Color("green", "deep"), BallType.VOLLEYBALL)
          , new BasketballBall(11, new Color("black", "light"), BallType.VOLLEYBALL)
          , new BasketballBall(13, new Color("black", "deep"), BallType.FOOTBALL)
          , new BasketballBall(11, new Color("black", "light"), BallType.TENNIS)}
  );

}
