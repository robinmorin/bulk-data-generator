package com.personal.fields.behavior;

import java.util.List;

public class RandomPositionalValueBehavior<T> extends RandomValueBehavior<Integer> {

    private final List<T> elementForRandom;

    public RandomPositionalValueBehavior(List<T> elementForRandom) {
        super(0, elementForRandom.size() - 1);
        this.elementForRandom = elementForRandom;
    }

    public T getRandomValue(){
        return elementForRandom.get(getRandomNumber());
    }

    public T getActualValue(){
        return elementForRandom.get(getLastValue());
    }

}
