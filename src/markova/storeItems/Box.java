package markova.storeItems;

public class Box<T>
{
    T item;

    public Box() {
        this.item = null;
    }

    public T getItem() {
        if (item == null) {
            return null;
        }
        T temp = item;
        item = null;
        return temp;
    }

    public void setItem(T item) {
        if (!isEmpty())
            throw new RuntimeException("Box is not empty!");
        this.item = item;
    }

    public boolean isEmpty(){
        return item == null;
    }
}
