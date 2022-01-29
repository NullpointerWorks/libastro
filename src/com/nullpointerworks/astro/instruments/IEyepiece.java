package com.nullpointerworks.astro.instruments;

import com.nullpointerworks.astro.measure.IMeasurement;

public interface IEyepiece
{
	void setFocalLength(IMeasurement fl);
	void setApparentFieldOfView(IMeasurement afov);
	
	IMeasurement getFocalLength();
	IMeasurement getApparentFieldOfView();
}
