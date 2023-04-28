  public class Node {
    public Node next;
    public int data;

    public Node(int data) {
      this.data = data;
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();

      Node nextNode = next;

      sb.append(data);

      while (nextNode != null) {
        sb.append("->");

        sb.append(nextNode.data);

        nextNode = nextNode.next;
      }

      return sb.toString();
    }
  }
