package com.nullpointerworks.astro.measure.factory;

import com.nullpointerworks.astro.measure.LengthUnit;

public interface AbstractLengthUnitFactory 
{
	double convert(double v, LengthUnit newUnit);
	
	static AbstractLengthUnitFactory getFactory(LengthUnit unit)
	{
		switch(unit)
		{
		case MILLI: return new MilliLengthUnitFactory();
		case INCH: return new InchLengthUnitFactory();
		default: return null;
		}
	}
}
