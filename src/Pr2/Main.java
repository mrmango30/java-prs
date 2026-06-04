package Pr2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

//Главный класс программы
public class Main {

  //Логическая переменная отвечающая за состояние программы
  private static boolean isRunning = true;

  //Список студентов
  private static ArrayList<Student> students = new ArrayList<>();

  //Создание экземпляра класса Scanner
  private static Scanner scanner = new Scanner(System.in);

  //Главный метод класса
  public static void main(String[] args) {
    clickProcessing();
  }

  //Метод отображающий список возможных действий программы
  public static void showMenu() {
    System.out.println("1. Добавление пустого объекта к массиву");
    System.out.println("2. Добавление объекта с данными, заполненными пользователем");
    System.out.println("3. Редактирование любого поля любого объекта");
    System.out.println("4. Вывод информации обо всех объектах");
    System.out.println("5. Сортировка списка объектов по выбранному полю");
    System.out.println("6. Завершение работы программы");
  }

  //Метод обрабатывающий выбор действия программы
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
          exit();
          break;
        default:
          System.out.println("Введено некорректное значение");
      }
    }
  }

  //Метод добавляющий пустой объект
  public static void addEmptyStudent() {
    students.add(new Student());
    System.out.println("Пустой студент добавлен");
  }

  //Метод добавляющий объект с данными пользователя
  public static void addStudentWithData() {
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
    System.out.println("Студент добавлен");
  }

  //Метод редактирующий выбранное поле выбранного объекта
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
    }
  }

  //Метод выводящий всех студентов
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

  //Метод сортирующий студентов по выбранному полю
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

    System.out.println("Список отсортирован");
  }

  //Метод завершающий программу
  public static void exit() {
    isRunning = false;
  }

  //Метод считывающий целое число
  public static int readInt() {
    while (!scanner.hasNextInt()) {
      System.out.println("Введите целое число");
      scanner.nextLine();
    }

    int value = scanner.nextInt();
    scanner.nextLine();
    return value;
  }

  //Метод считывающий вещественное число
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


