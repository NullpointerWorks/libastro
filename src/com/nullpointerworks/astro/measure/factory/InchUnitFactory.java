package com.nullpointerworks.astro.measure.factory;

import com.nullpointerworks.astro.measure.Unit;

public class InchUnitFactory implements AbstractUnitFactory
{
	@Override
	public boolean compatible(Unit newUnit) 
	{
		if (newUnit == Unit.METER) return true;
		if (newUnit == Unit.MILLI) return true;
		if (newUnit == Unit.MICRO) return true;
		if (newUnit == Unit.NANO) return true;
		return false;
	}
	
	@Override
	public double convert(double v, Unit newUnit) 
	{
		switch(newUnit)
		{
		case METER: return v * 0.0254;
		case MILLI: return v * 25.4;
		case MICRO: return v * 25400.0;
		case NANO: return v *  25400000.0;
		
		default: break;
		}
		return 0;
	}
}
