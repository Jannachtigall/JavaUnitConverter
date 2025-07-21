package org.example.converter;

import org.example.exception.ConversionException;

public abstract class BaseConverter<T> {
    public abstract double convert (double value, T firstUnit, T secondUnit) throws ConversionException;
}
