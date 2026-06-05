package Pr6;

// Обобщенный класс кольцевого однонаправленного списка
class CircularList<T> {

  // Узел списка
  private static class Node<T> {
    private T value;
    private Node<T> next;

    private Node(T value) {
      this.value = value;
    }
  }

  private Node<T> head;
  private Node<T> tail;
  private Node<T> pointer;
  private int size;

  // Метод проверяющий список на пустоту
  public boolean isEmpty() {
    return size == 0;
  }

  // Метод устанавливающий указатель в начало
  public void setPointerToStart() {
    pointer = head;
  }

  // Метод добавляющий элемент за указателем
  public void addAfterPointer(T value) {
    Node<T> node = new Node<>(value);

    if (isEmpty()) {
      head = node;
      tail = node;
      pointer = node;
      node.next = node;
      size++;
      return;
    }

    if (pointer == null) {
      pointer = head;
    }

    node.next = pointer.next;
    pointer.next = node;

    if (pointer == tail) {
      tail = node;
    }

    size++;
  }

  // Метод удаляющий элемент за указателем
  public T removeAfterPointer() {
    if (isEmpty() || pointer == null) {
      return null;
    }

    Node<T> removed = pointer.next;

    if (size == 1) {
      T value = head.value;
      head = null;
      tail = null;
      pointer = null;
      size = 0;
      return value;
    }

    pointer.next = removed.next;

    if (removed == head) {
      head = removed.next;
    }

    if (removed == tail) {
      tail = pointer;
    }

    size--;
    return removed.value;
  }

  // Метод возвращающий элемент за указателем
  public T getPointerValue() {
    if (isEmpty() || pointer == null) {
      return null;
    }

    return pointer.next.value;
  }

  // Метод перемещающий указатель вправо
  public void movePointerRight() {
    if (!isEmpty()) {
      if (pointer == null) {
        pointer = head;
      } else {
        pointer = pointer.next;
      }
    }
  }

  // Метод меняющий местами конец списка и элемент за указателем
  public void swapTailAndPointer() {
    if (isEmpty() || pointer == null) {
      return;
    }

    T temp = tail.value;
    tail.value = pointer.next.value;
    pointer.next.value = temp;
  }

  // Метод меняющий местами начало списка и элемент за указателем
  public void swapHeadAndPointer() {
    if (isEmpty() || pointer == null) {
      return;
    }

    T temp = head.value;
    head.value = pointer.next.value;
    pointer.next.value = temp;
  }

  // Метод возвращающий строковое представление списка
  public String toString() {
    if (isEmpty()) {
      return "Список пуст";
    }

    String result = "";
    Node<T> current = head;

    for (int i = 0; i < size; i++) {
      result += current.value;

      if (current == pointer) {
        result += "(указатель)";
      }

      if (i < size - 1) {
        result += " -> ";
      }

      current = current.next;
    }

    return result;
  }
}
