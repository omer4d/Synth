package com.stas.synth;

import java.io.IOException;

import com.stas.synth.modules.DC;
import com.stas.synth.modules.Sine;

public class Main implements NeetJavaSound.NjsCallback
{
	private static final int SAMPLE_RATE = 44100;
	private static final int BUFF_LEN = 512;
	
    public static void main(String[] args)
    {
        NeetJavaSound.open(SAMPLE_RATE, 2, BUFF_LEN);
        NeetJavaSound.setCallback(new Main());
        NeetJavaSound.start();
        
        try
		{
			System.in.read();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
        
        NeetJavaSound.close();
    }

    double t = 0.f;
    
    Sine lfo = new Sine(1.f, 800.f, new Input(1.f), new Input(0.f), new Input(0.f));
    
    //Sine sine = new Sine(0.1f, 440.f, new Input(1.f), new Input(0.f), new Input(lfo, 0.5f, 0.5f));
    
    Sine sine = new Sine(0.1f, 440.f, new Input(1.f), new Input(lfo), new Input(lfo));
    
    /*
    
    (defn voice1 [freq vel]
      (let [lfo (Tri. 0.1 1)
      	    gen1 (Sine. vel freq {:freq-mod [lfo 0.5 0.5]
      	                          :amp-mod lfo
      	                          :phase-mod [lfo 0.1 0]})
      	    out (Mixer. gen1)]
      	    out))
      
     
      	    
    */
    
    @Override
    public void render(final float[] output, final int n)
    {
    	double dt = 1.0 / SAMPLE_RATE;
    	
        for(int i = 0; i < n; i++)
        {
        	lfo.update(dt);
        	sine.update(dt);
        	
            output[i * 2] = sine.getOutput();
            output[i * 2 + 1] = sine.getOutput();
            
            t += dt;
        }
    }
}