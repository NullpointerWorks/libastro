package com.nullpointerworks.astro.instruments;

import com.nullpointerworks.astro.measure.IMeasurement;

public class CustomEyepiece implements IEyepiece 
{
	private IMeasurement fl;
	private IMeasurement fov;
	
	public CustomEyepiece() {}
	
	public CustomEyepiece(IMeasurement focalLength, IMeasurement afov)
	{
		setFocalLength(focalLength);
		setApparentFieldOfView(afov);
	}
	
	public void setFocalLength(IMeasurement focalLength)
	{
		fl = focalLength;
	}
	
	public void setApparentFieldOfView(IMeasurement afov)
	{
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
