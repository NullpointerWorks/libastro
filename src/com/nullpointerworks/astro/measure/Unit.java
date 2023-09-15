package com.nullpointerworks.astro.measure;

/**
 * 
 */
public enum Unit 
{
	// == metric ================================================
	
	/**
	 * meters 10^0
	 */
	METER("m"),
	
	/**
	 * millimeters 10^-3
	 */
	MILLI("mm"),
	
	/**
	 * micrometers (micron) 10^-6
	 */
	MICRO("um"),
	
	/**
	 * nanometers 10^-9
	 */
	NANO("nm"),
	
	// == imperial ================================================
	
	/**
	 * inches
	 */
	INCH("inch"),
	
	// == angle ================================================
	
	/**
	 * angle in radians
	 */
	RADIAN("rad"),
	
	/**
	 * angle in degrees
	 */
	DEGREE("deg"),
	
	/**
	 * one minute of arc
	 */
	ARCMINUTE("arcmin"),
	
	/**
	 * one second of arc
	 */
	ARCSECOND("arcsec"),
	
	// == other ================================================
	
	/**
	 * a ratio
	 */
	RATIO("ratio"),
	
	/**
	 * pixels
	 */
	PIXEL("px");
	
	private final String name;
	private Unit(String n) {name = n;}
	public String toString() {return name;}
	
	/**
	 * Quickly create a measurement object of the accessing unit type with a given value.
	 * @param v - value of the measurement
	 * @return a measurement object of the accessing unit type
	 */
	public IMeasurement value(double v)
	{
		return new Measurement(v, this);
	}
}
