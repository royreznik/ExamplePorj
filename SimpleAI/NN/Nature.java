import java.util.ArrayList;

public class Nature {
	public static NeuralNetwork Mutate(NeuralNetwork n1){
		//for (NeuronLine line : n1.lines)
		NeuralNetwork n2 = n1;
		float f = 0;
		for(int k = 0; k<n2.lines.size();k++)
		{
			//for(Neuron n : line.neurons)
			for(int j = 0; j< n2.lines.get(k).neurons.size();j++)
			{
				//for(float f : n.weights)
				for(int i=0;i<n2.lines.get(k).neurons.get(j).weights.size();i++)
				{
					if(Math.random() < 0.1)
					{
						
						System.out.println();
						f = (float) (n2.lines.get(k).neurons.get(j).weights.get(i).floatValue() + Math.random());
						if(f>1) f--;
						n2.lines.get(k).neurons.get(j).weights.set(i, f);
						//n1.lines.get(k).neurons.get(j).weights.get(i).intValue();
						//n1.lines.get(k).neurons.get(j).weights.get(i).floatValue() += Math.random();
						//if(f > 1) f--;
					}
				}
			}
		}
		return n2;
	}
	public static NeuralNetwork crossover(NeuralNetwork n1, NeuralNetwork n2)
	{
		float f = 0;
		NeuralNetwork n3 = new NeuralNetwork(1,3,2,1);
		for(int k = 0; k<n2.lines.size();k++)
		{
			//for(Neuron n : line.neurons)
			for(int j = 0; j< n2.lines.get(k).neurons.size();j++)
			{
				//for(float f : n.weights)
				for(int i=0;i<n2.lines.get(k).neurons.get(j).weights.size();i++)
				{
					if(Math.random() < 0.2)
					{
						f = (float) (n2.lines.get(k).neurons.get(j).weights.get(i).floatValue());
						n3.lines.get(k).neurons.get(j).weights.set(i, f);
					}
					else
					{
						f = (float) (n1.lines.get(k).neurons.get(j).weights.get(i).floatValue());
						n3.lines.get(k).neurons.get(j).weights.set(i, f);
					}
				}
			}
		}
		return n3;
	}
}

