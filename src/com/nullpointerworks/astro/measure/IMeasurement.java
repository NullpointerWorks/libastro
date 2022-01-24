package com.nullpointerworks.astro.measure;

import com.nullpointerworks.astro.Unit;

public interface IMeasurement 
{
	double getValue();
	Unit getUnit();
	
	void toUnit(Unit newUnit);
}
