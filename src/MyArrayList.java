public class MyArrayList<T> implements List<T> {

    private final int INITIAL_SIZE = 16;
    private final float GROWTH_FACTOR = 1.5f;
    private final float THRESHOLD_FACTOR = 0.75f;

    private T[] stock;
    private int size;

    public MyArrayList(){
        this.stock = (T[])new Object[INITIAL_SIZE];
        this.size = 0;
    }

    @Override
    public void add(T value) {
        if(size >= stock.length * THRESHOLD_FACTOR){
            T[] newStock = (T[])new Object[(int)(stock.length * GROWTH_FACTOR)];
            System.arraycopy(stock, 0, newStock, 0, stock.length);
            stock = newStock;
        }
        stock[size++] = value;
    }

    @Override
    public T remove(int index) {
        if(index>=size || index<0)
            throw new ArrayIndexOutOfBoundsException();
        T output = stock[index];
        int threshold = (int)(stock.length*THRESHOLD_FACTOR);
        if(size-1 < threshold){
            T[] newStock = (T[])new Object[threshold];
            System.arraycopy(stock, 0, newStock, 0, index);
            System.arraycopy(stock, index+1, newStock, index, size-index-1);
            stock = newStock;
        } else {
            for (int i = index+1; i < stock.length; i++) {
                stock[i-1] = stock[i];
            }
        }
        size--;
        return output;
    }

    @Override
    public T get(int index) {
        if(index>=size || index<0)
            throw new ArrayIndexOutOfBoundsException();
        return stock[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void reverse() {
        int left = 0;
        int right = size-1;
        while(left < right){
            T temp = stock[left];
            stock[left] = stock[right];
            stock[right] = temp;
            left++;
            right--;
        }
    }
}
