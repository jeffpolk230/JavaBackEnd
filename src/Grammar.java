
public interface Grammar<PA,CT>{
	
	String getDesc (CT c);
	PA getCombine (boolean p, CT r1,CT r2);
	PA tokenToCats (boolean p, Symbol s);
}
