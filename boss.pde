class Boss {
  PImage bossImage;
  int x;
  int y;
  int vitesse = 36;
  int aleatoire;
  color pixelA;
  color pixelB;
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
  void apparaitre() {
    image(bossImage, x, y, 54, 54);
  }

  // Prend une direction aléatoire
  void aleatoire() {
    aleatoire = int(random(0, 100)) % 4;
  }

  // Récupère les couleurs des pixels autour du boss
  void verifier() {
    rA = red(pixelA);
    gA = green(pixelA);
    bA = blue(pixelA);
    rB = red(pixelB);
    gB = green(pixelB);
    bB = blue(pixelB);
  }

  // Aller en haut
  void haut() {
    y = y - vitesse;
  }

  // Aller à gauche
  void gauche() {
    x = x - vitesse;
  }

  // Aller en bas
  void bas() {
    y = y + vitesse;
  }

  // Aller à droite
  void droite() {
    x = x + vitesse;
  }

  // Autoriser à bouger d'une case si elle n'est pas de couleur noire
  void deplacer() {
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
  int positionX() {
    return x;
  }

  // Retourne la position y du boss
  int positionY() {
    return y;
  }
};