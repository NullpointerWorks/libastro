package com.nullpointerworks.astro;

import com.nullpointerworks.astro.instruments.CustomEyepiece;
import com.nullpointerworks.astro.instruments.CustomSensor;
import com.nullpointerworks.astro.instruments.CustomTelescope;
import com.nullpointerworks.astro.instruments.IEyepiece;
import com.nullpointerworks.astro.instruments.ISensor;
import com.nullpointerworks.astro.instruments.ITelescope;
import com.nullpointerworks.astro.measure.IMeasurement;
import com.nullpointerworks.astro.measure.Measurement;
import static com.nullpointerworks.astro.measure.Unit.*;

/*

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
		// eyepieces
		IEyepiece eyepiece30 = new CustomEyepiece();
		eyepiece30.setFocalLength( new Measurement(30.0, MILLI) );
		eyepiece30.setApparentFieldOfView( new Measurement(69.0, DEGREE) );
		
		
		// telescopes
		ITelescope scope70ED = new CustomTelescope("TSO 70ED");
		scope70ED.setDiameter( new Measurement(70.0, MILLI) );
		scope70ED.setFocalLength( new Measurement(420.0, MILLI) );
		
		ITelescope scope130PDS = new CustomTelescope("Skywatcher 130PDS");
		scope130PDS.setDiameter( new Measurement(130.0, MILLI) );
		scope130PDS.setFocalLength( new Measurement(650.0, MILLI) );
		
		
		// sensors
		ISensor my350DSLR	= new CustomSensor("Canon EOS 350D (APS-C)");
		my350DSLR.setPixelSize( new Measurement(6.4, MICRO) );
		my350DSLR.setSensorSize( new Measurement(22.2, MILLI), new Measurement(14.8, MILLI) );
		my350DSLR.setSensorResolution(3464, 2309);
		
		
		ISensor my1100DSLR	= new CustomSensor("Canon EOS 1100D (APS-C)");
		my1100DSLR.setPixelSize( new Measurement(5.2, MICRO) );
		my350DSLR.setSensorSize( new Measurement(22.2, MILLI), new Measurement(14.7, MILLI) );
		my350DSLR.setSensorResolution(4272, 2848);
		
		
		ISensor myAtik320E	= new CustomSensor("Atik 320E Color (Sony ICX274)");
		myAtik320E.setPixelSize( new Measurement(4.4, MICRO) );
		my350DSLR.setSensorSize( new Measurement(7.18, MILLI), new Measurement(5.32, MILLI) ); // 1/1.8" size
		my350DSLR.setSensorResolution(1620, 1220);
		
		
		ISensor myDMK21AU04	= new CustomSensor("DMK 21AU04.AS (Sony ICX098BL)");
		myDMK21AU04.setPixelSize( new Measurement(5.6, MICRO) );
		myDMK21AU04.setSensorSize( new Measurement(3.2, MILLI), new Measurement(2.4, MILLI) ); // 1/4" size
		myDMK21AU04.setSensorResolution(640, 480);
		
		
		
		
		
		// get some details
		additionalDetails(scope70ED, eyepiece30);
		System.out.println();
		
		//test the suitability of the sensor to the telescope
		testSuitibility(scope70ED, myAtik320E, 0.4);
	}
	
	
	private void additionalDetails(ITelescope scope, IEyepiece eyepiece) 
	{
		IMeasurement focalRatio = scope.getFocalRatio();
		System.out.println("telescope's focal ratio: "+focalRatio.getValue());
		
		IMeasurement exitPupil = scope.getExitPupil(eyepiece);
		System.out.println("exit pupil for the eyepiece is: "+exitPupil.getValue() +" "+exitPupil.getUnit());
		
		IMeasurement trueFOV = scope.getTrueFieldOfView(eyepiece);
		System.out.println("the true field of view with the eyepiece is: "+trueFOV.getValue() +" "+trueFOV.getUnit());
		
	}

	// If the resolving power of your telescope is better then the pixel resolution of the sensor
	// then your sensor is not able to catch the detail provided by the telescope. 
	// This means the sensor is undersampling. You get fewer detail in the image.
	
	// If however the pixel resolution of the sensor is better than the resolving power of the telescope
	// the image may look blurry when viewed at normal resolution. 
	// This means the sensor is oversampling. You may see more noise in the image.
	
	// The ideal situation would be to match the resolving power and pixel resolution.
	
	void testSuitibility(ITelescope scope, ISensor sensor, final double margin)
	{
		/*
		 * find telescope's resolving power
		 */
		IMeasurement wavelength = new Measurement(700.0, NANO); // the eye can see approximately 380 to 700 nanometers
		IMeasurement resolve = scope.getResolvingPower(wavelength);
		resolve.setUnit(ARCSECOND);
		
		/*
		 * find sensor's pixel resolution
		 */
		IMeasurement pixRes = sensor.getPixelResolution(scope);
		pixRes.setUnit(ARCSECOND);
		
		System.out.println("Minimum resolving power:   "+resolve.getValue() +" "+resolve.getUnit());
		System.out.println("Sensor resolution:         "+pixRes.getValue() + " "+pixRes.getUnit() +" per pixel");
		
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
		else if (delta > margin)
		{
			System.out.println("This setup is undersampling.");
		}
		else
		{
			System.out.println("This setup is pretty good!");
		}
	}
	
}
