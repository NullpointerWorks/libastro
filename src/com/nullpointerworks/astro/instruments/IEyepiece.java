package com.nullpointerworks.astro.instruments;

import com.nullpointerworks.astro.measure.IMeasurement;

public interface IEyepiece
{
	IMeasurement getFocalLength();
	IMeasurement getApparentFieldOfView();
}
