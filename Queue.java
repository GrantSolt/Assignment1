public class Queue<Item> {
    private int n;
    private Node first;
    private Node last;
    public Queue() {
        n=0;
        first=null;
        last=null;
    }
    private class Node
    {
        Item item;
        Node next;
        Node prev;
    }

    public void Enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        if (oldlast == null) {
            first = last;
        }
        else
            oldlast.next = last;
        n++;
    }
    public Item Dequeue() {
        Item item = first.item;
        first=first.next;
        if(first!=null)
            first.prev=null;
        else
            last=null;
        n--;
        return item;
    }
    public boolean isEmpty(){
        return n==0;
    }
}
