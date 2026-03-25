package momento;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;

    private List<IMemento> undoHistory;
    private List<IMemento> redoHistory;
    private ObservableList<IMemento> historyList; // for UI

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;

        undoHistory = new ArrayList<>();
        redoHistory = new ArrayList<>();
        historyList = FXCollections.observableArrayList();
    }

    public void setOption(int optionNumber, int choice) {
        saveState();
        redoHistory.clear();
        model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveState();
        redoHistory.clear();
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    private void saveState() {
        IMemento m = model.createMemento();
        undoHistory.add(m);
        historyList.add(m);
    }

    public void undo() {
        if (!undoHistory.isEmpty()) {
            IMemento current = model.createMemento();
            redoHistory.add(current);

            IMemento prev = undoHistory.remove(undoHistory.size() - 1);
            model.restoreState(prev);
            gui.updateGui();
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            IMemento current = model.createMemento();
            undoHistory.add(current);

            IMemento next = redoHistory.remove(redoHistory.size() - 1);
            model.restoreState(next);
            gui.updateGui();
        }
    }

    // ===== HISTORY WINDOW =====
    public void showHistoryWindow() {
        Stage stage = new Stage();

        ListView<IMemento> listView = new ListView<>(historyList);

        listView.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(IMemento item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getDescription());
            }
        });

        listView.setOnMouseClicked(e -> {
            IMemento selected = listView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                model.restoreState(selected);
                gui.updateGui();
            }
        });

        VBox root = new VBox(listView);
        stage.setScene(new Scene(root, 400, 400));
        stage.setTitle("History");
        stage.show();
    }
}