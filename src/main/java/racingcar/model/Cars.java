package racingcar.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void findWinners() {
        sortCarsByDistance();
        int maxDistance = cars.get(0).getDistance();
        int i = 0;
        while (i < cars.size() && maxDistance == cars.get(i).getDistance()) {
            winners.add(cars.get(i).getName());
            i++;
        }
    }

    private void sortCarsByDistance() {
        cars.sort(Comparator.comparingInt(Car::getDistance).reversed());
    }
}

