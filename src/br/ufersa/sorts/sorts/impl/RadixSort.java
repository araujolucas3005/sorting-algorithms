package br.ufersa.sorts.sorts.impl;

import br.ufersa.sorts.sorts.Sort;
import br.ufersa.sorts.utils.ArrayUtils;
import br.ufersa.sorts.utils.NumberUtils;

public class RadixSort implements Sort {

  @Override
  public void sort(int[] array) {
    // index do maior elemento do array
    int maxIndex = ArrayUtils.findMaxElementIndex(array);

    // maior elemento
    int maxElement = array[maxIndex];

    // número de dígitos do maior número do array
    int maxNumberOfDigits = NumberUtils.getNumberOfDigits(maxElement);

    // primeiro verifica o último dígito, depois o penúltimo ... até o primeiro dígito
    for (int i = 0; i < maxNumberOfDigits; i++) {

      // utiliza qualquer algoritmo de ordenação estável
      // nesse caso foi utilizado o Counting sort com adaptações para o Radix
      countingSort(array, i);
    }
  }

  /**
   * @param array O arranjo para ordenar
   * @param exp   Por qual dígito dos elementos o arranjo deve ser ordenado
   */
  private static void countingSort(int[] array, int exp) {

    // só terão elementos de 0 a 9
    int[] aux = new int[10];

    // por exemplo: [321, 784],
    // quando exp = 0
    //    784 -> auxIndex = 4
    //    321 -> auxIndex = 1
    // quando exp = 1
    //    784 -> auxIndex = 8
    //    321 -> auxIndex = 2
    // ...
    for (int number : array) {
      int auxIndex = number / ((int) Math.pow(10, exp)) % 10;
      aux[auxIndex]++;
    }

    for (int i = 1; i < aux.length; i++) {
      aux[i] += aux[i - 1];
    }

    // array onde serão armazenados os elementos em ordem
    int[] orderedArray = new int[array.length];

    // percorre inversamente
    for (int i = array.length - 1; i >= 0; i--) {
      // índice que será utilizdo do array auxiliar
      int auxIndex = array[i] / ((int) Math.pow(10, exp)) % 10;

      // índice que será utilizado no array ordenado
      // -1 para não ocorrer ArrayOutOfBoundsException
      int orderedArrayIndex = aux[auxIndex] - 1;

      orderedArray[orderedArrayIndex] = array[i];
      aux[auxIndex]--;
    }

    // copia os valores para o array original
    System.arraycopy(orderedArray, 0, array, 0, array.length);
  }
}
