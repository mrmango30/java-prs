package Pr5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

// Главный класс программы
public class Main {

  // Логическая переменная отвечающая за состояние программы
  private static boolean isRunning = true;

  // Список студентов
  private static ArrayList<Student> students = new ArrayList<>();

  // Создание экземпляра класса Scanner
  private static Scanner scanner = new Scanner(System.in);

  // Создание логгера
  private static Logger logger = Logger.getLogger(Main.class.getName());

  static {
    try {
      FileHandler handler = new FileHandler("pr5.log", true);
      handler.setFormatter(new SimpleFormatter());
      logger.addHandler(handler);
    } catch (IOException exception) {
      System.out.println("Логирование в файл недоступно");
    }
  }

  // Главный метод класса
  public static void main(String[] args) {
    clickProcessing();
  }

  // Метод отображающий список возможных действий программы
  public static void showMenu() {
    System.out.println("1. Добавление пустого объекта к массиву");
    System.out.println("2. Добавление объекта с данными, заполненными пользователем");
    System.out.println("3. Редактирование любого поля любого объекта");
    System.out.println("4. Вывод информации обо всех объектах");
    System.out.println("5. Сортировка списка объектов по выбранному полю");
    System.out.println("6. Демонстрация исключений, утверждений и логирования");
    System.out.println("7. Завершение работы программы");
  }

  // Метод обрабатывающий выбор действия программы
  public static void clickProcessing() {
    while (isRunning) {
      showMenu();
      int inputInt = readInt();

      switch (inputInt) {
        case 1:
          addEmptyStudent();
          break;
        case 2:
          addStudentWithData();
          break;
        case 3:
          editStudent();
          break;
        case 4:
          showStudents();
          break;
        case 5:
          sortStudents();
          break;
        case 6:
          demonstrateSpecialTasks();
          break;
        case 7:
          exit();
          break;
        default:
          System.out.println("Введено некорректное значение");
      }
    }
  }

  // Метод добавляющий пустой объект
  public static void addEmptyStudent() {
    students.add(new Student());
    logger.info("Добавлен пустой студент");
    System.out.println("Пустой студент добавлен");
  }

  // Метод добавляющий объект с данными пользователя
  public static void addStudentWithData() {
    try {
      System.out.println("Введите фамилию");
      String lastName = scanner.nextLine();

      System.out.println("Введите имя");
      String firstName = scanner.nextLine();

      System.out.println("Введите возраст");
      int age = readInt();

      System.out.println("Введите курс");
      int course = readInt();

      System.out.println("Введите средний балл");
      double averageMark = readDouble();

      Student student = new Student(lastName, firstName, age, course, averageMark);
      students.add(student);
      logger.info("Добавлен студент: " + student);
      System.out.println("Студент добавлен");
    } catch (InvalidStudentDataException | InvalidMarkException exception) {
      logger.log(Level.WARNING, "Ошибка добавления студента", exception);
      System.out.println(exception.getMessage());
    }
  }

  // Метод редактирующий выбранное поле выбранного объекта
  public static void editStudent() {
    if (students.isEmpty()) {
      System.out.println("Список студентов пуст");
      return;
    }

    showStudents();
    System.out.println("Введите индекс студента");
    int index = readInt();

    if (index < 0 || index >= students.size()) {
      System.out.println("Студент с таким индексом не найден");
      return;
    }

    Student student = students.get(index);

    System.out.println("1. Фамилия");
    System.out.println("2. Имя");
    System.out.println("3. Возраст");
    System.out.println("4. Курс");
    System.out.println("5. Средний балл");
    int field = readInt();

    try {
      switch (field) {
        case 1:
          System.out.println("Введите фамилию");
          student.setLastName(scanner.nextLine());
          break;
        case 2:
          System.out.println("Введите имя");
          student.setFirstName(scanner.nextLine());
          break;
        case 3:
          System.out.println("Введите возраст");
          student.setAge(readInt());
          break;
        case 4:
          System.out.println("Введите курс");
          student.setCourse(readInt());
          break;
        case 5:
          System.out.println("Введите средний балл");
          student.setAverageMark(readDouble());
          break;
        default:
          System.out.println("Введено некорректное значение");
          return;
      }

      logger.info("Студент изменен: " + student);
    } catch (InvalidStudentDataException | InvalidMarkException exception) {
      logger.log(Level.WARNING, "Ошибка редактирования студента", exception);
      System.out.println(exception.getMessage());
    }
  }

