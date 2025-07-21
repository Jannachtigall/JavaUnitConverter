package org.example.converter;

import org.example.exception.ConversionException;
import org.example.unit.LengthUnit;

public class LengthConverter extends BaseConverter<LengthUnit> {
    @Override
    public double convert(double value, LengthUnit firstUnit, LengthUnit secondUnit) throws ConversionException {
        if (value < 0) {
            throw new ConversionException("length");
        }
        return value * firstUnit.getFactor(secondUnit);
    }
}
