public interface List<T> {
    void add(T value);
    T remove(int index);
    T get(int index);
    int size();
    void reverse();
}
