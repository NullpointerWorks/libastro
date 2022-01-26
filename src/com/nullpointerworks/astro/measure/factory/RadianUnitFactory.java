package com.nullpointerworks.astro.measure.factory;

import com.nullpointerworks.astro.measure.Unit;

public class RadianUnitFactory implements AbstractUnitFactory
{
	private final double toDegree = 180.0 / 3.1415;
	private final double toMinute = 3437.746771;
	private final double toSecond = 206264.80627;
	
	@Override
	public boolean compatible(Unit newUnit) 
	{
		if (newUnit == Unit.DEGREE) return true;
		if (newUnit == Unit.ARCMINUTE) return true;
		if (newUnit == Unit.ARCSECOND) return true;
		return false;
	}
	
	@Override
	public double convert(double v, Unit newUnit) 
	{
		switch(newUnit)
		{
		case DEGREE: return v * toDegree;
		case ARCMINUTE: return v * toMinute;
		case ARCSECOND: return v * toSecond; // toMinute * 60.0
		
		default: break;
		}
		return 0;
	}
}
