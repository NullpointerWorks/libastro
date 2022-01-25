package com.nullpointerworks.astro.measure.factory;

import com.nullpointerworks.astro.measure.Unit;

public interface AbstractUnitFactory 
{
	boolean compatible(Unit newUnit);
	double convert(double v, Unit newUnit);
	
	static AbstractUnitFactory getFactory(Unit unit)
	{
		switch(unit)
		{
		case MILLI: return new MilliUnitFactory();
		case INCH: return new InchUnitFactory();
		case DEGREE: return new DegreeUnitFactory();
		default: return null;
		}
	}
}
