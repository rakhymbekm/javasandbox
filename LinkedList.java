public class LinkedList {
    public static void main(String[] args) {
        // adding random number for demo purposes
        LinkedListGen linkedListGen = new LinkedListGen();
        linkedListGen.insert(5);
        linkedListGen.insert(10);
        linkedListGen.insert(15);
        linkedListGen.insert(20);
        linkedListGen.display();
        linkedListGen.insertAt(2, 100.68);
        linkedListGen.display();
        linkedListGen.insertHead(7.6);
        linkedListGen.display();
        linkedListGen.deleteNodeAt(2.8);
        linkedListGen.display();
        linkedListGen.reverse();
        linkedListGen.display();
    }
}

class Node {
    private int data;
    private Node nextNode;

    public Node(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}

class LinkedListGen {
    private Node head;

    public LinkedListGen() {
    }

    public void insert(int data) {
        Node newNode = new Node(data);

        if (this.head == null) {
            head = newNode;
        } else {
            Node currentNode = head;
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(newNode);
        }
    }

    public void display() {
        if (head != null) {
            Node currentNode = head;
            while (currentNode.getNextNode() != null) {
                System.out.print(currentNode.getData() + " ");
                currentNode = currentNode.getNextNode();
            }
            System.out.println(currentNode.getData());
        }
    }

    public <I extends Number, V extends Number> void insertAt(I index, V value) {

        int i = index.intValue();
        int v = value.intValue();

        Node newNode = new Node(v);
        Node prevNode = head;
        Node nextNode;

        for(int j = 0; j< i-1; j++){
            prevNode = prevNode.getNextNode();
        }

        nextNode = prevNode.getNextNode();

        newNode.setNextNode(nextNode);
        prevNode.setNextNode(newNode);
    }

    public <V extends Number> void insertHead(V value) {
        int v = value.intValue();

        Node newHead = new Node(v);

        if (head == null) {
            head = newHead;
        } else {
            Node currentNode = head;
            head = newHead;

            newHead.setNextNode(currentNode);

            while (currentNode != null) {
                Node nextNode = currentNode.getNextNode();
                currentNode.setNextNode(nextNode);
                currentNode = nextNode;
            }
        }

    }

    public <I extends Number> void deleteNodeAt(I index) {

        if (head.getNextNode() == null) return;

        Node prevNode = null;
        Node nextNode = null;
        Node currentNode = head;

        int j = 0;
        int i = index.intValue();

        while (j <= i) {

            if (currentNode.getNextNode() == null) return;

            if (j != 0) {
                prevNode = currentNode;
                currentNode = currentNode.getNextNode();
            }

            if (currentNode.getNextNode() != null) {
                nextNode = currentNode.getNextNode();
            }

            if (j == i) {

                if (prevNode == null && nextNode != null) {
                    head = nextNode;
                }

                if (prevNode != null && nextNode == null) {
                    prevNode.setNextNode(null);
                }

                if (prevNode != null && nextNode != null) {
                    prevNode.setNextNode(nextNode);
                }

            }

            j++;

        }

    }

    public void reverse() {

        if (head == null || head.getNextNode() == null) return;

        Node currentNode = head;
        Node newHead = new Node(currentNode.getData());
        Node nextNode;

        while (true) {

            if (currentNode.getNextNode() == null) {
                head = newHead;
                break;
            }

            nextNode = newHead;
            newHead = new Node(currentNode.getNextNode().getData());
            currentNode = currentNode.getNextNode();
            newHead.setNextNode(nextNode);
        }

    }
}
