package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class App extends Application {
    AbstractWorldMap map;

    private int getMapSizeInRows(){
        return map.getRightUpperBound().subtract(map.getLeftLowerBound()).y + 1;
    }

    private int getMapSizeInColumns(){
        return map.getRightUpperBound().subtract(map.getLeftLowerBound()).x + 1;
    }

    private Label createLabel(String str){
        Label label = new Label(str);
        label.setFont(new Font("Arial", 30));
        GridPane.setHalignment(label, HPos.CENTER);
        return label;
    }

    private void setGridLegend(GridPane grid){
        int gridInsideHeight = getMapSizeInRows();
        Label legendLabel;

        for(int x = map.getLeftLowerBound().x; x <= map.getRightUpperBound().x; x++){
            legendLabel = createLabel(Integer.toString(x));
            int currentColumn = x - map.getLeftLowerBound().x + 1;
            grid.add(legendLabel, currentColumn, 0);
        }

        for(int y = map.getLeftLowerBound().y; y <= map.getRightUpperBound().y; y++){
            legendLabel = createLabel(Integer.toString(y));
            int currentRow = gridInsideHeight - (y - map.getLeftLowerBound().y);
            grid.add(legendLabel, 0, currentRow);
        }

        legendLabel = createLabel("y\\x");
        grid.add(legendLabel, 0, 0);
    }

    private void fillGridWithMapElements(GridPane grid){
        int gridInsideHeight = getMapSizeInRows();
        Label mapElementLabel;

        for(int x = map.getLeftLowerBound().x; x <= map.getRightUpperBound().x; x++){
            for(int y = map.getLeftLowerBound().y; y <= map.getRightUpperBound().y; y++){
                Vector2d position = new Vector2d(x, y);
                if(map.isOccupied(position)){
                    mapElementLabel = createLabel(map.objectAt(position).toString());
                    int currentColumn = x - map.getLeftLowerBound().x + 1;
                    int currentRow = gridInsideHeight - (y - map.getLeftLowerBound().y);
                    grid.add(mapElementLabel, currentColumn, currentRow);
                }
            }
        }
    }

    private void setGridConstraints(GridPane grid){
        int gridRowsCount = getMapSizeInRows();
        int gridColumnsCount = getMapSizeInColumns();
        int width = 50;
        int height = 50;

        for(int i = 0; i <= gridRowsCount; i++){
            grid.getRowConstraints().add(new RowConstraints(height));
        }

        for(int i = 0; i <= gridColumnsCount; i++){
            grid.getColumnConstraints().add(new ColumnConstraints(width));
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.init();

        GridPane grid = new GridPane();

        setGridConstraints(grid);
        setGridLegend(grid);
        fillGridWithMapElements(grid);
        grid.setGridLinesVisible(true);

        Scene scene = new Scene(grid);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void init(){
        String[] args = getParameters().getRaw().toArray(new String[0]);

        try{
            ArrayList<MoveDirection> directions = OptionsParser.parse(args);
            map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2,2), new Vector2d(3,4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        }
        catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}
