/**
 * insertFirst
 * display
 * insertLast
 * find
 * insert
 *
 */

public class DoublyLinkedList {

    private class Node {
        int val;
        Node prev;
        Node next;

        public Node (int val) {
            this.val = val;
        }

        public Node (int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
    Node head;

    public void insertFirst(int val) {

        if(head == null) {
            head =  new Node(val, null, null);
            return;
        }

        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        head.prev = node;
        head = node;
    }

    public void display() {
        if(head == null) return;
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void insertLast(int val) {
        if(head == null) {
            insertFirst(val);
            return;
        }

        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }

        //tail node
        temp.next = new Node(val, temp, null);
    }

    public Node find(int val) {
        if(head == null) return null;
       Node temp = head;
       while(temp != null) {
           if(temp.val == val) return temp;
           temp = temp.next;
       }
       return null;
    }

    /*public void insert(int val, int index) {
        if(head == null) {
            if(index == 0) insertFirst(val);
            else return;
        }
        int localIndex = 0;
        Node temp = head;
        while(temp.next != null && localIndex != index) {
            temp = temp.next;
            localIndex++;
        }

        //Assuming we are at the last node, and inserting the node after tail node.
        if(temp.next == null && (localIndex + 1) ==  index) {
            Node insertingNode = new Node(val,temp, null);
        }
        //New node being inserted in middle
        new Node(val, temp.prev, temp);
    }*/

    public void insert(int val, int index) {
        if(index == 0) {
            insertFirst(val);
            return;
        }
        if(head == null) return;
        Node temp = head;
        for (int i = 0; i <index-1 ; i++) {
            temp = temp.next;
            if(temp == null) return;
        }

        Node insertingNode = new Node(val);
        insertingNode.next = temp.next;
        insertingNode.prev = temp;

        if(temp.next != null) {
            temp.next.prev = insertingNode;
        }
        temp.next = insertingNode;

    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertFirst(12);
        dll.insertFirst(14);
        dll.insertFirst(17);
        dll.insertFirst(19);
        dll.insertFirst(21);
        dll.display();
        dll.insertLast(11);
        dll.display();
    }


}
