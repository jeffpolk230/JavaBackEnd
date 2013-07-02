public class Pair <T>  implements Value {
	T first, second;
	//Dangerous to leave it like this !
	public Pair (T r1, T r2){this.first = r1; this.second = r2;}
	public String show(){
		String out = "";
		if (first instanceof Value && second instanceof Value)
			out = out.concat(((Value) first).show() ).concat(" :/: ").concat(((Value) second).show());
		else  
			out = out.concat(first.toString()).concat(second.toString());
		return out;
	}
	public void setFirst(T first){this.first = first;}
	public void setSecond(T second){this.second = second;}
	@Override
	public Value addition(Value b){
		System.out.println("Bang!! adding with Pair");
		return null;
	}
	@Override
	public Value multiplication(boolean p, Value b) {
		// TODO getCombine implementation should go here
		return null;
	}
}