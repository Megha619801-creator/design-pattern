package design;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PixelEditorApp extends Application {

    private PixelGrid model = new PixelGrid();

    private Rectangle[][] cells = new Rectangle[8][8];

    @Override
    public void start(Stage stage) {

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);

        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {

                Rectangle rect = new Rectangle(50, 50);
                rect.setStroke(Color.GRAY);

                cells[r][c] = rect;

                gridPane.add(rect, c, r);
            }
        }

        Button codeButton = new Button("Create Code");

        Command generate =
                new GenerateCodeCommand(model);

        codeButton.setOnAction(e -> generate.execute());

        BorderPane root = new BorderPane();
        root.setCenter(gridPane);
        root.setBottom(codeButton);
        BorderPane.setAlignment(codeButton, Pos.CENTER);

        Scene scene = new Scene(root, 500, 500);

        scene.setOnKeyPressed(e -> {

            Command command = null;

            if (e.getCode() == KeyCode.UP)
                command = new MoveCursorUpCommand(model);

            else if (e.getCode() == KeyCode.DOWN)
                command = new MoveCursorDownCommand(model);

            else if (e.getCode() == KeyCode.LEFT)
                command = new MoveCursorLeftCommand(model);

            else if (e.getCode() == KeyCode.RIGHT)
                command = new MoveCursorRightCommand(model);

            else if (e.getCode() == KeyCode.SPACE)
                command = new TogglePixelCommand(model);

            if (command != null) {
                command.execute();
                redraw();
            }
        });

        redraw();

        stage.setScene(scene);
        stage.setTitle("Pixel Art Editor");
        stage.show();

        scene.requestFocus();
    }

    private void redraw() {

        boolean[][] pixels = model.getPixels();

        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {

                Rectangle rect = cells[r][c];

                rect.setFill(
                        pixels[r][c]
                                ? Color.BLACK
                                : Color.WHITE
                );

                rect.setStroke(Color.GRAY);
                rect.setStrokeWidth(1);
            }
        }

        Rectangle cursor =
                cells[model.getCursorRow()][model.getCursorCol()];

        cursor.setStroke(Color.RED);
        cursor.setStrokeWidth(3);
    }

    public static void main(String[] args) {
        launch();
    }
}