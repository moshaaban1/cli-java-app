package com.cli.utils;

import java.util.List;

public class PrintListItems {
    public static <T> void print(List<T> list) {
        if(list != null) {
            if(list.size() == 0) {
                System.out.println("There is nothing to be viewed");
            }

            for(var item : list) {
                System.out.println(item.toString());
            }
        }
    }
}
