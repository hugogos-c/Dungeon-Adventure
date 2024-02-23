import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import ddf.minim.*; 
import ddf.minim.analysis.*; 
import ddf.minim.effects.*; 
import ddf.minim.signals.*; 
import ddf.minim.spi.*; 
import ddf.minim.ugens.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class dungeonAdventure extends PApplet {







Minim minim;
AudioPlayer musiqueModeArcade;
AudioPlayer bouton;
AudioPlayer musiqueEcranTitre;
AudioPlayer pain;
AudioPlayer victoire;
AudioPlayer prelude;
public void setup() {
  
  minim = new Minim(this);
  musiqueModeArcade = minim.loadFile("music/musiqueModeArcade.mp3", 2048);
  bouton = minim.loadFile("music/bouton.wav");
  musiqueEcranTitre = minim.loadFile("music/musiqueEcranTitre.wav");
  pain = minim.loadFile("music/pain.wav");
  victoire = minim.loadFile("music/victoire.wav");
  prelude = minim.loadFile("music/prelude.mp3");
  hero = new Hero("images/hero.png", 942, 522);
  boss = new Boss("images/boss.png", 924, 468);
  ennemie = new Ennemie[7];
  ennemie[0] = new Ennemie("images/squelette.png", 1356, 108);
  ennemie[1] = new Ennemie("images/squelette.png", 780, 468);
  ennemie[2] = new Ennemie("images/squelette.png", 528, 936);
  ennemie[3] = new Ennemie("images/squelette.png", 528, 180);
  ennemie[4] = new Ennemie("images/squelette.png", 1356, 432);
  ennemie[5] = new Ennemie("images/squelette.png", 816, 972);
  ennemie[6] = new Ennemie("images/squelette.png", 1176, 792);
  chargerImages();
}
public void draw() {
  background(fond);

  // Écran titre
  if (ecranTitre == true) {
    musiqueEcranTitre.play();
    image(dungeonAdventure, 720, 300, 480, 155);
    image(start, 910, 550, 100, 100);
    image(quitter, 847, 680, 225, 72);
  }

  // Menu
  else if (zoneHistoire == false && zoneArcade == false && ecranTitre == false) {
    musiqueEcranTitre.play();
    lignes = loadStrings("map/start.txt");
    map();
    fill(192, 192, 192, 130);
    rect(68, 120, 320, 100);
    textSize(20);
    fill(0);
    text("Deplacez-vous avec ZQSD,", 78, 145);
    text("aller dans une zone et", 78, 165);
    text("appuyer sur F pour aller dans", 78, 185);
    text("le mode que vous voulez !", 78, 205);
    image(histoire, 492, 72, 252, 180);
    image(arcade, 1176, 72, 252, 180);
    image(titre, 492, 864, 288, 144);
    hero.apparaitre();
  }

  // Mode histoire
  else if (zoneHistoire == true) {
    histoire();
  }
  
  // Mode arcade
  else if (zoneArcade == true) {
    if (explicationArcade == true) {
      fill(192, 192, 192, 130);
      rect(560, 240, 800, 600);
      fill(0);
      textSize(30);
      text("Objectif :", 900, 400);
      text("Terminer toutes les maps pour", 730, 520);
      text("arriver à la fin", 870, 550);
      textSize(20);
      text("Appuyer sur F pour continuer", 830, 770);
    } else {
      map();
      arcade();
    }
  }
}
public void mousePressed() {
  boutons();
}
public void keyPressed() {
  touches();
  hero.deplacer();
}
public void stop() {
  minim.stop();
  super.stop();
}
public void arcade() {
  fill(255);
  text("Vie(s) : " + vies, 1564, 120);
  if (vies >= 1 && vies <= 3) {
    musiqueModeArcade.play();
    hero.apparaitre();
    // Map 1
    if (aleatoire == 0) {
      if (map1 == false) {
        if (mapActive == false) {
          hero.replacerMap1();
          mapActive = true;
        }
        if (mapActive == true) {
          lignes = loadStrings("map/map1.txt");
        }
      } else {
        aleatoire();
      }
    }
    // Map 2
    if (aleatoire == 1) {
      if (map2 == false) {
        if (mapActive == false) {
          hero.replacerMap2();
          mapActive = true;
        }
        if (mapActive == true) {
          lignes = loadStrings("map/map2.txt");
        }
      } else {
        aleatoire();
      }
    }
    // Map 3
    if (aleatoire == 2) {
      if (map3 == false) {
        if (mapActive == false) {
          hero.replacerMap3();
          mapActive = true;
        } else {
          lignes = loadStrings("map/map3.txt");
        }
      } else {
        aleatoire();
      }
    }
    // Map 4
    if (aleatoire == 3) {
      if (map4 == false) {
        if (mapActive == false) {
          hero.replacerMap4();
          mapActive = true;
        } else {
          deplacerEnnemies();
          collisionEnnemies();
          lignes = loadStrings("map/map4.txt");
        }
      } else {
        aleatoire();
      }
    }
    // Map 5
    if (aleatoire == 4) {
      if (map5 == false) {
        if (mapActive == false) {
          hero.replacerMap5();
          mapActive = true;
        } else {
          deplacerBoss();
          collisionBoss();
          lignes = loadStrings("map/map5.txt");
        }
      } else {
        aleatoire();
      }
    }
    if (map1 == true && map2 == true && map3 == true && map4 == true && map5 == true) {
      // Victoire
      musiqueModeArcade.rewind();
      musiqueModeArcade.pause();
      victoire.rewind();
      victoire.play();
      textSize(100);
      fill(255);
      text("Bravo !", 830, 540);
      textSize(20);
      text("Appuyer sur F pour continuer", 840, 600);
    }
  } else if (vies == 0) {
    // Défaite
    musiqueModeArcade.rewind();
    musiqueModeArcade.pause();
    textSize(100);
    fill(255);
    text("Vous avez péri !", 580, 540);
    textSize(20);
    text("Appuyer sur F pour continuer", 840, 600);
  }
}
public void aleatoire() {
  aleatoire = PApplet.parseInt(random(0, 100)) % 5;
}
class Boss {
  PImage bossImage;
  int x;
  int y;
  int vitesse = 36;
  int aleatoire;
  int pixelA;
  int pixelB;
  float rA;
  float gA;
  float bA;
  float rB;
  float gB;
  float bB;
  Boss (String imageBoss, int pbx, int pby) {
    bossImage = loadImage(imageBoss);
    x = pbx;
    y = pby;
  }
  public void apparaitre() {
    image(bossImage, x, y, 54, 54);
  }

  // Prend une direction aléatoire
  public void aleatoire() {
    aleatoire = PApplet.parseInt(random(0, 100)) % 4;
  }

  // Récupère les couleurs des pixels autour du boss
  public void verifier() {
    rA = red(pixelA);
    gA = green(pixelA);
    bA = blue(pixelA);
    rB = red(pixelB);
    gB = green(pixelB);
    bB = blue(pixelB);
  }

  // Aller en haut
  public void haut() {
    y = y - vitesse;
  }

  // Aller à gauche
  public void gauche() {
    x = x - vitesse;
  }

  // Aller en bas
  public void bas() {
    y = y + vitesse;
  }

  // Aller à droite
  public void droite() {
    x = x + vitesse;
  }

  // Autoriser à bouger d'une case si elle n'est pas de couleur noire
  public void deplacer() {
    pixelA = get(x + 18, y - 1);
    pixelB = get(x + 54, y - 1);
    verifier();
    if ((rA != 0 && gA != 0 && bA != 0) && (rB != 0 && gB != 0 && bB != 0)) {
      if (hero.positionY() - y < 0) {
        y = y - vitesse;
      }
    }
    pixelA = get(x - 1, y + 18);
    pixelB = get(x - 1, y + 54);
    verifier();
    if ((rA != 0 && gA != 0 && bA != 0) && (rB != 0 && gB != 0 && bB != 0)) {
      if (hero.positionX() - boss.positionX() < 0) {
        x = x - vitesse;
      }
    }
    pixelA = get(x + 18, y + 73);
    pixelB = get(x + 54, y + 73);
    verifier();
    if ((rA != 0 && gA != 0 && bA != 0) && (rB != 0 && gB != 0 && bB != 0)) {
      if (hero.positionX() - boss.positionX() > 0) {
        y = y + vitesse;
      }
    }
    pixelA = get(x + 73, y + 18);
    pixelB = get(x + 73, y + 54);
    verifier();
    if ((rA != 0 && gA != 0 && bA != 0) && (rB != 0 && gB != 0 && bB != 0)) {
      if (hero.positionY() - boss.positionY() > 0) {
        x = x + vitesse;
      }
    }
  }

  // Retourne la position x du boss
  public int positionX() {
    return x;
  }

  // Retourne la position y du boss
  public int positionY() {
    return y;
  }
};
public void boutons() {
  if (mouseButton == LEFT) {

    // Écran titre
    if (mouseX > 910 && mouseX < 1010 && mouseY > 550 && mouseY < 650) {
      if (ecranTitre == true) {
        bouton.rewind();
        bouton.play();
        hero.replacerMenu();
        ecranTitre = false;
      }
    }

    // Bouton suivant du mode histoire
    if (zoneHistoire == true) {
      if (ecranHistoire == 0) {
        bouton.rewind();
        bouton.play();
        ecranHistoire = 1;
      } else if (ecranHistoire == 1) {
        bouton.rewind();
        bouton.play();
        ecranHistoire = 2;
      } else if (ecranHistoire == 2) {
        bouton.rewind();
        bouton.play();
        ecranHistoire = 3;
      } else if (ecranHistoire == 3) {
        bouton.rewind();
        bouton.play();
        ecranHistoire = 4;
      } else if (ecranHistoire == 4) {
        bouton.rewind();
        bouton.play();
        ecranHistoire = 5;
      } else if (ecranHistoire == 6) {
        bouton.rewind();
        bouton.play();
        ecranHistoire = 7;
      } else if (ecranHistoire == 7) {
        bouton.rewind();
        bouton.play();
        ecranHistoire = 8;
      } else if (ecranHistoire == 9) {
        bouton.rewind();
        bouton.play();
        ecranHistoire = 10;
      } else if (ecranHistoire == 10) {
        bouton.rewind();
        bouton.play();
        ecranHistoire = 11;
      } else if (ecranHistoire == 12) {
        bouton.rewind();
        bouton.play();
        ecranHistoire = 13;
      } else if (ecranHistoire == 14) {
        bouton.rewind();
        bouton.play();
        ecranHistoire = 15;
      } else if (ecranHistoire == 16) {
        bouton.rewind();
        bouton.play();
        ecranHistoire = 17;
      } else if (ecranHistoire == 17) {
        bouton.rewind();
        bouton.play();
        ecranHistoire = 18;
      } else if (ecranHistoire == 18) {
        bouton.rewind();
        bouton.play();
        ecranHistoire = 19;
      } else if (ecranHistoire == 19) {
        bouton.rewind();
        bouton.play();
        ecranHistoire = 20;
      } else if (ecranHistoire == 20) {
        bouton.rewind();
        bouton.play();
        ecranHistoire = 21;
      } else if (ecranHistoire == 21) {
        bouton.rewind();
        bouton.play();
        ecranHistoire = 22;
      } else if (ecranHistoire == 22) {
        bouton.rewind();
        bouton.play();
        ecranHistoire = 23;
      } else if (ecranHistoire == 23) {
        bouton.rewind();
        bouton.play();
        ecranHistoire = 24;
      } else if (ecranHistoire == 24) {
        bouton.rewind();
        bouton.play();
        ecranHistoire = 25;
      } else if (ecranHistoire == 25) {
        bouton.rewind();
        bouton.play();
        ecranHistoire = 0;
        zoneHistoire = false;
        hero.replacerMenu();
      }
    }

    // Bouton quitter
    if (ecranTitre == true) {
      if (mouseX > 847 && mouseX < 1073 && mouseY > 680 && mouseY < 752) {
        exit();
      }
    }
  }
}
public void touches() {
  if (zoneHistoire == false && zoneArcade == false) {
    if (key == 'f' || key == 'F') {
      // Aller dans le mode histoire
      if (hero.positionX() > 474 && hero.positionX() < 726 && hero.positionY() > 54 && hero.positionY() < 234) {
        musiqueEcranTitre.pause();
        musiqueEcranTitre.rewind();
        bouton.rewind();
        bouton.play();
        zoneHistoire = true;
        map1 = false;
        map2 = false;
        map3 = false;
        map4 = false;
        map5 = false;
      } else {
        zoneHistoire = false;
      }
      // Aller dans le mode arcade
      if (hero.positionX() > 1158 && hero.positionX() < 1410 && hero.positionY() > 54 && hero.positionY() < 234) {
        musiqueEcranTitre.pause();
        musiqueEcranTitre.rewind();
        bouton.rewind();
        bouton.play();
        zoneArcade = true;
        explicationArcade = true;
        map1 = false;
        map2 = false;
        map3 = false;
        map4 = false;
        map5 = false;
        aleatoire();
      } else {
        zoneArcade = false;
      }
      // Retourner à l'écran titre
      if (hero.positionX() > 474 && hero.positionX() < 762 && hero.positionY() > 858 && hero.positionY() < 984) {
        bouton.rewind();
        bouton.play();
        ecranTitre = true;
      }
    }
  }

  // Mode histoire
  else if (zoneHistoire == true) {
    // Map 1 (labyrinthe)
    if (map1 == false) {
      if (mapActive == true) {
        if (key == 'z' || key == 'Z') {
          if (hero.positionX() > 510 && hero.positionX() < 546 && hero.positionY() > 18 && hero.positionY() < 54) {
            mapActive = false;
            ecranHistoire = 6;
            map1 = true;
          }
        }
      }
    }
    // Map 2 (labyrinthe)
    if (map2 == false) {
      if (mapActive == true) {
        if (key == 'z' || key == 'Z') {
          if (hero.positionX() > 1194 && hero.positionX() < 1230 && hero.positionY() > 198 && hero.positionY() < 234) {
            mapActive = false;
            ecranHistoire = 9;
            map2 = true;
          }
        }
      }
    }
    // Map 3 (squelettes)
    if (map4 == false) {
      if (mapActive == true) {
        if (key == 'z' || key == 'Z') {
          if (hero.positionX() > 510 && hero.positionX() < 546 && hero.positionY() > 18 && hero.positionY() < 54) {
            mapActive = false;
            ecranHistoire = 12;
            map4 = true;
          }
        }
      }
    }
    // Map 4 (labyrinthe)
    if (map3 == false) {
      if (mapActive == true) {
        if (key == 'z' || key == 'Z') {
          if (hero.positionX() > 618 && hero.positionX() < 654 && hero.positionY() > 270 && hero.positionY() < 306) {
            mapActive = false;
            ecranHistoire = 14;
            map3 = true;
          }
        }
      }
    }
    // Map 5 (boss)
    if (map5 == false) {
      if (mapActive == true) {
        if (key == 'z' || key == 'Z') {
          if (hero.positionX() > 510 && hero.positionX() < 546 && hero.positionY() > 18 && hero.positionY() < 54) {
            mapActive = false;
            ecranHistoire = 16;
            map5 = true;
          }
        }
      }
    }
  }

  // Mode arcade
  else if (zoneArcade == true) {
    if (explicationArcade == true && (key == 'f' || key == 'F')) {
      vies = 3;
      bouton.rewind();
      bouton.play();
      explicationArcade = false;
    } else {
      if (key == 'z' || key == 'Z') {
        // Map 1 (labyrinthe)
        if (aleatoire == 0) {
          if (map1 == false && mapActive == true) {
            if (hero.positionX() > 510 && hero.positionX() < 546 && hero.positionY() > 18 && hero.positionY() < 54) {
              map1 = true;
              mapActive = false;
              aleatoire();
            }
          }
        }
        // Map 2 (labyrinthe)
        if (aleatoire == 1) {
          if (map2 == false && mapActive == true) {
            if (hero.positionX() > 1194 && hero.positionX() < 1230 && hero.positionY() > 198 && hero.positionY() < 234) {
              map2 = true;
              mapActive = false;
              aleatoire();
            }
          }
        }
        // Map 3 (labyrinthe)
        if (aleatoire == 2) {
          if (map3 == false && mapActive == true) {
            if (hero.positionX() > 618 && hero.positionX() < 654 && hero.positionY() > 270 && hero.positionY() < 306) {
              map3 = true;
              mapActive = false;
              aleatoire();
            }
          }
        }
        // Map 4 (squelettes)
        if (aleatoire == 3) {
          if (map4 == false && mapActive == true) {
            if (hero.positionX() > 510 && hero.positionX() < 546 && hero.positionY() > 18 && hero.positionY() < 54) {
              map4 = true;
              mapActive = false;
              aleatoire();
            }
          }
        }
        // Map 5 (boss)
        if (aleatoire == 4) {
          if (map5 == false && mapActive == true) {
            if (hero.positionX() > 510 && hero.positionX() < 546 && hero.positionY() > 18 && hero.positionY() < 54) {
              map5 = true;
              mapActive = false;
              aleatoire();
            }
          }
        }
      }
      if (key == 'f' || key == 'F') {
        // Fin
        if (map1 == true && map2 == true && map3 == true && map4 == true && map5 == true) {
          zoneArcade = false;
          hero.replacerMenu();
        }
        if (vies == 0) {
          zoneArcade = false;
          hero.replacerMenu();
        }
      }
    }
  }
}
public void collisionEnnemies() {
  for (int i = 0; i < ennemie.length; ++i) {
    if (hero.positionX() >= ennemie[i].positionX() - 18 && hero.positionX() <= ennemie[i].positionX() + 18) {
      if (hero.positionY() >= ennemie[i].positionY() - 18 && hero.positionY() <= ennemie[i].positionY() + 18) {
        hero.replacerMap4();
        vies = vies - 1;
        pain.rewind();
        pain.play();
      }
    }
  }
}
public void collisionBoss() {
  if (hero.positionX() >= boss.positionX() - 18 && hero.positionX() <= boss.positionX() + 18) {
    if (hero.positionY() >= boss.positionY() - 36 && hero.positionY() <= boss.positionY() + 36) {
      hero.replacerMap5();
      vies = vies - 1;
      pain.rewind();
      pain.play();
    }
  }
}
public void deplacerEnnemies() {

  // Dessine les ennemies
  for (int i = 0; i < ennemie.length; ++i) {
    ennemie[i].squelette();
  }

  // Condition pour changer de direction toutes les 3s
  if (millis() % 30 == 0) {
    for (int i = 0; i < ennemie.length; ++i) {
      ennemie[i].aleatoire();
    }
  }

  // Déplace les ennemies dans la direction dicté ci-dessus
  if (frameCount % 6 == 0) {
    for (int i = 0; i < ennemie.length; ++i) {
      ennemie[i].deplacer();
    }
  }
}
public void deplacerBoss() {

  // Dessine le boss
  boss.apparaitre();

  // Déplace le boss dans la direction dicté ci-dessus
  if (frameCount % 16 == 0) {
    boss.deplacer();
  }
}
class Ennemie {
  PImage squeletteImage;
  int x;
  int y;
  int vitesse = 36;
  int aleatoire;
  int pixel;
  float r;
  float g;
  float b;
  Ennemie (String imageSquelette, int pex, int pey) {
    squeletteImage = loadImage(imageSquelette);
    x = pex;
    y = pey;
  }
  public void squelette() {
    image(squeletteImage, x, y, 36, 36);
  }

  // Prend une direction aléatoire
  public void aleatoire() {
    aleatoire = PApplet.parseInt(random(0, 100)) % 4;
  }

  // Récupère les couleurs des pixels autour des ennemies
  public void verifier() {
    r = red(pixel);
    g = green(pixel);
    b = blue(pixel);
  }

  // Autoriser à bouger d'une case si elle n'est pas de couleur noire
  public void deplacer() {
    if (aleatoire == 0) {
        pixel = get(x + 18, y - 1);
        verifier();
      if (r != 0 && g != 0 && b != 0) {
        y = y - vitesse;
      }
      else {
        aleatoire();
      }
    }
    if (aleatoire == 1) {
        pixel = get(x - 1, y + 18);
        verifier();
      if (r != 0 && g != 0 && b != 0) {
        x = x - vitesse;
      }
      else {
        aleatoire();
      }
    }
    if (aleatoire == 2) {
        pixel = get(x + 18, y + 37);
        verifier();
      if (r != 0 && g != 0 && b != 0) {
        y = y + vitesse;
      }
      else {
        aleatoire();
      }
    }
    if (aleatoire == 3) {
        pixel = get(x + 37, y + 18);
        verifier();
      if (r != 0 && g != 0 && b != 0) {
        x = x + vitesse;
      }
      else {
        aleatoire();
      }
    }
  }
  
  // Retourne la position x des ennemies
  public int positionX() {
    return x;
  }

  // Retourne la position y des ennemies
  public int positionY() {
    return y;
  }
};
class Hero {
  PImage heroImage;
  PImage ennemie;
  int x;
  int y;
  int vitesse = 18;
  int pixelA;
  int pixelB;
  float rA;
  float gA;
  float bA;
  float rB;
  float gB;
  float bB;
  boolean zoneHistoire = false;
  boolean zoneArcade = false;
  Hero (String imageHero, int phx, int phy) {
    heroImage = loadImage(imageHero);
    x = phx;
    y = phy;
  }

  // Fait apparaitre le hero
  public void apparaitre() {
    image(heroImage, x + 5, y + 1, 26, 34);
  }

  // Replace le hero quand il est dans le menu
  public void replacerMenu() {
    x = 942;
    y = 522;
  }

  // Replace le hero quand il est dans la map1
  public void replacerMap1() {
    x = 1356;
    y = 1008;
  }
  // Replace le hero quand il est dans la map2
  public void replacerMap2() {
    x = 528;
    y = 1008;
  }
  // Replace le hero quand il est dans la map3
  public void replacerMap3() {
    x = 492;
    y = 648;
  }
  // Replace le hero quand il est dans la map4
  public void replacerMap4() {
    x = 1356;
    y = 1008;
  }
  // Replace le hero quand il est dans la map5
  public void replacerMap5() {
    x = 1356;
    y = 1008;
  }

  // Récupère les couleurs des pixels autour du hero
  public void verifier() {
    rA = red(pixelA);
    gA = green(pixelA);
    bA = blue(pixelA);
    rB = red(pixelB);
    gB = green(pixelB);
    bB = blue(pixelB);
  }

  // Autoriser à bouger d'une case si la touche correspondante est pressée et si elle n'est pas de couleur noire
  public void deplacer() {
    if (keyPressed) {
      if (key == 'z' || key == 'Z') {
        pixelA = get(x + 9, y - 1);
        pixelB = get(x + 27, y - 1);
        verifier();
        if ((rA != 0 && gA != 0 && bA != 0) && (rB != 0 && gB != 0 && bB != 0)) {
          y = y - vitesse;
        }
      }
      if (key == 'q' || key == 'Q') {
        pixelA = get(x - 1, y + 9);
        pixelB = get(x - 1, y + 27);
        verifier();
        if ((rA != 0 && gA != 0 && bA != 0) && (rB != 0 && gB != 0 && bB != 0)) {
          x = x - vitesse;
        }
      }
      if (key == 's' || key == 'S') {
        pixelA = get(x + 9, y + 37);
        pixelB = get(x + 27, y + 37);
        verifier();
        if ((rA != 0 && gA != 0 && bA != 0) && (rB != 0 && gB != 0 && bB != 0)) {
          y = y + vitesse;
        }
      }
      if (key == 'd' || key == 'D') {
        pixelA = get(x + 37, y + 9);
        pixelB = get(x + 37, y + 27);
        verifier();
        if ((rA != 0 && gA != 0 && bA != 0) && (rB != 0 && gB != 0 && bB != 0)) {
          x = x + vitesse;
        }
      }
    }
  }

  // Retourne la position x du hero
  public int positionX() {
    return x;
  }

  // Retourne la position y du hero
  public int positionY() {
    return y;
  }
}
public void histoire() {
  if (ecranHistoire == 0) {

    prelude.play();
    // 1ère boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Tout commence dans le village de NOMVILLAGE,", 445, 520);
    text("un petit village médiéval réputé pour son donjon", 445, 550);
    text("qui habiterai des esprits maléfiques...", 445, 580);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 1) {

    // 2ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Ce petit village était composé d'habitations,", 445, 520);
    text("d'épiceries, et d'un château.", 445, 550);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 2) {

    // 3ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Le hero, " + nomHero + ", est un ami de la princesse du", 445, 520);
    text("château. Victoire, la princesse, a voulu partir", 445, 550);
    text("découvrir ce qui se cachait au sommet du donjon.", 445, 580);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 3) {
    
    // 4ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Passionnée par le paranormal, et soûlé par " + nomHero + ",", 445, 520);
    text("elle est partit seule, pour savoir la vérité.", 445, 550);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 4) {
    
    // 5ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Vous vous réveiller alors qu'elle est déjà partit, parce que vous vous", 445, 520);
    text("êtes couché trop tard hier soir, et vous sentez que ça va mal se passer,", 445, 550);
    text("vous courrez à son secours mais, un labyrinthe se présente à vous.", 445, 580);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 5) {

    // 1ère map
    map();
    hero.apparaitre();
    if (mapActive == false) {
      hero.replacerMap1();
      mapActive = true;
    }
    if (mapActive == true) {
      lignes = loadStrings("map/map1.txt");
    }
  } else if (ecranHistoire == 6) {
    
    // 6ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Toujours pas de trace de Victoire...", 445, 520);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 7) {
    
    // 7ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Peut-être est-elle déjà au 2ème étage...", 445, 520);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 8) {
    
    // 2ème map
    map();
    hero.apparaitre();
    if (mapActive == false) {
      hero.replacerMap2();
      mapActive = true;
    }
    if (mapActive == true) {
      lignes = loadStrings("map/map2.txt");
    }
  } else if (ecranHistoire == 9) {
    
    // 8ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Vous arrivez au 3ème étage et...", 445, 520);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 10) {
    
    // 9ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Des squelettes en armures ?", 445, 520);
    text("Peut-être que la princesse est passée par là", 445, 550);
    text("et a réveillé les esprits qui ont pris possession des squelettes...", 445, 580);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 11) {
    
    // 3ème map
    map();
    hero.apparaitre();
    deplacerEnnemies();
    collisionEnnemies();
    if (mapActive == false) {
      hero.replacerMap4();
      mapActive = true;
    }
    if (mapActive == true) {
      lignes = loadStrings("map/map4.txt");
    }
  } else if (ecranHistoire == 12) {

    // 10ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Vous arrivez au 4ème étage...", 445, 520);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 13) {
    
    // 4ème map
    map();
    hero.apparaitre();
    if (mapActive == false) {
      hero.replacerMap3();
      mapActive = true;
    }
    if (mapActive == true) {
      lignes = loadStrings("map/map3.txt");
    }
  } else if (ecranHistoire == 14) {

    // 11ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Vous arrivez au 5ème et dernier étage...", 445, 520);
    text("On peut apercevoir un esprit qui s'est matérialisé de lui-même,", 445, 550);
    text("comme s'il avait crée tout seul son propre corps.", 445, 580);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 15) {
    
    // 5ème map
    map();
    hero.apparaitre();
    deplacerBoss();
    collisionBoss();
    if (mapActive == false) {
      hero.replacerMap5();
      mapActive = true;
    }
    if (mapActive == true) {
      lignes = loadStrings("map/map5.txt");
    }
  } else if (ecranHistoire == 16) {

    // 12ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Vous avez réussi à aller au sommet de la tour", 445, 520);
    text("et à enfermer l'esprit matérialisé au 5ème étage.", 445, 550);
    text("Puis votre regard se croise avec celui de la princesse...", 445, 580);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 17) {

    // 13ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Elle est dans une cage !", 445, 520);
    text("Avec assez d'espace pour ne pas dormir confortablement", 445, 550);
    text("en attendant un valeureux chevalier.", 445, 580);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 18) {

    // 14ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Victoire : Oh non pas toi ! je voulais que ce soit quelqu'un", 445, 520);
    text("d'autre qui vienne me sauver !", 445, 550);
    text("Pas un lourd comme toi !", 445, 580);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 19) {

    // 15ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Victoire : Bon ok délivres-moi maintenant !", 445, 520);
    text(nomHero + " : j'y gagne quoi ?", 445, 550);
    text("Victoire : Je ne sais pas...", 445, 580);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 20) {

    // 16ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text(nomHero + " : Ce n'est pas grave j'arrive quand même.", 445, 520);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 21) {

    // 17ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Victoire : Merci je t'adore.", 445, 520);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 22) {

    // 18ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text(nomHero + " : On peut dire que c'est une Victoire !", 445, 520);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 23) {

    // 19ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Vous vous êtes pris une claque...", 445, 520);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 24) {

    // 20ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Victoire : Bon, retournons à NOMVILLAGE, j'ai vu ce que je voulais voir.", 445, 520);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 25) {

    // Fin
    textSize(100);
    text("FIN", 880, 540);
    prelude.pause();
    prelude.rewind();
  }
}
public void map() {
  int positionMapX = 456;
  int positionMapY = 36;
  int longueurCase = 36;

  // Boucle pour parcourir chaque ligne du fichier
  for (int i = 0; i < lignes.length; ++i) {

    // Boucle pour parcourir chaque caractère de chaque ligne
    // Boucle pour créer la map
    for (int j = 0; j < lignes[i].length(); ++j) {

      // Remplace les A par des murs
      if (lignes[i].charAt(j) == 'A') {
        image(mur1, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les B par des murs
      if (lignes[i].charAt(j) == 'B') {
        image(mur2, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les C par des murs
      if (lignes[i].charAt(j) == 'C') {
        image(mur3, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les D par des murs
      if (lignes[i].charAt(j) == 'D') {
        image(mur4, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les E par des murs
      if (lignes[i].charAt(j) == 'E') {
        image(mur5, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les F par des murs
      if (lignes[i].charAt(j) == 'F') {
        image(mur6, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les G par des murs
      if (lignes[i].charAt(j) == 'G') {
        image(mur7, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les H par des murs
      if (lignes[i].charAt(j) == 'H') {
        image(mur8, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les I par des murs
      if (lignes[i].charAt(j) == 'I') {
        image(mur9, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les J par des murs
      if (lignes[i].charAt(j) == 'J') {
        image(mur10, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les K par des murs
      if (lignes[i].charAt(j) == 'K') {
        image(mur11, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les L par des murs
      if (lignes[i].charAt(j) == 'L') {
        image(mur12, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les M par des murs
      if (lignes[i].charAt(j) == 'M') {
        image(mur13, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les N par des murs
      if (lignes[i].charAt(j) == 'N') {
        image(mur14, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les O par des murs
      if (lignes[i].charAt(j) == 'O') {
        image(mur15, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les P par des murs
      if (lignes[i].charAt(j) == 'P') {
        image(mur16, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les Q par des murs
      if (lignes[i].charAt(j) == 'Q') {
        image(mur17, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les R par des murs
      if (lignes[i].charAt(j) == 'R') {
        image(mur18, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les S par des murs
      if (lignes[i].charAt(j) == 'S') {
        image(mur19, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les T par des murs
      if (lignes[i].charAt(j) == 'T') {
        image(mur20, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les U par des murs
      if (lignes[i].charAt(j) == 'U') {
        image(mur21, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les V par des murs
      if (lignes[i].charAt(j) == 'V') {
        image(mur22, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les W par des murs
      if (lignes[i].charAt(j) == 'W') {
        image(mur23, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les X par des murs
      if (lignes[i].charAt(j) == 'X') {
        image(mur24, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les Y par des murs
      if (lignes[i].charAt(j) == 'Y') {
        image(mur25, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les Z par des murs
      if (lignes[i].charAt(j) == 'Z') {
        image(mur26, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les a par des murs
      if (lignes[i].charAt(j) == 'a') {
        image(mur27, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les b par des murs
      if (lignes[i].charAt(j) == 'b') {
        image(mur28, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les c par des murs
      if (lignes[i].charAt(j) == 'c') {
        image(mur29, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les d par des murs
      if (lignes[i].charAt(j) == 'd') {
        image(mur30, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les e par des murs
      if (lignes[i].charAt(j) == 'e') {
        image(mur31, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les f par des murs
      if (lignes[i].charAt(j) == 'f') {
        image(mur32, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les g par des murs
      if (lignes[i].charAt(j) == 'g') {
        image(mur33, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les h par des murs
      if (lignes[i].charAt(j) == 'h') {
        image(mur34, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les i par des murs
      if (lignes[i].charAt(j) == 'i') {
        image(mur35, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les j par des murs
      if (lignes[i].charAt(j) == 'j') {
        image(mur36, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les k par des murs
      if (lignes[i].charAt(j) == 'k') {
        image(mur37, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les l par des murs
      if (lignes[i].charAt(j) == 'l') {
        image(mur38, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les m par des murs
      if (lignes[i].charAt(j) == 'm') {
        image(mur39, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les n par des murs
      if (lignes[i].charAt(j) == 'n') {
        image(mur40, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les o par des murs
      if (lignes[i].charAt(j) == 'o') {
        image(mur41, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les p par des murs
      if (lignes[i].charAt(j) == 'p') {
        image(mur42, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les q par des murs
      if (lignes[i].charAt(j) == 'q') {
        image(mur43, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les r par des murs
      if (lignes[i].charAt(j) == 'r') {
        image(mur44, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les s par des murs
      if (lignes[i].charAt(j) == 's') {
        image(mur45, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les t par des murs
      if (lignes[i].charAt(j) == 't') {
        image(mur46, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les u par des murs
      if (lignes[i].charAt(j) == 'u') {
        image(mur47, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace les . par du plancher
      if (lignes[i].charAt(j) == '.') {
        image(plancher, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace le O par un escalier descendant
      if (lignes[i].charAt(j) == '0') {
        image(echelleDescendante, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
      // Remplace le 0 par un escalier montant
      if (lignes[i].charAt(j) == '1') {
        image(echelleMontante, j * longueurCase + positionMapX, i * longueurCase + positionMapY, longueurCase, longueurCase);
      }
    }
  }

  // Contour de la map
  stroke(0, 0, 0);
  strokeWeight(4);
  line(positionMapX, positionMapY, positionMapX, positionMapY + lignes.length * longueurCase);
  line(positionMapX, positionMapY, positionMapX + lignes.length * longueurCase, positionMapY);
  line(positionMapX + lignes.length * longueurCase, positionMapY, positionMapX + lignes.length * longueurCase, positionMapY + lignes.length * longueurCase);
  line(positionMapX, positionMapY + lignes.length * longueurCase, positionMapX + lignes.length * longueurCase, positionMapY + lignes.length * longueurCase);
}
PImage mur1;
PImage mur2;
PImage mur3;
PImage mur4;
PImage mur5;
PImage mur6;
PImage mur7;
PImage mur8;
PImage mur9;
PImage mur10;
PImage mur11;
PImage mur12;
PImage mur13;
PImage mur14;
PImage mur15;
PImage mur16;
PImage mur17;
PImage mur18;
PImage mur19;
PImage mur20;
PImage mur21;
PImage mur22;
PImage mur23;
PImage mur24;
PImage mur25;
PImage mur26;
PImage mur27;
PImage mur28;
PImage mur29;
PImage mur30;
PImage mur31;
PImage mur32;
PImage mur33;
PImage mur34;
PImage mur35;
PImage mur36;
PImage mur37;
PImage mur38;
PImage mur39;
PImage mur40;
PImage mur41;
PImage mur42;
PImage mur43;
PImage mur44;
PImage mur45;
PImage mur46;
PImage mur47;
PImage plancher;
PImage echelleDescendante;
PImage echelleMontante;
PImage start;
PImage quitter;
PImage histoire;
PImage arcade;
PImage titre;
PImage fond;
PImage dungeonAdventure;
Hero hero;
Boss boss;
Ennemie[] ennemie;
String[] lignes;
String nomHero = "NOMHERO";
int aleatoire;
int ecranHistoire = 0;
int vies;
boolean explicationArcade = false;
boolean map1 = false;
boolean map2 = false;
boolean map3 = false;
boolean map4 = false;
boolean map5 = false;
boolean mapActive = false;
boolean ecranTitre = true;
boolean zoneHistoire = false;
boolean zoneArcade = false;
public void chargerImages() {
  mur1 = loadImage("images/murs/mur1.png");
  mur2 = loadImage("images/murs/mur2.png");
  mur3 = loadImage("images/murs/mur3.png");
  mur4 = loadImage("images/murs/mur4.png");
  mur5 = loadImage("images/murs/mur5.png");
  mur6 = loadImage("images/murs/mur6.png");
  mur7 = loadImage("images/murs/mur7.png");
  mur8 = loadImage("images/murs/mur8.png");
  mur9 = loadImage("images/murs/mur9.png");
  mur10 = loadImage("images/murs/mur10.png");
  mur11 = loadImage("images/murs/mur11.png");
  mur12 = loadImage("images/murs/mur12.png");
  mur13 = loadImage("images/murs/mur13.png");
  mur14 = loadImage("images/murs/mur14.png");
  mur15 = loadImage("images/murs/mur15.png");
  mur16 = loadImage("images/murs/mur16.png");
  mur17 = loadImage("images/murs/mur17.png");
  mur18 = loadImage("images/murs/mur18.png");
  mur19 = loadImage("images/murs/mur19.png");
  mur20 = loadImage("images/murs/mur20.png");
  mur21 = loadImage("images/murs/mur21.png");
  mur22 = loadImage("images/murs/mur22.png");
  mur23 = loadImage("images/murs/mur23.png");
  mur24 = loadImage("images/murs/mur24.png");
  mur25 = loadImage("images/murs/mur25.png");
  mur26 = loadImage("images/murs/mur26.png");
  mur27 = loadImage("images/murs/mur27.png");
  mur28 = loadImage("images/murs/mur28.png");
  mur29 = loadImage("images/murs/mur29.png");
  mur30 = loadImage("images/murs/mur30.png");
  mur31 = loadImage("images/murs/mur31.png");
  mur32 = loadImage("images/murs/mur32.png");
  mur33 = loadImage("images/murs/mur33.png");
  mur34 = loadImage("images/murs/mur34.png");
  mur35 = loadImage("images/murs/mur35.png");
  mur36 = loadImage("images/murs/mur36.png");
  mur37 = loadImage("images/murs/mur37.png");
  mur38 = loadImage("images/murs/mur38.png");
  mur39 = loadImage("images/murs/mur39.png");
  mur40 = loadImage("images/murs/mur40.png");
  mur41 = loadImage("images/murs/mur41.png");
  mur42 = loadImage("images/murs/mur42.png");
  mur43 = loadImage("images/murs/mur43.png");
  mur44 = loadImage("images/murs/mur44.png");
  mur45 = loadImage("images/murs/mur45.png");
  mur46 = loadImage("images/murs/mur46.png");
  mur47 = loadImage("images/murs/mur47.png");
  plancher = loadImage("images/plancher.png");
  echelleDescendante = loadImage("images/echelleDescendante.png");
  echelleMontante = loadImage("images/echelleMontante.png");
  start = loadImage("images/start.png");
  quitter = loadImage("images/quitter.png");
  fond = loadImage("images/fond.jpg");
  histoire = loadImage("images/histoire.png");
  arcade = loadImage("images/arcade.png");
  titre = loadImage("images/titre.png");
  dungeonAdventure = loadImage("images/dungeonAdventure.png");
}
  public void settings() {  fullScreen(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "dungeonAdventure" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
