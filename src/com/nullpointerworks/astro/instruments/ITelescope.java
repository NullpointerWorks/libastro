package com.nullpointerworks.astro.instruments;

import com.nullpointerworks.astro.measure.IMeasurement;

public interface ITelescope 
{
	
	/**
	 * 
	 */
	void setDiameter(IMeasurement d);
	
	/**
	 * 
	 */
	void setFocalLength(IMeasurement fl);
	
	/**
	 * 
	 */
	IMeasurement getDiameter();
	
	/**
	 * 
	 */
	IMeasurement getFocalLength();
	
	/**
	 * 
	 */
	IMeasurement getFocalRatio();
	
	/**
	 * 
	 */
	IMeasurement getMagnification(IEyepiece ep);
	
	/**
	 * 
	 */
	IMeasurement getExitPupil(IEyepiece ep);
	
	/**
	 * 
	 */
	IMeasurement getTrueFieldOfView(IEyepiece ep);
	
	/**
	 * Takes the selected wavelength in nanometers and returns the minimum 
	 * resolving power based on Rayleigh’s criterion in radians.
	 */
	IMeasurement getResolvingPower(IMeasurement wave);
	
	
}
