package util;

public class Counter {
    private static Integer id = 0;

    public  static Integer nextId(){
        id++;
        return id;
    }

}