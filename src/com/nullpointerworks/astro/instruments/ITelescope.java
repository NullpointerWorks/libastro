package com.nullpointerworks.astro.instruments;

import com.nullpointerworks.astro.measure.IMeasurement;

/**
 * 
 */
public interface ITelescope 
{
	/**
	 * 
	 */
	String getName();
	
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
	 * Calculated the resolving power in radians using the Rayleigh criterion formula at a specified wavelength. 
	 */
	IMeasurement getResolvingPower(IMeasurement wave);
	
	
}
