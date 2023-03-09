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

class ParallelOddEvenSortTest extends AbstractTest {

  @Test
  void testParallelOddEvenSortBySize() {
    List<Ball> ballList = new ArrayList<>(ballTestSet);
    List<Ball> ballListSortedByJava = new ArrayList<>(ballTestSet);
    sortService.bySize().parallelOddEvenSort(ballList);
    ballListSortedByJava.sort(Comparator.comparing(Ball::getSize));
    assertThat(ballList.stream().map(Ball::getSize).toList(),
        is(ballListSortedByJava.stream().map(Ball::getSize).toList()));
  }

  @Test
  void testParallelOddEvenSortByColor() {
    List<Ball> ballList = new ArrayList<>(ballTestSet);
    List<Ball> ballListSortedByJava = new ArrayList<>(ballTestSet);
    sortService.byColor().parallelOddEvenSort(ballList);
    ballListSortedByJava.sort(Comparator.comparing(Ball::getColor));
    assertThat(ballList.stream().map(Ball::getColor).toList(),
        is(ballListSortedByJava.stream().map(Ball::getColor).toList()));
  }

  @Test
  void testParallelOddEvenSortByType() {
    List<Ball> ballList = new ArrayList<>(ballTestSet);
    List<Ball> ballListSortedByJava = new ArrayList<>(ballTestSet);
    sortService.byType().parallelOddEvenSort(ballList);
    ballListSortedByJava.sort(Comparator.comparing(Ball::getType));
    assertThat(ballList.stream().map(Ball::getType).toList(),
        is(ballListSortedByJava.stream().map(Ball::getType).toList()));
  }

  @Test
  void testParallelOddEvenSortByOneElementSet() {
    List<Ball> ballList = new ArrayList<>(oneElementTestSet);
    List<Ball> ballListSortedByJava = new ArrayList<>(oneElementTestSet);
    sortService.byType().parallelOddEvenSort(ballList);
    ballListSortedByJava.sort(Comparator.comparing(Ball::getType));
    assertThat(ballList.stream().map(Ball::getType).toList(),
        is(ballListSortedByJava.stream().map(Ball::getType).toList()));
  }

  @Test
  void testParallelOddEvenSortByEmptySet() {
    List<Ball> ballList = Collections.emptyList();
    sortService.parallelOddEvenSort(ballList);
    assertThat(ballList, is(Collections.emptyList()));
  }
  @Test
  void testParallelOddEvenSortByNullInput(){
    assertThrows(IllegalArgumentException.class,() -> sortService.bySize().parallelOddEvenSort(null));
  }
}
