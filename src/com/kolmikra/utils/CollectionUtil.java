package com.kolmikra.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class CollectionUtil {
    public static  void Swap(List<?> list,int i, int j){
        if(list instanceof RandomAccess){
            swapHelper(list,i,j);
        }else{
            final List l = list;
            l.set(i, l.set(j, l.get(i)));
        }
    }
    private static <T> void swapHelper(List<T> elements, int i, int j) {
        T temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }
}
