import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

  @Test
  void partitionV1() {
    Assertions.assertNull(Main.partitionV1(null, 2));

    Assertions.assertFalse(checkValidity(build(3, 5, 8, 5, 10, 2, 1), 5));
    Assertions.assertTrue(checkValidity(build(3, 1, 2, 10, 5, 5, 8), 5));

    Assertions.assertTrue(checkValidity(Main.partitionV1(build(3, 5, 8, 5, 10, 2, 1), 20), 20));
    Assertions.assertTrue(checkValidity(Main.partitionV1(build(3, 5, 8, 5, 10, 2, 1), 10), 10));
    Assertions.assertTrue(checkValidity(Main.partitionV1(build(3, 5, 8, 5, 10, 2, 1), 8), 8));
    Assertions.assertTrue(checkValidity(Main.partitionV1(build(3, 5, 8, 5, 10, 2, 1), 5), 5));
    Assertions.assertTrue(checkValidity(Main.partitionV1(build(3, 5, 8, 5, 10, 2, 1), 3), 3));
    Assertions.assertTrue(checkValidity(Main.partitionV1(build(3, 5, 8, 5, 10, 2, 1), 2), 2));
    Assertions.assertTrue(checkValidity(Main.partitionV1(build(3, 5, 8, 5, 10, 2, 1), 1), 1));
    Assertions.assertTrue(checkValidity(Main.partitionV1(build(3, 5, 8, 5, 10, 2, 1), 0), 0));
    Assertions.assertTrue(checkValidity(Main.partitionV1(build(1), 1), 1));
  }

  @Test
  void partitionV2() {
    Assertions.assertNull(Main.partitionV2(null, 2));

    Assertions.assertTrue(checkValidity(Main.partitionV2(build(3, 5, 8, 5, 10, 2, 1), 20), 20));
    Assertions.assertTrue(checkValidity(Main.partitionV2(build(3, 5, 8, 5, 10, 2, 1), 10), 10));
    Assertions.assertTrue(checkValidity(Main.partitionV2(build(3, 5, 8, 5, 10, 2, 1), 8), 8));
    Assertions.assertTrue(checkValidity(Main.partitionV2(build(3, 5, 8, 5, 10, 2, 1), 5), 5));
    Assertions.assertTrue(checkValidity(Main.partitionV2(build(3, 5, 8, 5, 10, 2, 1), 3), 3));
    Assertions.assertTrue(checkValidity(Main.partitionV2(build(3, 5, 8, 5, 10, 2, 1), 2), 2));
    Assertions.assertTrue(checkValidity(Main.partitionV2(build(3, 5, 8, 5, 10, 2, 1), 1), 1));
    Assertions.assertTrue(checkValidity(Main.partitionV2(build(3, 5, 8, 5, 10, 2, 1), 0), 0));
    Assertions.assertTrue(checkValidity(Main.partitionV2(build(1), 1), 1));
  }

  private boolean checkValidity(Node n, int x) {
    if (n == null) {
      return false;
    }

    boolean smallerThanX = n.data < x;

    n = n.next;

    while (n != null) {
      if (smallerThanX && n.data >= x) {
        smallerThanX = false;
      }

      if ((!smallerThanX && n.data < x)) {
        return false;
      }

      n = n.next;
    }

    return true;
  }

  private static Node build(Integer... values) {
    Node prev = null;
    Node head = null;

    for (Integer value : values) {
      Node n = new Node(value);

      if (prev == null) {
        head = n;
      } else {
        prev.next = n;
      }

      prev = n;
    }

    return head;
  }
}
