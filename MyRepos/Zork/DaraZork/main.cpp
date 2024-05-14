
#include "mainwindow.h"
#include <QApplication>
#include <iostream>
#include "gamemanager.h"

using namespace std;

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    MainWindow w;

    w.setFixedSize(910, 520);
    w.show();

    GameManager gameManager;
    gameManager.setUpNewGame();

    return a.exec();
}




