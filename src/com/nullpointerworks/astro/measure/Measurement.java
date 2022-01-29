package com.nullpointerworks.astro.measure;

import com.nullpointerworks.astro.measure.factory.AbstractUnitFactory;

public class Measurement implements IMeasurement
{
	private final double v;
	private final AbstractUnitFactory fac;
	
	private double cv;
	private Unit cu;
	
	public Measurement(double value, Unit unit) 
	{
		cv = v = value;
		cu = unit;
		fac = AbstractUnitFactory.getFactory(unit);
	}
	
	public double getValue()
	{
		return cv;
	}
	
	public Unit getUnit()
	{
		return cu;
	}
	
	public boolean setUnit(Unit newUnit)
	{
		if (!fac.compatible(newUnit)) return false;
		if (newUnit == cu) return true;
		cv = fac.convert(v, newUnit);
		cu = newUnit;
		return true;
	}
}
