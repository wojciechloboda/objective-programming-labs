package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{
    private final ArrayList<MoveDirection> directionList;
    private final List<Animal> animalList;
    private final AbstractWorldMap map;

    public SimulationEngine(ArrayList<MoveDirection> directionList, AbstractWorldMap map, Vector2d[] initPositions){
        this.directionList = directionList;
        this.map = map;
        this.animalList = new ArrayList<>();

        for(var pos : initPositions){
            Animal newAnimal = new Animal(map, pos);

            if(map.place(newAnimal)){
                animalList.add(newAnimal);
            }
        }
    }

    @Override
    public void run() {
        for(int i = 0; i < directionList.size(); i++){
            animalList.get(i % animalList.size()).move(directionList.get(i));
            System.out.println(map.toString());
        }
    }
}
