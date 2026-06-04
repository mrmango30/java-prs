package Pr3;

import java.util.Objects;

class Vehicle {

  private String name;
  private int maxSpeed;

  // Конструктор по умолчанию.
  public Vehicle() {
    this.name = "Не задано";
    this.maxSpeed = 1;
  }

  // Конструктор с параметрами.
  public Vehicle(String name, int maxSpeed) {
    setName(name);
    setMaxSpeed(maxSpeed);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if (name == null || name.isBlank()) {
      this.name = "Не задано";
    } else {
      this.name = name;
    }
  }

  public int getMaxSpeed() {
    return maxSpeed;
  }

  public void setMaxSpeed(int maxSpeed) {
    if (maxSpeed <= 0) {
      this.maxSpeed = 1;
    } else {
      this.maxSpeed = maxSpeed;
    }
  }

  // Сравнивает транспортные средства по полям.
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }

    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    Vehicle vehicle = (Vehicle) object;
    return maxSpeed == vehicle.maxSpeed && Objects.equals(name, vehicle.name);
  }

  // Возвращает хеш-код транспортного средства.
  @Override
  public int hashCode() {
    return Objects.hash(name, maxSpeed);
  }

  // Возвращает строковое представление транспортного средства.
  @Override
  public String toString() {
    return "Транспортное средство: название = " + name + ", максимальная скорость = " + maxSpeed;
  }
}
