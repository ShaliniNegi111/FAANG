import java.util.*;

class ReverseNodesInKGroup{
  public static void main(String[] args) {
    ListNode one = new ListNode(1);
    ListNode t = new ListNode(2);
    ListNode th = new ListNode(3);
    ListNode f = new ListNode(4);
    ListNode fi = new ListNode(5);
    one.next = t ;
    System.out.println(reverseKGroup(one,2));
    t.next = th;
    th.next = f;
    f.next = fi;
//        System.out.println(reverseKGroup(one,2));
    System.out.println(reverseKGroup(one,3));
  }
  public static ListNode reverseKGroup(ListNode head, int k) {
      ListNode op = new ListNode(-1) , hR = head, hR2 = head;
      op.next = head;
      ListNode opR = op;
      int index = 1;
      while(index < k && hR2 != null){
//         Advance the hR2 pointer to K.
          hR2 = hR2.next;
          index++;
      }
//         Now loop till the hR2 pointer is null, and have an internal loop to reverse K nodes.
      while(hR != null && hR2 != null){
          ListNode op2 = new ListNode(-1), op2R = op2.next;
          int i = 0;
          while(i < k && hR != null){
              ListNode t = op2R;
              op2R = new ListNode(hR.val);
              op2R.next = t;
              hR = hR.next;
              i++;
              hR2 = hR2 != null ? hR2.next : null;
          }
          op.next = op2R;
          while(op.next != null){
              op = op.next;
          }
      }
      if(hR != null) {
          op.next = hR;
      }
      return opR.next;
  }

  public static ListNode reverseKGroup1(ListNode head, int k) {
      ListNode root = null, node = head, prev = null;
      Stack<ListNode> stack = new Stack<>();
      while (node != null) {
          if (stack.size() == k - 1) {
              if (root == null)
                  root = prev = node;
              else
                  prev = prev.next = node;
              node = node.next;
              for (int i = 1; i < k; i++)
                  prev = prev.next = stack.pop();
              prev.next = node;
          }
          else {
              stack.add(node);
              node = node.next;
          }
      }
      return root != null ? root : head;
  }
}
