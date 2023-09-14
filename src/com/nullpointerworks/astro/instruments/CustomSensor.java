package com.nullpointerworks.astro.instruments;

import com.nullpointerworks.astro.measure.IMeasurement;
import com.nullpointerworks.astro.measure.Measurement;
import com.nullpointerworks.astro.measure.Unit;

public class CustomSensor implements ISensor
{
	private String sensorName = "<unnamed>";
	private IMeasurement pixSize;
	private IMeasurement sensorWidth;
	private IMeasurement sensorHeight;
	private int resolutionWidth;
	private int resolutionHeight;
	
	public CustomSensor() {}
	
	public CustomSensor(String name) 
	{
		setSensorName(name);
	}
	
	public void setSensorName(String name) 
	{
		sensorName = name;
	}
	
	public void setPixelSize(IMeasurement pxs) 
	{
		pixSize = pxs;
	}
	
	public void setSensorSize(IMeasurement sensorw, IMeasurement sensorh) 
	{
		sensorWidth = sensorw;
		sensorHeight = sensorh;
	}
	
	public void setSensorResolution(int width, int height) 
	{
		resolutionWidth = width;
		resolutionHeight = height;
	}
	
	
	
	
	public String getSensorName()
	{
		return sensorName;
	}
	
	public IMeasurement getPixelSize()
	{
		return pixSize;
	}
	
	public IMeasurement getPixelResolution(ITelescope scope)
	{
		IMeasurement focallength = scope.getFocalLength();
		focallength.setUnit(Unit.MILLI);
		pixSize.setUnit(Unit.MICRO);
		final double factor = 206.265;
		
		double fl = focallength.getValue();
		if (fl <= 0.0) fl = 0.0001;
		double px = pixSize.getValue();
		double arc = (px/fl) * factor;
		return new Measurement(arc, Unit.ARCSECOND);
	}
	
	
}
