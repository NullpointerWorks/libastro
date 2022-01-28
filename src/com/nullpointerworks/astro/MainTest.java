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
		ITelescope scopeTSO70ED			= new CustomTelescope(scopeDiameter, scopeFocalLength);
		
		IMeasurement pdsDiameter 		= new Measurement(130.0, Unit.MILLI);
		IMeasurement pdsFocalLength 	= new Measurement(650.0, Unit.MILLI);
		ITelescope scope130PDS			= new CustomTelescope(pdsDiameter, pdsFocalLength);
		
		/*
		 * 
		 */
		ISensor my350DSLR			= new CustomSensor("Canon 350D");
		my350DSLR.setPixelSize( new Measurement(6.4, Unit.MICRO) );
		
		ISensor my1100DSLR			= new CustomSensor("Canon 1100D");
		my1100DSLR.setPixelSize( new Measurement(5.2, Unit.MICRO) );
		
		ISensor myAtik320E			= new CustomSensor("Atik 320E Color");
		myAtik320E.setPixelSize( new Measurement(4.4, Unit.MICRO) );
		
		/*
		 * test the suitability of the sensor to the telescope
		 */
		testSuitibility(scopeTSO70ED, myAtik320E, 0.2);
		
		
		
		/*
		 * get some details
		 *
		IMeasurement focalRatio = scope.getFocalRatio();
		System.out.println("telescope's focal ratio: "+focalRatio.getValue());
		
		IMeasurement exitPupil = scope.getExitPupil(eyepiece);
		System.out.println("exit pupil for the eyepiece is: "+exitPupil.getValue());
		
		IMeasurement trueFOV = scope.getTrueFieldOfView(eyepiece);
		System.out.println("the true field of view with the eyepiece is: "+trueFOV.getValue());
		//*/
	}
	

	// If the resolving power of your telescope is better then the pixel resolution of the sensor
	// then your sensor is not able to catch the detail provided by the telescope. 
	// This means the sensor is undersampling.
	
	// If however the pixel resolution of the sensor is better than the resolving power of the telescope
	// the image may look blurry when viewed at normal resolution. 
	// This means the sensor is oversampling.
	
	// The ideal situation would be to match the resolving power and pixel resolution.
	
	void testSuitibility(ITelescope scope, ISensor sensor, final double margin)
	{
		/*
		 * find telescope's resolving power
		 */
		IMeasurement wavelength = new Measurement(650.0, Unit.NANO);
		IMeasurement resolve = scope.getResolvingPower(wavelength);
		resolve.setUnit(Unit.ARCSECOND);
		System.out.println("minimum resolving power is: "+resolve.getValue() +" "+resolve.getUnit());
		
		/*
		 * find sensor's pixel resolution
		 */
		IMeasurement pixRes = sensor.getPixelResolution( scope.getFocalLength() );
		System.out.println("Sensor resolution is:       "+pixRes.getValue() + " "+pixRes.getUnit() +" per pixel");
		
		/*
		 * compare the two
		 */
		double scopeResolve = resolve.getValue();
		double pixelResolution = pixRes.getValue();
		double delta = pixelResolution - scopeResolve;
		
		if (delta < -margin)
		{
			System.out.println("This setup is oversampling.");
		}
		else
		if (delta > margin)
		{
			System.out.println("This setup is undersampling.");
		}
		else
		{
			System.out.println("This setup is pretty good!");
		}
	}
	
}
