package org.example.converter;

import org.example.unit.TemperatureUnit;

public class TemperatureConverter extends BaseConverter<TemperatureUnit> {
    @Override
    public double convert(double value, TemperatureUnit firstUnit, TemperatureUnit secondUnit) {
        return firstUnit.getAction(value, secondUnit);
    }
}
