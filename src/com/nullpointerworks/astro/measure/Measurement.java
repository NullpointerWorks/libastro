package com.nullpointerworks.astro.measure;

import com.nullpointerworks.astro.measure.factory.AbstractUnitFactory;

/**
 * The Measurement class manages the unit, value and conversion of a particular unit type.
 */
public class Measurement implements IMeasurement
{
	private final double v; // the original value at instantiation. 
	private final AbstractUnitFactory fac; // a conversion factory for this unit.
	
	private double cv; // the current value
	private Unit cu; // the current unit
	
	public Measurement(double value, Unit unit) 
	{
		fac = AbstractUnitFactory.getFactory(unit);
		cv = v = value;
		cu = unit;
	}

	/**
	 * Returns the current value of the stored unit type.
	 */
	public double getValue()
	{
		return cv;
	}

	/**
	 * Returns the unit type of the associated value.
	 */
	public Unit getUnit()
	{
		return cu;
	}

	/**
	 * Convert the current unit into another unit. 
	 * This method returns false if the requested unit is not compatible, true otherwise.
	 */
	public boolean setUnit(Unit newUnit)
	{
		if (!fac.compatible(newUnit)) return false;
		if (newUnit == cu) return true;
		cv = fac.convert(v, newUnit);
		cu = newUnit;
		return true;
	}
}
