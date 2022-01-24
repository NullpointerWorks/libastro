package com.nullpointerworks.astro.measure.factory;

import com.nullpointerworks.astro.Unit;

public class MilliUnitFactory implements AbstractUnitFactory
{
	@Override
	public double convert(double v, Unit newUnit) 
	{
		switch(newUnit)
		{
		case INCH: return v * 0.03937008;
		
		default: break;
		}
		return 0;
	}
}
