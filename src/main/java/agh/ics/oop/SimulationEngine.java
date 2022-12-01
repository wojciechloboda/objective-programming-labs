package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine, IPositionChangeObserver, Runnable{
    private ArrayList<MoveDirection> directionList;
    private final List<Animal> animalList = new ArrayList<>();
    private final List<IPositionChangeObserver> observersList = new ArrayList<>();

    private void setupAnimals(AbstractWorldMap map, Vector2d[] initPositions){
        for(var pos : initPositions){
            Animal newAnimal = new Animal(map, pos);

            if(map.place(newAnimal)){
                animalList.add(newAnimal);
                newAnimal.addObserver(this);
            }
        }
    }

    public void setDirections(ArrayList<MoveDirection> directionList){
        this.directionList = directionList;
    }

    public SimulationEngine(AbstractWorldMap map, Vector2d[] initPositions){
        this.directionList = new ArrayList<>();
        setupAnimals(map, initPositions);
    }

    public SimulationEngine(ArrayList<MoveDirection> directionList, AbstractWorldMap map, Vector2d[] initPositions){
        this.directionList = directionList;
        setupAnimals(map, initPositions);
    }

    @Override
    public void run() {
        for(int i = 0; i < directionList.size(); i++){
            animalList.get(i % animalList.size()).move(directionList.get(i));
        }
    }

    public void addObserver(IPositionChangeObserver observer){
        this.observersList.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        this.observersList.remove(observer);
    }

    private void notifyObservers(Vector2d oldPosition, Vector2d newPosition){
        for(var observer : this.observersList){
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        notifyObservers(oldPosition, newPosition);
    }
}
