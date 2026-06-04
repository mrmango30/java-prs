package Pr5;

// Исключение демонстрирующее цепочку исключений
public class StudentCreateException extends Exception {
  public StudentCreateException(String message, Throwable cause) {
    super(message, cause);
  }
}
