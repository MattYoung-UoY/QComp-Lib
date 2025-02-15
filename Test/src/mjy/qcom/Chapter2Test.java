package mjy.qcom;

import java.util.Arrays;

import mjy.qcom.maths.CompMat;
import mjy.qcom.maths.Complex;
import mjy.qcom.maths.ComplexNum;

public class Chapter2Test {

	public static void main(String[] args) {
		
		ComplexNum a = new ComplexNum(5, 13);
		ComplexNum b = new ComplexNum(6, 2);
		ComplexNum c = new ComplexNum(0.53f, -6);
		ComplexNum d = new ComplexNum(12, 0);
		ComplexNum[][] vec = {{a}, {b}, {c}, {d}};
		CompMat testVec = new CompMat(vec);
		
		ComplexNum a2 = new ComplexNum(7, -8);
		ComplexNum b2 = new ComplexNum(0, 4);
		ComplexNum c2 = new ComplexNum(2, 0);
		ComplexNum d2 = new ComplexNum(9.4f, 3);
		ComplexNum[][] vec2 = {{a2}, {b2}, {c2}, {d2}};
		CompMat testVec2 = new CompMat(vec2);
		
		System.out.println(Complex.add(testVec, testVec2) + "\n");
		
		ComplexNum a3 = new ComplexNum(16, 2.3f);
		ComplexNum b3 = new ComplexNum(0, -7);
		ComplexNum c3 = new ComplexNum(6, 0);
		ComplexNum d3 = new ComplexNum(5, -4);
		ComplexNum[][] vec3 = {{a3}, {b3}, {c3}, {d3}};
		
		CompMat testVec3 = new CompMat(vec3);
		
		System.out.println(Complex.scalarMult(new ComplexNum(8, -2), testVec3) + "\n");

		System.out.println(testVec);
		System.out.println(Complex.negate(testVec));
		System.out.println(Complex.transpose(testVec) + "\n");
		
		System.out.println(Arrays.toString(testVec.getDimensions()));
		System.out.println(Arrays.toString(Complex.transpose(testVec).getDimensions()) + "\n");
		
		
		
		
		ComplexNum[][] multAvec = {{new ComplexNum(3, 2), new ComplexNum(0, 0), new ComplexNum(5, -6)}, 
								{new ComplexNum(1, 0), new ComplexNum(4, 2), new ComplexNum(0, 1)}, 
								{new ComplexNum(4, -1), new ComplexNum(0, 0), new ComplexNum(4, 0)}};
		CompMat multA = new CompMat(multAvec);
		
		ComplexNum[][] multBvec = {{new ComplexNum(5, 0), new ComplexNum(2, -1), new ComplexNum(6, -4)},
								{new ComplexNum(0, 0), new ComplexNum(4, 5), new ComplexNum(2, 0)},
								{new ComplexNum(7, -4), new ComplexNum(2, 7), new ComplexNum(0, 0)}};
		CompMat multB = new CompMat(multBvec);
		
		System.out.println(Complex.matMult(multA, multB) + "\n\n\n\n");
		
		
		
		
		ComplexNum[][] startVecArr = {{new ComplexNum(7.2f, -1.7f)},
									{new ComplexNum(0, 4.1f)}};
		CompMat startVec = new CompMat(startVecArr);
		
		CompMat action = Complex.identityMat(2);
		
		System.out.println(action + "\n");
		System.out.println(Complex.vecMult(action, startVec));
		
		action = Complex.negate(action);

		System.out.println(Complex.vecMult(action, startVec));
		
	}
	
}
