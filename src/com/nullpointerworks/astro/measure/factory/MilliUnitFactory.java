package com.nullpointerworks.astro.measure.factory;

import com.nullpointerworks.astro.measure.Unit;

public class MilliUnitFactory implements AbstractUnitFactory
{
	@Override
	public boolean compatible(Unit newUnit) 
	{
		if (newUnit == Unit.METER) return true;
		if (newUnit == Unit.MICRO) return true;
		if (newUnit == Unit.NANO) return true;
		if (newUnit == Unit.INCH) return true;
		return false;
	}
	
	@Override
	public double convert(double v, Unit newUnit) 
	{
		switch(newUnit)
		{
		case METER: return v * 0.001;
		case MICRO: return v * 1000.0;
		case NANO: return v * 1000_000.0;
		case INCH: return v * 0.03937008;
		
		default: break;
		}
		return 0;
	}
}
