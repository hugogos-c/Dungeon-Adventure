void deplacerEnnemies() {

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
void deplacerBoss() {

  // Dessine le boss
  boss.apparaitre();

  // Déplace le boss dans la direction dicté ci-dessus
  if (frameCount % 16 == 0) {
    boss.deplacer();
  }
}
