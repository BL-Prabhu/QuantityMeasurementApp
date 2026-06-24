package model;

public interface IMeasurable {

    double getConversionFactor();   // ✅ ADD THIS

    double convertToBaseUnit(double value);

    double convertFromBaseUnit(double baseValue);

    String getUnitName();
}