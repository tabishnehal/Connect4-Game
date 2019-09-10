package com.internshala.connectfour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {
    
    private Controller controller;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootGridPane = loader.load();
        
        controller = loader.getController();
        controller.createPlayGround();
        MenuBar menuBar=createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        Pane menuPane= (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().addAll(menuBar);
        Scene scene = new Scene(rootGridPane);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect Four");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    private MenuBar createMenu(){
        //File menu
        Menu fileMenu=new Menu("File");
        Menu helpMenu=new Menu("Help");
        //MenuItems
	    MenuItem aboutConnect4=new MenuItem("About Connect4");
	    aboutConnect4.setOnAction(event -> aboutconnect4());
	    SeparatorMenuItem separatorMenuItem1=new SeparatorMenuItem();
	    MenuItem aboutMe=new MenuItem("About Me");
	    aboutMe.setOnAction(event -> aboutme());
        MenuItem newGame=new MenuItem("New Game");
        newGame.setOnAction(event -> controller.resetGame());
        MenuItem resetGame=new MenuItem("Reset Game");
        resetGame.setOnAction(event -> controller.resetGame());
        SeparatorMenuItem separatorMenuItem2=new SeparatorMenuItem();
        MenuItem exitGame=new MenuItem("Exit Game");
        exitGame.setOnAction(event -> {
            Platform.exit();
            System.exit(0);
        });
        fileMenu.getItems().addAll(newGame,resetGame,separatorMenuItem2,exitGame);
        helpMenu.getItems().addAll(aboutConnect4,separatorMenuItem1,aboutMe);
        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;
    }
	
	private void aboutme() {
		Alert alert=new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About Developer");
		alert.setHeaderText("Mohd Tabish Nehal");
		alert.setContentText("I am very found of games from beginning and love to play around codes,creating awesome games. " +
				"Connect 4 is One of my favourite Games!" +
				" I spend my free times with my near and dear ones.");
		alert.show();
	}
	
	private void aboutconnect4() {
		Alert alert=new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About Connect Four");
		alert.setHeaderText("How To Play!");
		alert.setContentText("Connect Four is a two-player connection game in which the players" +
				" first choose a color and then take turns dropping colored discs from the top " +
				"into a seven-column, six-row vertically suspended grid. The pieces fall straight down," +
				" occupying the next available space within the column. The objective of the game is to" +
				" be the first to form a horizontal, vertical, or diagonal line of four of one's" +
				" own discs. Connect Four is a solved game. The first player can always win by" +
				" playing the right moves.");
		alert.show();
	}
	
    public static void main(String[] args) {
        launch(args);
    }
}
