
public class LinkedList implements ListInterface {

    public class Node {

        private int info;
        private Node next;

        public Node() {
            info = 0;
            next = null;
        }

        public void setInfo(int i) {
            info = i;
        }

        public void setNext(Node l) {
            next = l;
        }

        public int getInfo() {
            return info;
        }

        public Node getNext() {
            return next;
        }
    }

    private Node first;

    public LinkedList() {
        first = new Node();
    }

    public boolean isEmpty() {
        return (first.getNext() == null);
    }

    public void display() {
        Node current = first.getNext();

        while (current != null) {
            System.out.print(current.getInfo() + " ");
            current = current.getNext();
        }

        System.out.println();
    }

    public boolean search(int x) {
        Node current = first.getNext();

        while (current != null) {
            if (current.getInfo() == x) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    public void add(int x) {
        Node p = new Node();

        p.setInfo(x);
        p.setNext(first.getNext());

        first.setNext(p);
    }

    public void remove(int x) {
        Node old = first.getNext(),
                p = first;

        boolean found = false;
        while (old != null && !found) {
            if (old.getInfo() == x) {
                found = true;
            }
            else {
                p = old;
                old = p.getNext();
            }
        }

        if (found) {
            p.setNext(old.getNext());
        }
    }

    public void insert(int x, int loc) {
        if (loc >= length()) {
            System.out.println("Incorrect Location!");
        }
        else {
            Node current = first;

            for (int i = 0; i < loc; i++) {
                current = current.getNext();
            }

            Node p = new Node();
            p.setInfo(x);
            p.setNext(current.getNext());

            current.setNext(p);
        }
    }

    public void removeItemAt(int loc) {
        if (loc >= length()) {
            System.out.println("Incorrect Location");
        }
        else {
            Node current = first;
            for (int i = 0; i < loc; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
        }
    }

    public int length() {
        Node current = first.getNext();
        int count = 0;
        while (current != null) {
            count++;

            current = current.getNext();
        }
        return count;
    }
}
