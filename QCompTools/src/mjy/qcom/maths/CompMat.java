package mjy.qcom.maths;

public class CompMat {

	private ComplexNum[][] mat;

	public CompMat(ComplexNum[][] mat) {
		this.mat = mat;
	}
	
	protected CompMat(ComplexNum[] vec) {
		ComplexNum[][] temp = {vec};
		this.mat = temp;
	}

	public ComplexNum getCjk(int j, int k) {
		return mat[j][k];
	}
	
	public int[] getDimensions() {
		int[] res = new int[2];
		res[0] = mat.length;
		res[1] = mat[0].length;
		return res;
	}
	
	@Override
	public String toString() {
		String res = "[";
		for(ComplexNum[] row: mat) {
			res += printRow(row) + "\n";
		}
		res += "]";
		return res;
	}
	
	private String printRow(ComplexNum[] row) {
		String result = "[";
		for(int i = 0; i < row.length; i++) {
			result += row[i];
			if(i < row.length - 1) result += ", ";
		}
		result += "]";
		return result;
	}
	
}
