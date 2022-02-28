/*
Author: PJEM
Date: 10/12/2021
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int quantidadePares = 0;

        for (int i = 0; i < 5; i++) {
            int n = scan.nextInt();

            //TODO: Implemente a condição abaixo verificando se "n" é par, ou seja, se o resto da divisão de "n" por 2 é zero.
            if ( n %2 == 0 ) {
                quantidadePares++;
            }
        }
        System.out.printf("%d valores pares\n", quantidadePares);
    }
}