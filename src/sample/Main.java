package sample;

import com.sun.javafx.scene.layout.region.LayeredBorderPaintConverter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group group = new Group();
        Scene scene=new Scene(group,1000,500);
        primaryStage.setTitle("Main");
        VBox main= new VBox();
        main.setLayoutY(50);
        TextArea txt=new TextArea();
        txt.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        txt.setText("grrrr");

        txt.setMaxHeight(100);
        txt.setMaxWidth(800);


        MenuBar menuBar=new MenuBar();
        Menu colorMenu = new Menu("Color");
        Menu fontMenu = new Menu("Font");

        MenuItem [] colors=new MenuItem[]{
                new MenuItem("red"),
                new MenuItem("blue"),
                new MenuItem("black")
        };

        MenuItem [] fonts=new MenuItem[]{
                new MenuItem("Times New Roman"),
                new MenuItem("MS Sans Serif"),
                new MenuItem("Courier New")
        };

        for (MenuItem t: colors
             ) {
            t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    txt.setStyle("-fx-text-inner-color: "+t.getText()+";");

                }
            });
        }
        for (MenuItem t:fonts
             ) {
            t.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    txt.setFont(Font.font(t.getText(), FontWeight.BOLD, FontPosture.REGULAR, 20));
                }
            });

        }


        colorMenu.getItems().addAll(colors);
        fontMenu.getItems().addAll(fonts);

        menuBar.getMenus().addAll(colorMenu,fontMenu);//всё в кучу

        BorderPane mn=new BorderPane();
        mn.setTop(menuBar);
        main.getChildren().addAll(txt);
        group.getChildren().addAll(mn,main);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
