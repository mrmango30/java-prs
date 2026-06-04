package Pr2;

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
  public Student(String lastName, String firstName, int age, int course, double averageMark) {
    setLastName(lastName);
    setFirstName(firstName);
    setAge(age);
    setCourse(course);
    setAverageMark(averageMark);
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    if (lastName == null || lastName.isBlank()) {
      this.lastName = "Не задано";
    } else {
      this.lastName = lastName;
    }
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    if (firstName == null || firstName.isBlank()) {
      this.firstName = "Не задано";
    } else {
      this.firstName = firstName;
    }
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    if (age < 16 || age > 100) {
      this.age = 18;
    } else {
      this.age = age;
    }
  }

  public int getCourse() {
    return course;
  }

  public void setCourse(int course) {
    if (course < 1 || course > 6) {
      this.course = 1;
    } else {
      this.course = course;
    }
  }

  public double getAverageMark() {
    return averageMark;
  }

  public void setAverageMark(double averageMark) {
    if (averageMark < 0 || averageMark > 5) {
      this.averageMark = 3.0;
    } else {
      this.averageMark = averageMark;
    }
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
