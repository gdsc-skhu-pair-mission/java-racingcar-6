package racingcar.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static Cars instance;
    private List<Car> cars;
    private List<String> winners;

    public static Cars getInstance() {
        if (instance == null) {
            instance = new Cars();
        }
        return instance;
    }

    public List<String> getWinners() {
        return winners;
    }

    public Cars() {
        this.cars = new ArrayList<>();
        this.winners = new ArrayList<>();
    }

    public void addCar(String name) {
        this.cars.add(new Car(name));
    }

    public void addAllCar(List<String> carNames) {
        for (String carName : carNames) {
            addCar(carName);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void findWinners() {
        List<Car> sortedCars = sortCarsByDistance();
        int maxDistance = sortedCars.get(0).getDistance();

        winners = sortedCars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());

    }

    private List<Car> sortCarsByDistance() {

        return new ArrayList<>(cars).stream()
                .sorted(Comparator.comparingInt(Car::getDistance).reversed())
                .collect(Collectors.toList());
    }
}

