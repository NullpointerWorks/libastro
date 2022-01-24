package com.nullpointerworks.astro.measure;

import com.nullpointerworks.astro.Unit;
import com.nullpointerworks.astro.measure.factory.AbstractUnitFactory;

public class Measurement implements IMeasurement
{
	private final double v;
	private final Unit u;
	private final AbstractUnitFactory fac;
	
	private double cv;
	private Unit cu;
	
	public Measurement(double value, Unit unit) 
	{
		cv = v = value;
		cu = u = unit;
		fac = AbstractUnitFactory.getFactory(u);
	}
	
	public double getValue()
	{
		return cv;
	}
	
	public Unit getUnit()
	{
		return cu;
	}
	
	public void toUnit(Unit newUnit)
	{
		if (newUnit == u) return;
		cv = fac.convert(v, newUnit);
		cu = newUnit;
	}
}
