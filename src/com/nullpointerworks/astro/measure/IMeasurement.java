package com.nullpointerworks.astro.measure;

public interface IMeasurement 
{
	double getValue();
	Unit getUnit();
	boolean setUnit(Unit newUnit);
}
