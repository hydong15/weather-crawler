package org.ajou.realcoding.weathercrawler.weathercrawler.controller;

import org.ajou.realcoding.weathercrawler.weathercrawler.domain.Dog;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DogController {
    List<Dog> dogs = new ArrayList<>();

    @PostMapping("/dogs") // http://localhost:8081/dogs
    public Dog createDog(@RequestBody Dog dog) {
        dogs.add(dog);
        return dog;
    }

    @GetMapping("/dogs")
    public List<Dog> findAllDogs() {
        return dogs;
    }

    @GetMapping("/dogs/{name}")
    public Dog findDog(@PathVariable String name) {
        for (Dog dog : dogs) {
            if (dog.getName().equals(name)) {
                return dog;
            }
        }
        return null;
    }

    @DeleteMapping("/dogs/{name}")
    public void deleteDog(@PathVariable String name) {
        for (int i = 0; i < dogs.size(); i++) {
            if (dogs.get(i).getName().equals(name)) {
                dogs.remove(i);
            }
        }
    }

    @PutMapping("/dogs/{name}")
    public Dog updateDog(@PathVariable String name, @RequestBody String kind) {
        for (Dog dog : dogs) {
            if (dog.getName().equals(name)) {
                dog.setKind(kind);
                return dog;
            }
        }
        return null;
    }
}
