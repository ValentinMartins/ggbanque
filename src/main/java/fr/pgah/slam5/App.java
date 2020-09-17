package fr.pgah.slam5;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BanqueClient laBanque = new BanqueClient(scanner);
        laBanque.run();
    }

}
