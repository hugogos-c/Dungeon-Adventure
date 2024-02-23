void boutons() {
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
void touches() {
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