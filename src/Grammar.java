
public interface Grammar<CT>{
	
	String getDesc (CT c);
	Pair getCombine (boolean p, CT r1,CT r2);
	Pair tokenToCats (boolean p, Symbol s);
}
