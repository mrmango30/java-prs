package Pr5;

// Проверяемое исключение для некорректных данных студента
public class InvalidStudentDataException extends Exception {
  public InvalidStudentDataException(String message) {
    super(message);
  }
}
