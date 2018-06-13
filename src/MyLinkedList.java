import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements List<T>{

    private int size;
    public Node<T> head;
    public Node<T> tail;

    public MyLinkedList(){
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;
            @Override
            public boolean hasNext() {
                return node!=null;
            }

            @Override
            public T next() {
                if(this.hasNext()){
                    T output = node.val;
                    node = node.next;
                    return output;
                }
                throw new NoSuchElementException();
            }
        };
    }

    class Node<T>{
        T val;
        Node<T> next;
        Node<T> last;
        private Node(T val){
            this.val = val;
        }
    }

    @Override
    public void add(T value) {
        if(size==0){
            head = new Node(value);
            tail = head;
        } else {
            tail.next = new Node(value);
            tail.next.last = tail;
            tail = tail.next;
        }
        size++;
    }

    @Override
    public T remove(int index) {
        Node<T> output = find(index);
        if(index!=0 && index!=size-1) {
            output.last.next = output.next;
            output.next.last = output.last;
        }
        if(index==0) {
            head = output.next;
            head.last = null;
        }
        if(index==size-1){
            tail = output.last;
            tail.next = null;
        }
        size--;
        return output.val;
    }

    public boolean remove(T val){
        Node<T> node = get(val);
        if(node==null)
            return false;
        if(node.last==null && node.next==null){
            head = null;
            tail = null;
        } else if(node.last==null){
            head = node.next;
            head.last = null;
        } else if(node.next==null){
            tail = node.last;
            tail.next = null;
        } else{
            node.last.next = node.next;
            node.next.last = node.last;
        }
        size--;
        return true;
    }

    @Override
    public T get(int index) {
        return find(index).val;
    }

    public Node<T> get(T val){
        Node<T> node = head;
        while(node!=null){
            if(node.val.equals(val))
                return node;
            node = node.next;
        }
        return null;
    }

    private Node<T> find(int index){
        if(index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException();
        Node<T> output;
        if(index >= size/2){
            output = tail;
            for(int i=0; i<size-index-1; i++)
                output = output.last;
        }else{
            output = head;
            for(int i=0; i<index; i++)
                output = output.next;
        }
        return output;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void reverse() {
        if(head==null)
            return;
        tail = head;
        Node<T> prev = null;
        Node<T> node = head;
        Node<T> next = head.next;

        node.last = next;
        node.next = prev;

        prev = node;
        node = next;
        while(node.next!=null){
            next = node.next;

            prev.last = node;
            node.next = prev;

            prev = node;
            node = next;
        }
        node.next = prev;

        head = node;
        head.last = null;
    }
}
