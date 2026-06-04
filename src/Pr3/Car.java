package Pr3;

import java.util.Objects;

class Car extends Vehicle {

  private String brand;
  private int doors;

  // Конструктор по умолчанию.
  public Car() {
    super();
    this.brand = "Не задано";
    this.doors = 4;
  }

  // Конструктор с параметрами.
  public Car(String name, int maxSpeed, String brand, int doors) {
    super(name, maxSpeed);
    setBrand(brand);
    setDoors(doors);
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    if (brand == null || brand.isBlank()) {
      this.brand = "Не задано";
    } else {
      this.brand = brand;
    }
  }

  public int getDoors() {
    return doors;
  }

  public void setDoors(int doors) {
    if (doors <= 0) {
      this.doors = 4;
    } else {
      this.doors = doors;
    }
  }

  // Сравнивает автомобили по полям.
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }

    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    Car car = (Car) object;
    return super.equals(object) && doors == car.doors && Objects.equals(brand, car.brand);
  }

  // Возвращает хеш-код автомобиля.
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), brand, doors);
  }

  // Возвращает строковое представление автомобиля.
  @Override
  public String toString() {
    return "Автомобиль: " + super.toString() + ", марка = " + brand + ", двери = " + doors;
  }
}
