package com.nullpointerworks.astro.measure.factory;

import com.nullpointerworks.astro.measure.Unit;

public class MilliUnitFactory implements AbstractUnitFactory
{
	@Override
	public boolean compatible(Unit newUnit) 
	{
		if (newUnit == Unit.INCH) return true;
		if (newUnit == Unit.NANO) return true;
		return false;
	}
	
	@Override
	public double convert(double v, Unit newUnit) 
	{
		switch(newUnit)
		{
		case NANO: return v * 1000.0;
		case INCH: return v * 0.03937008;
		
		default: break;
		}
		return 0;
	}
}
