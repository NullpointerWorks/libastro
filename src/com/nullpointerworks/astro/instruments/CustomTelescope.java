package com.nullpointerworks.astro.instruments;

import com.nullpointerworks.astro.measure.IMeasurement;
import com.nullpointerworks.astro.measure.Measurement;
import com.nullpointerworks.astro.measure.Unit;

public class CustomTelescope implements ITelescope 
{
	private final double INFINITY = 0.00001;
	private String n;
	private IMeasurement d;
	private IMeasurement fl;
	
	public CustomTelescope(String name) 
	{
		n = name;
	}
	
	public CustomTelescope(String name, IMeasurement aperature, IMeasurement focallength)
	{
		n = name;
		setDiameter(aperature);
		setFocalLength(focallength);
	}
	
	public String getName() {return n;}
	public void setDiameter(IMeasurement aperature) {d = aperature;}
	public void setFocalLength(IMeasurement focallength) {fl = focallength;}
	
	public IMeasurement getDiameter() {return d;}
	
	public IMeasurement getFocalLength() {return fl;}
	
	public IMeasurement getFocalRatio()
	{
		d.setUnit(Unit.MILLI);
		fl.setUnit(Unit.MILLI);
		
		/*
		
		fR = fT / dT
		
		*/
		
		double dia = d.getValue();
		double focal = fl.getValue();
		if (dia <= 0.0) dia = INFINITY; // infinity check
		double fr = focal / dia;
		
		return new Measurement(fr, Unit.RATIO);
	}

	@Override
	public IMeasurement getMagnification(IEyepiece ep) 
	{
		IMeasurement efl = ep.getFocalLength();
		fl.setUnit(Unit.MILLI);
		efl.setUnit(Unit.MILLI);
		
		/*
		
		mag = fT / fE
		
		*/
		
		double fE = efl.getValue();
		double fT = fl.getValue();
		if (fE <= 0.0) fE = INFINITY; // infinity check
		double mag = fT / fE;
		
		return new Measurement(mag, Unit.RATIO);
	}
	
	@Override
	public IMeasurement getExitPupil(IEyepiece ep) 
	{
		IMeasurement efl = ep.getFocalLength();
		d.setUnit(Unit.MILLI);
		fl.setUnit(Unit.MILLI);
		efl.setUnit(Unit.MILLI);
		
		/*
		
		exit pupil = fE / fR
		exit pupil = (fE * dT) / fT
		
		*/
		
		double fE = efl.getValue();
		double dT = d.getValue();
		double fT = fl.getValue();
		if (fT <= 0.0) fT = INFINITY; // infinity check
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
		if (factor <= 0.0) factor = INFINITY; // infinity check
		double tfov = fov / factor;
		
		return new Measurement(tfov, Unit.DEGREE);
	}
	
	/**
	 * Calculated the resolving power in radians using the Rayleigh criterion formula at a specified wavelength. 
	 */
	@Override
	public IMeasurement getResolvingPower(IMeasurement wavelength)
	{
		wavelength.setUnit(Unit.METER);
		d.setUnit(Unit.METER);
		
		/*
		
		sin(theta) = 1.22 * (wavelength / dT)
		
		*/
		
		double dia = d.getValue();
		if (dia <= 0.0) dia = INFINITY; // infinity check
		double theta = 1.22 * (wavelength.getValue() / d.getValue());
		double resp = StrictMath.asin(theta);
		return new Measurement(resp, Unit.RADIAN);
	}
	
	
}
