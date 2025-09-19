import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {
    public ArrayList<T> list;

    public Heap() {
        list = new ArrayList<>();

    }

    public void swap(int first, int second) {
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    public int parent(int index) {
        //considering array index counting from zero. and we are referring the index counting from 1.
        return (index - 1) / 2;
    }

    public int left(int index) {
        return index * 2 + 1;
    }

    public int right(int index) {
        return index * 2 + 2;
    }

    public void insert(T value) {
        list.add(value);
        upheap(list.size() - 1);
    }

    public void upheap(int index) {
        if(index == 0) {
            return;
        }

        int p = parent(index);

        //if the current item is smaller than the parent, swap
        if(list.get(index).compareTo(list.get(p)) < 0) {
            swap(index, p);
            upheap(p);
        }
    }

    public T remove() throws Exception {
        if(list.isEmpty()) {
            throw new Exception("Removing from an empty heap");
        }

        T temp = list.getFirst();

        T last = list.removeLast();

        if (!list.isEmpty()) {
           list.set(0, last);
           downheap(0);
        }
        return temp;
    }


    public void downheap(int index) {
        int min = index;
        int leftIndex = left(index);
        int rightIndex = right(index);
        
        //min heap
        if(leftIndex < list.size() && list.get(min).compareTo(list.get(leftIndex)) > 0) {
            min = leftIndex;
        }
        
        if(rightIndex < list.size() && list.get(min).compareTo(list.get(rightIndex)) > 0) {
            min = rightIndex;
        }
        
        if(min != index) {
            swap(min, index);
            downheap(min);
        }
    }
}
