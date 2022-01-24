package com.nullpointerworks.astro.measure;

public interface IMeasurement 
{
	double getValue();
	LengthUnit getUnit();
	
	void toUnit(LengthUnit newUnit);
}
