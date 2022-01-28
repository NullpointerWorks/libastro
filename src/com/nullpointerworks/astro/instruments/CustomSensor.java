package com.nullpointerworks.astro.instruments;

import com.nullpointerworks.astro.measure.IMeasurement;

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
	
	public void setSensorName(String name) 
	{
		sensorName = name;
	}
	
	public void setPixelSize(IMeasurement pxs) 
	{
		pixSize = pxs;
	}
	
	
	
}
