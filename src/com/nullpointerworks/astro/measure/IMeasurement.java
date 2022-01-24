package com.nullpointerworks.astro.measure;

public interface IMeasurement 
{
	IMeasurement getControl();
	double getValue();
	Unit getUnit();
	
	IMeasurement toUnit(Unit newUnit) throws IlligalConversionException;
}
