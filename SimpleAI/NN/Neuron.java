import java.util.*;

public class Neuron {
	public ArrayList<Float> weights;
	public int numWeights;
	public float calculate(ArrayList<Float> inputs)
	{
		float sum = 0f;
		int i = 0;
		try
		{
			for(Float f : weights)
			{
				//System.out.println(weights);
				sum += f*inputs.get(i);
				//System.out.println("yes");
				i++;
			}
		}catch(Exception e)
		{
			System.out.println(e.getClass());
		}
		
		return sum;
	}
	
	public Neuron(int numWeights)
	{
		this.numWeights = numWeights;
		weights = new ArrayList<>();	
		for(int i = 0;i<numWeights;i++)
			weights.add((float) Math.random());
		
	}
	public Neuron(Neuron n1)
	{
		this.numWeights = n1.numWeights;
		weights = new ArrayList<>();	
		for(int i = 0;i<n1.numWeights;i++)
			weights.add(n1.weights.get(i));
	}
	public static float sigmoid(float weight) {
        return (float) (1.0 / (1 + Math.exp(-1.0 * weight)));
    }
	
}
