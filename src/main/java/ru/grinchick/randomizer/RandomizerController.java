package ru.grinchick.randomizer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import ru.grinchick.randomizer.services.RandomizerService;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;

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
    private Slider distribution;

    @FXML
    private TextArea list_1;

    @FXML
    private TextArea list_2;

    @FXML
    private TextArea listAll;

    @FXML
    protected void onRandomizeButtonClick() {

        List<String> sequence_1;
        List<String> sequence_2;

        listAll.setText("");
        list_1.setText("");
        list_2.setText("");

        sequence_1 = RandomizerService.getRandomLongSequence(Long.parseLong(min_1.getText()), Long.parseLong(max_1.getText()), Long.parseLong(quantity_1.getText()));
        sequence_2 = RandomizerService.getRandomLongSequence(Long.parseLong(min_2.getText()), Long.parseLong(max_2.getText()), Long.parseLong(quantity_2.getText()));
        List<String> finalSequence = sequence_1;
        finalSequence.addAll(sequence_2);
        Collections.shuffle(finalSequence, new Random());

        finalSequence.forEach(el -> listAll.appendText(el + "\r\n"));
        sequence_1.forEach(el ->  list_1.appendText(el + "\r\n"));
        sequence_2.forEach(el ->  list_2.appendText(el + "\r\n"));
    }
}