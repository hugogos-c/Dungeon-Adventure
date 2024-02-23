void arcade() {
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
void aleatoire() {
  aleatoire = int(random(0, 100)) % 5;
}