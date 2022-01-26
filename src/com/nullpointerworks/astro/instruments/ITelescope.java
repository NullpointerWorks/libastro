package com.nullpointerworks.astro.instruments;

import com.nullpointerworks.astro.measure.IMeasurement;

public interface ITelescope 
{
	IMeasurement getFocalRatio();
	IMeasurement getMagnification(IEyepiece ep);
	IMeasurement getExitPupil(IEyepiece ep);
	IMeasurement getTrueFieldOfView(IEyepiece ep);
	
	
	
}
