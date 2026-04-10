package Pr1;

import java.util.Random;
import java.util.Scanner;

//Объявление класса
public class Main {

  //Инициализация логической переменной отвечающей за состояние программы
  private static Boolean isRunning = true;

  //Инициализация главной матрицы
  private static int[][] mainMatrix;
  //Инициализация матрицы для результата
  private static int[][] resultMatrix;

  //Создание экземпляров класса Scanner
  private static Scanner scanner = new Scanner(System.in);
  //Создание экземпляров класса Random
  private static Random random = new Random();

  //Главный метод класса
  public static void main(String[] args) {
    сlickProcessing();
  }

  //Метод отображащий списко возможных действий программы
  public static void showMenu() {
    System.out.println(
        "1. Ввод исходных данных, как вручную, так и сгенерированных случайным образом");
    System.out.println("2. Выполнение алгоритма по заданию");
    System.out.println("3. Вывод результата");
    System.out.println("4. Завершение работы программы");
  }

  //Метод обрабатывающий выбор действия программы
  public static void сlickProcessing() {
    //Бесконечный цикл проверяющий выбор действия
    while (isRunning) {
      showMenu();

      //Получение значения с клавиатуры
      int inputInt = scanner.nextInt();

      //Определения действия
      switch (inputInt) {
        case 1:
          inputMatrix();
          break;
        case 2:
          runApp();
          break;
        case 3:
          showResult();
          break;
        case 4:
          exit();
          break;
      }
    }
  }

  //Метод обрабатыващий выбор заполнения матрицы
  public static void inputMatrix() {
    System.out.println("1. Ручное заполение матрицы");
    System.out.println("2. Автоматическая генерация матрицы");
    //Получение данных от пользователя
    int inputInt = scanner.nextInt();

    if (inputInt == 1) {
      manualEntryMatrix();
    } else if (inputInt == 2) {
      generateMatrix();
    } else {
      inputMatrix();
    }
  }

  //Метод запускающий главный программный код
  public static void runApp() {
    if (mainMatrix == null) {
      System.out.println("Исходные данные не заданы!");
      return;
    }

    matrixProcessing();
    System.out.println("Обработка матрицы выполненна!");
  }

  //Метод отображащий матрицу (результат выполения программы)
  public static void showResult() {
    if (resultMatrix == null) {
      System.out.println("Результата нет");
      return;
    }

    showMantrix(resultMatrix);
  }

  //Метод для выхода из программы
  public static void exit() {
    isRunning = false;
  }

  //Метод обрабатывающий матрицу, вычисляет сумму и добавляет столбец
  public static void matrixProcessing() {
    int[] rowSums = new int[mainMatrix.length];

    //Цикл заполняющий массив сумм строк
    for (int i = 0; i < mainMatrix.length; i++) {
      int sum = 0;
      //Цикл вычисляющий сумму каждой строки
      for (int j = 0; j < mainMatrix[0].length; j++) {
        sum += Math.abs(mainMatrix[i][j]);
      }

      rowSums[i] = sum;
    }

    addColumnToMatrix(rowSums);
  }

  //Метод добавляющий столбец с суммой строк
  public static void addColumnToMatrix(int[] addedColumn) {
    resultMatrix = new int[mainMatrix.length][mainMatrix[0].length + 1];

    //Цикл заполняющий матрицу с результатом одинаковыми значениями и добавленим столбца с суммой
    for (int i = 0; i < resultMatrix.length; i++) {
      for (int j = 0; j < resultMatrix[0].length - 1; j++) {
        resultMatrix[i][j] = mainMatrix[i][j];
      }
      //Добавления столбца с суммой строк
      resultMatrix[i][resultMatrix[0].length - 1] = addedColumn[i];
    }

    sortMatrix();
  }

  //Метод производящий сортировку матрицы по убыванию
  public static void sortMatrix() {
    for (int i = 0; i < resultMatrix.length - 1; i++) {
      for (int j = 0; j < resultMatrix.length - i - 1; j++) {
        //Получение индекса суммы текущей строки
        int lastIndexCurrent = resultMatrix[j].length - 1;
        //Получение индекса суммы следующей строки
        int lastIndexNext = resultMatrix[j + 1].length - 1;

        //Условие при выполнение которого строки меняются местами
        if (resultMatrix[j + 1][lastIndexNext] > resultMatrix[j][lastIndexCurrent]) {
          int[] tempRow = resultMatrix[j];
          resultMatrix[j] = resultMatrix[j + 1];
          resultMatrix[j + 1] = tempRow;
        }
      }
    }
  }

  //Метод генерирующий матрицы автоматически
  public static void generateMatrix() {
    System.out.println("Генерация матрицы...");

    //Создание случайных размеров матрицы
    int countRows = random.nextInt(2, 10);
    int countColumns = random.nextInt(2, 10);

    //Создание новой матрицы
    mainMatrix = new int[countRows][countColumns];

    randomizeValueMantrix();
    showMantrix(mainMatrix);
  }

  //Метод создающий матрицу в ручную
  public static void manualEntryMatrix() {
    System.out.println("Введите кол-во строк");
    //Получение данных от пользователя
    int countRows = scanner.nextInt();

    if(countRows <= 1){
      System.out.println("Введенно некорректное значение");
      manualEntryMatrix();
      return;
    }

    System.out.println("Введите кол-во столбцов");
    //Получение данных от пользователя
    int countColumns = scanner.nextInt();

    if(countColumns <= 1){
      System.out.println("Введенно некорректное значение");
      manualEntryMatrix();
      return;
    }

    mainMatrix = new int[countRows][countColumns];

    //Заполнение матрицы ручным способом
    for (int i = 0; i < mainMatrix.length; i++) {
      for (int j = 0; j < mainMatrix[0].length; j++) {
        System.out.println("Введите значения для ячейки: [" + i + ", " + j + "]");
        mainMatrix[i][j] = scanner.nextInt();
      }
    }

    showMantrix(mainMatrix);
  }

  //Метод заполняющий матрицу случайными значениями
  public static void randomizeValueMantrix() {
    for (int i = 0; i < mainMatrix.length; i++) {
      for (int j = 0; j < mainMatrix[0].length; j++) {
        mainMatrix[i][j] = random.nextInt(-10, 10);
      }
    }
  }

  //Метод отображащий матрицу
  public static void showMantrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }

      System.out.println();
    }
  }
}