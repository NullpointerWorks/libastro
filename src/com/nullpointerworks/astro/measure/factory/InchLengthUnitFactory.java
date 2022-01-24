package com.nullpointerworks.astro.measure.factory;

import com.nullpointerworks.astro.measure.LengthUnit;

public class InchLengthUnitFactory implements AbstractLengthUnitFactory
{
	@Override
	public double convert(double v, LengthUnit newUnit) 
	{
		switch(newUnit)
		{
		case MILLI: return v * 25.4;
		
		default: break;
		}
		return 0;
	}
}
