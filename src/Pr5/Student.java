package Pr5;

// Класс описывающий студента
class Student {

  private String lastName;
  private String firstName;
  private int age;
  private int course;
  private double averageMark;

  // Конструктор по умолчанию
  public Student() {
    this.lastName = "Не задано";
    this.firstName = "Не задано";
    this.age = 18;
    this.course = 1;
    this.averageMark = 3.0;
  }

  // Конструктор с параметрами
  public Student(String lastName, String firstName, int age, int course, double averageMark)
      throws InvalidStudentDataException, InvalidMarkException {
    setLastName(lastName);
    setFirstName(firstName);
    setAge(age);
    setCourse(course);
    setAverageMark(averageMark);
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) throws InvalidStudentDataException {
    if (lastName == null || lastName.isBlank()) {
      throw new InvalidStudentDataException("Фамилия не может быть пустой");
    }

    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) throws InvalidStudentDataException {
    if (firstName == null || firstName.isBlank()) {
      throw new InvalidStudentDataException("Имя не может быть пустым");
    }

    this.firstName = firstName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) throws InvalidStudentDataException {
    if (age < 16 || age > 100) {
      throw new InvalidStudentDataException("Возраст должен быть от 16 до 100");
    }

    this.age = age;
  }

  public int getCourse() {
    return course;
  }

  public void setCourse(int course) throws InvalidStudentDataException {
    if (course < 1 || course > 6) {
      throw new InvalidStudentDataException("Курс должен быть от 1 до 6");
    }

    this.course = course;
  }

  public double getAverageMark() {
    return averageMark;
  }

  public void setAverageMark(double averageMark) throws InvalidMarkException {
    if (averageMark < 0 || averageMark > 5) {
      throw new InvalidMarkException("Средний балл должен быть от 0 до 5");
    }

    this.averageMark = averageMark;
  }

  // Метод возвращающий результат, основанный на имеющихся полях
  public String getScholarshipResult() {
    if (averageMark >= 4.5) {
      return "Студент может получать повышенную стипендию";
    } else if (averageMark >= 3.0) {
      return "Студент может получать обычную стипендию";
    }

    return "Студент не может получать стипендию";
  }

  public String toString() {
    return "Студент: фамилия = "
        + lastName
        + ", имя = "
        + firstName
        + ", возраст = "
        + age
        + ", курс = "
        + course
        + ", средний балл = "
        + averageMark;
  }
}
