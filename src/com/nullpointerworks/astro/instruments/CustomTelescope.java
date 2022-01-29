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
	
	public IMeasurement getDiameter()
	{
		return d;
	}
	
	public IMeasurement getFocalLength()
	{
		return fl;
	}
	
	public IMeasurement getFocalRatio()
	{
		d.setUnit(Unit.MILLI);
		fl.setUnit(Unit.MILLI);
		
		/*
		
		fT / dT = fR
		
		*/
		
		double dia = d.getValue();
		double focal = fl.getValue();
		if (dia <= 0.0) dia = 0.0001f; // infinity error check
		double fr = focal / dia;
		
		return new Measurement(fr, Unit.FACTOR);
	}

	@Override
	public IMeasurement getMagnification(IEyepiece ep) 
	{
		IMeasurement efl = ep.getFocalLength();
		fl.setUnit(Unit.MILLI);
		efl.setUnit(Unit.MILLI);
		
		/*
		
		fT / fE = mag
		
		*/
		
		double fE = efl.getValue();
		double fT = fl.getValue();
		if (fE <= 0.0) fE = 0.0001f; // infinity error check
		double mag = fT / fE;
		
		return new Measurement(mag, Unit.FACTOR);
	}

	@Override
	public IMeasurement getExitPupil(IEyepiece ep) 
	{
		IMeasurement efl = ep.getFocalLength();
		d.setUnit(Unit.MILLI);
		fl.setUnit(Unit.MILLI);
		efl.setUnit(Unit.MILLI);
		
		/*
		
		fE / fR = exit pupil
		(fE * dT) / fT = exit pupil
		
		*/
		
		double fE = efl.getValue();
		double dT = d.getValue();
		double fT = fl.getValue();
		if (fT <= 0.0) fT = 0.0001f; // infinity error check
		double exitPupil = (fE * dT) / fT;
		
		return new Measurement(exitPupil, Unit.MILLI);
	}
	
	@Override
	public IMeasurement getTrueFieldOfView(IEyepiece ep) 
	{
		IMeasurement mag = getMagnification(ep);
		IMeasurement afov = ep.getApparentFieldOfView();
		afov.setUnit(Unit.DEGREE);
		
		double factor = mag.getValue();
		double fov = afov.getValue();
		if (factor <= 0.0) factor = 0.0001f; // infinity error check
		double tfov = fov / factor;
		
		return new Measurement(tfov, Unit.DEGREE);
	}
	
	@Override
	public IMeasurement getResolvingPower(IMeasurement wave)
	{
		wave.setUnit(Unit.METER);
		d.setUnit(Unit.METER);
		
		/*
		
		sin(theta) = 1.22 * (wavelength / dT)
		
		*/
		
		double dia = d.getValue();
		if (dia <= 0.0) dia = 0.0001f; // infinity error check
		double theta = 1.22 * (wave.getValue() / d.getValue());
		double resp = StrictMath.asin(theta);
		return new Measurement(resp, Unit.RADIAN);
	}
	
	
}
