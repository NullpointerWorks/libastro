package com.nullpointerworks.astro.instruments;

import com.nullpointerworks.astro.Unit;
import com.nullpointerworks.astro.measure.IMeasurement;
import com.nullpointerworks.astro.measure.Measurement;

public class CustomTelescope implements ITelescope 
{
	private IMeasurement d;
	private IMeasurement fl;
	
	public CustomTelescope(IMeasurement aperature, IMeasurement focallength)
	{
		d = aperature;
		fl = focallength;
		
		
		
		
	}
	
	public IMeasurement getFocalRatio()
	{
		d.toUnit(Unit.MILLI);
		fl.toUnit(Unit.MILLI);
		
		double dia = d.getValue();
		double focal = fl.getValue();
		if (dia < 0.0) dia = 0.0001f; // infinity error check
		double fr = focal / dia;
		
		return new Measurement(fr, Unit.FACTOR);
	}
	
	
	
	
}
