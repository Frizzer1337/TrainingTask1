package com.frizzer.ballsort.entity;

public class Color implements Comparable<Color> {

  private String name;
  private String tone;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTone() {
    return tone;
  }

  public void setTone(String tone) {
    this.tone = tone;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Color color = (Color) o;

    if (!name.equals(color.name)) {
      return false;
    }
    return tone.equals(color.tone);
  }

  @Override
  public int hashCode() {
    int result = name.hashCode();
    result = 31 * result + tone.hashCode();
    return result;
  }


  @Override
  public int compareTo(Color o) {
    return name.compareTo(o.name) == 0 ? 0 : tone.compareTo(o.tone);
  }

  @Override
  public String toString() {
    return "Color{" +
        "name='" + name + '\'' +
        ", tone='" + tone + '\'' +
        '}';
  }

}
