/**
 * insertLast
 * display
 * delete a specific value
 */
public class CircularLinkedList {
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

    public void insertLast(int value) {
        Node node = new Node(value);
        if(head == null )  {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }


    public void display() {
        if(head == null) return;
        Node node = head;

        do {
            System.out.print(node.value + "->" );
            node = node.next;
        } while(node != head);
        System.out.print("HEAD");
        System.out.println();
    }

    //would throw exception if there is only one node and we tried to delete that node
    public void delete(int value) {
        if(head == null) return;

        Node node = head;
        if(node.value == value) {

            head = head.next;
            tail.next = head;
            return;
        }
        do {
            Node temp = node.next;
            if(temp.value == value) {
                node.next = temp.next;
                break;
            }
            node = node.next;
        } while (node != head);
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.insertLast(9);
        cll.insertLast(7);
        cll.insertLast(5);
        cll.insertLast(3);
        cll.insertLast(4);
        cll.insertLast(1);
        cll.insertLast(13);
        cll.display();
        cll.delete(9);
        cll.display();
    }

}
