import ddf.minim.*;
import ddf.minim.analysis.*;
import ddf.minim.effects.*;
import ddf.minim.signals.*;
import ddf.minim.spi.*;
import ddf.minim.ugens.*;
Minim minim;
AudioPlayer musiqueModeArcade;
AudioPlayer bouton;
AudioPlayer musiqueEcranTitre;
AudioPlayer pain;
AudioPlayer victoire;
AudioPlayer prelude;
void setup() {
  fullScreen();
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
void draw() {
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
void mousePressed() {
  boutons();
}
void keyPressed() {
  touches();
  hero.deplacer();
}
void stop() {
  minim.stop();
  super.stop();
}
