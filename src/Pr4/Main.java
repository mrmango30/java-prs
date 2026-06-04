package Pr4;

import java.util.Scanner;

// Главный класс программы
public class Main {

  // Логическая переменная отвечающая за состояние программы
  private static boolean isRunning = true;

  // Исходная строка
  private static String mainString = "";

  // Создание экземпляра класса Scanner
  private static Scanner scanner = new Scanner(System.in);

  // Главный метод класса
  public static void main(String[] args) {
    clickProcessing();
  }

  // Метод отображающий список возможных действий программы
  public static void showMenu() {
    System.out.println("1. Ввод строки");
    System.out.println("2. Подсчет строчных символов");
    System.out.println("3. Подсчет заглавных символов");
    System.out.println("4. Вывод результата через лямбда-выражение");
    System.out.println("5. Завершение работы программы");
  }

  // Метод обрабатывающий выбор действия программы
  public static void clickProcessing() {
    while (isRunning) {
      showMenu();
      int inputInt = readInt();

      switch (inputInt) {
        case 1:
          inputString();
          break;
        case 2:
          runLowercaseAnalyser();
          break;
        case 3:
          runUppercaseAnalyser();
          break;
        case 4:
          runLambdaAnalyser();
          break;
        case 5:
          exit();
          break;
        default:
          System.out.println("Введено некорректное значение");
      }
    }
  }

  // Метод считывающий строку
  public static void inputString() {
    System.out.println("Введите строку из символов латинского алфавита");
    String value = scanner.nextLine();

    if (!isLatinString(value)) {
      System.out.println("Строка должна содержать только латинские буквы");
      return;
    }

    mainString = value;
    System.out.println("Строка сохранена");
  }

  // Метод запускающий анализ строчных символов
  public static void runLowercaseAnalyser() {
    if (mainString.isEmpty()) {
      System.out.println("Строка не задана");
      return;
    }

    StringAnalyser analyser = new LowercaseAnalyser();
    System.out.println("Количество строчных символов: " + analyser.analyse(mainString));
  }

  // Метод запускающий анализ заглавных символов
  public static void runUppercaseAnalyser() {
    if (mainString.isEmpty()) {
      System.out.println("Строка не задана");
      return;
    }

    StringAnalyser analyser = new UppercaseAnalyser();
    System.out.println("Количество заглавных символов: " + analyser.analyse(mainString));
  }

  // Метод демонстрирующий лямбда-выражение
  public static void runLambdaAnalyser() {
    if (mainString.isEmpty()) {
      System.out.println("Строка не задана");
      return;
    }

    StringAnalyser analyser =
        str -> {
          int count = 0;

          for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
              count++;
            }
          }

          return count;
        };

    System.out.println("Количество букв в строке: " + analyser.analyse(mainString));
  }

  // Метод проверяющий строку на латинские символы
  public static boolean isLatinString(String value) {
    if (value == null || value.isEmpty()) {
      return false;
    }

    for (int i = 0; i < value.length(); i++) {
      char symbol = value.charAt(i);

      if (!((symbol >= 'A' && symbol <= 'Z') || (symbol >= 'a' && symbol <= 'z'))) {
        return false;
      }
    }

    return true;
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
