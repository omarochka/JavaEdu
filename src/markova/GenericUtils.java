package markova;

import markova.generalInterfaces.Applyable;
import markova.generalInterfaces.Testable;
import markova.math.geometry.Point2D;
import markova.math.geometry.Point3D;
import markova.math.geometry.StraightLine;
import markova.storeItems.Box;
import markova.storeItems.Storage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class GenericUtils {

    public static <T> void getItemIntoBox(Box<T> box) {
        T value = box.getItem();

        if (value != null) {
            System.out.println("Item: " + value);
        } else {
            System.out.println("Box is empty.");
        }
    }

    public static <T> void getItemIntoStorage(Storage<T> storage) {
        T value = storage.getItem();
        System.out.println("Значение из хранилища: " + value);
    }

    public static <T extends Point2D> void  moveTheLine(StraightLine<T> line){
        line.getOriginCoordinate().x += 10;
    }

    @SafeVarargs
    public static double maxInBox(Box<? extends Number>... box){
        double maxTemp = box[0].getItem().doubleValue();
        for (int i = 1; i < box.length; i++){
            double tempBoxValue = box[i].getItem().doubleValue();
            if (maxTemp < tempBoxValue)
                maxTemp = tempBoxValue;
        }
        return maxTemp;
    }

    public static void fillBoxWith3DPoint(Box<? super Point3D> box) {
        Point3D point = new Point3D(new Random().nextInt(100), new Random().nextInt(100), new Random().nextInt(100));
        box.setItem(point);
    }

    public static void fillList(List<? super Integer> list){
        for (int i = 1; i <= 100; i++) {
            list.add(i);
        }
    }

    public static <T, P> List<P> func(List<T> list, Applyable<T, P> apply){
        if (list == null || apply == null) {
            throw new RuntimeException("Список или объект равен null");
        }

        List<P> tempList = new ArrayList<>();
        for (T elem: list) {
            tempList.add(apply.apply(elem));
        }
        return tempList;
    }

    public static <T> List<T> filter(List<T> list, Testable<T> test){
        if (list == null || test == null) {
            throw new RuntimeException("Список или объект не должен быть равен null");
        }

        List<T> tempList = new ArrayList<>();
        for (T elem: list) {
            if (test.test(elem)) tempList.add(elem);
        }
        return tempList;
    }

    public static <T> T reduce(List<T> list, T identity, BinaryOperator<T> reduceOperation) {
        if (list == null || reduceOperation == null) {
            return identity;
        }

        T result = identity;
        for (T item : list) {
            result = reduceOperation.apply(result, item);
        }

        return result;
    }

    //TODO predicate, function, supplier, BiConsumer
    public static <T, P> T collect(
            List<P> list,
            Supplier<T> supplier,
            BiConsumer<T, P> consumer
    ){
        T result = supplier.get();
        for(var element: list){
            consumer.accept(result, element);
        }
        return result;
    }
}
