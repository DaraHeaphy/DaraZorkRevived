 #include "gamemanager.h"
#include "game.h"
#include <iostream>
#include <QObject>

using namespace std;

GameManager::GameManager() {}

bool GameManager::setUpNewGame() {    
        Game game;
        cout <<  "Welcome to DARAZORK!" << endl;
        game.setCurrentLocationToStart();
        game.printAreaDescription();
         return true;
    }






