#include "mainwindow.h"
#include "ui_mainwindow.h"
#include <QPixmap>
#include <QPlainTextEdit>
#include <Qstring>
#include <QTextStream>
#include <iostream>
#include <QObject>
#include "movement.h"
#include "game.h"
#include "gamemanager.h"

using namespace std;

Movement movement;

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);

    // connect(&game, SIGNAL(transmit_to_gui(QString)), this, SLOT(receive_from_object(QString)));

    // connect(this, SIGNAL(transmit_to_object(bool)), &game, SLOT(receive_from_gui(bool)));

    connect(&game, &Game::areaDescriptionChanged, this, &MainWindow::update_gui_text);
    connect(&game, &Game::invalidDirection, this, &MainWindow::update_gui_text);

    QPlainTextEdit gameText;

}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::update_gui_text(const QString& description)
{
    ui->textEdit->setText(description);
}

void MainWindow::receive_from_object(QString output)
{
    if (!output.isEmpty())
    {
        ui->textEdit->setText("true");
    }
    else
    {
        ui->textEdit->setText("false");
    }
}

// void MainWindow::updateImage(const QString& locationId) {
//     QString imagePath = getLocationImagePath(locationId);
//     QPixmap image(imagePath);
//     ui->pix2->setPixmap(image);
// }

void MainWindow::on_northButton_clicked()
{
    movement.goNorth();
}

void MainWindow::on_southButton_clicked()
{
    movement.goSouth();
}

void MainWindow::on_eastButton_clicked()
{
    movement.goEast();
}

void MainWindow::on_westButton_clicked()
{
    movement.goWest();
}


void MainWindow::on_pushButton_7_clicked()
{

}

