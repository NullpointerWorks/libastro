package com.nullpointerworks.astro.measure.factory;

import com.nullpointerworks.astro.measure.Unit;

public class DegreeUnitFactory implements AbstractUnitFactory
{
	private final double toRadian = 3.1415 / 180.0;
	
	@Override
	public boolean compatible(Unit newUnit) 
	{
		if (newUnit == Unit.RADIAN) return true;
		if (newUnit == Unit.ARCMINUTE) return true;
		if (newUnit == Unit.ARCSECOND) return true;
		return false;
	}
	
	@Override
	public double convert(double v, Unit newUnit) 
	{
		switch(newUnit)
		{
		case RADIAN: return v * toRadian;
		case ARCMINUTE: return v * 60.0;
		case ARCSECOND: return v * 3600.0;
		
		default: break;
		}
		return 0;
	}
}
