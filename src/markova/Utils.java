package markova;

import markova.computer.Connection;
import markova.creature.Bird;
import markova.creature.Meowable;
import markova.creature.human.work.Student;
import markova.exceptions.IncorrectMarksException;
import markova.math.geometry.*;
import markova.math.geometry.figure.Figure;
import markova.storeItems.Box;
import markova.storeItems.Storage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class Utils
{
    public static double additionNumber(Number... numbers){
        double sumRes = 0;
        for (Number value : numbers) {
            sumRes += value.doubleValue();
        }
        return sumRes;
    }

    public static void birdMarket(Bird... birds){
        for (Bird value : birds) {
            value.sing();
        }
    }

    public static double totalArea(Figure... figures){
        double sumRes = 0;
        for (Figure value : figures) {
            sumRes += value.findArea();
        }
        return sumRes;
    }

    public static void meowing(Meowable... meowables){
        for (Meowable value : meowables) {
            value.meow();
            value.meow();
        }
    }

    public static double measureLength(LengthMeasurable... length){
        double sumRes = 0;
        for (LengthMeasurable value : length) {
            sumRes += value.getLength();
        }
        return sumRes;
    }

    public static Polyline polylineUnion(Polylinable... polyline){
        Polyline tempPolyline = new Polyline();
        for (Polylinable value : polyline) {
            tempPolyline.addPoints(value.getPolyline().getPoints());
        }
        return tempPolyline;
    }

    public static int pow(String x, String y){
        int tempX = Integer.parseInt(x);
        int tempY = Integer.parseInt(y);
        return (int) Math.pow(tempX, tempY);
    }

    public static void readData() {
        try(Connection connection = new Connection("ermakov.edu")) {
            System.out.println(connection.getData());
            System.out.println(connection.getData());
            System.out.println(connection.getData());
            System.out.println(connection.getData());
            System.out.println(connection.getData());
            System.out.println(connection.getData());
            System.out.println(connection.getData());
            System.out.println(connection.getData());
            System.out.println(connection.getData());
            System.out.println(connection.getData());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Double  sumNumFromString(String... strings){
        if (strings == null || Arrays.stream(strings).toList().isEmpty()){
            return null;
        }

        List<Double> numbers = new ArrayList<>();
        for (String str : strings) {
            try {
                double num = Double.parseDouble(str);
                numbers.add(num);
            }
            catch (NumberFormatException e) {
                System.out.println("Wrong number was ignored");
            }
        }

        double firstNum = numbers.getFirst();
        for (int i = 1; i < numbers.size(); i++){
            try {
                double tempNum = numbers.get(i);
                if (tempNum == 0.0) throw new ArithmeticException("Divide by zero");
                firstNum /= tempNum;
            }
            catch (ArithmeticException e){
                System.out.println("Divide by zero was ignored");
            }
        }
        return firstNum;
    }

    public static void addMarksToStudents(Student... students){
        Random rand = new Random();
        try {
            for (Student student: students){
                student.addMark(rand.nextInt(10)+1);
            }
        }
        catch (IncorrectMarksException e){
            System.out.println("Wrong marks for student: " + e.getMessage());
            System.out.println("All student don't get marks!");
        }
    }

    public static List<Student> convert(List<String> constructorArgs, List<String> addArgs){
        List<Student> students = new ArrayList<>();

        for (String name : constructorArgs) {
            try {
                Student student = new Student(name);
                students.add(student);
            } catch (Exception e) {
                System.out.println("Студента " + name + " создать невозможно");
            }
        }

        if (addArgs != null && !addArgs.isEmpty()){
            if (addArgs.size() != constructorArgs.size()) {
                System.out.println("Количество студентов не совпадает с количеством оценок. Оценки не будут добавлены!");
                return students;
            }
            for (int i = 0; i < students.size(); i++) {
                try {
                    int mark = Integer.parseInt(addArgs.get(i));
                    students.get(i).addMark(mark);
                } catch (IncorrectMarksException e) {
                    students = Utils.convert(constructorArgs, null);
                    System.out.println("Пценки не были добавлены!");
                }
                catch (NumberFormatException e) {
                    System.out.println("В качестве оценок были указаны не числа");
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return students;
    }
}
