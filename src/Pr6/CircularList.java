package Pr6;

/**
 * Обобщенный класс кольцевого однонаправленного списка.
 *
 * @param <T> тип хранимых значений
 */
public class CircularList<T> {

  private Node<T> head;
  private Node<T> tail;
  private Node<T> pointer;
  private int countElements;

  /** Создает пустой кольцевой однонаправленный список. */
  public CircularList() {}

  /**
   * Проверяет список на пустоту.
   *
   * @return true, если список пуст
   */
  public boolean isEmpty() {
    return countElements == 0;
  }

  /** Устанавливает указатель в начало списка. */
  public void setPointerToStart() {
    pointer = head;
  }

  /**
   * Добавляет элемент за указателем.
   *
   * @param value добавляемое значение
   */
  public void addAfterPointer(T value) {
    Node<T> node = new Node<>(value);

    if (isEmpty()) {
      head = node;
      tail = node;
      pointer = node;
      node.next = node;
      countElements++;
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

    countElements++;
  }

  /**
   * Удаляет элемент за указателем.
   *
   * @return удаленное значение или null, если удаление невозможно
   */
  public T removeAfterPointer() {
    if (isEmpty() || pointer == null) {
      return null;
    }

    Node<T> removed = pointer.next;

    if (countElements == 1) {
      T value = head.value;
      head = null;
      tail = null;
      pointer = null;
      countElements = 0;
      return value;
    }

    pointer.next = removed.next;

    if (removed == head) {
      head = removed.next;
    }

    if (removed == tail) {
      tail = pointer;
    }

    countElements--;
    return removed.value;
  }

  /**
   * Возвращает элемент за указателем.
   *
   * @return значение за указателем или null, если элемента нет
   */
  public T getPointerValue() {
    if (isEmpty() || pointer == null) {
      return null;
    }

    return pointer.next.value;
  }

  /** Перемещает указатель вправо. */
  public void movePointerRight() {
    if (!isEmpty()) {
      if (pointer == null) {
        pointer = head;
      } else {
        pointer = pointer.next;
      }
    }
  }

  /** Меняет местами конец списка и элемент за указателем. */
  public void swapTailAndPointer() {
    if (isEmpty() || pointer == null) {
      return;
    }

    T temp = tail.value;
    tail.value = pointer.next.value;
    pointer.next.value = temp;
  }

  /** Меняет местами начало списка и элемент за указателем. */
  public void swapHeadAndPointer() {
    if (isEmpty() || pointer == null) {
      return;
    }

    T temp = head.value;
    head.value = pointer.next.value;
    pointer.next.value = temp;
  }

  /**
   * Возвращает строковое представление списка.
   *
   * @return строковое представление списка
   */
  public String toString() {
    if (isEmpty()) {
      return "Список пуст";
    }

    String result = "";
    Node<T> current = head;

    for (int i = 0; i < countElements; i++) {
      result += current.value;

      if (current == pointer) {
        result += "(указатель)";
      }

      if (i < countElements - 1) {
        result += " -> ";
      }

      current = current.next;
    }

    return result;
  }

  /**
   * Узел кольцевого однонаправленного списка.
   *
   * @param <T> тип хранимого значения
   */
  private static class Node<T> {
    private T value;
    private Node<T> next;

    /**
     * Создает узел с указанным значением.
     *
     * @param value значение узла
     */
    private Node(T value) {
      this.value = value;
    }
  }
}
