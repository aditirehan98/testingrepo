import java.util.*;
public class LinkedList1
{
    Node head;
    static class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data=d;
            next=null;
        }
    }

    /********************************************************************************************/
    public LinkedList1 pushAtStart(LinkedList1 list,int d) {
        Node new_node=new Node(d);
        new_node.next=list.head;
        head=new_node;
        return list;
    }
    /***************************************************************************************************/


    public LinkedList1 pushAtEnd(LinkedList1 list,int d) {
        Node new_node=new Node(d);
        if(list.head==null)
        {
            head=new_node;
        }
        else
        {
            Node last=list.head;
            while(last.next!=null)
            {
                last=last.next;
            }
            last.next=new_node;
        }
        return list;
    }
    /******************************************************************************************************/
    public void print()
    {
        System.out.print("list is:  ");
        Node curr=head;
        while(curr!=null)
        {
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }
    /******************************************************************************************************/
    public static void deleteAtStart(LinkedList1 list)
    {
        Node new_node=list.head;
        if(list.head==null)
        {
            System.out.println("No item to delete!");
        }
        else
        {
            list.head=new_node.next;
            System.out.println("Deleted from start!");
        }
    }
    /**************************************************************************************************/
    public static int getCount(LinkedList1 list) {
        int ans=0;
        Node curr_node=list.head;
        while(curr_node!=null) {
            ans++;
            curr_node=curr_node.next;
        }
        return ans;
    }
    /******************************************************************************************************/
    public static void deleteAtEnd(LinkedList1 list)
    {
        Node curr=list.head;
        Node prev=null;
        if(list.head==null) {
            System.out.println("Nothing to delete!");
        }
        else {
            while(curr.next!=null) {
                prev=curr;
                curr=curr.next;
            }
            prev.next=null;
            System.out.println("Deleted from end!");
        }

    }

    /******************************************************************************************************/
    public static LinkedList1 insertAtK(LinkedList1 list,int n,int p) {
        Node new_node=new Node(n);
        Node curr=list.head;
        for(int i=0;i<p-2;i++)
        {
            curr=curr.next;
        }
        new_node.next=curr.next;
        curr.next=new_node;
        System.out.println("Inserted at "+p+" th position!");
        return list;
    }
    /*******************************************************************************************************/
    public static void deleteAtK(LinkedList1 list,int p)
    {
        Node curr=list.head;
        int ct=getCount(list);
        if(p<=ct) {
            for(int i=0;i<p-2;i++)
            {
                curr=curr.next;
            }
            curr.next=curr.next.next;
            System.out.println("Deleted from "+p+" th position!");
        }
        else
        {
            System.out.println("No element is here!");
        }
    }
    /******************************************************************************************************/
    public static void deleteAtValue(LinkedList1 list,int val) {
        Node curr=list.head;
        int ct=0;
        while(curr.data!=val) {
            ct++;
            curr=curr.next;
        }
        Node currt=list.head;
        for(int i=0;i<ct-1;i++) {
            currt=currt.next;
        }
        if(currt.next!=null)
            currt.next=currt.next.next;
        else
            currt.next=null;
        System.out.println("Deleted "+val+" from the list!");
    }
    /*********************************************************************************************************/
    public static void reverse(LinkedList1 list) {
        Node prev=null;
        Node curr=list.head;
        Node nex=null;
        while(curr!=null) {
            nex=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nex;
        }
        list.head=prev;
        System.out.println("List reversed!");
    }
    /*********************************************************************************************************/
    public static Node checkReverse(Node currt) {
        Node prev=null;
        Node curr=currt;
        Node nex=null;
        while(curr!=null) {
            nex=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nex;
        }
        return curr;
    }
    /*********************************************************************************************************/
    public static void findMiddle(LinkedList1 list)
    {
        Node curr=list.head;
        int size=getCount(list);
        if(size%2==1) {
            for(int i=0;i<((size)/2);i++) {
                curr=curr.next;
            }
            System.out.println("List is odd! Middle element is: "+curr.data);
        }
        else {
            for(int i=0;i<((size+1)/2);i++) {
                curr=curr.next;
            }
            System.out.println("List is even! Middle element is: "+curr.data);
        }
    }
    /***********************************************************************************************************/
    public static void removeDuplicates(LinkedList1 list){
        HashSet<Integer> hs=new HashSet<Integer>();
        Node curr=list.head;
        Node prev=null;
        while(curr!=null)
        {
            int val=curr.data;
            if(hs.contains(val))
            {
                prev.next=curr.next;
            }
            else
            {
                hs.add(val);
                prev=curr;
            }
            curr=curr.next;
        }
        System.out.println("Removed duplicates!");
    }
    /***********************************************************************************************************/
    public static void swap(LinkedList1 list,int x,int y) {
        if (x == y) return;
        Node prevX = null, currX = list.head;
        while (currX != null && currX.data != x)
        {
            prevX = currX;
            currX = currX.next;
        }

        Node prevY = null, currY =list.head;
        while (currY != null && currY.data != y)
        {
            prevY = currY;
            currY = currY.next;
        }

        if (currX == null || currY == null)
            return;

        if (prevX != null)
            prevX.next = currY;
        else
            list.head = currY;
        if (prevY != null)
            prevY.next = currX;
        else
            list.head = currX;
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }
    /************************************************************************************************/
    public static void moveLastAtFirst(LinkedList1 list) {
        Node curr=list.head;
        Node prev=null;
        while(curr.next!=null) {
            prev=curr;
            curr=curr.next;
        }
        prev.next=null;
        curr.next=list.head;
        list.head=curr;
        System.out.println("Moved at first!");
    }
    /**********************************************************************************************************/
    public static void checkPalindrome(LinkedList1 list) {
        boolean ans=true;
        Node ptr=list.head;
        int size=0;
        while(ptr!=null)
        {
            size++;
            ptr=ptr.next;
        }
        Node current=list.head;
        int mid=(size%2==0)?(size/2):((size+1)/2);
        for(int i=0;i<mid;i++)
        {
            current=current.next;
        }
        Node reversed=checkReverse(current);
        while(list.head!=null && reversed!=null)
        {
            if(list.head.data!=reversed.data)
            {
                ans=false;
                break;
            }
            list.head=list.head.next;
            reversed=reversed.next;
        }
        if(ans!=true) {
            System.out.println("Not Palindrome");
        }
        else
        {
            System.out.println(" palindrome");
        }
    }
    /*****************************************************************************************************/
    public static void segregateNodes(LinkedList1 list)
    {
        Node evenHead=null;
        Node oddHead=null;
        Node lastEven=null;
        Node lastOdd=null;
        Node curr=list.head;
        while(curr!=null)
        {
            if(curr.data%2==0)
            {
                if(evenHead==null)
                {
                    evenHead=lastEven=curr;
                }
                else
                {
                    lastEven.next=curr;
                    lastEven=curr;
                }
            }
            if(curr.data%2!=0)
            {
                if(oddHead==null) {
                    oddHead=lastOdd=curr;
                }
                else
                {
                    lastOdd.next=curr;
                    lastOdd=curr;
                }
            }
            if(evenHead!=null)
            {
                list.head=evenHead;
            }
            if(lastEven!=null)
            {
                lastEven.next=oddHead;

            }
            if(lastOdd!=null)
            {
                lastOdd=null;
            }
            curr=curr.next;
        }
        System.out.println("Sorted!");
    }
    /****************************************************************************************************/
    public static void main(String[] args) {
// TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        LinkedList1  list=new LinkedList1 ();
        System.out.print("\n******************************MENU*******************************\n"
                + "press 0 to print\npress 1 for inserting at start\npress 2 for inserting at end"
                + "\npress 3 for deleting at start\npress 4 for deleting at end\npress 5 for inserting "
                + "at kth position\npress 6 for deleting at kth position\npress 7 for deleting x value "
                + "node\npress 8 for reversing the list\npress 9 for checking if list is palindrome \n"
                + "press 10 for exit\n"+
                "press 11 for finding the middle element\n"
                + "press 12 to remove duplicate\npress 13 to swap nodes\n"
                + "press 14 to move last element to first in the list\npress 15 to separate even and odd nodes\n");
        int ch;
        boolean exit=false;
        do {
            System.out.println("\nEnter your choice:");
            ch=sc.nextInt();
            switch(ch)
            {
                case 0:
                    list.print();
                    break;
                case 1:
                    System.out.println("Enter number:");
                    int d=sc.nextInt();
                    list=list.pushAtStart(list,d);
                    break;
                case 2:
                    System.out.println("Enter number:");
                    int a=sc.nextInt();
                    list=list.pushAtEnd(list, a);
                    break;
                case 3:
                    deleteAtStart(list);
                    break;
                case 4:
                    deleteAtEnd(list);
                    break;
                case 5:
                    System.out.println("Enter number and position:");
                    int b=sc.nextInt();
                    int p=sc.nextInt();
                    list=list.insertAtK(list,b,p);
                    break;
                case 6:
                    System.out.println("Enter the position from where you want to delete:");
                    int pos=sc.nextInt();
                    deleteAtK(list,pos);
                    break;
                case 7:
                    System.out.println("enter the value which you want to delete:");
                    int val=sc.nextInt();
                    deleteAtValue(list,val);
                    break;
                case 8:
                    reverse(list);
                    break;
                case 9:
                    checkPalindrome(list);
                    break;
                case 10:
                    exit=true;
                    break;
                case 11:
                    findMiddle(list);
                    break;
                case 12:
                    removeDuplicates(list);
                    break;
                case 13:
                    System.out.println("enter data value of nodes you want to swap:");
                    int n1=sc.nextInt();
                    int n2=sc.nextInt();
                    swap(list,n1,n2);
                    break;
                case 14:
                    moveLastAtFirst(list);
                    break;
                case 15:
                    segregateNodes(list);
            }
        }while(exit!=true);
        System.out.println("Program done!");
    }

}