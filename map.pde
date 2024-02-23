void map() {
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