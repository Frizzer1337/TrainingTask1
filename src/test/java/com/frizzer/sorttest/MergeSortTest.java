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


class MergeSortTest extends AbstractTest {

  @Test
  void testMergeSortBySize() {
    List<Ball> ballList = new ArrayList<>(ballTestSet);
    List<Ball> ballListSortedByJava = new ArrayList<>(ballTestSet);
    sortService.bySize().mergeSort(ballList);
    ballListSortedByJava.sort(Comparator.comparing(Ball::getSize));
    assertThat(ballList.stream().map(Ball::getSize).toList(),
        is(ballListSortedByJava.stream().map(Ball::getSize).toList()));
  }

  @Test
  void testMergeSortByColor() {
    List<Ball> ballList = new ArrayList<>(ballTestSet);
    List<Ball> ballListSortedByJava = new ArrayList<>(ballTestSet);
    sortService.byColor().mergeSort(ballList);
    ballListSortedByJava.sort(Comparator.comparing(Ball::getColor));
    assertThat(ballList.stream().map(Ball::getColor).toList(),
        is(ballListSortedByJava.stream().map(Ball::getColor).toList()));
  }

  @Test
  void testMergeSortByType() {
    List<Ball> ballList = new ArrayList<>(ballTestSet);
    List<Ball> ballListSortedByJava = new ArrayList<>(ballTestSet);
    sortService.byType().mergeSort(ballList);
    ballListSortedByJava.sort(Comparator.comparing(Ball::getType));
    assertThat(ballList.stream().map(Ball::getType).toList(),
        is(ballListSortedByJava.stream().map(Ball::getType).toList()));
  }

  @Test
  void testMergeSortByOneElementSet() {
    List<Ball> ballList = new ArrayList<>(oneElementTestSet);
    List<Ball> ballListSortedByJava = new ArrayList<>(oneElementTestSet);
    sortService.byType().mergeSort(ballList);
    ballListSortedByJava.sort(Comparator.comparing(Ball::getType));
    assertThat(ballList.stream().map(Ball::getType).toList(),
        is(ballListSortedByJava.stream().map(Ball::getType).toList()));
  }

  @Test
  void testMergeSortByEmptySet() {
    List<Ball> ballList = Collections.emptyList();
    sortService.mergeSort(ballList);
    assertThat(ballList, is(Collections.emptyList()));
  }

  @Test
  void testMergeSortByNullInput(){
    assertThrows(IllegalArgumentException.class,() -> sortService.bySize().mergeSort(null));
  }

}
