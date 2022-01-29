package com.nullpointerworks.astro.instruments;

import com.nullpointerworks.astro.measure.IMeasurement;
import com.nullpointerworks.astro.measure.Measurement;
import com.nullpointerworks.astro.measure.Unit;

public class CustomSensor implements ISensor
{
	private String sensorName = "<not named>";
	private IMeasurement pixSize;
	
	public CustomSensor() {}
	public CustomSensor(String name) 
	{
		setSensorName(name);
	}
	
	public String getSensorName()
	{
		return sensorName;
	}
	
	public IMeasurement getPixelSize()
	{
		return pixSize;
	}
	
	public IMeasurement getPixelResolution(IMeasurement tfl)
	{
		tfl.setUnit(Unit.MILLI);
		pixSize.setUnit(Unit.MICRO);
		final double factor = 206.265;
		
		double fl = tfl.getValue();
		if (fl <= 0.0) fl = 0.0001;
		double px = pixSize.getValue();
		double arc = (px/fl) * factor;
		return new Measurement(arc, Unit.ARCSECOND);
	}
	
	public void setSensorName(String name) 
	{
		sensorName = name;
	}
	
	public void setPixelSize(IMeasurement pxs) 
	{
		pixSize = pxs;
	}
	
	
	
}
