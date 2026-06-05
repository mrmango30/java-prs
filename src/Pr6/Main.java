package Pr6;

import java.util.Scanner;

//Главный класс программы
public class Main {

  //Логическая переменная отвечающая за состояние программы
  private static boolean isRunning = true;

  //Коллекция строковых значений
  private static CircularList<String> stringList = new CircularList<>();

  //Коллекция целых чисел
  private static CircularList<Integer> integerList = new CircularList<>();

  //Признак выбранной строковой коллекции
  private static boolean isStringList = true;

  //Создание экземпляра класса Scanner
  private static Scanner scanner = new Scanner(System.in);

  //Главный метод класса
  public static void main(String[] args) {
    clickProcessing();
  }

  //Метод отображающий список возможных действий программы
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

  //Метод обрабатывающий выбор действия программы
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

  //Метод проверяющий пустой список или нет
  public static void checkList() {
    if (getCurrentList().isEmpty()) {
      System.out.println("Список пуст");
    } else {
      System.out.println("Список не пуст");
    }
  }

  //Метод устанавливающий указатель в начало списка
  public static void setPointerToStart() {
    getCurrentList().setPointerToStart();
    System.out.println("Указатель установлен в начало списка");
  }

  //Метод добавляющий элемент за указателем
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

  //Метод удаляющий элемент за указателем
  public static void removeAfterPointer() {
    Object value = getCurrentList().removeAfterPointer();

    if (value == null) {
      System.out.println("Удаление невозможно");
    } else {
      System.out.println("Удален элемент: " + value);
    }
  }

  //Метод выводящий элемент за указателем
  public static void showPointerValue() {
    Object value = getCurrentList().getPointerValue();

    if (value == null) {
      System.out.println("Элемента нет");
    } else {
      System.out.println("Элемент за указателем: " + value);
    }
  }

  //Метод перемещающий указатель вправо
  public static void movePointerRight() {
    getCurrentList().movePointerRight();
    System.out.println("Указатель перемещен вправо");
  }

  //Метод меняющий местами конец списка и элемент за указателем
  public static void swapTailAndPointer() {
    getCurrentList().swapTailAndPointer();
    System.out.println("Обмен выполнен");
  }

  //Метод меняющий местами начало списка и элемент за указателем
  public static void swapHeadAndPointer() {
    getCurrentList().swapHeadAndPointer();
    System.out.println("Обмен выполнен");
  }

  //Метод выводящий список
  public static void showList() {
    System.out.println(getCurrentList());
  }

  //Метод возвращающий текущую коллекцию
  public static CircularList<?> getCurrentList() {
    if (isStringList) {
      return stringList;
    }

    return integerList;
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
}

