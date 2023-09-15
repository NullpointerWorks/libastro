package com.nullpointerworks.astro.instruments;

import com.nullpointerworks.astro.measure.IMeasurement;

public interface ISensor 
{
	void setSensorName(String name);
	
	void setPixelSize(IMeasurement pxs);
	
	void setSensorSize(IMeasurement sensorw, IMeasurement sensorh);
	
	void setResolution(IMeasurement pxw, IMeasurement pxh);
	
	
	
	String getSensorName();
	
	IMeasurement getPixelSize();
	
	IMeasurement getPixelAngularResolution(ITelescope scope);
	
	IMeasurement getSensorWidth();
	
	IMeasurement getSensorHeight();
	
	IMeasurement getResolutionWidth();
	
	IMeasurement getResolutionHeight();
	
}
