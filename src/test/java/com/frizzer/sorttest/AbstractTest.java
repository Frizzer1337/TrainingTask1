package com.frizzer.sorttest;

import com.frizzer.ballsort.entity.Ball;
import com.frizzer.ballsort.entity.BasketballBall;
import com.frizzer.ballsort.entity.Color;
import com.frizzer.ballsort.service.SortService;
import java.util.List;

public abstract class AbstractTest {

  static final SortService sortService = new SortService();
  final List<Ball> ballsTestSet = List.of(
      new BasketballBall[]{
          new BasketballBall(12, new Color("red", "deep"))
          , new BasketballBall(11, new Color("red", "light"))
          , new BasketballBall(10, new Color("red", "deep"))
          , new BasketballBall(13, new Color("blue", "light"))
          , new BasketballBall(12, new Color("blue", "deep"))
          , new BasketballBall(14, new Color("blue", "light"))
          , new BasketballBall(12, new Color("green", "deep"))
          , new BasketballBall(15, new Color("green", "light"))
          , new BasketballBall(10, new Color("green", "deep"))
          , new BasketballBall(11, new Color("black", "light"))
          , new BasketballBall(13, new Color("black", "deep"))
          , new BasketballBall(11, new Color("black", "light"))}
  );

}
