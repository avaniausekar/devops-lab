package regression;

public class Regression {

	public double getValue(int[] xValues, int[] yValues) {
		double slp = 0;

		int lengthX = xValues.length;
		int lengthY = yValues.length;

		if (lengthX != lengthY) {
			throw new IllegalArgumentException("xValues and yValues must be of same length.");
		}

		double sumX = 0, sumY = 0;
		for (int i = 0; i < lengthX; i++) {
			sumX += xValues[i];
			sumY += yValues[i];
		}

		double averageX = sumX / lengthX;
		double averageY = sumY / lengthY;

		double sumProd = 0, sumSq = 0;

		for (int i = 0; i < lengthX; i++) {
			double dx = xValues[i] - averageX;
			double dy = yValues[i] - averageY;

			sumProd += dx * dy;
			sumSq += dx * dx;
		}

		slp = sumSq == 0 ? 0 : sumProd / sumSq;

		System.out.println("Slope: " + slp);

		return slp;
	}
}
