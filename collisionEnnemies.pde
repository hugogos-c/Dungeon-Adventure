void collisionEnnemies() {
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
void collisionBoss() {
  if (hero.positionX() >= boss.positionX() - 18 && hero.positionX() <= boss.positionX() + 18) {
    if (hero.positionY() >= boss.positionY() - 36 && hero.positionY() <= boss.positionY() + 36) {
      hero.replacerMap5();
      vies = vies - 1;
      pain.rewind();
      pain.play();
    }
  }
}