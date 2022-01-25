package com.nullpointerworks.astro;

import com.nullpointerworks.astro.instruments.CustomEyepiece;
import com.nullpointerworks.astro.instruments.CustomTelescope;
import com.nullpointerworks.astro.instruments.IEyepiece;
import com.nullpointerworks.astro.instruments.ITelescope;
import com.nullpointerworks.astro.measure.IMeasurement;
import com.nullpointerworks.astro.measure.Measurement;
import com.nullpointerworks.astro.measure.Unit;

/*


fT / fE = mag
fT / dT = fR

fE / fR = exit pupil
(fE * dT) / fT = exit pupil



dT / (fully dilated eye) = LUM lowest useful magnification
fT / LUM = eyepiece focal length







*/

public class MainTest 
{
	
	public static void main(String[] args) 
	{
		new MainTest();
	}
	
	public MainTest()
	{

		IMeasurement eyepiece25mm 		= new Measurement(25.0, Unit.MILLI);
		IMeasurement eyepiece52afov 	= new Measurement(52.0, Unit.DEGREE);
		IEyepiece eyepiece 				= new CustomEyepiece(eyepiece25mm, eyepiece52afov);
		
		IMeasurement scopeDiameter 		= new Measurement(70.0, Unit.MILLI);
		IMeasurement scopeFocalLength 	= new Measurement(420.0, Unit.MILLI);
		ITelescope scope 				= new CustomTelescope(scopeDiameter, scopeFocalLength);
		
		IMeasurement focalRatio = scope.getFocalRatio();
		System.out.println("focal ratio: "+focalRatio.getValue());
		
		IMeasurement exitPupil = scope.getExitPupil(eyepiece);
		System.out.println("exit pupil for an eyepiece of 25mm is: "+exitPupil.getValue());
		
		
		
		
		
		
	}
	
	
}
