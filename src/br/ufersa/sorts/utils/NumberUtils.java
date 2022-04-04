package br.ufersa.sorts.utils;

public class NumberUtils {

  public static int getNumberOfDigits(int n) {
    int numberOfDigits = 0;
    while (n != 0) {
      n /= 10;
      numberOfDigits++;
    }

    return numberOfDigits;
  }

}
