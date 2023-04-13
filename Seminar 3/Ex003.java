/**
 * 
 * Реализуем метод поиска элемента в односвязном списке для проверки наличия
 * элемента внутри списка. Для корректной работы со связным список необходимо
 * понимать, как именно можно обходить все значения внутри связного списка. Для
 * нашего примера проще всего будет
 * написать метод поиска значения в связном списке и возвращения из метода
 * информации о наличии искомого внутри списка.
 */
public class Ex003 {

  public static void main(String[] args) {
    MyListEx3 ml = new MyListEx3();
    ml.addFirst("Раз", "Два", "Три");

    var item = ml.head;

    while (item != null) {
      System.out.println(item);
      item = item.getNext();
    }

    System.out.println(ml.contains("Два"));
  }
}

class MyListEx3 {
  NodeEx3 head;

  public void addFirst(String... values) {
    for (String string : values) {
      this.addFirst(string);
    }
  }

  public void addFirst(String value) {
    NodeEx3 node = new NodeEx3(value);

    if (head != null) {
      node.setNext(head);
    }

    head = node;
  }

  public void removeFirst() {
    if (head != null) {
      head = head.getNext();
    }
  }

  public boolean contains(String value) {
    NodeEx3 node = head;
    while (node != null) {
      if (node.getValue().equals(value)) {
        return true;
      }
      node = node.getNext();
    }
    return false;
  }
}

class NodeEx3 {

  private NodeEx3 next;
  private String value;

  public NodeEx3(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public NodeEx3 getNext() {
    return next;
  }

  public void setNext(NodeEx3 next) {
    this.next = next;
  }

  public NodeEx3(NodeEx3 next, String value) {
    this.next = next;
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}
