package structure.link;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author zhy
 * @date 2020/5/26
 */
public class LinkListTest {

  public static void main(String[] args) {
    Node node1 = new Node(1);
    Node node2 = new Node(9);
    node1.next = node2;
    Node node3 = new Node(13);
    node2.next = node3;
    Node node4 = new Node(7);
    node3.next = node4;
    Node node5 = new Node(9);
    node4.next = node5;
    //排序
    sortLink(node1);
    System.out.println(node1.print());
    // 删除重复的
    deleteRepeat(node1);
    System.out.println(node1.print());

    // 单链表中环检测
    System.out.println(hasLoop(node1));
    node5.next = node3;
    System.out.println(hasLoop(node1));
    node5.next = null;
    // 单链表反转
    System.out.println(node1.print());
    node1 = reverse(node1);
    System.out.println(node1.print());



    Node node11 = new Node(2);
    Node node21 = new Node(3);
    node11.next = node21;
    Node node31 = new Node(6);
    node21.next = node31;
    Node node41 = new Node(18);
    node31.next = node41;
    Node node51 = new Node(19);
    node41.next = node51;
    sortLink(node1);
    sortLink(node11);
    // 合并链表
    Node merge = merge(node1, node11);
    System.out.println(merge.print());



  }

  private static void sortLink(Node head) {
    Node current = head;
    int temp;
    while (current.next != null){
      Node next = current.next;
      while (next != null) {
        if (next.value < current.value) {
          temp = current.value;
          current.value = next.value;
          next.value = temp;
        }
        next = next.next;
      }
      current = current.next;
    }
  }

  private static void deleteRepeat(Node headNode) {
    Map<Integer, Integer> map = new HashMap<>(5);
    map.put(headNode.value, headNode.value);
    Node tmp = headNode.next;
    Node pre = headNode;
    while (tmp != null) {
      if (map.containsKey(tmp.value)) {
       //重复
        pre.next = tmp.next;
      } else {
        map.put(tmp.value, tmp.value);
        pre = tmp;
      }
      tmp = tmp.next;
    }
  }

  public static boolean hasLoop(Node headNode) {
    if (headNode == null) {
      return false;
    }
    Node p = headNode;
    Node q = headNode.next;
    // 快指针未能遍历完所有节点
    while (q != null && q.next != null) {
      p = p.next; // 遍历一个节点
      q = q.next.next; // 遍历两个个节点
      // 已到链表末尾
      if (q == null) {
        return false;
      } else if (p == q) {
        // 快慢指针相遇，存在环
        return true;
      }
    }
    return false;
  }

  public static Node reverse(Node node) {
    if (node == null || node.next == null) {
      return node;
    }
    Node temp = node.next;
    Node newHead = reverse(node.next);
    temp.next = node;
    node.next = null;
    return newHead;
  }

  public static Node merge(Node node1, Node node2) {
    if (node1 == null) {
      return node2;
    } else if (node2 == null) {
      return node1;
    }
    Node newNode;
    Node p;
    Node q;
    if (node1.value < node2.value) {
      newNode = new Node(node1.value);
      p = node1.next;
      q = node2;
    } else {
      newNode = new Node(node2.value);
      p = node1;
      q = node2.next;
    }
    Node o = newNode;
    while (p != null && q != null) {
      if (p.value < q.value) {
        o.next = new Node(p.value);
        o = o.next;
        p = p.next;
      } else {
        o.next = new Node(q.value);
        o = o.next;
        q = q.next;
      }
    }
    if (p == null) {
      o.next = q;
    } else {
      o.next = p;
    }
    return newNode;
  }

  public static class Node {

    public int value;
    public Node next;

    public Node(int data) {
      this.value = data;
      this.next = null;
    }

    public String print() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(value).append("-");
      if (next != null) {
        stringBuilder.append(next.print());
      }
      return stringBuilder.toString();
    }
  }
}
