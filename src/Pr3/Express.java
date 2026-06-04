package Pr3;

import java.util.Objects;

class Express extends Train {

  private String serviceClass;

  // Конструктор по умолчанию.
  public Express() {
    super();
    this.serviceClass = "Обычный";
  }

  // Конструктор с параметрами.
  public Express(String name, int maxSpeed, String route, int wagonCount, String serviceClass) {
    super(name, maxSpeed, route, wagonCount);
    setServiceClass(serviceClass);
  }

  public String getServiceClass() {
    return serviceClass;
  }

  public void setServiceClass(String serviceClass) {
    if (serviceClass == null || serviceClass.isBlank()) {
      this.serviceClass = "Обычный";
    } else {
      this.serviceClass = serviceClass;
    }
  }

  // Сравнивает экспрессы по полям.
  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }

    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    Express express = (Express) object;
    return super.equals(object) && Objects.equals(serviceClass, express.serviceClass);
  }

  // Возвращает хеш-код экспресса.
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), serviceClass);
  }

  // Возвращает строковое представление экспресса.
  @Override
  public String toString() {
    return "Экспресс: " + super.toString() + ", класс обслуживания = " + serviceClass;
  }
}
