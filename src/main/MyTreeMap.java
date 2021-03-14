package main;

import typesfiles.Flat;

import java.util.TreeMap;

public class MyTreeMap {
    private TreeMap<Integer, Flat> MyMap;
    public static int ID_MAX = 1;

    public MyTreeMap() {
        MyMap = new TreeMap<>();
    }

    public void addFlat(Integer key, Flat flat) {
        try {
            MyMap.put(key, flat);
            ID_MAX++;
        } catch (NullPointerException e) {
            System.out.println("Error NullPointerException");
        }
    }

    public TreeMap<Integer, Flat> getMyMap() {
        return MyMap;
    }

    public void addToTree(TreeMap<Integer, Flat> addMap) {
        for (Integer key : addMap.keySet()) {
            addMap.get(key).setId(ID_MAX);
            addFlat(key, addMap.get(key));
        }
        //System.out.println("добавлена мапа:\n" + addMap.toString());
    }
}