
import java.util.List;

public class ListNodeAddTest {

    public ListNode AddTwoNumber(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;

        int carry = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null || l2 != null) {
                int num1 = l1 != null ? l1.val : 0;
                int num2 = l2 != null ? l2.val : 0;

                int sum = num1 + num2 + carry;

                if (head == null) {
                    head = new ListNode(sum%10);
                    tail = head;
                }
                else {
                    tail.next = new ListNode(sum%10);
                    tail = tail.next;
                }
                carry = sum/10;

                if( l1 != null){
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }

        }
        if (carry > 0) {
            tail.next = new ListNode( carry );
        }

        return head;
    }

    public static void main(String[] args) {

        ListNode head1 = new ListNode(2);
        ListNode tail1 = head1;
        tail1.next = new ListNode(2);
        tail1 = tail1.next;
        tail1.next = new ListNode(4);


        ListNode head2 = new ListNode(7);
        ListNode tail2 = head2;
        tail2.next = new ListNode(5);
        tail2 = tail2.next;
        tail2.next = new ListNode(6);



        ListNodeAddTest listNodeAddTest = new ListNodeAddTest();
        ListNode result = listNodeAddTest.AddTwoNumber(head1, head2);

        StringBuilder anStb = new StringBuilder();

        while (result != null) {
            anStb.append(result.val);
            result = result.next;
        }

        for (int n = anStb.length() - 1; n >= 0; n--) {
            System.out.print(anStb.charAt(n));
        }

    }

}



class ListNode{
    int val;

    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
