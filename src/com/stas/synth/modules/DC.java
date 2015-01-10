package com.stas.synth.modules;

import com.stas.synth.Message;
import com.stas.synth.Module;

public class DC implements Module {
	private float val;
	
	public DC(float val)
	{
		this.val = val;
	}
	
	@Override
	public void handleMessage(Message msg, int param1, int param2, int param3)
	{
	}

	@Override
	public void update(double dt)
	{
	}

	@Override
	public float getOutput()
	{
		return val;
	}
}
