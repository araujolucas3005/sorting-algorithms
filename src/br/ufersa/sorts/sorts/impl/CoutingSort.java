package br.ufersa.sorts.sorts.impl;

import br.ufersa.sorts.sorts.Sort;
import br.ufersa.sorts.utils.ArrayUtils;

public class CoutingSort implements Sort {

  @Override
  public void sort(int[] array) {
    // posição do maior elemento do array
    int maxIndex = ArrayUtils.findMaxElementIndex(array);

    // maior elemento
    int maxElement = array[maxIndex];

    // cria um array com tamanho do maior elemento do array de entrada + 1
    // +1 para não dar ArrayOutOfBoundsException
    int[] aux = new int[maxElement + 1];
    for (int auxIndex : array) {

      // o index do array auxiliar corresponde à chave do array de entrada
      // a chave do array auxiliar corresponde à quantidade de ocurrências da chave do array de entrada
      aux[auxIndex]++;
    }

    // [1, 0, 4, 10] -> [1, 1, 5, 15]
    for (int i = 1; i < aux.length; i++) {
      aux[i] += aux[i - 1];
    }

    // array onde serão armazenados os elementos em ordem
    int[] orderedArray = new int[array.length];

    // percorre inversamente
    for (int i = array.length - 1; i >= 0; i--) {
      // índice que será utilizdo do array auxiliar
      int auxIndex = array[i];

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
