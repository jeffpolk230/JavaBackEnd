public class Pair <CT extends CatTag>{
	CT[] first, second;
	public Pair (CT[] r1, CT[] r2){this.first = r1; this.second = r2;}
	public String getPair(){
		String out = "";
		for(CT i: first)
			out += i.name().concat("\n");
		out += " AND \n";
		for(CT i: second)
			out += i.name().concat("\n");
		return out;
	}
	public void setFirst(CT[] first){this.first = first;}
	public void setSecond(CT[] second){this.second = second;}
}