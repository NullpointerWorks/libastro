package com.nullpointerworks.astro.measure;

/**
 * 
 */
public enum Unit 
{
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
	
	// ================================================
	
	/**
	 * inches
	 */
	INCH("inch"),

	// ================================================
	
	/**
	 * a ratio
	 */
	RATIO("ratio"),
	
	// ================================================
	
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
	ARCSECOND("arcsec");
	
	private final String name;
	private Unit(String n) {name = n;}
	public String toString() {return name;}
}
