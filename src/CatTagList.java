
import java.util.Arrays;


public class CatTagList implements Value {
	public CatTag[] list;
	public static CnfTablesc cnfTable = new CnfTablesc();
	public CatTagList(CatTag[] input)
	{
		this.list = input;
	}
	public Value addition(Value b) {
		
		CatTag[] result = Arrays.copyOf(this.list, this.list.length+((CatTagList)b).list.length);
		System.arraycopy(((CatTagList)b).list, 0, result, this.list.length, ((CatTagList)b).list.length);
		this.list = result;
		return this;
	}

	public Value multiplication(boolean p, Value b) {
		if (b.getClass() != this.getClass())
			return null;
		else
		{
			CatTag[] bList =  ((CatTagList) b).list;
			CatTag[] first = new CatTag[]{};
			CatTag[] second = new CatTag[]{};
			for(CatTag ai: this.list)
			{
				  for(CatTag bi: bList){
					if (cnfTable.getCombine(p, ai, bi) == null)
					{	
						System.out.println("null");
						System.out.println(ai.show());
						System.out.println(bi.show());
					}
					first = CatTagList.concat(first, ((CatTagList) cnfTable.getCombine(p, ai, bi).first).list);
					second = CatTagList.concat(second, ((CatTagList) cnfTable.getCombine(p, ai, bi).second).list);
				  }
			}
			  Pair<Value> result = new Pair<Value>(new CatTagList(first),new CatTagList(second));
			return result;
		}
	}

	@Override
	public String show() {
		String out = "[";
		for (int i = 0 ; i < list.length ;i ++)
			out = out.concat(list[i].name()).concat(" ,");
		out = out.concat("]");
		return out;
	}
	
	public static CatTag[] subList(CatTag[] origin, int start, int end)
	{
		return Arrays.copyOfRange(origin, start, end);
	}
	public static CatTag[] concat(CatTag[] A, CatTag[] B) {
		   int aLen = A.length;
		   int bLen = B.length;
		   CatTag[] C= new CatTag[aLen+bLen];
		   System.arraycopy(A, 0, C, 0, aLen);
		   System.arraycopy(B, 0, C, aLen, bLen);
		   return C;
		}
	public static void main(String args[])
	{
		CatTagList ctl = new CatTagList(new CatTag[]{CatTag.CAT_Exp});
		CatTagList ctl2 = new CatTagList(new CatTag[]{CatTag.TOK_43});
		//Value result = ctl.addition(ctl2);
		//System.out.println(((CatTagList) cnfTable.getCombine(true, CatTag.CAT_Exp, CatTag.TOK_43).second).list == null);
		Value result2 = ctl.multiplication(true, ctl2);
		//for (CatTag x : ((CatTagList) result).list)	
			//System.out.println(x);
		System.out.println( ((CatTagList) ((Pair)result2).first).list.length); 
		for (CatTag x : ((CatTagList) ((Pair)result2).first).list)
			System.out.println(x);
	}
}
