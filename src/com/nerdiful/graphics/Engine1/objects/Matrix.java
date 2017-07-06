package com.nerdiful.graphics.Engine1.objects;

public class Matrix
{
	double[] values;
	
	Matrix(double[] values)
	{
		this.values = values;
	}
	
	public Matrix multiply(Matrix multMatrix)
	{
		double[] endMatrix = new double[9];
		for(int row=0; row<3; row++)
		{
			for(int col=0; col<3; col++)
			{
				for(int i=0; i<3; i++)
				{
					endMatrix[row * 3 + col] += values[row * 3 + i] * multMatrix.values[i * 3 + col];
				}
			}
		}
		
		return new Matrix(endMatrix);
	}
	
	public Point3D transform(Point3D transValue)
	{
		return new Point3D(
				transValue.getPosition()[0] * values[0] + transValue.getPosition()[1] * values[3] + transValue.getPosition()[2] * values[6],
				transValue.getPosition()[0] * values[1] + transValue.getPosition()[1] * values[4] + transValue.getPosition()[2] * values[7],
				transValue.getPosition()[0] * values[2] + transValue.getPosition()[1] * values[5] + transValue.getPosition()[2] * values[8]);
	}
}
