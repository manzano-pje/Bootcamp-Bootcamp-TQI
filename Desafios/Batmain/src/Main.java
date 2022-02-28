/*
Author: PJEM
Date: 10/12/2021
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();

        int viloesCapturados = 0;
        while(viloesCapturados < T) {
            String vilao = scan.next();


            //TODO: Imprima "Y" na linha abaixo, pois já temos o vilão em mãos ;-)
            System.out.println("Y");
            viloesCapturados++;
        }
    }
}