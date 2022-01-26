package com.nullpointerworks.astro;

import com.nullpointerworks.astro.instruments.CustomEyepiece;
import com.nullpointerworks.astro.instruments.CustomTelescope;
import com.nullpointerworks.astro.instruments.IEyepiece;
import com.nullpointerworks.astro.instruments.ITelescope;
import com.nullpointerworks.astro.measure.IMeasurement;
import com.nullpointerworks.astro.measure.Measurement;
import com.nullpointerworks.astro.measure.Unit;

/*

dT / (fully dilated eye) = LUM lowest useful magnification
fT / LUM = eyepiece focal length


sin(theta) = 1.22 * (wavelength / dT)


*/

public class MainTest 
{
	
	public static void main(String[] args) 
	{
		new MainTest();
	}
	
	public MainTest()
	{
		
		/*
		 * define an eyepiece
		 */
		IMeasurement eyepieceFL 	= new Measurement(25.0, Unit.MILLI);
		IMeasurement eyepieceAFOV 	= new Measurement(52.0, Unit.DEGREE);
		IEyepiece eyepiece 			= new CustomEyepiece(eyepieceFL, eyepieceAFOV);
		
		/*
		 * define a telescope
		 */
		IMeasurement scopeDiameter 		= new Measurement(70.0, Unit.MILLI);
		IMeasurement scopeFocalLength 	= new Measurement(420.0, Unit.MILLI);
		ITelescope scope 				= new CustomTelescope(scopeDiameter, scopeFocalLength);
		
		/*
		 * get some details
		 */
		IMeasurement focalRatio = scope.getFocalRatio();
		System.out.println("telescope's focal ratio: "+focalRatio.getValue());
		
		IMeasurement exitPupil = scope.getExitPupil(eyepiece);
		System.out.println("exit pupil for the eyepiece is: "+exitPupil.getValue());
		
		IMeasurement trueFOV = scope.getTrueFieldOfView(eyepiece);
		System.out.println("the true field of view with the eyepiece is: "+trueFOV.getValue());
		
		
		
		
		
	}
	
	
}
