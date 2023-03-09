package com.frizzer.sorttest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.frizzer.ballsort.entity.Ball;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Test;

class OddEvenSortTest extends AbstractTest {

  @Test
  void testOddEvenSortBySize() {
    List<Ball> ballList = new ArrayList<>(ballTestSet);
    List<Ball> ballListSortedByJava = new ArrayList<>(ballTestSet);
    sortService.bySize().oddEvenSort(ballList);
    ballListSortedByJava.sort(Comparator.comparing(Ball::getSize));
    assertThat(ballList.stream().map(Ball::getSize).toList(),
        is(ballListSortedByJava.stream().map(Ball::getSize).toList()));
  }

  @Test
  void testOddEvenSortByColor() {
    List<Ball> ballList = new ArrayList<>(ballTestSet);
    List<Ball> ballListSortedByJava = new ArrayList<>(ballTestSet);
    sortService.byColor().oddEvenSort(ballList);
    ballListSortedByJava.sort(Comparator.comparing(Ball::getColor));
    assertThat(ballList.stream().map(Ball::getColor).toList(),
        is(ballListSortedByJava.stream().map(Ball::getColor).toList()));
  }

  @Test
  void testOddEvenSortByType() {
    List<Ball> ballList = new ArrayList<>(ballTestSet);
    List<Ball> ballListSortedByJava = new ArrayList<>(ballTestSet);
    sortService.byType().oddEvenSort(ballList);
    ballListSortedByJava.sort(Comparator.comparing(Ball::getType));
    assertThat(ballList.stream().map(Ball::getType).toList(),
        is(ballListSortedByJava.stream().map(Ball::getType).toList()));
  }

  @Test
  void testOddEvenSortByOneElementSet() {
    List<Ball> ballList = new ArrayList<>(oneElementTestSet);
    List<Ball> ballListSortedByJava = new ArrayList<>(oneElementTestSet);
    sortService.byType().oddEvenSort(ballList);
    ballListSortedByJava.sort(Comparator.comparing(Ball::getType));
    assertThat(ballList.stream().map(Ball::getType).toList(),
        is(ballListSortedByJava.stream().map(Ball::getType).toList()));
  }

  @Test
  void testOddEvenSortByEmptySet() {
    List<Ball> ballList = Collections.emptyList();
    sortService.oddEvenSort(ballList);
    assertThat(ballList, is(Collections.emptyList()));
  }

  @Test
  void testOddEvenSortByNullInput(){
    assertThrows(IllegalArgumentException.class,() -> sortService.bySize().oddEvenSort(null));
  }
}
