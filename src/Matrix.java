import java.util.Arrays;


public abstract class Matrix <V extends Value>{
	
	/*Subclasses we want*/
	public static class Zero<V> extends Matrix {}
	public static class One<V extends Value> extends Matrix<V>
	{
		public V value;
		public One (V value)
		{
			this.value = value;
		}
		/*Two actual manipulating functions for One (the actual data)*/
		public Matrix plus(One A) 
		{
			return new One(this.value.addition(A.value)); 
		}
		public Matrix times(One A) 
		{
			return new One(this.value.multiplication(true, A.value));
		}
	}
	public static class Row<V> extends Matrix
	{
		public Matrix left, right;
		public Row (Matrix left, Matrix right)
		{
			this.left = left;
			this.right = right;
		}
	}
	public static class Col<V> extends Matrix
	{
		public Matrix upper, lower;
		public Col (Matrix upper, Matrix lower)
		{
			this.upper = upper;
			this.lower = lower;
		}
	}
	public static class Quad<V> extends Matrix
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
		else return new One(((One) A).value);
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
			return one(((One) A).plus(((One)B)));
		if(A instanceof Row && B instanceof Row)
			return row( add(((Row) A).left,((Row) B).left) ,add(((Row) A).right, ((Row) B).right) );
		if(A instanceof Col && B instanceof Col)
			return col( add(((Col) A).upper,((Col) B).upper) ,add(((Col) A).lower, ((Col) B).lower) );
		if(A instanceof Quad && B instanceof Quad)
			return quad( add(((Quad) A).ul,((Quad) B).ul), add(((Quad) A).ur,((Quad) B).ur) ,add(((Quad) A).ll,((Quad) B).ll) ,add(((Quad) A).lr,((Quad) B).lr)  );
		
