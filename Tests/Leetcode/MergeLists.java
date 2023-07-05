package Leetcode;

public class MergeLists {
  public static class ListNode {
    int value;
    ListNode next;
    ListNode () {}
    ListNode (int value) { this.value = value; }
    ListNode (int value, ListNode next) { this.value = value; this.next = next; }
    @Override
    public String toString () {
      ListNode curr = this;
      String output = "";
      if (curr != null) {
        output = "[" + curr.value;
        curr = curr.next;
      }
      while (curr != null) {
        output += ", " + curr.value;
        curr = curr.next;
      }
      return output + ']';
    }
  } 

  public static ListNode mergeTwoLists (ListNode list1, ListNode list2) {
    ListNode current1 = list1;
    ListNode current2 = list2;
    ListNode mergedList = null;
    ListNode currentMerged = null;

    while (current1 != null && current2 != null) {
      int lessValue = (current1.value < current2.value) ? (current1.value) : (current2.value);
      int greaterValue = (current1.value > current2.value) ? (current1.value) : (current2.value);
      ListNode newNode = new ListNode(lessValue, new ListNode(greaterValue, null));
      if (mergedList == null) {
        mergedList = newNode;
        currentMerged = mergedList;
      } else {
        while (currentMerged.next != null) 
          currentMerged = currentMerged.next;
        currentMerged.next = newNode;
      }
      current1 = current1.next;
      current2 = current2.next;
    }
    return mergedList;
  }

  public static void main(String[] args) {
    ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
    ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
    ListNode list3 = new ListNode();
    ListNode mergedList = mergeTwoLists(list1, list2);
    System.out.println(list3);
  }
}
