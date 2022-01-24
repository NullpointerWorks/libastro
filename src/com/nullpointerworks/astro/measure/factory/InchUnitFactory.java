package com.nullpointerworks.astro.measure.factory;

import com.nullpointerworks.astro.Unit;

public class InchUnitFactory implements AbstractUnitFactory
{
	@Override
	public double convert(double v, Unit newUnit) 
	{
		switch(newUnit)
		{
		case MILLI: return v * 25.4;
		
		default: break;
		}
		return 0;
	}
}
