package Pr5;

// Проверяемое исключение для некорректного среднего балла
public class InvalidMarkException extends Exception {
  public InvalidMarkException(String message) {
    super(message);
  }
}
