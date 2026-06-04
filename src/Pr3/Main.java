package Pr3;

import java.util.ArrayList;
import java.util.Scanner;

// Главный класс программы
public class Main {

  // Логическая переменная отвечающая за состояние программы
  private static boolean isRunning = true;

  // Коллекция транспортных средств
  private static ArrayList<Vehicle> vehicles = new ArrayList<>();

  // Создание экземпляра класса Scanner
  private static Scanner scanner = new Scanner(System.in);

  // Главный метод класса
  public static void main(String[] args) {
    clickProcessing();
  }

  // Метод отображающий список возможных действий программы
  public static void showMenu() {
    System.out.println("1. Добавить новый элемент");
    System.out.println("2. Удалить элемент по индексу");
    System.out.println("3. Вывод всех элементов в консоль");
    System.out.println("4. Сравнение двух элементов на равенство");
    System.out.println("5. Завершение работы приложения");
  }

  // Метод обрабатывающий выбор действия программы
  public static void clickProcessing() {
    while (isRunning) {
      showMenu();
      int inputInt = readInt();

      switch (inputInt) {
        case 1:
          addVehicle();
          break;
        case 2:
          removeVehicle();
          break;
        case 3:
          showVehicles();
          break;
        case 4:
          compareVehicles();
          break;
        case 5:
          exit();
          break;
        default:
          System.out.println("Введено некорректное значение");
      }
    }
  }

  // Метод добавляющий новый объект производного класса
  public static void addVehicle() {
    System.out.println("1. Транспортное средство");
    System.out.println("2. Автомобиль");
    System.out.println("3. Поезд");
    System.out.println("4. Экспресс");
    int type = readInt();

    System.out.println("Введите название");
    String name = scanner.nextLine();

    System.out.println("Введите максимальную скорость");
    int maxSpeed = readInt();

    if (type == 1) {
      vehicles.add(new Vehicle(name, maxSpeed));
    } else if (type == 2) {
      System.out.println("Введите марку автомобиля");
      String brand = scanner.nextLine();
      System.out.println("Введите количество дверей");
      int doors = readInt();
      vehicles.add(new Car(name, maxSpeed, brand, doors));
    } else if (type == 3) {
      System.out.println("Введите маршрут поезда");
      String route = scanner.nextLine();
      System.out.println("Введите количество вагонов");
      int wagonCount = readInt();
      vehicles.add(new Train(name, maxSpeed, route, wagonCount));
    } else if (type == 4) {
      System.out.println("Введите маршрут экспресса");
      String route = scanner.nextLine();
      System.out.println("Введите количество вагонов");
      int wagonCount = readInt();
      System.out.println("Введите класс обслуживания");
      String serviceClass = scanner.nextLine();
      vehicles.add(new Express(name, maxSpeed, route, wagonCount, serviceClass));
    } else {
      System.out.println("Введено некорректное значение");
      return;
    }

    System.out.println("Элемент добавлен");
  }

  // Метод удаляющий объект по индексу
  public static void removeVehicle() {
    if (vehicles.isEmpty()) {
      System.out.println("Коллекция пуста");
      return;
    }

    showVehicles();
    System.out.println("Введите индекс");
    int index = readInt();

    if (index < 0 || index >= vehicles.size()) {
      System.out.println("Элемент с таким индексом не найден");
      return;
    }

    vehicles.remove(index);
    System.out.println("Элемент удален");
  }

  // Метод выводящий все элементы коллекции
  public static void showVehicles() {
    if (vehicles.isEmpty()) {
      System.out.println("Коллекция пуста");
      return;
    }

    for (int i = 0; i < vehicles.size(); i++) {
      System.out.println("Индекс: " + i);
      System.out.println(vehicles.get(i));
    }
  }

  // Метод сравнивающий два объекта
  public static void compareVehicles() {
    if (vehicles.size() < 2) {
      System.out.println("Для сравнения нужно добавить минимум два элемента");
      return;
    }

    showVehicles();
    System.out.println("Введите индекс первого элемента");
    int firstIndex = readInt();
    System.out.println("Введите индекс второго элемента");
    int secondIndex = readInt();

    if (firstIndex < 0
        || firstIndex >= vehicles.size()
        || secondIndex < 0
        || secondIndex >= vehicles.size()) {
      System.out.println("Введен некорректный индекс");
      return;
    }

    if (vehicles.get(firstIndex).equals(vehicles.get(secondIndex))) {
      System.out.println("Элементы равны");
    } else {
      System.out.println("Элементы не равны");
    }
  }

  // Метод завершающий программу
  public static void exit() {
    isRunning = false;
  }

  // Метод считывающий целое число
  public static int readInt() {
    while (!scanner.hasNextInt()) {
      System.out.println("Введите целое число");
      scanner.nextLine();
    }

    int value = scanner.nextInt();
    scanner.nextLine();
    return value;
  }
}
