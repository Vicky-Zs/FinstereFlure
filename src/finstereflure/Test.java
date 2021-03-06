/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finstereflure;

import character.*;
import map.*;
import token.*;

/**
 *
 * @author Cédric
 */

public class Test extends Game {
  /**
   * Permet les tests du jeu
   */
  public static void main() {
  Token temp;
  Game g = new Game();
  g.iniMap();
  for (int i = 0; i < nbPlayers; i++) {
    g.p[i] = new Player(IA.defineName(), i, g);
  }
  System.out.println("\nDeux joueurs ont été créé avec des noms aléatoires");
  System.out.println("Ceci est une test automatique du jeu");
  g.iniDecorations(0);        // Décoration pour le test
  temp = g.p[0].getToken(5);  // Pion au pattern 5 - 2
  System.out.println(temp);
  //Test décors
  for (int i = 0; i < 16; i++){
    for (int j = 0; j < 11; j++){
      System.out.println("___________________________________________");
      System.out.print("\nLa case ["+i+";"+j+"]\tMur :");
      boolean flag = true;
      for (int k = 0; k < 4; k++){
        if (g.getMap(i, j).getWall(k)){
          flag = false;
          switch (k){
            case 0:
            System.out.print(" Nord");
            break;
            case 1:
            System.out.print(" Est");
            break;
            case 2:
            System.out.print(" Sud");
            break;
            case 3:
            System.out.print(" Ouest");
            break;
            case 4:
            System.out.print(" Erreur '4'");
            break;
            default:
            System.out.print(" Probleme");
            break;
          }
        }
      }
    }
  }
  System.out.println("___________________________________________");
  if (temp instanceof TokenP){
    TokenP tP = (TokenP) temp;
    System.out.println(tP);
    tP.move(0);
    System.out.println("Le token s'est déplacé, nouvelle position [" + tP.getPosX() + ";" + tP.getPosY() + "]");
    System.out.println(tP.getNbMove());
    tP.move(0);
    tP.move(0);
    // TEST DESTRUCTION DU PION PATTERN_5
    g.getMap(tP.getPosX(), tP.getPosY()).setNotTokenHere();
    temp.setPosX(3); temp.setPosY(10);
    g.getMap(tP.getPosX(), tP.getPosY()).setTokenHere();
    System.out.println("Nombre de Tokens : " + g.p[0].getNbToken());
    System.out.println("Nombre de victimes : " + TokenP.getVictime());
    // TEST DESTRUCTION DU PION PATTERN_5
    System.out.println("Le token s'est déplacé, nouvelle position [" + tP.getPosX() + ";" + tP.getPosY() + "]");
    System.out.println(tP.getNbMove());
    g.setTurnPlayers(false);
    }
    temp = g.getMonster().getToken();
    if (temp instanceof TokenM){
      TokenM tM = g.getMonster().getToken();
      System.out.println("Début du tour !!!");
      tM.tour();
      System.out.println("Fin du tour !!!");
      // TEST DESTRUCTION DU PION PATTERN_5
      System.out.println("Nombre de victimes : " + TokenP.getVictime());
      System.out.println("Nombre de Tokens : " + g.p[0].getNbToken());
      System.out.println("Pattern 5 ? " + g.p[0].getToken(5));
      System.out.println("Out ? " + !g.getTokenOutside().isEmpty() );
      // TEST DESTRUCTION DU PION PATTERN_5
    }
  }
}
