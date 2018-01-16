package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ComboBox regressionType;

    @FXML
    private TextField xValues;
    @FXML
    private TextField yValues;
    @FXML
    private TextField delta;
    @FXML
    private TextField deltaAlfaUI;
    @FXML
    private TextField deltaBetaUI;
    @FXML
    private TextField alfaUI;
    @FXML
    private TextField betaUI;
    @FXML
    private Label line;
    /*0.32 0.31 0.36 0.33 0.40 0.42
        0.43 0.41 0.35 0.38 0.42 0.47*/
    /*0.30 0.29 0.32 0.36 0.37 0.37
        0.42 0.40 0.38 0.34 0.37 0.56*/

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //xValues.setText("0.35, 0.35, 0.30, 0.36, 0.31, 0.36, 0.34, 0.38, 0.37, 0.38, 0.36, 0.40");
        xValues.setText("0.36, 0.38, 0.38, 0.37, 0.40, 0.38, 0.29, 0.35, 0.34, 0.42, 0.47, 0.60");//, 0.32, 0.34, 0.34, 0.49, 0.52, 0.81, 0.79, 0.57, 0.34, 0.25, 0.00, 0.65");
        //yValues.setText("0.24, 0.32, 0.29, 0.31, 0.27, 0.32, 0.24, 0.32, 0.29, 0.31, 0.27, 0.32");
        yValues.setText("0.32, 0.36, 0.37, 0.37, 0.37, 0.30, 0.26, 0.38, 0.34, 0.37, 0.56, 0.72");//, 0.65, 0.76, 0.43, 0.32, 0.10, 0.00, 0.26, 0.32, 0.34, 0.35, 0.57, 0.62");
    }

    public void calulate() {
        if (Calculation.isListOfDouble(xValues.getText()) && Calculation.isListOfDouble(yValues.getText())) {
            Calculation.LinearCalculate(xValues.getText(), yValues.getText());
            String setDelta = String.format("%.4f", Calculation.deltaValue);
            String setDeltaAlfa = String.format("%.4f", Calculation.deltaAlfaValue);
            String setDeltaBeta = String.format("%.4f", Calculation.deltaBetaValue);
            String setAlfa = String.format("%.4f", Calculation.alfa);
            String setBeta = String.format("%.4f", Calculation.beta);
            delta.setText(setDelta);
            deltaAlfaUI.setText(setDeltaAlfa);
            deltaBetaUI.setText(setDeltaBeta);
            alfaUI.setText(setAlfa);
            betaUI.setText(setBeta);
            line.setText(String.format("y = %s + %s*x", setAlfa, setBeta));
            Calculation.fillCorellationTable(xValues.getText(), yValues.getText());

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Wrong Input");
            alert.setContentText("Поле повинно містити список значень типу Double, розділених комою.");
            alert.show();
        }
    }
}







