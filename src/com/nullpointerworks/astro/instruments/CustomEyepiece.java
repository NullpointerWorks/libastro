package com.nullpointerworks.astro.instruments;

import com.nullpointerworks.astro.measure.IMeasurement;

public class CustomEyepiece implements IEyepiece 
{
	private IMeasurement fl;
	private IMeasurement fov;
	
	public CustomEyepiece(IMeasurement focalLength, IMeasurement afov)
	{
		fl = focalLength;
		fov = afov;
	}
	
	public IMeasurement getFocalLength()
	{
		return fl;
	}
	
	public IMeasurement getApparentFieldOfView()
	{
		return fov;
	}
}
