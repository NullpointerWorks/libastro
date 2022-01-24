package com.nullpointerworks.astro.measure.factory;

import com.nullpointerworks.astro.measure.IMeasurement;
import com.nullpointerworks.astro.measure.IlligalConversionException;

public interface AbstractMeasurementFactory 
{
	IMeasurement convert(IMeasurement m) throws IlligalConversionException;
}
