package com.nullpointerworks.astro;

import com.nullpointerworks.astro.instruments.CustomTelescope;
import com.nullpointerworks.astro.instruments.ITelescope;
import com.nullpointerworks.astro.measure.IMeasurement;
import com.nullpointerworks.astro.measure.IlligalConversionException;
import com.nullpointerworks.astro.measure.Unit;

/*


fT / fE = mag
fT / dT = fR

fE / fR = exit pupil
(fE * dT) / fT = exit pupil




*/

public class MainTest 
{
	
	public static void main(String[] args) 
	{
		new MainTest();
	}
	
	public MainTest()
	{
		
		IMeasurement scopeDiameter 		= new Measurement(70.0f, Unit.MILLI);
		IMeasurement scopeFocalLength 	= new Measurement(420.0f, Unit.MILLI);
		
		System.out.println("diameter in mm: "+scopeDiameter.getValue());
		

		try 
		{
			System.out.println("diameter in inch: "+scopeDiameter.toUnit(Unit.INCH).getValue());
		} 
		catch (IlligalConversionException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			System.out.println("diameter in mm: "+scopeDiameter.toUnit(Unit.MILLI).getValue());
		} 
		catch (IlligalConversionException e) 
		{
			e.printStackTrace();
		}
		
		
		
		ITelescope scope = new CustomTelescope(scopeDiameter, scopeFocalLength);
		
		
		
		
		
		
		
		
	}
	
	
}
