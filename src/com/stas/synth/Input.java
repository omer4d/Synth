package com.stas.synth;

import com.stas.synth.modules.DC;

public class Input {
	public final Module module;
	public final float coeff, constant;
	
	public Input(Module module, float coeff, float constant)
	{
		this.module = module;
		this.coeff = coeff;
		this.constant = constant;
	}
	
	public Input(Module module)
	{
		this(module, 1.f, 0.f);
	}
	
	public Input(float v)
	{
		this(new DC(v));
	}
	
	public float getValue()
	{
		return coeff * module.getOutput() + constant;
	}
}
