package com.nullpointerworks.astro.measure;

public interface IMeasurement 
{
	double getValue();
	Unit getUnit();
	
	void toUnit(Unit newUnit);
}
