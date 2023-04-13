/**
 * 
 * Обновляем методы согласно новой структуре. Появилась дополнительная
 * переменная, которую необходимо отслеживать во всех операциях. Так же
 * благодаря ссылке на последний элемент списка операции работы с концом стали
 * проще и их стоит заменить на логику аналогичную работе с началом списка
 */
public class Ex006 {

  public static void main(String[] args) {

    MyListEx6 ml = new MyListEx6();
    ml.addFirst("Раз", "Два", "Три");

    var item = ml.head;

    while (item != null) {
      System.out.println(item);
      item = item.getNext();
    }

    System.out.println(ml.contains("Два"));
    System.out.println();

    ml.removeLast();

    System.out.println();
    item = ml.head;
    while (item != null) {
      System.out.println(item);
      item = item.getNext();
    }

    ml.addLast("Пять!");

    System.out.println(

    );
    item = ml.head;
    while (item != null) {
      System.out.println(item);
      item = item.getNext();
    }

    ml.reverse();
    System.out.println("__________Reverse____________");
    item = ml.head;
    while (item != null) {
      System.out.println(item);
      item = item.getNext();
    }
  }
}


class MyListEx6 {
  NodeEx6 head;
  NodeEx6 tail;

  public void addFirst(String... values) {
    for (String string : values) {
      this.addFirst(string);
    }
  }

  public void addFirst(String value) {
    NodeEx6 node = new NodeEx6(value);

    if (head != null) {
      node.setNext(head);
      head.setPrev(node);
    } else {
      tail = node;
    }
    head = node;
  }

  public void removeFirst() {
    if (head != null && head.getNext() != null) {
      head.getNext().setPrev(null);
      head = head.getNext();
    } else {
      head = null;
      tail = null;
    }
  }

  public boolean contains(String value) {
    NodeEx6 node = head;
    while (node != null) {
      if (node.getValue().equals(value)) {
        return true;
      }
      node = node.getNext();
    }
    return false;
  }

  public void addLast(String value) {
    NodeEx6 node = new NodeEx6(value);

    if (tail != null) {
      node.setPrev(tail);
      tail.setNext(node);
    } else {
      head = node;
    }
    tail = node;
  }

  public void removeLast() {
    if (tail != null && tail.getPrev() != null) {
      tail.getPrev().setNext(null);
      tail = tail.getPrev();
    } else {
      head = null;
      tail = null;
    }
  }


  public void reverse() {
    NodeEx6 prev = null;
    NodeEx6 current = head;

    while (current != null) {
      prev = current.getPrev() ;
      current.setPrev(current.getNext());
      current.setNext(prev);
      current = current.getPrev();
    }
    if (prev != null)
    {
      head = prev.getPrev();
    }
  }
}
  class NodeEx6 {

    private NodeEx6 next;
    private NodeEx6 prev;

    String value;

    public NodeEx6(String value) {
      this.value = value;
    }

    public NodeEx6 getPrev() {
      return prev;
    }

    public void setPrev(NodeEx6 prev) {
      this.prev = prev;
    }

    public String getValue() {
      return value;
    }

    public NodeEx6 getNext() {
      return next;
    }

    public void setNext(NodeEx6 next) {
      this.next = next;
    }

    public NodeEx6(NodeEx6 next, String value) {
      this.next = next;
      this.value = value;
    }

    @Override
    public String toString() {
      return value;
    }
  }