  // Метод выводящий всех студентов
  public static void showStudents() {
    if (students.isEmpty()) {
      System.out.println("Список студентов пуст");
      return;
    }

    for (int i = 0; i < students.size(); i++) {
      System.out.println("Индекс: " + i);
      System.out.println(students.get(i));
      System.out.println("Результат функции: " + students.get(i).getScholarshipResult());
    }
  }

  // Метод сортирующий студентов по выбранному полю
  public static void sortStudents() {
    if (students.isEmpty()) {
      System.out.println("Список студентов пуст");
      return;
    }

    System.out.println("1. Фамилия");
    System.out.println("2. Имя");
    System.out.println("3. Возраст");
    System.out.println("4. Курс");
    System.out.println("5. Средний балл");
    int field = readInt();

    switch (field) {
      case 1:
        students.sort(Comparator.comparing(Student::getLastName));
        break;
      case 2:
        students.sort(Comparator.comparing(Student::getFirstName));
        break;
      case 3:
        students.sort(Comparator.comparingInt(Student::getAge));
        break;
      case 4:
        students.sort(Comparator.comparingInt(Student::getCourse));
        break;
      case 5:
        students.sort(Comparator.comparingDouble(Student::getAverageMark));
        break;
      default:
        System.out.println("Введено некорректное значение");
        return;
    }

    logger.info("Список студентов отсортирован");
    System.out.println("Список отсортирован");
  }

  // Метод демонстрирующий специальные задания практической работы
  public static void demonstrateSpecialTasks() {
    demonstrateRepeatedException();
    demonstrateChainedException();
    demonstrateSuppressedException();

    assert students.size() >= 0 : "Размер списка не может быть отрицательным";
    logger.info("Демонстрация утверждения и логирования выполнена");
    System.out.println("Демонстрация выполнена");
  }

  // Метод демонстрирующий повторную генерацию исключения
  public static void demonstrateRepeatedException() {
    try {
      createStudentForDemo("", "Иван", 20, 2, 4.0);
    } catch (InvalidStudentDataException | InvalidMarkException exception) {
      logger.log(Level.WARNING, "Повторно сгенерировано исключение", exception);
      System.out.println(
          "Перехвачено повторно сгенерированное исключение: " + exception.getMessage());
    }
  }

  // Метод демонстрирующий связывание исключений в цепочку
  public static void demonstrateChainedException() {
    try {
      try {
        createStudentForDemo("Иванов", "Иван", 20, 2, 7.0);
      } catch (InvalidMarkException exception) {
        throw new StudentCreateException("Не удалось создать студента", exception);
      }
    } catch (StudentCreateException exception) {
      logger.log(Level.WARNING, "Исключение связано в цепочку", exception);
      System.out.println("Перехвачено исключение с причиной: " + exception.getCause().getMessage());
    } catch (InvalidStudentDataException exception) {
      logger.log(Level.WARNING, "Ошибка данных студента", exception);
      System.out.println(exception.getMessage());
    }
  }

  // Метод демонстрирующий подавление исключения
  public static void demonstrateSuppressedException() {
    // Блок catch специально оставлен пустым, чтобы исключение было подавлено
    try {
      createStudentForDemo("Петров", "Петр", 20, 2, -1);
    } catch (InvalidStudentDataException | InvalidMarkException exception) {
    }

    logger.info("Продемонстрировано подавление исключения пустым блоком catch");
    System.out.println("Исключение было подавлено пустым блоком catch");
  }

  // Метод создающий студента для демонстрации исключений
  public static Student createStudentForDemo(
      String lastName, String firstName, int age, int course, double averageMark)
      throws InvalidStudentDataException, InvalidMarkException {
    try {
      return new Student(lastName, firstName, age, course, averageMark);
    } catch (InvalidStudentDataException | InvalidMarkException exception) {
      throw exception;
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

  // Метод считывающий вещественное число
  public static double readDouble() {
    while (!scanner.hasNextDouble()) {
      System.out.println("Введите число");
      scanner.nextLine();
    }

    double value = scanner.nextDouble();
    scanner.nextLine();
    return value;
  }
}
