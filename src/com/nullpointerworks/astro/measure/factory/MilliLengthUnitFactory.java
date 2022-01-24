package com.nullpointerworks.astro.measure.factory;

import com.nullpointerworks.astro.measure.LengthUnit;

public class MilliLengthUnitFactory implements AbstractLengthUnitFactory
{
	@Override
	public double convert(double v, LengthUnit newUnit) 
	{
		switch(newUnit)
		{
		case INCH: return v * 0.03937008;
		
		default: break;
		}
		return 0;
	}
}
