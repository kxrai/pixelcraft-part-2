//package view;
//
//// Import necessary JavaFX and other libraries
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Button;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.VBox;
//import javafx.stage.FileChooser;
//import javafx.stage.Stage;
//import javafx.geometry.Insets;
//import java.io.File;
//import java.util.Observer;
//import java.util.Observable;
//import model.PCModel;
//
///**
// * PCView class represents the view component of the MVC architecture.
// * It sets up the user interface, including the sidebar and the main body.
// */
//public class PCView implements Observer {
//
//    // Reference to the model
//    private final PCModel model;
//    // Reference to the primary stage
//    private final Stage stage;
//    // Layout for the view
//    private final BorderPane layout;
//    // ImageView to display the image
//    private final ImageView imageView;
//    // Scene for the stage
//    private Scene scene;
//    // Buttons for the sidebar
//    private final Button btnOpen;
//    private final Button btnSave;
//    private final Button btnGrayscale;
//    private final Button btnBlur;
//    private final Button btnRotate;
//    private final Button btnWarmer;
//    private final Button btnUndo;
//    private final Button btnRedo;
//
//    /**
//     * Constructor to initializes UI components
//     */
//    public PCView(Stage stage, PCModel model) {
//        this.stage = stage;
//        this.model = model;
//
//        // Add view as an observer of the model
//        this.model.addObserver(this);
//
//        // Initialize layout components
//        layout = new BorderPane();
//        imageView = new ImageView();
//        btnOpen = createButton("Open");
//        btnSave = createButton("Save");
//        btnGrayscale = createButton("Grayscale");
//        btnBlur = createButton("Blur");
//        btnRotate = createButton("Rotate");
//        btnWarmer = createButton("Warmer");
//        btnUndo = createButton("Undo");
//        btnRedo = createButton("Redo");
//
//        // Set up the sidebar with buttons
//        VBox sidebar = new VBox(10);
//        sidebar.setStyle("-fx-background-color: lightblue;");
//        sidebar.setPadding(new Insets(10));
//        sidebar.setPrefWidth(150);
//        // Add buttons in sidebar
//        sidebar.getChildren().addAll(btnOpen, btnSave, btnGrayscale, btnBlur, btnRotate, btnWarmer, btnUndo, btnRedo);
//
//        // Set predefined dimensions for the ImageView
//        imageView.setFitWidth(750);
//        imageView.setFitHeight(600);
//        // Maintain the aspect ratio of the image
//        imageView.setPreserveRatio(true);
//
//        // Set up the main layout
//        layout.setLeft(sidebar);
//        layout.setCenter(imageView);
//
//        // Create the scene and set it on the stage
//        scene = new Scene(layout, 900, 700);
//        stage.setScene(scene);
//        stage.setTitle("PixelCraft GUI");
//        stage.show();
//    }
//
//    /**
//     * Method to show alert dialog with a specified title and message
//     */
//    public void showAlert(String title, String message) {
//        // Create object of Alert
//        Alert alert = new Alert(Alert.AlertType.WARNING);
//        // set title, header and message
//        alert.setTitle(title);
//        alert.setHeaderText(null);
//        alert.setContentText(message);
//        alert.showAndWait();
//    }
//
//    /**
//     * Gets the current scene
//     */
//    public Scene getScene() {
//        return scene;
//    }
//
//    /**
//     * Gets the Open button
//     */
//    public Button getBtnOpen() {
//        return btnOpen;
//    }
//
//    /**
//     * Gets the Save button
//     */
//    public Button getBtnSave() {
//        return btnSave;
//    }
//
//    /**
//     * Gets the Grayscale button
//     */
//    public Button getBtnGrayscale() {
//        return btnGrayscale;
//    }
//
//    /**
//     * Gets the Blur button
//     */
//    public Button getBtnBlur() {
//        return btnBlur;
//    }
//
//    /**
//     * Gets the Rotate button
//     */
//    public Button getBtnRotate() {
//        return btnRotate;
//    }
//
//    /**
//     * Gets the Warmer button
//     */
//    public Button getBtnWarmer() {
//        return btnWarmer;
//    }
//
//    /**
//     * Gets the Undo button
//     */
//    public Button getBtnUndo() {
//        return btnUndo;
//    }
//
//    /**
//     * Gets the Redo button
//     */
//    public Button getBtnRedo() {
//        return btnRedo;
//    }
//
//    /**
//     * Sets image to be displayed in ImageView
//     */
//    public void setImage(Image image) {
//        imageView.setImage(image);
//    }
//
//    /**
//     * Creates button with specified text, a set width, and padding
//     */
//    private Button createButton(String text) {
//        // Create object of button
//        Button button = new Button(text);
//        // Set a preferred width
//        button.setPrefWidth(120);
//        // Set padding inside the button
//        button.setPadding(new Insets(10));
//        return button;
//    }
//
//    /**
//     * Displays file chooser dialog for opening an image file
//     */
//    public File showOpenFileDialog() {
//        // Create Object of FileChooser
//        FileChooser fileChooser = new FileChooser();
//        // Setup supported extensions
//        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg"));
//        return fileChooser.showOpenDialog(stage);
//    }
//
//    /**
//     * Displays a file chooser dialog for saving an image file
//     */
//    public java.io.File showSaveFileDialog() {
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg"));
//        return fileChooser.showSaveDialog(stage);
//    }
//
//    /**
//     * Method to ypdates the view when the model changes
//     */
//    @Override
//    public void update(Observable o, Object arg) {
//        if (o instanceof PCModel) {
//            setImage(((PCModel) o).getImage());
//        }
//    }
//}
//
//

