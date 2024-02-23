void histoire() {
  if (ecranHistoire == 0) {

    prelude.play();
    // 1ère boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Tout commence dans le village de NOMVILLAGE,", 445, 520);
    text("un petit village médiéval réputé pour son donjon", 445, 550);
    text("qui habiterai des esprits maléfiques...", 445, 580);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 1) {

    // 2ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Ce petit village était composé d'habitations,", 445, 520);
    text("d'épiceries, et d'un château.", 445, 550);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 2) {

    // 3ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Le hero, " + nomHero + ", est un ami de la princesse du", 445, 520);
    text("château. Victoire, la princesse, a voulu partir", 445, 550);
    text("découvrir ce qui se cachait au sommet du donjon.", 445, 580);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 3) {
    
    // 4ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Passionnée par le paranormal, et soûlé par " + nomHero + ",", 445, 520);
    text("elle est partit seule, pour savoir la vérité.", 445, 550);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 4) {
    
    // 5ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Vous vous réveiller alors qu'elle est déjà partit, parce que vous vous", 445, 520);
    text("êtes couché trop tard hier soir, et vous sentez que ça va mal se passer,", 445, 550);
    text("vous courrez à son secours mais, un labyrinthe se présente à vous.", 445, 580);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 5) {

    // 1ère map
    map();
    hero.apparaitre();
    if (mapActive == false) {
      hero.replacerMap1();
      mapActive = true;
    }
    if (mapActive == true) {
      lignes = loadStrings("map/map1.txt");
    }
  } else if (ecranHistoire == 6) {
    
    // 6ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Toujours pas de trace de Victoire...", 445, 520);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 7) {
    
    // 7ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Peut-être est-elle déjà au 2ème étage...", 445, 520);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 8) {
    
    // 2ème map
    map();
    hero.apparaitre();
    if (mapActive == false) {
      hero.replacerMap2();
      mapActive = true;
    }
    if (mapActive == true) {
      lignes = loadStrings("map/map2.txt");
    }
  } else if (ecranHistoire == 9) {
    
    // 8ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Vous arrivez au 3ème étage et...", 445, 520);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 10) {
    
    // 9ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Des squelettes en armures ?", 445, 520);
    text("Peut-être que la princesse est passée par là", 445, 550);
    text("et a réveillé les esprits qui ont pris possession des squelettes...", 445, 580);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 11) {
    
    // 3ème map
    map();
    hero.apparaitre();
    deplacerEnnemies();
    collisionEnnemies();
    if (mapActive == false) {
      hero.replacerMap4();
      mapActive = true;
    }
    if (mapActive == true) {
      lignes = loadStrings("map/map4.txt");
    }
  } else if (ecranHistoire == 12) {

    // 10ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Vous arrivez au 4ème étage...", 445, 520);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 13) {
    
    // 4ème map
    map();
    hero.apparaitre();
    if (mapActive == false) {
      hero.replacerMap3();
      mapActive = true;
    }
    if (mapActive == true) {
      lignes = loadStrings("map/map3.txt");
    }
  } else if (ecranHistoire == 14) {

    // 11ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Vous arrivez au 5ème et dernier étage...", 445, 520);
    text("On peut apercevoir un esprit qui s'est matérialisé de lui-même,", 445, 550);
    text("comme s'il avait crée tout seul son propre corps.", 445, 580);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 15) {
    
    // 5ème map
    map();
    hero.apparaitre();
    deplacerBoss();
    collisionBoss();
    if (mapActive == false) {
      hero.replacerMap5();
      mapActive = true;
    }
    if (mapActive == true) {
      lignes = loadStrings("map/map5.txt");
    }
  } else if (ecranHistoire == 16) {

    // 12ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Vous avez réussi à aller au sommet de la tour", 445, 520);
    text("et à enfermer l'esprit matérialisé au 5ème étage.", 445, 550);
    text("Puis votre regard se croise avec celui de la princesse...", 445, 580);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 17) {

    // 13ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Elle est dans une cage !", 445, 520);
    text("Avec assez d'espace pour ne pas dormir confortablement", 445, 550);
    text("en attendant un valeureux chevalier.", 445, 580);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 18) {

    // 14ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Victoire : Oh non pas toi ! je voulais que ce soit quelqu'un", 445, 520);
    text("d'autre qui vienne me sauver !", 445, 550);
    text("Pas un lourd comme toi !", 445, 580);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 19) {

    // 15ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Victoire : Bon ok délivres-moi maintenant !", 445, 520);
    text(nomHero + " : j'y gagne quoi ?", 445, 550);
    text("Victoire : Je ne sais pas...", 445, 580);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 20) {

    // 16ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text(nomHero + " : Ce n'est pas grave j'arrive quand même.", 445, 520);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 21) {

    // 17ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Victoire : Merci je t'adore.", 445, 520);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 22) {

    // 18ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text(nomHero + " : On peut dire que c'est une Victoire !", 445, 520);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 23) {

    // 19ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Vous vous êtes pris une claque...", 445, 520);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 24) {

    // 20ème boite de dialogue
    fill(192, 192, 192, 130);
    rect(422, 480, 1076, 120);
    fill(0);
    textSize(30);
    text("Victoire : Bon, retournons à NOMVILLAGE, j'ai vu ce que je voulais voir.", 445, 520);
    fill(255);
    rect(1720, 990, 200, 90);
  } else if (ecranHistoire == 25) {

    // Fin
    textSize(100);
    text("FIN", 880, 540);
    prelude.pause();
    prelude.rewind();
  }
}