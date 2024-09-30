public class Stack<Item> {
    private int n;
    private Node first;
    private Node last;

    public Stack() {
        n=0;
        first=null;
        last=null;
    }

    private class Node
    {
        Item item;
        Node next;
    }

    public void push(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        if (last == null)
            last = first;
        n++;
    }

    public Item pop(){
        if (n==0)
            throw new RuntimeException("Steque underflow");
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }
}
