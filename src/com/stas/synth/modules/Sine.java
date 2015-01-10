package com.stas.synth.modules;

import com.stas.synth.Input;
import com.stas.synth.Message;
import com.stas.synth.Module;
import com.stas.synth.Util;

public class Sine implements Module {
	private float amp, freq;
	private Input ampMod, phaseMod, vibrato;
	private float val;
	private double t;
	
	public Sine(float amp, float freq, Input ampMod, Input phaseMod, Input vibrato)
	{
		this.amp = amp;
		this.freq = freq;
		this.ampMod = ampMod;
		this.phaseMod = phaseMod;
		this.vibrato = vibrato;
	}
	
	@Override
	public void handleMessage(Message msg, int param1, int param2, int param3)
	{
	}

	@Override
	public void update(double dt)
	{
        t += Math.pow(1.059463094359295f, vibrato.getValue()) * dt;
        val = Util.sine(amp * ampMod.getValue(), freq, phaseMod.getValue(), t);
	}
	
	@Override
	public float getOutput()
	{
		return val;
	}
}
