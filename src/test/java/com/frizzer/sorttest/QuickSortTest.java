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

class QuickSortTest extends AbstractTest {

  @Test
  void testQuickSortBySize() {
    List<Ball> ballList = new ArrayList<>(ballTestSet);
    List<Ball> ballListSortedByJava = new ArrayList<>(ballTestSet);
    sortService.bySize().quickSort(ballList);
    ballListSortedByJava.sort(Comparator.comparing(Ball::getSize));
    assertThat(ballList.stream().map(Ball::getSize).toList(),
        is(ballListSortedByJava.stream().map(Ball::getSize).toList()));
  }

  @Test
  void testQuickSortByColor() {
    List<Ball> ballList = new ArrayList<>(ballTestSet);
    List<Ball> ballListSortedByJava = new ArrayList<>(ballTestSet);
    sortService.byColor().quickSort(ballList);
    ballListSortedByJava.sort(Comparator.comparing(Ball::getColor));
    assertThat(ballList.stream().map(Ball::getColor).toList(),
        is(ballListSortedByJava.stream().map(Ball::getColor).toList()));
  }

  @Test
  void testQuickSortByType() {
    List<Ball> ballList = new ArrayList<>(ballTestSet);
    List<Ball> ballListSortedByJava = new ArrayList<>(ballTestSet);
    sortService.byType().quickSort(ballList);
    ballListSortedByJava.sort(Comparator.comparing(Ball::getType));
    assertThat(ballList.stream().map(Ball::getType).toList(),
        is(ballListSortedByJava.stream().map(Ball::getType).toList()));
  }

  @Test
  void testQuickSortByOneElementSet() {
    List<Ball> ballList = new ArrayList<>(oneElementTestSet);
    List<Ball> ballListSortedByJava = new ArrayList<>(oneElementTestSet);
    sortService.byType().quickSort(ballList);
    ballListSortedByJava.sort(Comparator.comparing(Ball::getType));
    assertThat(ballList.stream().map(Ball::getType).toList(),
        is(ballListSortedByJava.stream().map(Ball::getType).toList()));
  }

  @Test
  void testQuickSortByEmptySet() {
    List<Ball> ballList = Collections.emptyList();
    sortService.quickSort(ballList);
    assertThat(ballList, is(Collections.emptyList()));
  }

  @Test
  void testQuickSortByNullInput(){
    assertThrows(IllegalArgumentException.class,() -> sortService.bySize().quickSort(null));
  }

}
