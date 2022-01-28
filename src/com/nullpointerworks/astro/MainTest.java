package com.nullpointerworks.astro;

import com.nullpointerworks.astro.instruments.CustomEyepiece;
import com.nullpointerworks.astro.instruments.CustomSensor;
import com.nullpointerworks.astro.instruments.CustomTelescope;
import com.nullpointerworks.astro.instruments.IEyepiece;
import com.nullpointerworks.astro.instruments.ISensor;
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
		 * 
		 */
		ISensor my350DSLR			= new CustomSensor("Canon 350D");
		my350DSLR.setPixelSize( new Measurement(6.4, Unit.MICRO) );
		
		ISensor my1100DSLR			= new CustomSensor("Canon 1100D");
		my1100DSLR.setPixelSize( new Measurement(5.2, Unit.MICRO) );
		
		
		
		/*
		 * get some details
		 */
		IMeasurement focalRatio = scope.getFocalRatio();
		System.out.println("telescope's focal ratio: "+focalRatio.getValue());
		
		IMeasurement exitPupil = scope.getExitPupil(eyepiece);
		System.out.println("exit pupil for the eyepiece is: "+exitPupil.getValue());
		
		IMeasurement trueFOV = scope.getTrueFieldOfView(eyepiece);
		System.out.println("the true field of view with the eyepiece is: "+trueFOV.getValue());
		
		/*
		 * find telescope's resolving power
		 */
		IMeasurement wavelength = new Measurement(650.0, Unit.NANO);
		IMeasurement resolve = scope.getResolvingPower(wavelength);
		resolve.setUnit(Unit.ARCSECOND);
		System.out.println("the minimum resolving power is: "+resolve.getValue() +" "+resolve.getUnit());
		
		/*
		 * find sensor and telescope suitability
		 */
		IMeasurement pixRes = my350DSLR.getPixelResolution( scope.getFocalLength() );
		System.out.println("Sensor resolution "+pixRes.getValue() + " "+pixRes.getUnit() +" per pixel");
		
		
		
		
	}
	
	
}
