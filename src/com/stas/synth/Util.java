package com.stas.synth;

public class Util {
	public static float dbToAmp(float db)
	{
	    return (float)Math.pow(10, db / 20);
	}

	public static float ampToDb(float amp)
	{	
	    return (float)(20 * Math.log10(amp));
	}

	public static float semitonesToRatio(float st)
	{
	    return (float)Math.pow(2, st / 12);
	}
	
	public static float tonesToRatio(float tones)
	{
	    return semitonesToRatio(tones * 2);
	}

	public static float linearBlend(float a, float b, float k)
	{
	    return a + (b - a) * k;
	}

	public static float logBlend(float a, float b, float k)
	{
	    return (float)Math.exp(Math.log(a) * (1 - k) + Math.log(b) * k);
	}

	// Waveforms:

	public static float sine(float a, float f, float phi, double t)
	{
	    return (float)(a * Math.sin(f * 2.0 * Math.PI * t + phi));
	}

	public static float square(float a, float f, float phi, double t)
	{
	    double c = f * t + phi + 0.5;
	    double k = 1.0 - c + (int)c;

	    return (k <= 0.5) ? a : -a;
	}

	public static float saw(float a, float f, float phi, double t)
	{
	    double c = f * t + phi + 0.5;
	    return (float)(2.0 * a * (c - (int)c) - a);
	}

	public static float revSaw(float a, float f, float phi, double t)
	{
	    double c = f * t + phi;
	    return (float)(2.0 * a * (1.0 - c + (int)c) - a);
	}

	public static float tri(float a, float f, float phi, double t)
	{
	    double c = f * t + phi + 0.25;
	    double k = (1.0 - c + (int)c) * 2.0;
	    
	    return (float)((k <= 1.0) ? 2.0 * a * k - a : 2.0 * a * (2.0 - k) - a);
	}
}
