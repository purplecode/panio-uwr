import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;

import com.nsn.uwr.panio.inputsparser.EOperand;

public class TestInputFileGenerator {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		PrintStream logfile = new PrintStream("build/Test_Input_File.txt");
		Random random = new Random();

		for (int i = 0; i < 1000; i++) {

			String line = nextRandomInt(random) + " " + nextRandomInt(random)
					+ " " + nextRandomOperator(random);
			logfile.println(line);

		}

		logfile.close();

	}

	private static int nextRandomInt(Random random) {
		return random.nextInt(101);
	}

	private static String nextRandomOperator(Random random) {
		EOperand[] operands = EOperand.values();
		int randomIndex = random.nextInt(operands.length);
		return operands[randomIndex].getOperand();

	}

}
