package com.nullpointerworks.astro;

import com.nullpointerworks.astro.instruments.CustomTelescope;
import com.nullpointerworks.astro.instruments.ITelescope;
import com.nullpointerworks.astro.measure.IMeasurement;
import com.nullpointerworks.astro.measure.Measurement;

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
		
		ITelescope scope = new CustomTelescope(scopeDiameter, scopeFocalLength);
		
		IMeasurement focalRatio = scope.getFocalRatio();
		
		
		
		
		
		System.out.println("focal ratio: "+focalRatio.getValue());
		
		
		
	}
	
	
}