package view;

import controller.AnnotationTool;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import model.PCModel;

import java.io.File;
import java.util.Observable;
import java.util.Observer;

public class PCView implements Observer {

    private final PCModel model;
    private final Stage stage;
    private final BorderPane layout;
    private final ImageView imageView;
    private Canvas annotationCanvas;
    private AnnotationTool annotationTool;
    private final Scene scene;
    private final Button btnOpen;
    private final Button btnSave;
    private final Button btnGrayscale;
    private final Button btnBlur;
    private final Button btnRotate;
    private final Button btnWarmer;
    private final Button btnUndo;
    private final Button btnRedo;
    private final Button btnNextImage;
    private final Button btnPreviousImage;
    private final Button btnClearAnnotations;
    private final Button btnStartAnnotations;

    public PCView(Stage stage, PCModel model) {
        this.stage = stage;
        this.model = model;
        this.model.addObserver(this);

        layout = new BorderPane();
        imageView = new ImageView();

        btnOpen = createButton("Open");
        btnSave = createButton("Save");
        btnGrayscale = createButton("Grayscale");
        btnBlur = createButton("Blur");
        btnRotate = createButton("Rotate");
        btnWarmer = createButton("Warmer");
        btnUndo = createButton("Undo");
        btnRedo = createButton("Redo");
        btnNextImage = createButton("Next");
        btnPreviousImage = createButton("Previous");
        btnClearAnnotations = createButton("Clear Annotations");
        btnStartAnnotations = createButton("Start Annotations");

        VBox sidebar = new VBox(10);
        sidebar.setId("sidebar");
        sidebar.setPadding(new Insets(10));
        sidebar.getChildren().addAll(btnOpen, btnSave, btnGrayscale, btnBlur, btnRotate, btnWarmer, btnUndo, btnRedo, btnNextImage, btnPreviousImage, btnStartAnnotations, btnClearAnnotations);

        imageView.setFitWidth(750);
        imageView.setFitHeight(600);
        imageView.setPreserveRatio(true);

        // Initialize annotationCanvas here before adding it to the StackPane
        annotationCanvas = new Canvas(750, 600);
        annotationTool = new AnnotationTool(annotationCanvas);
        annotationTool.setDrawingEnabled(false); // Disable drawing by default

        // StackPane to hold both the ImageView and Canvas
        StackPane imagePane = new StackPane();
        imagePane.getChildren().addAll(imageView, annotationCanvas); // Canvas is on top of ImageView

        layout.setLeft(sidebar);
        layout.setCenter(imagePane);  // Use StackPane in the center

        initAnnotationTools();

        scene = new Scene(layout, 900, 700);
        stage.setScene(scene);
        stage.setTitle("PixelCraft GUI");
    }

    private void initAnnotationTools() {
        btnClearAnnotations.setOnAction(e -> {
            annotationTool.clearCanvas();
            annotationTool.setDrawingEnabled(false); // Disable drawing after clearing
        });

        btnStartAnnotations.setOnAction(e -> {
            annotationTool.setDrawingEnabled(true); // Enable drawing when button is clicked
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof PCModel) {
            imageView.setImage(model.getCurrentImage());
        }
    }

    public Scene getScene() {
        return scene;
    }

    public Button getBtnOpen() {
        return btnOpen;
    }

    public Button getBtnSave() {
        return btnSave;
    }

    public Button getBtnGrayscale() {
        return btnGrayscale;
    }

    public Button getBtnBlur() {
        return btnBlur;
    }

    public Button getBtnRotate() {
        return btnRotate;
    }

    public Button getBtnWarmer() {
        return btnWarmer;
    }

    public Button getBtnUndo() {
        return btnUndo;
    }

    public Button getBtnRedo() {
        return btnRedo;
    }

    public Button getBtnNextImage() {
        return btnNextImage;
    }

    public Button getBtnPreviousImage() {
        return btnPreviousImage;
    }

    public Button getBtnClearAnnotations() {
        return btnClearAnnotations;
    }

    public Button getBtnStartAnnotations() {
        return btnStartAnnotations;
    }

    public File showOpenFileDialog() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg"));
        return fileChooser.showOpenDialog(stage);
    }

    public File showSaveFileDialog() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg"));
        return fileChooser.showSaveDialog(stage);
    }

    public void setImage(Image image) {
        imageView.setImage(image);
    }

    public void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private Button createButton(String text) {
        Button button = new Button(text);
        button.setPrefWidth(120);
        button.setPadding(new Insets(10));
        return button;
    }

    public AnnotationTool getAnnotationTool() {
        return annotationTool;
    }
}
