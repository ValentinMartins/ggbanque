package fr.pgah.slam5;

import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Compte> comptes = new HashMap<>();
        ;
        Banque banque = new Banque(comptes);
        BanqueClient laBanque = new BanqueClient(scanner, banque);
        laBanque.run();
    }

}
