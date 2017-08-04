package 遗传学算法;

import java.util.ArrayList;
import java.util.List;

//袋鼠基因载体
public class CGenome {
	// 定义装载基因的容器（事实上从英文解释来看，Weights 是权值的意思，这用来表示
	// 基因的确有点名不符实，呵呵。这主要是因为这些代码来自于 GA-ANN 引擎，所以在
	// 它里面基因实质就是神经网络的权值， 所以习惯性的把它引入过来就只好这样了。 ）
	public List<Double> vecWeights;

	// dFitness 用于存储对该基因的适应性评估。
	public double dFitness;

	public CGenome() {
		dFitness = 0;
	}

	public CGenome(List<Double> vecWeights, double dFitness) {
		this.vecWeights = new ArrayList<Double>();
		this.dFitness = 0;
	}

}
