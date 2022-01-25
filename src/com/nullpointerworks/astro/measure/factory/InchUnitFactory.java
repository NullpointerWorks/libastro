package com.nullpointerworks.astro.measure.factory;

import com.nullpointerworks.astro.measure.Unit;

public class InchUnitFactory implements AbstractUnitFactory
{
	@Override
	public boolean compatible(Unit newUnit) 
	{
		if (newUnit == Unit.MILLI) return true;
		if (newUnit == Unit.NANO) return true;
		return false;
	}
	
	@Override
	public double convert(double v, Unit newUnit) 
	{
		switch(newUnit)
		{
		case MILLI: return v * 25.4;
		case NANO: return v * 25400.0;
		
		default: break;
		}
		return 0;
	}
}
