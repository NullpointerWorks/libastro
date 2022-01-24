package com.nullpointerworks.astro.measure.factory;

import com.nullpointerworks.astro.Measurement;
import com.nullpointerworks.astro.measure.IMeasurement;
import com.nullpointerworks.astro.measure.IlligalConversionException;
import com.nullpointerworks.astro.measure.Unit;

public class MilliMeasurementFactory implements AbstractMeasurementFactory
{
	
	public IMeasurement convert(IMeasurement m) throws IlligalConversionException
	{
		Unit sourceUnit = m.getUnit();
		switch (sourceUnit)
		{
		case INCH: return fromInch(m);
		default: break;
		}
		throw new IlligalConversionException();
	}
	
	
	private IMeasurement fromInch(IMeasurement m)
	{
		double v = m.getValue() * 25.4;
		return new Measurement(v, Unit.MILLI);
	}
	
}
