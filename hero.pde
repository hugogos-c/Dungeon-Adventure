class Hero {
  PImage heroImage;
  PImage ennemie;
  int x;
  int y;
  int vitesse = 18;
  color pixelA;
  color pixelB;
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
  void apparaitre() {
    image(heroImage, x + 5, y + 1, 26, 34);
  }

  // Replace le hero quand il est dans le menu
  void replacerMenu() {
    x = 942;
    y = 522;
  }

  // Replace le hero quand il est dans la map1
  void replacerMap1() {
    x = 1356;
    y = 1008;
  }
  // Replace le hero quand il est dans la map2
  void replacerMap2() {
    x = 528;
    y = 1008;
  }
  // Replace le hero quand il est dans la map3
  void replacerMap3() {
    x = 492;
    y = 648;
  }
  // Replace le hero quand il est dans la map4
  void replacerMap4() {
    x = 1356;
    y = 1008;
  }
  // Replace le hero quand il est dans la map5
  void replacerMap5() {
    x = 1356;
    y = 1008;
  }

  // Récupère les couleurs des pixels autour du hero
  void verifier() {
    rA = red(pixelA);
    gA = green(pixelA);
    bA = blue(pixelA);
    rB = red(pixelB);
    gB = green(pixelB);
    bB = blue(pixelB);
  }

  // Autoriser à bouger d'une case si la touche correspondante est pressée et si elle n'est pas de couleur noire
  void deplacer() {
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
  int positionX() {
    return x;
  }

  // Retourne la position y du hero
  int positionY() {
    return y;
  }
}