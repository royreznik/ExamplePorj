import java.util.ArrayList;

public class NeuralNetwork {
	public ArrayList<NeuronLine> lines;
	public int numOfHidden,numOfNeuronInMiddle,numInputs,numOutputs;
	
	public NeuralNetwork(int numOfHidden,int numOfNeuronInMiddle,int numInputs, int numOutputs)
	{
		this.numOfHidden = numOfHidden;
		this.numOfNeuronInMiddle =numOfNeuronInMiddle;
		this.numInputs = numInputs;
		this.numOutputs = numOutputs;
		lines = new ArrayList<>();
		lines.add(new NeuronLine(numInputs,0));
		for(int i=1;i<=numOfHidden;i++)
		{
			lines.add(new NeuronLine(numOfNeuronInMiddle,lines.get(i-1).neurons.size()));
		}
		lines.add(new NeuronLine(numOutputs,numOfNeuronInMiddle));
	}
	
	public NeuralNetwork(NeuralNetwork n)
	{
		this.numOfHidden = n.numOfHidden;
		this.numOfNeuronInMiddle = n.numOfNeuronInMiddle;
		this.numInputs = n.numInputs;
		this.numOutputs = n.numOutputs;
		lines = new ArrayList<>();
		lines.add(new NeuronLine(n.lines.get(0)));
		for(int i=1;i<=numOfHidden;i++)
		{
			lines.add(new NeuronLine(n.lines.get(i)));
		}
		lines.add(new NeuronLine(n.lines.get(n.lines.size()-1)));
	}
	
	public ArrayList<Float> calculate(ArrayList<Float> inputs)
	{
		for(int i =1; i <lines.size();i++)
		{
			inputs = lines.get(i).calculate(inputs);
		}
		if(inputs.get(0) > 1) inputs.set(0, inputs.get(0)-1);
		return inputs;
	}
	
	/*public ArrayList<Float> calculate(ArrayList<Float> inputs)
	{
		ArrayList<Float> outputs = new ArrayList<>();
		for(NeuronLine line : lines)
		{
			outputs = line.calculate(inputs);
			inputs.clear();
			for(float f : outputs)
			{
				inputs.add(f);
			}
		}
		return inputs;
	}*/
	
	
}
