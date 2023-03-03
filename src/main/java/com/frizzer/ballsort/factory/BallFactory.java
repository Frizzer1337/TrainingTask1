package com.frizzer.ballsort.factory;

import com.frizzer.ballsort.entity.Ball;
import com.frizzer.ballsort.entity.BasketballBall;
import com.frizzer.ballsort.entity.FootballBall;
import com.frizzer.ballsort.entity.TennisBall;
import com.frizzer.ballsort.entity.VolleyballBall;

public class BallFactory {

  public Ball createBall(String ballType) {
    if (ballType == null || ballType.isEmpty()) {
      return null;
    }
    return switch (ballType) {
      case "BASKETBALL" -> new BasketballBall();
      case "FOOTBALL" -> new FootballBall();
      case "TENNIS" -> new TennisBall();
      case "VOLLEYBALL" -> new VolleyballBall();
      default ->
          throw new IllegalArgumentException("This ball type cannot be produced at our factory");
    };
  }

}
