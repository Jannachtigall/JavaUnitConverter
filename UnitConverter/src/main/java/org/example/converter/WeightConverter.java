package org.example.converter;

import org.example.exception.ConversionException;
import org.example.unit.WeightUnit;

public class WeightConverter extends BaseConverter<WeightUnit> {
    @Override
    public double convert(double value, WeightUnit firstUnit, WeightUnit secondUnit) throws ConversionException {
        if (value < 0) {
            throw new ConversionException("weight");
        }
        return value * firstUnit.getFactor(secondUnit);
    }
}
