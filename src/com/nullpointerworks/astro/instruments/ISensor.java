package com.nullpointerworks.astro.instruments;

import com.nullpointerworks.astro.measure.IMeasurement;

public interface ISensor 
{
	void setSensorName(String name);
	
	void setPixelSize(IMeasurement pxs);
	
	void setSensorSize(IMeasurement sensorw, IMeasurement sensorh);
	
	void setSensorResolution(int pxw, int pxh);
	
	
	
	
	String getSensorName();
	
	IMeasurement getPixelSize();
	
	IMeasurement getPixelResolution(ITelescope scope);
	
}
