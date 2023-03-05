package com.frizzer.sorttest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.frizzer.ballsort.entity.Ball;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Test;

class OddEvenSortTest extends AbstractTest {

  @Test
  void testOddEvenSortBySize() {
    List<Ball> balls = new ArrayList<>(ballsTestSet);
    List<Ball> ballsSortedByJava = new ArrayList<>(ballsTestSet);
    sortService.bySize().oddEvenSort(balls);
    ballsSortedByJava.sort(Comparator.comparing(Ball::getSize));
    assertThat(balls.stream().map(Ball::getSize).toList(),
        is(ballsSortedByJava.stream().map(Ball::getSize).toList()));
  }

  @Test
  void testOddEvenSortByColor() {
    List<Ball> balls = new ArrayList<>(ballsTestSet);
    List<Ball> ballsSortedByJava = new ArrayList<>(ballsTestSet);
    sortService.byColor().oddEvenSort(balls);
    ballsSortedByJava.sort(Comparator.comparing(Ball::getColor));
    assertThat(balls.stream().map(Ball::getColor).toList(),
        is(ballsSortedByJava.stream().map(Ball::getColor).toList()));
  }

  @Test
  void testOddEvenSortByType() {
    List<Ball> balls = new ArrayList<>(ballsTestSet);
    List<Ball> ballsSortedByJava = new ArrayList<>(ballsTestSet);
    sortService.byType().oddEvenSort(balls);
    ballsSortedByJava.sort(Comparator.comparing(Ball::getType));
    assertThat(balls.stream().map(Ball::getType).toList(),
        is(ballsSortedByJava.stream().map(Ball::getType).toList()));
  }

}
