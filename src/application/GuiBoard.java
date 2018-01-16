package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import reversiapp.Board;
import reversiapp.Piece;
import reversiapp.Sign;
import reversiapp.GameSettings;
import settings_io.SettingsReader;

import java.io.IOException;

public class GuiBoard extends GridPane {
    private Board board;
    private int height;
    private int width;
    private GameSettings gameSettings;

    public GuiBoard(Board board) {
        this.board = board;
        this.gameSettings = SettingsReader.readFile();
        FXMLLoader fxmlLoader = new
                FXMLLoader(getClass().getResource("reversiBoard.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void draw() {
        this.getChildren().clear();
        this.height = (int) this.getPrefHeight();
        this.width = (int) this.getPrefWidth();
        int cellHeight = height / board.getSize();
        int cellWidth = width / board.getSize();
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                Rectangle rect = new Rectangle(cellWidth, cellHeight, Color.LAVENDER);
                rect.setStroke(Color.BLACK);
                this.add(rect, j, i);
                if (this.board.getCell(i,j).getDisk() == Sign.kBlacks) {
                    Circle disk = new Circle(Math.min(cellWidth,cellHeight) /2, gameSettings.getPlayer1Color());
                    this.add(disk,j,i);
                } else if (this.board.getCell(i,j).getDisk() == Sign.kWhites) {
                    Circle disk = new Circle(Math.min(cellWidth,cellHeight) /2, gameSettings.getPlayer2Color());
                    this.add(disk,j,i);
                } else if (this.board.getCell(i, j).getDisk() == Sign.kToFlip) {
                    Circle disk = new Circle(Math.min(cellWidth,cellHeight) /2, Color.TRANSPARENT);
                    disk.setStroke(Color.BLACK);
                    this.add(disk, j, i);
                }
            }
        }

    }

    /**
     * calculates the cell that was clicked.
     * @param event - a mouse click event.
     * @return - a cell location in the board.
     */
    public Piece clicked(MouseEvent event) {
        double x =  event.getX();
        double y =  event.getY();
        double cellHeight =  (this.getPrefHeight() / board.getSize());
        double cellWidth =  ((this.getPrefWidth() + 10)  / board.getSize());
        int i = (int)(x / cellWidth);
        int j = (int)(y / cellHeight);
        System.out.println(i + " " + j);
        return new Piece(j, i);
    }
}