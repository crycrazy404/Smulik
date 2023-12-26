package com.example.lab4fx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import shapes.*;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class HelloController implements Initializable, EventHandler<MouseEvent> {
    @FXML
    private ListView<Shape> listView;
    @FXML
    Canvas canvas;
    @FXML
    TextField xCords;
    @FXML
    TextField yCords;
    @FXML
    ColorPicker figureColor;
    @FXML
    ColorPicker strokeColor;
    @FXML
    ComboBox<Integer> strokeWidBox;
    @FXML
    Label figureName;
    GraphicsContext gc;
    ObservableList <Shape> items;
    ObservableList <Integer> strokeWid;
    double x,y;

    public void onClearButtonClick(MouseEvent event){
        gc.clearRect(0,0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        ShapeFactory sf = new ShapeFactory();
        items = FXCollections.observableArrayList();
        for (int i = 0; i < sf.getMap().size(); i++) {
            items.add(sf.createShape(i));
        }
        strokeWid = FXCollections.observableArrayList(0,1,2,3,4,5);
        strokeWidBox.setItems(strokeWid);
        listView.setItems(items);
        listView.setCellFactory(shapeListView -> new ShapeCell());
        canvas.setOnMouseClicked(this::handle);
    }
    @Override
    public void handle(MouseEvent event) {
            x = event.getX();
            y = event.getY();
            int index = listView.getSelectionModel().getSelectedIndex();
            Shape shape = items.get(index);
            shape.draw(gc, x, y, figureColor.getValue(),strokeWidBox.getValue(), strokeColor.getValue());
            figureName.setText("Фигура: " + shape);
    }
}