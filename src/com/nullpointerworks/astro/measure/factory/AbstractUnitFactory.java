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
		case METER: return new MeterUnitFactory();
		case MILLI: return new MeterUnitFactory(0.001);
		case MICRO: return new MeterUnitFactory(0.000001);
		case NANO: return new MeterUnitFactory(0.000000001);
		
		case INCH: return new InchUnitFactory();

		case ARCMINUTE:
		case ARCSECOND:
		case DEGREE: return new DegreeUnitFactory();
		case RADIAN: return new RadianUnitFactory();
		
		default: return null;
		}
	}
}
