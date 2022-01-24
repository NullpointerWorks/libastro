package com.nullpointerworks.astro.measure.factory;

import com.nullpointerworks.astro.Unit;

public interface AbstractUnitFactory 
{
	double convert(double v, Unit newUnit);
	
	static AbstractUnitFactory getFactory(Unit unit)
	{
		switch(unit)
		{
		case MILLI: return new MilliUnitFactory();
		case INCH: return new InchUnitFactory();
		default: return null;
		}
	}
}