		else throw new Exception("Mismatching while adding; you shouldn't be here!");
	}
	public static Matrix mul(boolean p, Matrix A, Matrix B) throws Exception
	{
		if (A instanceof Zero || B instanceof Zero) 
			return zero;
		
		if (A instanceof One && B instanceof One) 
			return one(((One) A).times(((One) B)));
		
		if (A instanceof One && B instanceof Row)
			return row(mul(p, A,(((Row) B).left)),mul(p, A,(((Row) B).right)));
		
		if (A instanceof Col && B instanceof One)
			return col(mul(p, ((Col) A).upper,B), mul(p, ((Col) A).lower,B));
		
		if (A instanceof Row && B instanceof Col)
			return add(( mul(p, (((Row) A).left),(((Col) B).upper ))),(( mul(p, (((Row) A).right),(((Col) B).lower )))));
		
		if (A instanceof Col && B instanceof Row)
			return quad(mul(p, ((Col) A).upper,((Row) B).left),mul(p, ((Col) A).upper,((Row) B).right),mul(p, ((Col) A).lower,((Row) B).left),mul(p, ((Col) A).lower,((Row) B).right));
		
		if (A instanceof Row && B instanceof Quad)
			return row( add( mul(p, ((Row) A).left,((Quad) B).ul),mul(p, ((Row) A).right,((Quad) B).ll) ), add( mul(p,  ((Row) A).left,((Quad) B).ur ) ,mul(p, ((Row) A).right,((Quad) B).lr)) );
			//row (a & a' + b & c') (a & b' + b & d')
		
		if (A instanceof Quad && B instanceof Col)
			return col( add( mul(p,  ((Quad) A).ul, ((Col) B).upper) , mul(p, ((Quad) A).ur,((Col) B).lower )), add( mul(p, ((Quad) A).ll,((Col) B).upper), mul(p, ((Quad) A).lr,((Col) B).lower )) );
			//Quad a b c d & Col a' c' = col (a & a' + b & c') (c & a' + d & c')
		
		if(A instanceof Quad && B instanceof Quad)
			return quad( mul(p, ((Quad) A).ul, ((Quad) B).ul),mul(p, ((Quad) A).ur, ((Quad) B).ur) ,mul(p, ((Quad) A).ll, ((Quad) B).ll) ,mul(p, ((Quad) A).lr, ((Quad) B).lr)  );
		
		else throw new Exception("Mismatching while multipling; you shouldn't reach here");		
	}
	
	
	public Pair closeDisjointP(boolean p, Matrix a, Matrix b, Matrix c)
	{
		try{
			Pair result = close(p, a, b, c);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return new Pair(a,b);
	}
	public Pair close(boolean p , Matrix a,Matrix b,Matrix c) throws Exception
	{
		if (b instanceof Zero)
			return new Pair(new Zero(), new Zero());
		else if (a instanceof Zero && c instanceof Zero)
			return trav(b);
		else if (a instanceof Quad && b instanceof Quad && c instanceof Quad)
		{
			Pair x21 = close (p, ((Quad) a).lr, ((Quad) b).ll, ((Quad) c).ul);
			Pair x11 = close (p, ((Quad) a).ul, add(mul( p,((Quad) a).ur , (Matrix) x21.second), ((Quad) b).ul) , ((Quad) c).ul);
			Pair x22 = close (p, ((Quad) a).lr, add(mul( p, (Matrix) x21.first, ((Quad) c).ur ), ((Quad) b).ll) , ((Quad) c).ll);
			Pair x12 = close (p, ((Quad) a).ul, add(mul( p,((Quad) a).ur , (Matrix) x22.second) ,add(mul( p, (Matrix) x11.first, ((Quad) c).ur ), ((Quad) b).ur)) , ((Quad) c).ll);
			
		}
		else if (a instanceof Zero && b instanceof Quad && c instanceof Quad)
			return close(p, new Quad(new Zero(),new Zero(),new Zero(),new Zero()), b, new Quad( ((Quad) c).ul, ((Quad) c).ur, new Zero(), ((Quad) c).lr  ) );
		else if (a instanceof Quad && ((Quad) a).ll instanceof Zero && b instanceof Quad && c instanceof Zero)
			return close(p, new Quad( ((Quad) a).ul, ((Quad) a).ur, new Zero(), ((Quad) a).lr  ), b, new Quad(new Zero(), new Zero(),new Zero(),new Zero()) );
		else if (a instanceof Quad && ((Quad) a).ll instanceof Zero && b instanceof Col && c instanceof Zero)
		{
			Matrix one, two;
			Pair x2 = close (p, ((Quad) a).lr, ((Col) b).lower, new Zero() );
			Pair x1 = close (p, ((Quad) a).ul, add(mul( p,((Quad) a).ur , (Matrix) x2.second), ((Col) b).upper), new Zero());
			one = col((Matrix) x1.first,(Matrix) x2.first);
			two = col((Matrix) x1.second,(Matrix) x2.second);
			return new Pair(one, two);
		}
		else if (a instanceof Zero && b instanceof Row && c instanceof Quad && ((Quad) c).ll instanceof Zero)
		{
			Matrix one, two;
			Pair x1 = close (p, new Zero(), ((Row) b).left, ((Quad) c).ul);
			Pair x2 = close (p, new Zero(), add(mul( p, (Matrix) x1.first, ((Quad) c).ur ), ((Row) b).right), ((Quad) c).lr);
			one = col((Matrix) x1.first,(Matrix) x2.first);
			two = col((Matrix) x1.second,(Matrix) x2.second);
			return new Pair(one, two);
		}
		else throw new Exception("closeDisjoint mismatching");
		return null;
	}
	
	public static Pair trav(Matrix<Pair> x) throws Exception
	{
		if (x instanceof Zero)
			return new Pair(new Zero(), new Zero());
		if (x instanceof One)
			return new Pair(new One( (Value) ((Pair) ((One) x).value ).first), new One( (Value) ((Pair) ((One) x).value ).second));
		if (x instanceof Row)
		{
			Matrix one = row( (Matrix) trav (((Row) x).left).first,(Matrix) trav (((Row) x).right).first);
			Matrix two = row( (Matrix) trav (((Row) x).left).second,(Matrix) trav (((Row) x).right).second);
			return new Pair (one, two);
		}
		if (x instanceof Col)
		{
			Matrix one = col( (Matrix) trav (((Col) x).upper).first,(Matrix) trav (((Col) x).lower).first);
			Matrix two = col( (Matrix) trav (((Col) x).upper).second,(Matrix) trav (((Col) x).lower).second);
			return new Pair (one, two);
		}
		if (x instanceof Quad)
		{  
			Matrix one = quad( (Matrix) trav (((Quad) x).ul).first,(Matrix) trav (((Quad) x).ur).first,(Matrix) trav (((Quad) x).lr).first,(Matrix) trav (((Quad) x).ll).first  );
			Matrix two = quad( (Matrix) trav (((Quad) x).ul).second,(Matrix) trav (((Quad) x).ur).second,(Matrix) trav (((Quad) x).lr).second,(Matrix) trav (((Quad) x).ll).second  );
			return new Pair (one, two);
		}
		else throw new Exception("closeDisjoint mismatching, shouldn't happen");
	}
	
	/*Test Client*/
	public static void main(String args[])
	{
		CatTag[] ct = new CatTag[]{CatTag.CAT_0};
		Pair p = new Pair(ct,ct);
		CatTagList ctl = new CatTagList(ct);
		One o = new One(p);
		Row r = new Row(o,o);
		try {
			Pair result = trav(r);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
