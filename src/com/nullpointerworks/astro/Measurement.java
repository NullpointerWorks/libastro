package com.nullpointerworks.astro;

import com.nullpointerworks.astro.measure.IMeasurement;
import com.nullpointerworks.astro.measure.LengthUnit;
import com.nullpointerworks.astro.measure.factory.AbstractLengthUnitFactory;

public class Measurement implements IMeasurement
{
	private final double v;
	private final LengthUnit u;
	private final AbstractLengthUnitFactory fac;
	
	private double cv;
	private LengthUnit cu;
	
	public Measurement(double value, LengthUnit unit) 
	{
		cv = v = value;
		cu = u = unit;
		fac = AbstractLengthUnitFactory.getFactory(u);
	}
	
	public double getValue()
	{
		return cv;
	}
	
	public LengthUnit getUnit()
	{
		return cu;
	}
	
	public void toUnit(LengthUnit newUnit)
	{
		cv = fac.convert(v, newUnit);
		cu = newUnit;
	}
}
