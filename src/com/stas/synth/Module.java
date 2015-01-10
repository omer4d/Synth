package com.stas.synth;

public interface Module {
	public void handleMessage(Message msg, int param1, int param2, int param3);
	public void update(double dt);
	public float getOutput();
}
