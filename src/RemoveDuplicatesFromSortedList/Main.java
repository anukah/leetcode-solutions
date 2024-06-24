package RemoveDuplicatesFromSortedList;

import java.util.List;

public class Main {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static void main(String[] args) {
        ListNode list = new ListNode(1,new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        ListNode ok = deleteDuplicates(list);
        System.out.println(ok.next.val);
    }
    public static ListNode deleteDuplicates(ListNode head) {
            ListNode temp = head;
            while(temp!=null && temp.next!=null){
                if (temp.val == temp.next.val){
                    temp.next = temp.next.next;
                } else {
                temp = temp.next;
                }
            }
        return head;
    }

}
