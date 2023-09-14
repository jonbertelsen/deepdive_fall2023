package dat;

public interface DataStorage<T> {
    void store(T data);
    T retrieve();
}