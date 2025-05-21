package markova.main;

import markova.GenericUtils;
import markova.creature.human.work.Student;
import markova.generalInterfaces.Applyable;
import markova.generalInterfaces.Testable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

import static markova.GenericUtils.collect;

public class Main
{
    public static void main(String[] args)
    {
//        6.3.4
//        List<Integer> numberList = Arrays.asList(1, -3, 7, -2, 0, 5, -8);
//
//        Supplier<List<List<Integer>>> sublistsFactory = () -> Arrays.asList(new ArrayList<>(), new ArrayList<>());
//        BiConsumer<List<List<Integer>>, Integer> numberSplitter = (lists, num) -> {
//            if (num > 0) {
//                lists.get(0).add(num);
//            } else {
//                lists.get(1).add(num);
//            }
//        };
//
//        List<List<Integer>> separatedLists = GenericUtils.collect(numberList, sublistsFactory, numberSplitter);
//        System.out.println("Разделенные списки (положительные и отрицательные): " + separatedLists);
    }
}