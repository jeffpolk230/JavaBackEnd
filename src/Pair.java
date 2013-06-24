public class Pair{
	CatTag[] first, second;
	public Pair (CatTag[] r1, CatTag[] r2){this.first = r1; this.second = r2;}
	public String getPair(){
		String out = "";
		for(CatTag i: first)
			out += i.name().concat("\n");
		out += " AND \n";
		for(CatTag i: second)
			out += i.name().concat("\n");
		return out;
	}
	public void setFirst(CatTag[] first){this.first = first;}
	public void setSecond(CatTag[] second){this.second = second;}
}