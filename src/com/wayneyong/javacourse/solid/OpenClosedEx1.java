package com.wayneyong.javacourse.solid;

/*
 * SOLID Principle -
 * SOLID is an acronym for that first java object oriented design (OOD)
 * principles by Robert C. Martin
 *
 * S - Single Responsibility Principle -
 *   A class should have one and only reason to change
 *
 * O - Open Closed Principles -
 *   Objects or entities should be open for extension but closed for modification
 *
 * */
interface ValueComparator {
    /*
     * @return +ve if value1 > value2, -ve if value1 < value2,
     * 0 if value1 = value2
     * */
    int compare(int value1, int value2);
}

class ArrayUtil {
    public static void sort(int a[], ValueComparator comparator) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (comparator.compare(a[i], a[j]) > 0) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}


public class OpenClosedEx1 {
    public static void main(String[] args) {
        int arr[] = {1, 5, 4, 2, 3};
        ArrayUtil.sort(arr, new DescComparator());
        System.out.println("Values in the array are: ");
        for (int ele : arr) {
            System.out.println(ele);
        }
    }
}

class AscComparator implements ValueComparator {
    @Override
    public int compare(int value1, int value2) {
        return value1 - value2;
    }
}

class DescComparator implements ValueComparator {
    @Override
    public int compare(int value1, int value2) {
        return value2 - value1;
    }
}
