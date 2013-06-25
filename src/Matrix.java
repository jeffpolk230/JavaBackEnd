/*Matrix class should be abstract, there will be no instance of matrix
 * for the time being, due to data is only using int and implementation of plus and times depends on this
 * will change to abstract once the plus and times are fixed
 * */
public class Matrix {
	private int r, c;
	public int[][] data;
	class mulMismacthingException extends Exception
	{
	  public mulMismacthingException(String message)
	  {
	    super(message);
	  }
	}
	public Matrix(int r, int c)
	{
		this.r = r; this.c = c;
		this.data = new int[r][c];
	}
	public void show() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) 
                System.out.printf("%4d", data[i][j]);
            System.out.println();
        }
        System.out.println();
    }
	public Matrix plus(Matrix B)
	{
		Matrix A = this;
        Matrix C = new Matrix(A.r, A.c);
        for (int i = 0; i < A.r; i++)
            for (int j = 0; j < A.c; j++)
                C.data[i][j] = A.data[i][j] + B.data[i][j];
        return C;	
	}
	public Matrix times(Matrix B)
	{
		// ToDo: A times B returns addition of getCombine from CnfTablesc??
		Matrix C = new Matrix(this.r, B.c);
        for (int i = 0; i < C.r; i++)
            for (int j = 0; j < C.c; j++)
                for (int k = 0; k < this.c; k++)
                    C.data[i][j] += (this.data[i][k] * B.data[k][j]);
        return C;
	}
	
	/*Smart constructors*/
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
			return zero;
		else return new One(A);
	}
	public static Matrix quad (Matrix A,Matrix B, Matrix C, Matrix D){
		if (A == zero && B == zero && C == zero && D == zero )
			return zero;
		else return new Quad(A, B, C, D);
	}
	
	public static Matrix add(Matrix A, Matrix B)
	{
		if(A instanceof Zero) return B;
		if(B instanceof Zero) return A;
		if(A instanceof One && B instanceof One)
			return one(A.plus(B));
		if(A instanceof Row && B instanceof Row)
		{
			return row( add(((Row) A).left,((Row) B).left) ,add(((Row) A).right, ((Row) B).right) );
		}
		if(A instanceof Col && B instanceof Col)
			return col( add(((Col) A).upper,((Col) B).upper) ,add(((Col) A).lower, ((Col) B).lower) );
		if(A instanceof Quad && B instanceof Quad)
			return quad( add(((Quad) A).x,((Quad) B).x), add(((Quad) A).y,((Quad) B).y) ,add(((Quad) A).z,((Quad) B).z) ,add(((Quad) A).w,((Quad) B).w)  );
		
		else return null;
	}
	
	public static Matrix mul(Matrix A, Matrix B) throws mulMismacthingException
	{
		if (A instanceof Zero || B instanceof Zero) return zero;
		if (A instanceof One && B instanceof One) return one(A.times(B));
		if (A instanceof One && B instanceof Row)
		{
			return row(mul(A,(((Row) B).left)),mul(A,(((Row) B).right)));
		}
		if (A instanceof Col && B instanceof One)
			return col(mul(((Col) A).upper,B), mul(((Col) A).lower,B));
		if (A instanceof Row && B instanceof Col)
		{
			return add(( mul((((Row) A).left),(((Col) B).upper ))),(( mul((((Row) A).right),(((Col) B).lower )))));
		}
		if (A instanceof Col && B instanceof Row)
			return quad(mul(((Col) A).upper,((Row) B).left),mul(((Col) A).upper,((Row) B).right),mul(((Col) A).lower,((Row) B).left),mul(((Col) A).lower,((Row) B).right));
		if (A instanceof Row && B instanceof Quad)
			return row( add( mul(((Row) A).left,((Quad) B).x),mul(((Row) A).right,((Quad) B).z) ), add( mul( ((Row) A).left,((Quad) B).y ) ,mul(((Row) A).right,((Quad) B).w)) );
					//row (a & a' + b & c') (a & b' + b & d')
		if (A instanceof Quad && B instanceof Col)
			return col( add( mul( ((Quad) A).x, ((Col) B).upper) , mul(((Quad) A).y,((Col) B).lower )), add( mul(((Quad) A).z,((Col) B).upper), mul(((Quad) A).w,((Col) B).lower )) );
			//Quad a b c d & Col a' c' = col (a & a' + b & c') (c & a' + d & c')
		if(A instanceof Quad && B instanceof Quad)
			return quad( mul(((Quad) A).x, ((Quad) B).x),mul(((Quad) A).y, ((Quad) B).y) ,mul(((Quad) A).z, ((Quad) B).z) ,mul(((Quad) A).w, ((Quad) B).w)  );
		else throw A.new mulMismacthingException("Multiplication Mismatched !");
		
	}
	
	public static class One extends Matrix
	{
		private One()
		{
			super(1,1);
			super.data[0][0] = 1;
		}
		public One(Matrix A)
		{
			super(1,1);
			super.data[0][0] = A.data[0][0];
		}
	}
	public static class Zero extends Matrix
	{
		public Zero()
		{
			super(1,1);
		}
	}
	public static class Row extends Matrix
	{
		public Matrix left, right;
		public Row(Matrix left, Matrix right)
		{
			super(left.r, left.c+right.c);
			for(int i = 0; i< super.r;i++)
				for(int j = 0; j < super.c; j++)
					if(j< left.c)
						super.data[i][j] = left.data[i][j];
					else
						super.data[i][j] = right.data[i][j-left.c];
			this.left = left;
			this.right = right;
		}
	}
	public static class Col extends Matrix
	{
		public Matrix upper, lower;
		public Col(Matrix upper, Matrix lower)
		{
			super(upper.r + lower.r, upper.c);
			for(int i = 0 ; i < super.r ; i ++)
				for(int j = 0 ; j < super.c ; j ++)
					if(i < upper.r)
						super.data[i][j] =upper.data[i][j];
					else
						super.data[i][j] = lower.data[i-upper.r][j];
			this.upper = upper;
			this.lower = lower;
		}
	}
	public static class Quad extends Matrix
	{
		public Matrix x, y, z, w;
		public Quad(Matrix x, Matrix y, Matrix z, Matrix w)
		{
			super(x.r+z.r, x.c+y.c);
			for(int i = 0 ; i< super.r ; i++)
				for(int j = 0 ; j < super.c ; j++)
					if(i < x.r && j < x.c)//upper left
						super.data[i][j] = x.data[i][j];
					else if( i < x.r && j < x.c + y.c)//upper right
						super.data[i][j] = y.data[i][j-x.c];
					else if( i < x.r + z.r && j < x.c)//lower left
						super.data[i][j] = z.data[i-x.r][j];
					else
						super.data[i][j] = w.data[i-x.r][j-x.c];//lower right
			this.x = x; this.y = y; this.z = z; this.w = w;
		}
	}
	
	//test Client
	public static void main(String args[])
	{

		Col c = new Col(new Zero(),new One());
		Row r = new Row(new Zero(),new One());
		r.show();
		c.show();
		try {
			Row r2 = new Row(r, new One());
			r2.show();
			System.out.println(((Row) r2.left).left.getClass());
			mul(new One(),r2).show();
			System.out.println(mul(new One(),r2).getClass());
			add(mul(c,r),new Quad(new Zero(),new One(), new Zero(),new Zero())).show();
		} catch (mulMismacthingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
