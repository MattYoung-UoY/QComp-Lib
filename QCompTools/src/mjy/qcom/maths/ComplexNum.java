package mjy.qcom.maths;

public class ComplexNum {

	private float r, i, theta, mod;
	
	public ComplexNum(float r, float i) {
		this.r = r;
		this.i = i;
		theta = (float) Math.atan(i/r);
		mod = Complex.mod(this);
	}

	public float getR() {
		return r;
	}

	public float getI() {
		return i;
	}
	
	public float getTheta() {
		return theta;
	}

	public float getMod() {
		return mod;
	}

	@Override
	public String toString() {
		return "(" + r + " + " + i + "i)";
	}
	
	public boolean equals(ComplexNum a) {
		return (a.getR() == r) && (a.getI() == i);
	}
	
}
