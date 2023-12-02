package ru.grinchick.randomizer;

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
    private ListView<String> list_1;

    @FXML
    private ListView<String> list_2;

    @FXML
    private ListView<String> listAll;

    @FXML
    protected void onRandomizeButtonClick() {

        List<String> sequence_1;
        List<String> sequence_2;


        sequence_1 = RandomizerService.getRandomLongSequence(Long.parseLong(min_1.getText()), Long.parseLong(max_1.getText()), Long.parseLong(quantity_1.getText()));
        sequence_2 = RandomizerService.getRandomLongSequence(Long.parseLong(min_2.getText()), Long.parseLong(max_2.getText()), Long.parseLong(quantity_2.getText()));
        List<String> finalSequence = sequence_1;
        finalSequence.addAll(sequence_2);
        Collections.shuffle(finalSequence, new Random());

        listAll.setItems((ObservableList<String>) finalSequence);
        list_1.setItems((ObservableList<String>) sequence_1);
        list_2.setItems((ObservableList<String>) sequence_2);
    }
}