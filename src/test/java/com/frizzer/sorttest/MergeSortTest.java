package com.frizzer.sorttest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.frizzer.ballsort.entity.Ball;
import com.frizzer.ballsort.entity.BallType;
import com.frizzer.ballsort.entity.BasketballBall;
import com.frizzer.ballsort.entity.Color;
import com.frizzer.ballsort.service.SortService;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Test;


class MergeSortTest {

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


  @Test
  void testMergeSortBySize() {
    List<Ball> balls = new ArrayList<>(ballsTestSet);
    List<Ball> ballsSortedByJava = new ArrayList<>(ballsTestSet);
    sortService.bySize().mergeSort(balls);
    ballsSortedByJava.sort(Comparator.comparing(Ball::getSize));
    assertThat(balls.stream().map(Ball::getSize).toList(),
        is(ballsSortedByJava.stream().map(Ball::getSize).toList()));
  }

  @Test
  void testMergeSortByColor() {
    List<Ball> balls = new ArrayList<>(ballsTestSet);
    List<Ball> ballsSortedByJava = new ArrayList<>(ballsTestSet);
    sortService.byColor().mergeSort(balls);
    ballsSortedByJava.sort(Comparator.comparing(Ball::getColor));
    assertThat(balls.stream().map(Ball::getColor).toList(),
        is(ballsSortedByJava.stream().map(Ball::getColor).toList()));
  }

  @Test
  void testMergeSortByType() {
    List<Ball> balls = new ArrayList<>(ballsTestSet);
    List<Ball> ballsSortedByJava = new ArrayList<>(ballsTestSet);
    sortService.byType().mergeSort(balls);
    ballsSortedByJava.sort(Comparator.comparing(Ball::getType));
    assertThat(balls.stream().map(Ball::getType).toList(),
        is(ballsSortedByJava.stream().map(Ball::getType).toList()));
  }


}
