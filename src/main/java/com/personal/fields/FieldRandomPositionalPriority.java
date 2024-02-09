package com.personal.fields;

import com.personal.config.FieldNameDefinition;
import com.personal.fields.behavior.RandomPositionalValueBehavior;
import com.personal.fields.behavior.RandomValueBehavior;
import lombok.Getter;

import java.util.List;

@Getter
public final class FieldRandomPositionalPriority<T> extends AbstractField implements IField<T> {
    private final List<RandomPositionalValueBehavior<T>> randomPositionalValueBehavior;
    private final List<T> highPriority;
    private final List<T> lowPriority;
    private final RandomValueBehavior<Integer> randomProbability = new RandomValueBehavior<>(0, 9);
    private final int[] probability = new int[10];
    private T lastValue;

    public FieldRandomPositionalPriority(FieldNameDefinition fieldName, int positionStart, int positionEnd, List<T> highPriority, List<T> lowPriority, int priorityLevel) {
        super(fieldName, positionStart, positionEnd);
        if(priorityLevel <= 0 || priorityLevel > 10) {
            throw new IllegalArgumentException("Priority level must be between 1 and 10");
        }
        randomPositionalValueBehavior = List.of(new RandomPositionalValueBehavior<>(highPriority), new RandomPositionalValueBehavior<>(lowPriority));
        this.highPriority = highPriority;
        this.lowPriority = lowPriority;
        for(int i = 0; i < 10; i++) {
            probability[i] = (i < priorityLevel)? 0: 1;
        }
    }

    public T getValue() {
        lastValue = randomPositionalValueBehavior.get(getSelectorProbability()).getRandomValue();
        return lastValue;
    }

    @Override
    public T getActualValue() {
        return lastValue;
    }

    private int getSelectorProbability() {
        return probability[randomProbability.getRandomNumber()];
    }

}
