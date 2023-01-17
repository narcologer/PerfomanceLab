package alfa.modules;

class Node {

    int value;
    Node nextNode;

    public Node(int value) {
        this.value = value;
    }
}

public class CircularList {
    private Node head = null;
    private Node tail = null;

    public void addNode(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
        }

        tail = newNode;
        tail.nextNode = head;
    }

    public void traverseList() {
        Node currentNode = head;

        if (head != null) {
            do {
                System.out.println(currentNode.value + " ");
                currentNode = currentNode.nextNode;
            } while (currentNode != head);
        }
    }

    public void traverseListWithStep(int m) {
        Node currentNode = head;
        String way = new String();
        do {
            for (int i = 0; i < m; i++) {
                if (i==0)
                    way+=currentNode.value;
                if (i!=m-1)
                    currentNode = currentNode.nextNode;
            }
        } while (currentNode.value != head.value);
        System.out.println(way);
    }
}
