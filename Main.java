/**
 * Write code to partition a linked list around a value x, such that all nodes less than x come
 * before all nodes greater than or equal to x. lf x is contained within the list, the values of x only need
 * to be after the elements less than x (see below) . The partition element x can appear anywhere in the
 * "right partition"; it does not need to appear between the left and right partitions.
 *
 * For this challenge, we'll assume the following singly linked list:
 *
 * public class Node {
 *   public Node next;
 *   public int data;
 *
 *   public Node(int data) {
 *     this.data = data;
 *   }
 *
 *   @Override
 *   public String toString() {
 *     StringBuilder sb = new StringBuilder();
 *
 *     Node nextNode = next;
 *
 *     sb.append(data);
 *
 *     while (nextNode != null) {
 *       sb.append("->");
 *
 *       sb.append(nextNode.data);
 *
 *       nextNode = nextNode.next;
 *     }
 *
 *     return sb.toString();
 *   }
 * }
 */
public class Main {

  /**
   * For the 1st version, we'll create 2 linked lists:
   * - 1 for the left partition (< value)
   * - 1 for the right partition (>= value)
   *
   * We'll traverse through the elements and put them in their concrete partitions and at the end -> link them together (if both have nodes)
   * and return the head of the left partition.
   *
   * <warning>Make sure to prevent infinite cycle by detaching the next nodes accordingly. Also linking the 2 partitions at the end.</warning>
   *
   * Time Complexity: O(n)
   * Space Complexity: O(1)
   */
  public static Node partitionV1(Node n, int value) {
    if (n == null) {
      return null;
    }

    Node leftStart = null;
    Node leftEnd = null;
    Node rightStart = null;
    Node rightEnd = null;

    while (n != null) {
      if (n.data < value) {
        if (leftStart == null) {
          leftStart = leftEnd = n;
        } else {
          leftEnd.next = n;
          leftEnd = n;
        }
      } else {
        if (rightStart == null) {
          rightStart = rightEnd = n;
        } else {
          rightEnd.next = n;
          rightEnd = n;
        }
      }

      n = n.next;
    }

    // Prevent infinite cycle
    if (rightEnd != null) {
      rightEnd.next = null;
    }

    // if we have no nodes in the left partition
    // right only the right one, no matter if it's null
    if (leftEnd == null) {
      return rightStart;
    }

    // If the above condition didn't pass
    // always link to the right part
    leftEnd.next = rightStart;

    // return head
    return leftStart;
  }

  /**
   * To optimize the approach in terms of code length, we could work only with 2 pointers:
   * -left & right which will always point to the first node in their partitions. To keep it this way during adding new ones ->
   * we will always put them at the beginning after we've changed the pointer to the previous head (left/right).
   *
   * <warning>Make sure to prevent infinite cycle by detaching the next nodes accordingly. Also linking the 2 partitions at the end</warning>
   *
   * Time Complexity: O(n)
   * Space Complexity: O(1)
   */
  public static Node partitionV2(Node n, int value) {
    if (n == null) {
      return null;
    }

    Node left = null;
    Node right = null;

    while (n != null) {
      Node next = n.next;

      if (n.data < value) {
        if (left != null) {
          n.next = left;
        }
        left = n;
      } else {
        n.next = right;
        right = n;
      }

      n = next;
    }

    if (left == null) {
      return right;
    }

    left.next = right;

    return left;
  }
}
