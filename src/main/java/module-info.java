module ru.grinchick.randomizer {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    opens ru.grinchick.randomizer to javafx.fxml;
    exports ru.grinchick.randomizer;
}