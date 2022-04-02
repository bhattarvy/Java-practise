package leet.linkedlist;


import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val=val;
        this.next=null;
    }
}



public class Main {

    public static void displayNodes(ListNode head) {
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }

    public static void solve2181(ListNode head) {
        ListNode temp=head;

        while(temp!=null){
            if(temp.next!=null) {
                if(temp.next.val==0){
                    if(temp.next.next==null){
                        temp.next=null;
                        break;
                    } else {
                        temp=temp.next;
                    }

                } else {
                    temp.val+=temp.next.val;
                    temp.next=temp.next.next;
                    temp=temp.next;
                }
            } else {
                temp=temp.next;
            }

        }
        while (head != null) {

            ListNode t=head;
            while(t!=null) {
                System.out.println(t.val);
                t=t.next;
            }
        }
    }

    public  static void create() {

       ListNode head=new ListNode(0);
        head.next=new ListNode(4);
        head.next.next = new ListNode(0);
        solve2181(head);


    }

    public static void main(String[] args) {
            create();
    }
}

