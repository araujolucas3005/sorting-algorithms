package br.ufersa.sorts.utils;

public class ArrayUtils {

  public static int findMaxElementIndex(int[] v) {
    if (v.length == 0) {
      return -1;
    }

    int maxIndex = 0;
    for (int i = 0; i < v.length; i++) {
      if (v[maxIndex] < v[i]) {
        maxIndex = i;
      }
    }

    return maxIndex;
  }

}
