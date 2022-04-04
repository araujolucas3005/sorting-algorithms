package br.ufersa.sorts;

import br.ufersa.sorts.sorts.Sort;
import br.ufersa.sorts.sorts.impl.BucketSort;
import br.ufersa.sorts.sorts.impl.CoutingSort;
import br.ufersa.sorts.sorts.impl.RadixSort;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    int[] array = new int[]{690, 751, 453, 704, 835, 435, 326, 608};
    Sort sort = new CoutingSort();
    sort.sort(array);
    System.out.println(Arrays.toString(array));

    array = new int[]{690, 751, 453, 704, 835, 435, 326, 608};
    sort = new BucketSort(5);
    sort.sort(array);
    System.out.println(Arrays.toString(array));

    array = new int[]{690, 751, 453, 704, 835, 435, 326, 608};
    sort = new RadixSort();
    sort.sort(array);
    System.out.println(Arrays.toString(array));
  }

}
