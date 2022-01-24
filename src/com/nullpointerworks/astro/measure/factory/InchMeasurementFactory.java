package com.nullpointerworks.astro.measure.factory;

import com.nullpointerworks.astro.Measurement;
import com.nullpointerworks.astro.measure.IMeasurement;
import com.nullpointerworks.astro.measure.IlligalConversionException;
import com.nullpointerworks.astro.measure.Unit;

public class InchMeasurementFactory implements AbstractMeasurementFactory
{
	
	public IMeasurement convert(IMeasurement m) throws IlligalConversionException
	{
		IMeasurement control = m.getControl();
		Unit sourceUnit = m.getUnit();
		switch (sourceUnit)
		{
		case MILLI: return fromMilli(m);
		default: break;
		}
		
		throw new IlligalConversionException();
	}
	
	private IMeasurement fromMilli(IMeasurement m)
	{
		double v = m.getValue() * 0.00393700787401574803149606299;
		return new Measurement(v, Unit.INCH);
	}
	
}
