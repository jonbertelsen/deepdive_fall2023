package dat;
public class MemoryStorage<T> implements DataStorage<T>
{
    private T data;

    public void store(T data) {
        this.data = data;
    }

    public T retrieve() {
        return data;
    }
}
