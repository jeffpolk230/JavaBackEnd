import java.util.Arrays;


public interface Grammar<CT extends CatTag>{
	
	String getDesc (CT c);
	Pair getCombine (boolean p, CT r1,CT r2);
	Pair tokenToCats (boolean p, Symbol s);
}
