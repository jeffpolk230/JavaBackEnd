public class Pair <T>  implements Value {
	T first, second;
	//Dangerous to leave it like this !
	public Pair (T r1, T r2){this.first = r1; this.second = r2;}
	public String getPair(){
		String out = "";
		out.concat(first.toString()).concat(second.toString());
		return out;
	}
	public void setFirst(T first){this.first = first;}
	public void setSecond(T second){this.second = second;}
	@Override
	public Value addition(Value b) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Value multiplication(boolean p, Value b) {
		// TODO Auto-generated method stub
		return null;
	}
}