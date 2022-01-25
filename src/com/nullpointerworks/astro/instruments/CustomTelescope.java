package com.nullpointerworks.astro.instruments;

import com.nullpointerworks.astro.measure.IMeasurement;
import com.nullpointerworks.astro.measure.Measurement;
import com.nullpointerworks.astro.measure.Unit;

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
		
		/*
		
		fT / dT = fR
		
		*/
		
		double dia = d.getValue();
		double focal = fl.getValue();
		if (dia < 0.0) dia = 0.0001f; // infinity error check
		double fr = focal / dia;
		
		return new Measurement(fr, Unit.FACTOR);
	}

	@Override
	public IMeasurement getMagnification(IEyepiece ep) 
	{
		IMeasurement efl = ep.getFocalLength();
		fl.toUnit(Unit.MILLI);
		efl.toUnit(Unit.MILLI);
		
		/*
		
		fT / fE = mag
		
		*/

		double fE = efl.getValue();
		double fT = fl.getValue();
		if (fE < 0.0) fE = 0.0001f; // infinity error check
		double mag = fT / fE;
		
		return new Measurement(mag, Unit.FACTOR);
	}

	@Override
	public IMeasurement getExitPupil(IEyepiece ep) 
	{
		IMeasurement efl = ep.getFocalLength();
		d.toUnit(Unit.MILLI);
		fl.toUnit(Unit.MILLI);
		efl.toUnit(Unit.MILLI);
		
		/*
		
		fE / fR = exit pupil
		(fE * dT) / fT = exit pupil
		
		*/
		
		double fE = efl.getValue();
		double dT = d.getValue();
		double fT = fl.getValue();
		if (fT < 0.0) fT = 0.0001f; // infinity error check
		double exitPupil = (fE * dT) / fT;
		
		return new Measurement(exitPupil, Unit.MILLI);
	}
	
	@Override
	public IMeasurement getTrueFieldOfView(IEyepiece ep) 
	{
		IMeasurement mag = getMagnification(ep);
		IMeasurement afov = ep.getApparentFieldOfView();
		
		
		
		return null;
	}
	
	
	
	
}
