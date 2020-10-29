import java.util.*;
public class LinkedList {
    Node head;
  static   class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            this.data = d;
        }
    }
    public LinkedList insertAtStart(LinkedList l , int d)
    {
        Node newnode = new Node(d);
           newnode.next = l.head;
           l.head = newnode;
           return l;
    }
    public LinkedList insertAtEnd(LinkedList l , int d)
    {
        Node newnode = new Node(d);
        Node n = l.head;
        newnode.next = null;
        if(l.head == null)
        {
            head = newnode;
        }
        else
        {
            while(n.next!=null)
            {
                n=n.next;
            }
            n.next = newnode;
        }
        return l;
    }
    public void deleteAtPos(int pos)
    {
        Node n = head;
        for(int i=0;i<pos-1;i++)
        {
            n=n.next;
        }
        if(n==null||n.next==null)
        {
            return;
        }
        Node n1=n.next.next;
        n.next=n1;
    }
    public LinkedList insertAtPos(LinkedList l ,int d,int pos)
    {


        Node newnode = new Node(d);
        newnode.data=d;
        Node n1=l.head;
        for(int i=0;i<pos-2&&n1!=null;i++)
        {
            n1=n1.next;
        }
        newnode.next=n1.next;
        n1.next=newnode;
        return l;
    }
    public void printList(LinkedList l)
    {
        Node ptr=l.head;
        while(ptr!=null)
        {
            System.out.println(ptr.data);
            ptr=ptr.next;
        }
    }
    public void reverse()
    {
        Node prevnode = null;
        Node currnode = head;
        Node nextnode = head;
        while(currnode!=null)
        {
            nextnode = nextnode.next;
            currnode.next = prevnode;
            prevnode = currnode;
            currnode = nextnode;
        }
        head = prevnode;
    }
    public static void main(String[]args)
    {

        Scanner sc = new Scanner(System.in);
        System.out.println("1: Insert at start");
        System.out.println("2: Insert at end");
        System.out.println("3: Insert at position");
        System.out.println("4: delete at position");
        System.out.println("5: reverse the list");
        System.out.println("6: print the list");
        System.out.println("7: Exit");
        LinkedList list = new LinkedList();
        boolean exit=false;

        do {
            System.out.println("Enter your choice");
            int  n = sc.nextInt();
           switch(n)
           {
               case 1 :
                   for(int i=0;i<5;i++) {
                       int m = sc.nextInt();
                       list.insertAtStart(list, m);
                   }
                   break;
               case 2 :
                   System.out.println("Enter the elements");
                   for(int i=0;i<5;i++) {
                       int m1 = sc.nextInt();
                       list.insertAtEnd(list, m1);
                   }
                   break;

               case 3 :
                   int pos = sc.nextInt();
                   list.insertAtPos( list,10,pos);
                   break;
               case 4 :
                   int pos1 = sc.nextInt();
                   list.deleteAtPos(pos1);
                   break;
               case 5 :
                   System.out.println("print the list");
                   list.printList(list);
                   break;
               case 6 :
                   list.reverse();
                   break;
               case 7 :
                   exit = true;

           }
        }while(exit!=true);
    }
}
