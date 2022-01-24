package com.nullpointerworks.astro;

import com.nullpointerworks.astro.measure.IMeasurement;
import com.nullpointerworks.astro.measure.IlligalConversionException;
import com.nullpointerworks.astro.measure.Unit;
import com.nullpointerworks.astro.measure.factory.AbstractMeasurementFactory;
import com.nullpointerworks.astro.measure.factory.InchMeasurementFactory;
import com.nullpointerworks.astro.measure.factory.MilliMeasurementFactory;

public class Measurement implements IMeasurement
{
	private final IMeasurement control;
	private final double v;
	private final Unit u;
	
	public Measurement(double value, Unit unit) 
	{
		this(null, value, unit);
	}
	
	public Measurement(IMeasurement parent, double value, Unit unit) 
	{
		control = parent;
		v = value;
		u = unit;
	}
	
	public IMeasurement getControl()
	{
		//if (control!=null) return control.getControl();
		return control;
	}
	
	public double getValue()
	{
		return v;
	}
	
	public Unit getUnit()
	{
		return u;
	}
	
	public IMeasurement toUnit(Unit newUnit) throws IlligalConversionException
	{
		if (u == newUnit) return this;
		
		AbstractMeasurementFactory fac;
		switch(newUnit)
		{
		case MILLI:
			fac = new MilliMeasurementFactory();
			return fac.convert(this);
			
		case INCH:
			fac = new InchMeasurementFactory();
			return fac.convert(this);
		
		default: break;
		}
		
		throw new IlligalConversionException();
	}
	
}
