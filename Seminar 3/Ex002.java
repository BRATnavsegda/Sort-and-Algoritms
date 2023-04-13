/**
 * 
 * Реализуем метод добавления новых элементов в начало списка и удаление первого
 * элемента связного списка. Односвязный список всегда имеет ссылку на первый
 * элемент последовательности, потому именно с реализации методов для первого
 * элемента последовательности стоит начать
 */
public class Ex002 {

  public static void main(String[] args) {
    MyList_ex2 ml = new MyList_ex2();
    ml.addFirst("Раз", "Два", "Три");

    var item = ml.head;

    while (item != null) {
      System.out.println(item);
      item = item.getNext();
    }
  }
}

class MyList_ex2 {
  NodeEx2 head;

  public void addFirst(String... values) {
    for (String string : values) {
      this.addFirst(string);
    }
  }

  public void addFirst(String value) {
    NodeEx2 node = new NodeEx2(value);

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
}

class NodeEx2 {

  private NodeEx2 next;
  private String value;

  public NodeEx2(String value) {
    this.value = value;
  }

  public NodeEx2 getNext() {
    return next;
  }

  public void setNext(NodeEx2 next) {
    this.next = next;
  }

  public NodeEx2(NodeEx2 next, String value) {
    this.next = next;
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}
