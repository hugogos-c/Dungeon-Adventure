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
void chargerImages() {
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
