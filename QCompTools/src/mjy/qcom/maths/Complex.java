package mjy.qcom.maths;

import java.util.Arrays;

public class Complex {

	public static ComplexNum add(ComplexNum a, ComplexNum b) {
		return new ComplexNum(a.getR() + b.getR(), a.getI() + b.getI());
	}
	
	public static ComplexNum multiply(ComplexNum a, ComplexNum b) {
		float real = (a.getR() * b.getR()) - (a.getI() * b.getI());
		float imaginary = (a.getR() * b.getI()) + (a.getI() * b.getR());
		return new ComplexNum(real, imaginary);
	}
	
	public static ComplexNum sub(ComplexNum a, ComplexNum b) {
		return new ComplexNum(a.getR() - b.getR(), a.getI() - b.getI());
	}
	
	public static ComplexNum div(ComplexNum a, ComplexNum b) {
		float modSqr = (b.getR() * b.getR()) + (b.getI() * b.getI());
		float x = ((a.getR() * b.getR()) + (a.getI() * b.getI()))/modSqr;
		float y = ((b.getR() * a.getI()) - (a.getR() * b.getI()))/modSqr;
		return new ComplexNum(x, y);
	}
	
	protected static float mod(ComplexNum a) {
		return (float) Math.sqrt((a.getR() * a.getR()) + (a.getI() * a.getI()));
	}
	
	public static ComplexNum conj(ComplexNum a) {
		return new ComplexNum(a.getR(), -a.getI());
	}
	
	public static CompMat transpose(CompMat m) {
		int[] dims = m.getDimensions();
		ComplexNum[][] res = new ComplexNum[dims[1]][dims[0]];
		for(int j = 0; j < res.length; j++) {
			for(int k = 0; k < res[0].length; k++) {
				res[j][k] = m.getCjk(k, j);
			}
		}
		return new CompMat(res);
	}
	
	public static CompMat add(CompMat m, CompMat n) {
		int[] sizeM = m.getDimensions();
		if((sizeM[0] != n.getDimensions()[0]) || (sizeM[1] != n.getDimensions()[1]))
			throw new IllegalArgumentException("The two matrices must have the same dimensions!\n\nMatrix 1: " + m + "\n\nMatrix 2: " + n);
		ComplexNum[][] res = new ComplexNum[sizeM[0]][sizeM[1]];
		for(int j = 0; j < sizeM[0]; j++) {
			for(int k = 0; k < sizeM[1]; k++) {
				res[j][k] = add(m.getCjk(j, k), n.getCjk(j, k));
			}
		}
		return new CompMat(res);
	}
	
	public static CompMat inverse(CompMat m) {
		int[] sizeM = m.getDimensions();
		ComplexNum[][] res = new ComplexNum[sizeM[0]][sizeM[1]];
		for(int j = 0; j < sizeM[0]; j++) {
			for(int k = 0; k < sizeM[1]; k++) {
				res[j][k] = multiply(m.getCjk(j, k), new ComplexNum(-1, 0));
			}
		}
		return new CompMat(res);
	}
	
	public static CompMat scalarMult(ComplexNum c, CompMat m) {
		int[] sizeM = m.getDimensions();
		ComplexNum[][] res = new ComplexNum[sizeM[0]][sizeM[1]];
		for(int j = 0; j < sizeM[0]; j++) {
			for(int k = 0; k < sizeM[1]; k++) {
				res[j][k] = multiply(m.getCjk(j, k), c);
			}
		}
		return new CompMat(res);
	}
	
	public static CompMat matMult(CompMat a, CompMat b) {
		int[] sizeA = a.getDimensions(),
				sizeB = b.getDimensions(),
				sizeC = {sizeA[0], sizeB[1]};
		if(sizeA[1] != sizeB[0]) throw new IllegalArgumentException("Matrix A must have the same number of columns as Matrix B has rows!");
		ComplexNum[][] res = new ComplexNum[sizeC[0]][sizeC[1]];
		for(int row = 0; row < sizeC[0]; row++) {
			for(int col = 0; col < sizeC[1]; col++) {
				res[row][col] = multRes(a, b, row, col);
			}
		}
		return new CompMat(res);
	}
	
	private static ComplexNum multRes(CompMat a, CompMat b, int row, int col) {
		ComplexNum res = new ComplexNum(0, 0);
		ComplexNum[] resParts = new ComplexNum[a.getDimensions()[1]];
		
		for(int i = 0; i < resParts.length; i++) {
			resParts[i] = Complex.multiply(a.getCjk(row, i), b.getCjk(i, col));
		}
		for(ComplexNum part: resParts) {
			res = Complex.add(res, part);
		}
		
		return res;
	}
	
	
}
