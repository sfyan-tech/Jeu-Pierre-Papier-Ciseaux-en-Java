

import java.util.Random;
import java.util.Scanner;

public class PierrePapierCiseaux {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int scoreUtilisateur = 0;
        int scoreOrdinateur = 0;
        final int SCORE_MAX = 3;

        System.out.println("Bienvenue au jeu de Pierre-Papier-Ciseaux !");
        System.out.println("Le premier à atteindre 3 victoires gagne la partie.");
        
        while (scoreUtilisateur < SCORE_MAX && scoreOrdinateur < SCORE_MAX) {
            
            System.out.println("\nChoisissez : 1 (Pierre), 2 (Papier), 3 (Ciseaux)");
            int choixUtilisateur = scanner.nextInt();

            
            if (choixUtilisateur < 1 || choixUtilisateur > 3) {
                System.out.println("Entrée invalide. Choisissez 1, 2 ou 3.");
                continue;
            }

            
            int choixOrdinateur = random.nextInt(3) + 1;

            
            System.out.println("Vous avez choisi : " + traduireChoix(choixUtilisateur));
            System.out.println("L'ordinateur a choisi : " + traduireChoix(choixOrdinateur));

            
            if (choixUtilisateur == choixOrdinateur) {
                System.out.println("Égalité !");
            } else if (gagneContre(choixUtilisateur, choixOrdinateur)) {
                System.out.println("Vous gagnez ce tour !");
                scoreUtilisateur++;
            } else {
                System.out.println("L'ordinateur gagne ce tour !");
                scoreOrdinateur++;
            }

            
            System.out.println("Score : Vous " + scoreUtilisateur + " - " + scoreOrdinateur + " Ordinateur");
        }

        
        if (scoreUtilisateur == SCORE_MAX) {
            System.out.println("\nFélicitations ! Vous avez gagné la partie !");
        } else {
            System.out.println("\nL'ordinateur a gagné la partie. Bonne chance pour la prochaine fois !");
        }
        
        scanner.close();
    }

    
    public static String traduireChoix(int choix) {
        return switch (choix) {
            case 1 -> "Pierre";
            case 2 -> "Papier";
            case 3 -> "Ciseaux";
            default -> "Inconnu";
        };
    }

    
    public static boolean gagneContre(int joueur, int adversaire) {
        return (joueur == 1 && adversaire == 3) || 
               (joueur == 2 && adversaire == 1) || 
               (joueur == 3 && adversaire == 2);   
    }
}
