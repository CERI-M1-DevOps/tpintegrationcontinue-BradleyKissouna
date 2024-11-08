package liste;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ListeSimpleTest {

    ListeSimple listeATester;

    @BeforeEach
    public void init() {
        listeATester = new ListeSimple();
    }

    @Test
    public void listeConstruiteVide() {
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
    }

    @Test
    public void ajoutAugmenteSize() {
        listeATester.ajout(1);
        assertEquals(1, listeATester.getSize());
    }

    @Test
    public void ajoutChangeTete() {
        listeATester.ajout(1);
        Noeud teteApresPremierAjout = listeATester.tete;
        listeATester.ajout(1);
        assertNotNull(teteApresPremierAjout);
        assertNotSame(teteApresPremierAjout, listeATester.tete);
    }

    @Test
    public void ajoutPlusieursFoisLeMeme() {
        listeATester.ajout(1);
        listeATester.ajout(1);
        listeATester.ajout(1);
        assertEquals(3, listeATester.getSize());
    }

    @Test
    public void toStringDonneTousLesNoeuds() {
        System.out.println(listeATester);
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        System.out.println(listeATester);
    }

    @Test
    public void modifiePremier() {
        ListeSimple listeATester = new ListeSimple();
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.modifiePremier(2, 4);

        assertEquals("ListeSimple(Noeud(3), Noeud(4), Noeud(1))", listeATester.toString()); 
        assertEquals(4, listeATester.tete.getSuivant().getElement());
        assertEquals(1, listeATester.tete.getSuivant().getSuivant().getElement());

        listeATester.modifiePremier(5, 10);

        assertEquals("ListeSimple(Noeud(3), Noeud(4), Noeud(1))", listeATester.toString()); 
        assertEquals(4, listeATester.tete.getSuivant().getElement());
        assertEquals(1, listeATester.tete.getSuivant().getSuivant().getElement());

        listeATester.modifiePremier(3, 100);

        assertEquals("ListeSimple(Noeud(100), Noeud(4), Noeud(1))", listeATester.toString()); 
        assertEquals(100, listeATester.tete.getElement());

        ListeSimple listeVide = new ListeSimple();
        listeVide.modifiePremier(1, 2);
        assertEquals("ListeSimple()", listeVide.toString());

        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.modifiePremier(2, 4);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(3), Noeud(4), Noeud(1), Noeud(100), Noeud(4), Noeud(1))");
        assertEquals(4, listeATester.tete.getSuivant().getElement());
    }

    @Test
    public void modifieTous() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(1);
        listeATester.ajout(1);
        listeATester.modifieTous(1, 4);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(4), Noeud(4), Noeud(2), Noeud(4))");
        assertEquals(4, listeATester.tete.getSuivant().getElement());
    }

    @Test
    public void supprimePremierListeVide() {
        listeATester.supprimePremier(1);
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
    }

    @Test
    public void supprimePremierEnPremierePosition() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.supprimePremier(3);
        assertEquals(listeATester.toString(),"ListeSimple(Noeud(2), Noeud(1))");
        assertEquals(2, listeATester.getSize());
    }

    @Test
    public void supprimePremierEnPositionQuelconque() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        listeATester.supprimePremier(2);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(4), Noeud(3), Noeud(1))");
        assertEquals(3, listeATester.getSize());
    }

    @Test
    public void supprimePremierNonExistant() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        listeATester.supprimePremier(5);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(4), Noeud(3), Noeud(2), Noeud(1))");
        assertEquals(4, listeATester.getSize());
        assertFalse(listeATester.toString().contains("Noeud(5)"));
    }

    @Test
    public void supprimePremierEnDernierePosition() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        listeATester.supprimePremier(1);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(4), Noeud(3), Noeud(2))");
        assertEquals(3, listeATester.getSize());
    }

    @Test
    public void supprimeTousListeVide() {
        listeATester.supprimePremier(1);
        assertNull(listeATester.tete);
        assertEquals(0, listeATester.getSize());
    }

    @Test
    public void supprimeTousUneSeuleFoisAuDebut() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.supprimeTous(3);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(2), Noeud(1))");
        assertEquals(2, listeATester.getSize());
    }

    @Test
    public void supprimeTousUneSeuleFoisPositionQuelconque() {
        listeATester.ajout(1);
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.supprimeTous(3);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(2), Noeud(1))");
        assertEquals(2, listeATester.getSize());
    }

    @Test
    public void supprimeTousPlusieursFois() {
        listeATester.ajout(2);
        listeATester.ajout(1);
        listeATester.ajout(1);
        listeATester.supprimeTous(1);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(2))");
        assertEquals(1, listeATester.getSize());
    }

    @Test
    public void supprimeTousPlusieursFoisPositionQuelconque() {
        listeATester.ajout(3);
        listeATester.ajout(1);
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.supprimeTous(3);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(2), Noeud(1))");
        assertEquals(2, listeATester.getSize());
    }

    @Test
    public void avantDernierListeVide() {
        assertNull(listeATester.getAvantDernier());
    }

    @Test
    public void avantDernierListeAUnElement() {
        listeATester.ajout(1);
        assertNull(listeATester.getAvantDernier());
    }

    @Test
    public void avantDernierListeADeuxElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        assertEquals(2, listeATester.getAvantDernier().getElement());
    }

    @Test
    public void avantDernierListeAPlusieursElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        assertEquals(2, listeATester.getAvantDernier().getElement());
    }

    @Test
    public void inverserListeVide() {
        listeATester.inverser();
        assertNull(listeATester.tete);
    }

    @Test
    public void inverserListeNbPairDElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.ajout(4);
        listeATester.inverser();
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4))");
    }

    @Test
    public void inverserListeNbImPairDElements() {
        listeATester.ajout(1);
        listeATester.ajout(2);
        listeATester.ajout(3);
        listeATester.inverser();
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(1), Noeud(2), Noeud(3))");
    }

    @Test
    public void echanger2NoeudsQuelconques() {
        listeATester.ajout(5);
        listeATester.ajout(4);
        Noeud r1 = listeATester.tete;
        listeATester.ajout(3);
        listeATester.ajout(2);
        Noeud r2 = listeATester.tete;
        listeATester.ajout(1);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4), Noeud(5))");
        listeATester.echanger(r1, r2);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(1), Noeud(4), Noeud(3), Noeud(2), Noeud(5))");
    }

    @Test
    public void echangerLePremierNoeudAvecUnAutre() {
        listeATester.ajout(5);
        listeATester.ajout(4);
        Noeud r2 = listeATester.tete;
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.ajout(1);
        Noeud r1 = listeATester.tete;
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4), Noeud(5))");
        listeATester.echanger(r1, r2);
        System.out.println(listeATester);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(4), Noeud(2), Noeud(3), Noeud(1), Noeud(5))");
    }

    @Test
    public void echangerDeuxListesEgaux() {
        listeATester.ajout(6);
        listeATester.ajout(9);
        Noeud r2 = listeATester.tete;
        listeATester.ajout(6);
        listeATester.ajout(9);
        Noeud r1 = listeATester.tete;
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(9), Noeud(6), Noeud(9), Noeud(6))");
        listeATester.echanger(r1, r2);
        System.out.println(listeATester);
    }

    @Test
    public void testEchangerIdentiques() {
        Noeud n1 = listeATester.tete;
        Noeud n2 = n1;
        listeATester.echanger(n1, n2);
        assertEquals(n1, n2);
    }

    @Test
    public void testEchangerR2EgalTete() {
        // Création de la liste
        ListeSimple liste = new ListeSimple();
        liste.ajout(10); // tete = 10
        liste.ajout(20); // tete = 20, 10 est le suivant
    
        // On force r2 == tete
        Noeud tete = liste.tete; // tete = 20
        Noeud n1 = tete.getSuivant(); // n1 = 10
    
        // Test où r2 est égal à tete
        liste.echanger(n1, tete);
        assertTrue(tete == n1.getSuivant());

        // Simple vérification pour s'assurer que l'échange s'est bien produit
        assertEquals(10, liste.tete.getElement()); // La tête doit maintenant être 10
        assertEquals(20, liste.tete.getSuivant().getElement()); // La tête pointe vers 20
    }

    @Test
    public void echangerLePremierEnSecondArgumentNoeudAvecUnAutre() {
        listeATester.ajout(5);
        listeATester.ajout(4);
        Noeud r1 = listeATester.tete;
        listeATester.ajout(3);
        listeATester.ajout(2);
        listeATester.ajout(1);
        Noeud r2 = listeATester.tete;
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(1), Noeud(2), Noeud(3), Noeud(4), Noeud(5))");
        listeATester.echanger(r1, r2);
        System.out.println(listeATester);
        assertEquals(listeATester.toString(), "ListeSimple(Noeud(4), Noeud(2), Noeud(3), Noeud(1), Noeud(5))");
    }
}