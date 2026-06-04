package Pr3;

import java.util.Objects;

class Train extends Vehicle {

  private String route;
  private int wagonCount;

  // Конструктор по умолчанию.
  public Train() {
    super();
    this.route = "Не задано";
    this.wagonCount = 1;
  }

  // Конструктор с параметрами.
  public Train(String name, int maxSpeed, String route, int wagonCount) {
    super(name, maxSpeed);
    setRoute(route);
    setWagonCount(wagonCount);
  }

  public String getRoute() {
    return route;
  }

  public void setRoute(String route) {
    if (route == null || route.isBlank()) {
      this.route = "Не задано";
    } else {
      this.route = route;
    }
  }

  public int getWagonCount() {
    return wagonCount;
  }

  public void setWagonCount(int wagonCount) {
    if (wagonCount <= 0) {
      this.wagonCount = 1;
    } else {
      this.wagonCount = wagonCount;
    }
  }

  // Сравнивает поезда по полям.
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }

    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    Train train = (Train) object;
    return super.equals(object)
        && wagonCount == train.wagonCount
        && Objects.equals(route, train.route);
  }

  // Возвращает хеш-код поезда.
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), route, wagonCount);
  }

  // Возвращает строковое представление поезда.
  @Override
  public String toString() {
    return "Поезд: " + super.toString() + ", маршрут = " + route + ", вагоны = " + wagonCount;
  }
}
