
public abstract class Matrix{
	
	private int value;
	
	/*Subclasses we want*/
	public static class Zero extends Matrix {}
	public static class One extends Matrix 
	{
		public int value;
		public One (int value)
		{
			super.value = value;
			this.value = super.value;
		}
		/*Two actual manipulating functions for One (the actual data)*/
		public Matrix plus(Matrix A) 
		{
			// Temp plus function, should be changed according to 'Value'
			return new One(A.value + this.value); 
		}
		public Matrix times(Matrix A) 
		{
			return new One(A.value * this.value);
		}
	}
	public static class Row extends Matrix 
	{
		public Matrix left, right;
		public Row (Matrix left, Matrix right)
		{
			this.left = left;
			this.right = right;
		}
	}
	public static class Col extends Matrix 
	{
		public Matrix upper, lower;
		public Col (Matrix upper, Matrix lower)
		{
			this.upper = upper;
			this.lower = lower;
		}
	}
	public static class Quad extends Matrix 
	{
		public Matrix ul, ur, ll, lr; //upper left; upper right; lower left; lower right
		public Quad(Matrix ul, Matrix ur, Matrix ll, Matrix lr)
		{
			this.ul = ul;
			this.ur = ur;
			this.ll = ll;
			this.lr = lr;
		}
	}
	
	/*Smart Constructor for creating Zero*/
	public static Matrix zero = new Zero();
	public static Matrix row (Matrix A, Matrix B){
		if (A == zero && B == zero)
			return zero;
		else return new Row(A, B);
	}
	public static Matrix col (Matrix A,Matrix B){
		if (A == zero && B == zero)
			return zero;
		else return new Col(A, B);
	}
	public static Matrix one(Matrix A)
	{
		if(A == zero)
		{
			System.out.println("hey");
			return zero;
		}
		else return new One(A.value);
	}
	public static Matrix quad (Matrix A,Matrix B, Matrix C, Matrix D){
		if (A == zero && B == zero && C == zero && D == zero )
			return zero;
		else return new Quad(A, B, C, D);
	}
	
	/*Add and Mul for all subclasses*/
	public static Matrix add(Matrix A, Matrix B) throws Exception
	{
		if(A instanceof Zero) return B;
		if(B instanceof Zero) return A;
		if(A instanceof One && B instanceof One)
			return one(((One) A).plus(B));
		if(A instanceof Row && B instanceof Row)
			return row( add(((Row) A).left,((Row) B).left) ,add(((Row) A).right, ((Row) B).right) );
		if(A instanceof Col && B instanceof Col)
			return col( add(((Col) A).upper,((Col) B).upper) ,add(((Col) A).lower, ((Col) B).lower) );
		if(A instanceof Quad && B instanceof Quad)
			return quad( add(((Quad) A).ul,((Quad) B).ul), add(((Quad) A).ur,((Quad) B).ur) ,add(((Quad) A).ll,((Quad) B).ll) ,add(((Quad) A).lr,((Quad) B).lr)  );
		
		else throw new Exception("Mismatching while adding; you shouldn't be here!");
	}
	public static Matrix mul(Matrix A, Matrix B) throws Exception
	{
		if (A instanceof Zero || B instanceof Zero) 
			return zero;
		
		if (A instanceof One && B instanceof One) 
			return one(((One) A).times(B));
		
		if (A instanceof One && B instanceof Row)
			return row(mul(A,(((Row) B).left)),mul(A,(((Row) B).right)));
		
		if (A instanceof Col && B instanceof One)
			return col(mul(((Col) A).upper,B), mul(((Col) A).lower,B));
		
		if (A instanceof Row && B instanceof Col)
			return add(( mul((((Row) A).left),(((Col) B).upper ))),(( mul((((Row) A).right),(((Col) B).lower )))));
		
		if (A instanceof Col && B instanceof Row)
			return quad(mul(((Col) A).upper,((Row) B).left),mul(((Col) A).upper,((Row) B).right),mul(((Col) A).lower,((Row) B).left),mul(((Col) A).lower,((Row) B).right));
		
		if (A instanceof Row && B instanceof Quad)
			return row( add( mul(((Row) A).left,((Quad) B).ul),mul(((Row) A).right,((Quad) B).ll) ), add( mul( ((Row) A).left,((Quad) B).ur ) ,mul(((Row) A).right,((Quad) B).lr)) );
			//row (a & a' + b & c') (a & b' + b & d')
		
		if (A instanceof Quad && B instanceof Col)
			return col( add( mul( ((Quad) A).ul, ((Col) B).upper) , mul(((Quad) A).ur,((Col) B).lower )), add( mul(((Quad) A).ll,((Col) B).upper), mul(((Quad) A).lr,((Col) B).lower )) );
			//Quad a b c d & Col a' c' = col (a & a' + b & c') (c & a' + d & c')
		
		if(A instanceof Quad && B instanceof Quad)
			return quad( mul(((Quad) A).ul, ((Quad) B).ul),mul(((Quad) A).ur, ((Quad) B).ur) ,mul(((Quad) A).ll, ((Quad) B).ll) ,mul(((Quad) A).lr, ((Quad) B).lr)  );
		
		else throw new Exception("Mismatching while multipling; you shouldn't reach here");		
	}
	
	/*Test Client*/
	public static void main(String args[])
	{

	}
}
