package Pr6;

import java.util.Scanner;

/** Главный класс демонстрационной программы. */
public class Main {

  /** Создает объект главного класса. */
  private Main() {}

  private static boolean isRunning = true;
  private static CircularList<String> stringList = new CircularList<>();
  private static CircularList<Integer> integerList = new CircularList<>();
  private static boolean isStringList = true;
  private static Scanner scanner = new Scanner(System.in);

  /**
   * Запускает программу.
   *
   * @param args аргументы командной строки
   */
  public static void main(String[] args) {
    clickProcessing();
  }

  /** Отображает список возможных действий программы. */
  public static void showMenu() {
    System.out.println("1. Выбрать коллекцию String");
    System.out.println("2. Выбрать коллекцию Integer");
    System.out.println("3. Проверить список пуст/не пуст");
    System.out.println("4. Установить указатель в начало списка");
    System.out.println("5. Добавить элемент за указателем");
    System.out.println("6. Удалить элемент за указателем");
    System.out.println("7. Просмотреть элемент за указателем");
    System.out.println("8. Переместить указатель вправо");
    System.out.println("9. Обменять значения конца списка и элемента за указателем");
    System.out.println("10. Обменять значения начала списка и элемента за указателем");
    System.out.println("11. Вывод списка на экран");
    System.out.println("12. Завершение работы программы");
  }

  /** Обрабатывает выбор действия программы. */
  public static void clickProcessing() {
    while (isRunning) {
      System.out.println("Выбранная коллекция: " + (isStringList ? "String" : "Integer"));
      showMenu();
      int inputInt = readInt();

      switch (inputInt) {
        case 1:
          isStringList = true;
          break;
        case 2:
          isStringList = false;
          break;
        case 3:
          checkList();
          break;
        case 4:
          setPointerToStart();
          break;
        case 5:
          addAfterPointer();
          break;
        case 6:
          removeAfterPointer();
          break;
        case 7:
          showPointerValue();
          break;
        case 8:
          movePointerRight();
          break;
        case 9:
          swapTailAndPointer();
          break;
        case 10:
          swapHeadAndPointer();
          break;
        case 11:
          showList();
          break;
        case 12:
          exit();
          break;
        default:
          System.out.println("Введено некорректное значение");
      }
    }
  }

  /** Проверяет пустой выбранный список или нет. */
  public static void checkList() {
    if (getCurrentList().isEmpty()) {
      System.out.println("Список пуст");
    } else {
      System.out.println("Список не пуст");
    }
  }

  /** Устанавливает указатель в начало выбранного списка. */
  public static void setPointerToStart() {
    getCurrentList().setPointerToStart();
    System.out.println("Указатель установлен в начало списка");
  }

  /** Добавляет элемент за указателем в выбранный список. */
  public static void addAfterPointer() {
    if (isStringList) {
      System.out.println("Введите строку");
      stringList.addAfterPointer(scanner.nextLine());
    } else {
      System.out.println("Введите целое число");
      integerList.addAfterPointer(readInt());
    }

    System.out.println("Элемент добавлен");
  }

  /** Удаляет элемент за указателем из выбранного списка. */
  public static void removeAfterPointer() {
    Object value = getCurrentList().removeAfterPointer();

    if (value == null) {
      System.out.println("Удаление невозможно");
    } else {
      System.out.println("Удален элемент: " + value);
    }
  }

  /** Выводит элемент за указателем выбранного списка. */
  public static void showPointerValue() {
    Object value = getCurrentList().getPointerValue();

    if (value == null) {
      System.out.println("Элемента нет");
    } else {
      System.out.println("Элемент за указателем: " + value);
    }
  }

  /** Перемещает указатель выбранного списка вправо. */
  public static void movePointerRight() {
    getCurrentList().movePointerRight();
    System.out.println("Указатель перемещен вправо");
  }

  /** Меняет местами конец списка и элемент за указателем. */
  public static void swapTailAndPointer() {
    getCurrentList().swapTailAndPointer();
    System.out.println("Обмен выполнен");
  }

  /** Меняет местами начало списка и элемент за указателем. */
  public static void swapHeadAndPointer() {
    getCurrentList().swapHeadAndPointer();
    System.out.println("Обмен выполнен");
  }

  /** Выводит выбранный список. */
  public static void showList() {
    System.out.println(getCurrentList());
  }

  /**
   * Возвращает текущую выбранную коллекцию.
   *
   * @return выбранная коллекция
   */
  public static CircularList<?> getCurrentList() {
    if (isStringList) {
      return stringList;
    }

    return integerList;
  }

  /** Завершает работу программы. */
  public static void exit() {
    isRunning = false;
  }

  /**
   * Считывает целое число.
   *
   * @return введенное целое число
   */
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
