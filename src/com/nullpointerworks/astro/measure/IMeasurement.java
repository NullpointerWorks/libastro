package com.nullpointerworks.astro.measure;

/**
 * An interface for measurement objects. This allows for better management of unit conversion.
 */
public interface IMeasurement 
{
	/**
	 * Returns the current value of the stored unit type.
	 */
	double getValue();
	
	/**
	 * Returns the unit type of the associated value.
	 */
	Unit getUnit();
	
	/**
	 * Convert the current unit into another unit. 
	 * This method returns false if the requested unit is not compatible, true otherwise.
	 */
	boolean setUnit(Unit newUnit);
}
