public class SinglyLinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node (int value) {
            this.value = value;
        }

        public Node (int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
        this.size = 0;
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    public void insertLast(int value) {
        if(tail == null) {
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;

        size += 1;
    }

    public void insert(int val, int index) {
        if(index == 0) {
            insertFirst(val);
        }

        if(index == size) {
            insertLast(val);
        }

        Node temp  = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;
    }

    public void deleteLast() {
        if(head == null) return;
        if(head == tail) {
            head = tail = null;
            size--;
            return;
        }
        Node temp = head;
        for (int i = 0; i < size - 1; i++) {
            temp = temp.next;
        }
        // or we could do
       /* while(temp.next != tail) {
            temp = temp.next; // finds the second last element.
        }*/
        tail = temp;
        tail.next = null;
        size--;

    }

    public void insertRec(int val, int index) {
        head = insertRec(val, index, head);
    }

    private Node insertRec(int val, int index, Node node) {
        if(index == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }
        node.next = insertRec(val, index-1, node.next);
        return node;
    }

    public void delete(int index) {
        if(index < 0 || index > size - 1) return;
        if(index == size - 1) deleteLast();
        if(index == 0) deleteFirst();;

        Node temp = head;
        for (int i = 0; i < index-1; i++) {
            temp = temp.next;
        }
        Node toDelete = temp.next;
        temp.next = temp.next.next;
        toDelete.next = null;
        size--;
    }

    public void deleteFirst() {
        if(head == null) return;
        if(size == 1) {
            head = tail = null;
            size--;
            return;
        }
        head = head.next;
        size--;
    }

    public Node find(int value) {
       if(head == null) return null;
       Node temp = head;
       while(temp != null) {
           if(temp.value == value) return temp;
           temp = temp.next;
       }
       return null;
    }

    public Node get(int index) {
        if(index > size -1 || index < 0) return null;
        if(index == 0) return head;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        SinglyLinkedList sll1 = new SinglyLinkedList();
        sll1.insertLast(20);
        sll1.insertLast(18);
        sll1.insertLast(12);
        sll1.insertLast(7);
        sll1.insertLast( 8);
        sll1.display();
        sll1.insertRec(50, 3);
        sll1.display();
    }


}
