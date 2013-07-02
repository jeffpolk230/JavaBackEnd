import java.util.Arrays;


public class CatTagList implements Value {
	public CatTag[] list;
	public CatTagList(CatTag[] input)
	{
		this.list = input;
	}
	
	@Override
	public Value addition(Value b) {
		
		CatTag[] result = Arrays.copyOf(this.list, this.list.length+((CatTagList)b).list.length);
		System.arraycopy(((CatTagList)b).list, 0, result, this.list.length, ((CatTagList)b).list.length);
		this.list = result;
		return this;
	}

	@Override
	public Value multiplication(boolean p, Value b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String show() {
		String out = "[";
		for (int i = 0 ; i < list.length ;i ++)
			out = out.concat(list[i].name()).concat(" ,");
		out = out.concat("]");
		return out;
	}
	
}
