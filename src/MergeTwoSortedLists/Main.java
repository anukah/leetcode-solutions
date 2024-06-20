package MergeTwoSortedLists;

public class Main {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode sol = mergeTwoLists(l1,l2);

        while (sol != null) {
            System.out.print(sol.val + ", ");
            sol = sol.next;
        }
    }
     public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode(0);
        ListNode current = temp;

        while(list1!=null && list2!=null){
            if (list1.val < list2.val){
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if (list1!=null){
            current.next = list1;
            list1 = list1.next;
        }
        if (list2!=null){
            current.next = list2;
            list2 = list2.next;
        }
        return temp.next;
    }

}
