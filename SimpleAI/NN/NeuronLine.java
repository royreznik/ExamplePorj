import java.util.ArrayList;

public class NeuronLine {
	public ArrayList<Neuron> neurons;
	public int numNeruon, numPrevLine;
	public NeuronLine(int numNeruon,int numPrevLine)
	{
		this.numNeruon = numNeruon;
		this.numPrevLine = numPrevLine;
		neurons = new ArrayList<>();
		for(int i=0;i<numNeruon;i++)
		{
			neurons.add(new Neuron(numPrevLine));
		}
	}
	public NeuronLine(NeuronLine n1)
	{
		this.numNeruon = n1.numNeruon;
		this.numPrevLine = n1.numPrevLine;
		neurons = new ArrayList<>();
		for(int i=0;i<numNeruon;i++)
		{
			neurons.add(new Neuron(n1.neurons.get(i)));
		}
	}
	public ArrayList<Float> calculate(ArrayList<Float> inputs)
	{
		ArrayList<Float> results = new ArrayList<>();
		for(Neuron n : neurons)
		{
			results.add(n.calculate(inputs));
		}
		return results;
	}
	
}
