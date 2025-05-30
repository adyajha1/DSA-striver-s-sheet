//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

//You may assume the two numbers do not contain any leading zero, except the number 0 itself.

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode dummy= new ListNode(0);
       ListNode current=dummy;
       ListNode p=l1, q=l2;
        int carry=0;
       while(p!=null||q!=null){
       int x = (p != null) ? p.val : 0;
       int y = (q != null) ? q.val : 0;
        int sum=x+y+carry;
        carry=sum/10;
        current.next=new ListNode(sum%10);
        current=current.next;
         if (p != null) p = p.next;
         if (q != null) q = q.next;
       }
        if(carry>0){
        current.next=new ListNode(carry);
       }
      
       return dummy.next;
    }
    
}