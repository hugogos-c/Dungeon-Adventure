class Ennemie {
  PImage squeletteImage;
  int x;
  int y;
  int vitesse = 36;
  int aleatoire;
  color pixel;
  float r;
  float g;
  float b;
  Ennemie (String imageSquelette, int pex, int pey) {
    squeletteImage = loadImage(imageSquelette);
    x = pex;
    y = pey;
  }
  void squelette() {
    image(squeletteImage, x, y, 36, 36);
  }

  // Prend une direction aléatoire
  void aleatoire() {
    aleatoire = int(random(0, 100)) % 4;
  }

  // Récupère les couleurs des pixels autour des ennemies
  void verifier() {
    r = red(pixel);
    g = green(pixel);
    b = blue(pixel);
  }

  // Autoriser à bouger d'une case si elle n'est pas de couleur noire
  void deplacer() {
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
  int positionX() {
    return x;
  }

  // Retourne la position y des ennemies
  int positionY() {
    return y;
  }
};