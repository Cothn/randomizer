package ru.grinchick.randomizer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import ru.grinchick.randomizer.services.RandomizerService;

import java.util.*;

public class RandomizerController {
    @FXML
    private TextField min_1;

    @FXML
    private TextField min_2;

    @FXML
    private TextField max_1;

    @FXML
    private TextField max_2;

    @FXML
    private TextField  quantity_1;

    @FXML
    private TextField  quantity_2;

    @FXML
    private TextField  quantity_all;

    @FXML
    private Slider distribution;

    @FXML
    private TextArea list_1;

    @FXML
    private TextArea list_2;

    @FXML
    private TextArea listAll;

    @FXML
    private CheckBox decimalFlag;

    @FXML
    protected void onRandomizeButtonClick() {

        List<String> sequence_1;
        List<String> sequence_2;

        listAll.setText("");
        list_1.setText("");
        list_2.setText("");

        if (decimalFlag.isSelected()){
            sequence_1 = RandomizerService.getRandomDoubleSequence(Double.parseDouble("0"+min_1.getText()), Double.parseDouble("0"+max_1.getText()), Long.parseLong("0"+quantity_1.getText()));
            sequence_2 = RandomizerService.getRandomDoubleSequence(Double.parseDouble("0"+min_2.getText()), Double.parseDouble("0"+max_2.getText()), Long.parseLong("0"+quantity_2.getText()));
        } else {
            sequence_1 = RandomizerService.getRandomLongSequence(Long.parseLong("0"+min_1.getText()), Long.parseLong("0"+max_1.getText()), Long.parseLong("0"+quantity_1.getText()));
            sequence_2 = RandomizerService.getRandomLongSequence(Long.parseLong("0"+min_2.getText()), Long.parseLong("0"+max_2.getText()), Long.parseLong("0"+quantity_2.getText()));
        }

        List<String> finalSequence = new ArrayList<>(sequence_1);
        finalSequence.addAll(sequence_2);
        Collections.shuffle(finalSequence, new Random());

        finalSequence.forEach(el -> listAll.appendText(el + "\r\n"));
        sequence_1.forEach(el ->  list_1.appendText(el + "\r\n"));
        sequence_2.forEach(el ->  list_2.appendText(el + "\r\n"));
    }

    @FXML
    protected void onDistributionChanged() {
        cropNumberField(quantity_all, 4);

        long buff;
        buff = (long)((distribution.getValue() / 100) * Long.parseLong("0"+quantity_all.getText()));
        quantity_1.setText(String.valueOf(buff));
        quantity_2.setText(String.valueOf(Long.parseLong("0"+quantity_all.getText()) - Long.parseLong("0"+quantity_1.getText())));
    }

    @FXML
    protected void onDiapazonQuantityChanged() {
        cropNumberField(quantity_1, 4);
        cropNumberField(quantity_2, 4);

        quantity_all.setText(String.valueOf(Long.parseLong("0"+quantity_1.getText()) + Long.parseLong("0"+quantity_2.getText())));
        double distributionPercent = ((double) Long.parseLong("0"+quantity_1.getText()) / Long.parseLong("0"+quantity_all.getText())) * 100;
        distribution.setValue(distributionPercent);
    }

    private void cropNumberField(TextField field, int maxLength) {
        if (field.getText().length()>maxLength){
            field.setText(String.valueOf(Long.parseLong("0"+field.getText()) / 10));
        }
    }
}