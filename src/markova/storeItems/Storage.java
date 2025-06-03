package markova.storeItems;

import java.util.NoSuchElementException;
import java.util.function.Supplier;

public class Storage<T>
{
    private static Storage<?> instance;
    final Supplier<T> item;

    private Storage(Supplier<T> item){
        this.item = item;
    }

    public static <T> Storage<T> createNullableStorage(T item) {
        if (instance == null) instance = new Storage<>(() -> {return item;});
        return (Storage<T>) instance;
    }
    public static <T> Storage<T> createNonNullableStorage(T item){
        if (item == null) throw new NoSuchElementException();
        return new Storage<>(() -> {return item;});
    }

    public static <T> Storage<T> createStorageWithSupplier(Supplier<T> spl){
        return new Storage<>(spl);
    }

    public T getItem() {
        return item.get();
    }

    public T orElse(T ob){
        T temp = item.get();
        if (temp == null) return ob;
        return temp;
    }
}
