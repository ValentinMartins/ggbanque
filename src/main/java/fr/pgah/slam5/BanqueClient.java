package fr.pgah.slam5;

import java.util.Scanner;

public class BanqueClient {
    private int numCompteSelectionne = 0;
    private Scanner scanner;

    private boolean fin = false;
    private Banque banque;

    public BanqueClient(Scanner scanner, Banque banque) {
        this.scanner = scanner;
        this.banque = banque;
    }

    void run() {
        while (!fin) {
            System.out.print(
                    "Entrez une commande (0 = quitter, 1 = nouveau compte, 2 = changer compte, 3 = créditer compte, 4 = demander emprunt, 5 = afficher infos comptes, 6 = appliquer intérêts): ");
            int choix = scanner.nextInt();
            traiterCommande(choix);
        }
        scanner.close();
    }

    private void traiterCommande(int cmd) {

        if (cmd == 0) {
            quitter();
        } else if (cmd == 1) {
            creerNouveauCompte();
        } else if (cmd == 2) {
            selectionnerCompte();
        } else if (cmd == 3) {
            crediterCompte();
        } else if (cmd == 4) {
            demanderEmprunt();
        } else if (cmd == 5) {
            afficherInfosContes();
        } else if (cmd == 6) {
            appliquerInterets();

        }
    }

    private void quitter() {

        fin = true;
        System.out.println("À bientôt.");
    }

    private void creerNouveauCompte() {
        boolean origine = demanderSiEteanger();
        int type = demanderType();
        numCompteSelectionne = banque.creeCompte(origine, type);
        System.out.println("Le numéro de votre nouveau compte est : " + numCompteSelectionne);
    }

    private void selectionnerCompte() {
        System.out.print("Entrez le numéro du compte : ");
        numCompteSelectionne = scanner.nextInt();
        int solde = banque.getSolde(numCompteSelectionne);
        System.out.println("Le solde du compte " + numCompteSelectionne + " est " + solde);
    }

    private void crediterCompte() {
        System.out.print("Entrez le montant : ");
        int montant = scanner.nextInt();
        banque.crediter(numCompteSelectionne, montant);
    }

    private void demanderEmprunt() {
        System.out.print("Entrez le montant de l'emprunt souhaité : ");
        int montant = scanner.nextInt();
        if (banque.demandeEmprunt(numCompteSelectionne, montant)) {
            System.out.println("Votre demande est approuvée.");
        } else {

            System.out.println("Votre demande est refusée.");
        }
    }

    private void afficherInfosContes() {

        System.out.println(banque.toString());
    }

    private void appliquerInterets() {
        banque.appliquertInterets();
    }

    private boolean demanderSiEteanger() {
        System.out.print("Provenence (1 = étranger , 2 = non-etranger) : ");
        int entree = scanner.nextInt();
        if (entree == 1) {
            return false;
        } else {
            return true;
        }
    }

    private int demanderType() {
        System.out.print("type  (1 = Epargne , 2 = Courant) : ");
        int entree = scanner.nextInt();
        return entree;

    }

}
