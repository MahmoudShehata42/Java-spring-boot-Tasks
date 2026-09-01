package com.pioneers.designpatterns.factory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AnimalFactory {

    public static AnimalService retrieveAnimal(final Animal animal) {
        if (Animal.LION.equals(animal)) {
            return new Lion();
        }

        return new Dog();
    }
}
