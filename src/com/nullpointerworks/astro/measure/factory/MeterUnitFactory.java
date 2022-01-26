package com.nullpointerworks.astro.measure.factory;

import com.nullpointerworks.astro.measure.Unit;

public class MeterUnitFactory implements AbstractUnitFactory
{
	private final double offset;
	
	public MeterUnitFactory() 
	{
		offset = 1.0;
	}
	
	public MeterUnitFactory(double factor)
	{
		offset = factor;
	}
	
	@Override
	public boolean compatible(Unit newUnit) 
	{
		if (newUnit == Unit.METER) return true;
		if (newUnit == Unit.MILLI) return true;
		if (newUnit == Unit.MICRO) return true;
		if (newUnit == Unit.NANO) return true;
		if (newUnit == Unit.INCH) return true;
		return false;
	}
	
	@Override
	public double convert(double v, Unit newUnit) 
	{
		double o = v * offset;
		switch(newUnit)
		{
		case METER: return o;
		case MILLI: return o * 1000.0;
		case MICRO: return o * 1000_000.0;
		case NANO: return o * 1000_000_000.0;
		case INCH: return o * 39.37008;
		
		default: break;
		}
		return 0;
	}
}
