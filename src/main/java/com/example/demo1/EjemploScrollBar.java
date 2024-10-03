package com.example.demo1;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.ScrollBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class EjemploScrollBar extends Application {

    final ScrollBar sc = new ScrollBar();
    final ScrollBar sch = new ScrollBar();
    //final Image img = new Image(getClass().getResourceAsStream("imagen.jpg"));
    final VBox vb = new VBox();
    final HBox hb = new HBox();
    DropShadow shadow = new DropShadow();
    Label lbl = new Label();

    @Override
    public void start(Stage stage) throws IOException {

        Group root = new Group();
        Scene scene = new Scene(root, 180, 180);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("Scrollbar");
        root.getChildren().addAll(hb, vb, sc, sch);

        shadow.setColor(Color.GREY);
        shadow.setOffsetX(2);
        shadow.setOffsetY(2);

        vb.setLayoutX(5);
        vb.setSpacing(10);

        sc.setLayoutX(scene.getWidth()-sc.getWidth());
        sc.setMin(0);
        sc.setOrientation(Orientation.VERTICAL);
        sc.setPrefHeight(180);
        sc.setPrefWidth(20);
        sc.setMax(180);

        sch.setLayoutY(166);
        sch.setMin(0);
        sch.setOrientation(Orientation.HORIZONTAL);
        sch.setPrefHeight(10);
        sch.setPrefWidth(180 - sc.getWidth());
        sch.setMax(180);

        lbl.setMaxWidth(scene.getWidth());

        lbl.setText("–¡Qué guapo soy! No me cansaría nunca de mirarme–se decía Filiberto un día que había salido a pasear a lomos de su caballo.\n" +
                "De repente, una anciana mendiga se cruzó en su camino.\n" +
                "–Por caridad, caballero, ¿no me daríais el espejo que cuelga del cuello de vuestro caballo?\n" +
                "En el pueblo lo podría cambiar por algo de pan.\n" +
                "Al escuchar la propuesta de la anciana, a Filiberto un poco más y le da un soponcio.\n" +
                "–Pero, ¿qué dices, insensata? ¿Regalarte el espejo? ¿Es que acaso has perdido el juicio?\n" +
                "Apártate de mi camino.Pero la anciana no se movió.\n" +
                "En lugar de eso, se quitó la capucha que le tapaba la cara y, entre chispas y resplandores mágicos,\n" +
                "descubrió su verdadera identidad: era Ventisca, la bruja más arisca.\n" +
                "–¡Rey engreído! –gritó–. ¡Te equivocaste al insultar a una bruja! –y murmurando para que Filiberto no pudiera escucharla,\n" +
                "recitó el siguiente conjuro:«¡Barrabín, Barrabel, el espejo será cruel, y no verás ya tu rostro, sino tu alma negra en él!» \n" +
                "Y dicho eso, la envolvió una gran nube de color violeta y desapareció.\n" +
                "–¡No me dan ningún miedo tus conjuros! –gritó Filiberto, fingiendo indiferencia.\n" +
                "Pero, de reojo, espío su reflejo en el espejo para tranquilizarse. \n" +
                "–¡Aaah!–aulló apenas se vio–. ¡Estoy horrible!Efectivamente, la imagen que le devolvía el espejo no era la del joven apuesto de siempre,\n" +
                "sino la de un ser monstruoso, de piel verde y lleno de verrugas.\n" +
                "–¡No puede ser! –gritaba mientras regresaba galopando al castillo, presa del pánico.\n" +
                "Nada más llegar, Filiberto, angustiado, se encerró en su habitación, y no quiso salir ni para comer, ni para merendar, ni para cenar.");

        lbl.setWrapText(true);
        lbl.setTextOverrun(OverrunStyle.CLIP);
        vb.getChildren().add(lbl);

        sc.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                vb.setLayoutY(-new_val.doubleValue());
            }
        });

        sch.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                vb.setLayoutX(-new_val.doubleValue());
            }
        });

        stage.show();

    }



    public static void main(String[] args) {
        launch();
    }
}