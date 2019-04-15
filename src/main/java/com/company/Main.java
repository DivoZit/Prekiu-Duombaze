package com.company;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    Database database = new Database();
    private TableView table = new TableView();

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Prekiu pridejimas");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Pridekit nauja preke");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label commodityName = new Label("Pavadinias:");
        grid.add(commodityName, 0, 1);
        TextField commodityNameTextField = new TextField();
        grid.add(commodityNameTextField, 1, 1);

        Label description = new Label("Aprasymas:");
        grid.add(description, 0, 2);
        TextField descriptionTextField = new TextField();
        grid.add(descriptionTextField, 1, 2);

        Label quantity = new Label("Kiekis:");
        grid.add(quantity, 0, 3);
        TextField quantityTextField = new TextField();
        grid.add(quantityTextField, 1, 3);

        Label price = new Label("Kaina:");
        grid.add(price, 0, 4);
        TextField priceTextField = new TextField();
        grid.add(priceTextField, 1, 4);

        Button btn = new Button("Prideti");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 5);
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        btn.setOnAction(e -> {
            String pavadinimas = commodityNameTextField.getText();
            String aprasymas = descriptionTextField.getText();
            String kiekis = quantityTextField.getText();
            String kaina = priceTextField.getText();

            int kiekisInt = Integer.parseInt(kiekis.trim());
            int kainaInt = Integer.parseInt(kaina.trim());
            database.insertGoods(pavadinimas, aprasymas, kiekisInt, kainaInt);

            System.out.println("Pavadinimas: " + pavadinimas);
            System.out.println("Aprasymas: " + aprasymas);
            System.out.println("Kiekis: " + kiekis);
            System.out.println("Kaina: " + kaina);
            actiontarget.setFill(Color.FIREBRICK);
            actiontarget.setText("Preke prideta.");

        });
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
