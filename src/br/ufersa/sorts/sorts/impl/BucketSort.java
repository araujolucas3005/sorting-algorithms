package br.ufersa.sorts.sorts.impl;

import br.ufersa.sorts.sorts.Sort;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort implements Sort {

  private final int numberOfBuckets;

  public BucketSort(int numberOfBuckets) {
    this.numberOfBuckets = numberOfBuckets;
  }

  @Override
  public void sort(int[] array) {
    // Cria um array de buckets
    @SuppressWarnings(value = "unchecked")
    List<Integer>[] buckets = new ArrayList[numberOfBuckets];

    // incializa cada bucket como uma lista
    for (int i = 0; i < numberOfBuckets; i++) {
      buckets[i] = new ArrayList<>();
    }

    // para cada número do array de entrada, verifica
    // em qual bucket ele deve ficar baseado no seu valor
    // ex.: Bucket 1 : valores de 1 à 9
    //      Bucket 2: valores de 10 à 19 ...
    for (int number : array) {
      boolean positionFound = false;
      for (int j = numberOfBuckets - 1; j >= 0 && !positionFound; j--) {
        if (number >= j * 10) {
          buckets[j].add(number);
          positionFound = true;
        }
      }
    }

    // lista para armazenar os valores ordenados dos buckets
    List<Integer> orderedList = new ArrayList<>();

    // ordena cada bucket com o algoritmo de escolha
    for (List<Integer> bucket : buckets) {
      Collections.sort(bucket);

      // adiciona todos os items do bucket ordenado na lista ordenada
      orderedList.addAll(bucket);
    }

    // transfere os valores da lista ordenada para o array original
    for (int i = 0; i < array.length; i++) {
      array[i] = orderedList.get(i);
    }
  }
}
