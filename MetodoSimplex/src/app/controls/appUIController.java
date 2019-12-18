/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controls;

import java.awt.Insets;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 *
 * @author sandy
 */
public class appUIController implements Initializable {

    @FXML
    private VBox boxCampos;
    @FXML
    private TextField funcionObjetivo;
    @FXML
    private TextField restriccion1;
    @FXML
    private TableView<?> tabla;
    @FXML
    private VBox boxRestricciones;

    public List<String> lista = new ArrayList<>();
    //Restricciones restricciones = new Restricciones();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        lista.add(restriccion1.getText());

        javafx.animation.Timeline timeline = new javafx.animation.Timeline(new javafx.animation.KeyFrame(javafx.util.Duration.seconds(5), ev -> {
            lista.clear();
            String last = "";
            String allText = "";
            int boxSize = boxRestricciones.getChildren().size();
            for (int i = 0; i < boxSize; i++) {
                TextField campoActual = (TextField) boxRestricciones.getChildren().get(i);
                String actualText = campoActual.getText();
                if (!actualText.equals("")) {
                    campoActual.setOpacity(1);
                    lista.add(actualText);
                } else {
                    campoActual.setOpacity(0.5);
                }
                last = actualText;
                allText += actualText;
            }

            String [] numVariables = devuelveNumVariables();

            if (!last.equals("")) {
                TextField nuevoCampo = new TextField();
                nuevoCampo.setPromptText("Agregue aqui otra restriccion");
                nuevoCampo.setStyle("-fx-padding: 5px;");
                nuevoCampo.setId("restriccion" + (boxSize + 1));

                boxRestricciones.getChildren().add(nuevoCampo);

                System.out.println("nuevo campo creado");
            }
        }));
        timeline.setCycleCount(javafx.animation.Animation.INDEFINITE);
        timeline.play();
    }

    private String[] devuelveNumVariables() {
        //Aqui va el retorno del texto de las columnas
        return new String[]{};
    }

}
