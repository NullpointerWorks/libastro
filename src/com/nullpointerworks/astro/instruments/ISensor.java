package com.nullpointerworks.astro.instruments;

import com.nullpointerworks.astro.measure.IMeasurement;

public interface ISensor 
{
	String getSensorName();
	IMeasurement getPixelSize();
	IMeasurement getPixelResolution(IMeasurement tfl);
	
	void setSensorName(String name);
	void setPixelSize(IMeasurement pxs);
}
