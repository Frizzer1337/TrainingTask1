package com.frizzer.ballsort;


import com.frizzer.ballsort.entity.Ball;
import com.frizzer.ballsort.entity.BasketballBall;
import com.frizzer.ballsort.entity.Color;
import com.frizzer.ballsort.entity.FootballBall;
import com.frizzer.ballsort.service.SortService;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    System.out.println("Сюда даже смотреть не будут");
    SortService sortService = new SortService();
    Ball basketBall = new BasketballBall(12,new Color("red","deep"));
    Ball basketBall1 = new BasketballBall(15,new Color("green","deer"));
    Ball basketBall2 = new FootballBall(10,new Color("red","dek"));
    List<Ball> balls= new ArrayList<>();
    balls.add(basketBall);
    balls.add(basketBall1);
    balls.add(basketBall2);

    balls.forEach(System.out::println);
    sortService.byType().oddEvenSort(balls);
    System.out.println(balls);

  }
}