/**
 * Created by Andy on 5/15/2016.
 */
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;

import java.awt.event.ActionListener;

public class ChoiceTest_JAVAFX extends Application {
    private GridPane gridPane;
    private Label labelMain;
    private ComboBox comboBoxFonts;
    private Text textFontWeightAndPosture;
    private CheckBox checkBoxBold;
    private CheckBox checkBoxItalic;
    private Text textFontSize;
    private RadioButton radioButtonSmall;
    private RadioButton radioButtonMedium;
    private RadioButton radioButtonLarge;
    private final ToggleGroup toggleGroupRadioButtonSizes = new ToggleGroup();
    private ActionListener listener;
    final int INTSMALLSIZE = 24;
    final int INTMEDIUMSIZE = 36;
    final int INTLARGESIZE = 48;

    @Override public void start(Stage mainStage) {


        // create a GridPane to organize everything
        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        Scene sceneMain = new Scene(gridPane, 300, 275);
        mainStage.setScene(sceneMain);

        // add all the UI controls
        // the label...
        labelMain = new Label("Text");
        labelMain.setFont(Font.font("Serif", INTLARGESIZE));
        gridPane.add(labelMain, 0, 0, 3, 1);

        // the combobox for serif, sans-serif and monospaced...
        createComboBoxes();

        // the checkboxes...
        createCheckBoxes();

        // the radiobuttons and radiobutton group...
        createRadioButtons();

        setFont();
        mainStage.setTitle("PIC 20A HW3 - JavaFX version");
        mainStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void createComboBoxes() {
        comboBoxFonts = new ComboBox();
        comboBoxFonts.setItems(FXCollections.observableArrayList("Serif", "Sansserif", "Monospaced"));
        comboBoxFonts.setEditable(true);
        comboBoxFonts.getSelectionModel().selectFirst();
        comboBoxFonts.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setFont();
            }
        });

        gridPane.add(comboBoxFonts, 1, 2, 3, 1);
    }

    public void createCheckBoxes() {
        textFontWeightAndPosture = new Text("Style");
        textFontWeightAndPosture.setFont(Font.font("Sansserif", FontWeight.BOLD, 14));
        gridPane.add(textFontWeightAndPosture, 0, 4, 1, 1);
        checkBoxBold = new CheckBox("Bold");
        checkBoxItalic = new CheckBox("Italic");
        checkBoxBold.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setFont();
            }
        });
        checkBoxItalic.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setFont();
            }
        });
        gridPane.add(checkBoxBold, 0, 5, 1, 1);
        gridPane.add(checkBoxItalic, 1, 5, 1, 1);
    }

    public void createRadioButtons() {
        textFontSize = new Text("Size");
        textFontSize.setFont(Font.font("Sansserif", FontWeight.BOLD, 14));
        gridPane.add(textFontSize, 0, 6, 1, 1);
        radioButtonSmall = new RadioButton("Small");
        radioButtonMedium = new RadioButton("Medium");
        radioButtonLarge = new RadioButton("Large");

        radioButtonLarge.setSelected(true);

        radioButtonSmall.setToggleGroup(toggleGroupRadioButtonSizes);
        radioButtonMedium.setToggleGroup(toggleGroupRadioButtonSizes);
        radioButtonLarge.setToggleGroup(toggleGroupRadioButtonSizes);

        radioButtonSmall.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setFont();
            }
        });

        radioButtonMedium.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setFont();
            }
        });

        radioButtonLarge.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setFont();
            }
        });

        gridPane.add(radioButtonSmall, 0, 7, 1, 1);
        gridPane.add(radioButtonMedium, 1, 7, 1, 1);
        gridPane.add(radioButtonLarge, 2, 7, 1, 1);
    }

    public void setFont() {
        String facename = "";
        try
        {
            facename = (String)comboBoxFonts.getValue().toString();
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e);
        }

        FontWeight fontWeight;
        FontPosture fontPosture;

        if(checkBoxBold.isSelected())
            fontWeight = FontWeight.BOLD;
        else
            fontWeight = FontWeight.NORMAL;

        if(checkBoxItalic.isSelected())
            fontPosture = FontPosture.ITALIC;
        else
            fontPosture = FontPosture.REGULAR;

        int size = 0;

        if(radioButtonSmall.isSelected())
            size = INTSMALLSIZE;
        else if (radioButtonMedium.isSelected())
            size = INTMEDIUMSIZE;
        else if (radioButtonLarge.isSelected())
            size = INTLARGESIZE;

        /*Font newFont = new Font();
        newFont.*/
        labelMain.setFont(Font.font(facename, fontWeight, fontPosture, size));
        labelMain.setText("Text");
    }
}
