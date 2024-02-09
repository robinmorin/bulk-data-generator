package com.personal.fields.behavior;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Random;

public class RandomValueBehavior<N extends Number> {

    private final N minValue;
    private final N maxValue;
    Random random = new Random();

    @Getter
    private N lastValue;

    public RandomValueBehavior(N minValue, N maxValue) {
        if(minValue == null || maxValue == null ||
          !minValue.getClass().getTypeName().equals(maxValue.getClass().getTypeName()) ||
           isNotTypeNumberBasic(minValue) || isNotTypeNumberBasic(maxValue)){
                throw new IllegalArgumentException("Min and Max value have invalid type or null");
        }
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    private <N extends Number> boolean isNotTypeNumberBasic(N number){
        return !(number instanceof Integer) && !(number instanceof Long) && !(number instanceof Float) && !(number instanceof Double) && !(number instanceof BigDecimal);
    }

    public N getRandomNumber(){
        lastValue = switch (minValue.getClass().getTypeName()) {
            case "java.lang.Integer" ->
                    (N) Integer.valueOf(random.nextInt((maxValue.intValue() - minValue.intValue()) + 1) + minValue.intValue());
            case "java.lang.Long" ->
                    (N) Long.valueOf(random.nextLong((maxValue.longValue() - minValue.longValue()) + 1) + minValue.longValue());
            case "java.lang.Float" ->
                    (N) Float.valueOf(random.nextFloat((maxValue.floatValue() - minValue.floatValue()) + 1) + minValue.floatValue());
            case "java.lang.Double" ->
                    (N) Double.valueOf(random.nextDouble((maxValue.doubleValue() - minValue.doubleValue()) + 1) + minValue.doubleValue());
            case "java.math.BigDecimal" ->
                    (N) BigDecimal.valueOf(random.nextDouble((maxValue.doubleValue() - minValue.doubleValue()) + 1) + minValue.doubleValue());
            default -> throw new IllegalArgumentException("Min and Max value have invalid type or null");
        };
        return lastValue;
    }

}
