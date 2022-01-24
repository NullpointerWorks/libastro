package com.nullpointerworks.astro;

import com.nullpointerworks.astro.instruments.CustomTelescope;
import com.nullpointerworks.astro.instruments.ITelescope;
import com.nullpointerworks.astro.measure.IMeasurement;
import com.nullpointerworks.astro.measure.LengthUnit;

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
		
		IMeasurement scopeDiameter 		= new Measurement(70.0f, LengthUnit.MILLI);
		IMeasurement scopeFocalLength 	= new Measurement(420.0f, LengthUnit.MILLI);
		
		
		ITelescope scope = new CustomTelescope(scopeDiameter, scopeFocalLength);
		
		
		
		
		
		
	}
	
	
}
