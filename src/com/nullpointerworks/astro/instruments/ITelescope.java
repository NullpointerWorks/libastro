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
	 * The resolving power of a telescope is it's ability to distinguish details of incoming light. 
	 * When two packages of light get too close together they blend and mix their respective colors which in turn means detail was lost.
	 * The angle between two beams of light that the optics can just about tell apart is called the Rayleigh criterion. 
	 * This however depends on the size of the objective and the wavelength of light.
	 * <br><br>
	 * In practice the telescope's resolving power tells you the minimal angular size of a target you're still able to observe.
	 */
	IMeasurement getResolvingPower(IMeasurement wave);
	
	
}
