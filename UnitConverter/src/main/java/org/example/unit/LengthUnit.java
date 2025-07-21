package org.example.unit;

import org.example.exception.WrongUnitException;

public enum LengthUnit {
    METER("meter") {
        @Override
        public double getFactor(LengthUnit unit) {
            switch (unit) {
                case MILE -> {
                    return 0.000621;
                }
                case KILOMETER -> {
                    return 0.001;
                }
                default -> {
                    return 1;
                }
            }
        }
    },
    KILOMETER("kilometer") {
        @Override
        public double getFactor(LengthUnit unit) {
            switch (unit) {
                case METER -> {
                    return 1000;
                }
                case MILE -> {
                    return 0.621371;
                }
                default -> {
                    return 1;
                }
            }
        }
    },
    MILE("mile") {
        @Override
        public double getFactor(LengthUnit unit) {
            switch (unit) {
                case METER -> {
                    return 1609.34;
                }
                case KILOMETER -> {
                    return 1.61;
                }
                default -> {
                    return 1;
                }
            }
        }
    };

    private String code;

    LengthUnit(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public abstract double getFactor(LengthUnit unit);

    public static LengthUnit getByCode(String code) throws WrongUnitException {
        for (LengthUnit val: LengthUnit.values()) {
            if (val.code.equals(code)) {
                return val;
            }
        }

        throw new WrongUnitException("length", code);
    }
}
