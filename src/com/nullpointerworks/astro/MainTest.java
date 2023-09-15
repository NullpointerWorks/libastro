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
		eyepiece30.setFocalLength( MILLI.value(30) );
		eyepiece30.setApparentFieldOfView( DEGREE.value(69) );
		
		
		// telescopes
		ITelescope scope70ED = new CustomTelescope("TSO 70ED");
		scope70ED.setDiameter( 		MILLI.value(70) );
		scope70ED.setFocalLength( 	MILLI.value(420) );
		
		ITelescope scope130PDS = new CustomTelescope("Skywatcher 130PDS");
		scope130PDS.setDiameter( 	MILLI.value(130) );
		scope130PDS.setFocalLength( MILLI.value(650) );
		
		
		// sensors
		ISensor my350DSLR	= new CustomSensor("Canon EOS 350D (APS-C)");
		my350DSLR.setPixelSize( 	MICRO.value(6.4) );
		my350DSLR.setSensorSize( 	MILLI.value(22.2), MILLI.value(14.8) );
		my350DSLR.setResolution( 	PIXEL.value(3464), PIXEL.value(2309));
		
		ISensor my1100DSLR	= new CustomSensor("Canon EOS 1100D (APS-C)");
		my1100DSLR.setPixelSize( 	MICRO.value(5.2) );
		my1100DSLR.setSensorSize( 	MILLI.value(22.2), MILLI.value(14.8) );
		my1100DSLR.setResolution( 	PIXEL.value(4272), PIXEL.value(2848) );
		
		ISensor myAtik320E	= new CustomSensor("Atik 320E Color (Sony ICX274)");
		myAtik320E.setPixelSize( 	MICRO.value(4.4) );
		myAtik320E.setSensorSize( 	MILLI.value(7.18), MILLI.value(5.32) ); // 1/1.8" size
		myAtik320E.setResolution(	PIXEL.value(1620), PIXEL.value(1220) );
		
		ISensor myDMK21AU04	= new CustomSensor("DMK 21AU04.AS (Sony ICX098BL)");
		myDMK21AU04.setPixelSize( 	MICRO.value(5.6) );
		myDMK21AU04.setSensorSize( 	MILLI.value(3.2), MILLI.value(2.4) ); // 1/4" size
		myDMK21AU04.setResolution( 	PIXEL.value(640), PIXEL.value(480));
		
		
		// get some details
		//additionalDetails(scope70ED, eyepiece30);
		//System.out.println();
		
		//test the suitability of the sensor to the telescope
		
		testSuitibility(scope70ED, myAtik320E, 0.2);
		
		
		
	}
	
	void additionalDetails(ITelescope scope, IEyepiece eyepiece) 
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
		IMeasurement wavelength = NANO.value(400.0); // the human eye can see approximately 380 to 740 nanometer wavelengths
		IMeasurement resolve = scope.getResolvingPower(wavelength);
		resolve.setUnit(ARCSECOND);
		System.out.println("Resolving power:    "+resolve.getValue() +" "+resolve.getUnit());
		
		/*
		 * find sensor's pixel resolution
		 */
		IMeasurement pixRes = sensor.getPixelAngularResolution(scope);
		pixRes.setUnit(ARCSECOND);
		
		System.out.println("Sensor resolution:  "+pixRes.getValue() + " "+pixRes.getUnit() +" per pixel");
		
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
