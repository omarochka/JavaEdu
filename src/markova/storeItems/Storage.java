package markova.storeItems;

public class Storage<T>
{
    final T item;
    final T defaultValue;

    public Storage(T item, T defaultValue){
        this.item = item;
        if (defaultValue == null) throw new RuntimeException("Default value must not be null");
        this.defaultValue = defaultValue;
    }

    public T getItem() {
        return (item != null) ? item : defaultValue;
    }
}
