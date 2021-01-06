import java.util.Vector;

// 地块类
public class Tile {
	private	int latitute; 			// x
	private	int longitude; 			// y
	private Character unitOnTile; 	// 地块上的单位
	private boolean isUnitEmpty;	// 地块上的单位是否有效
	public Vector<String> seeThis(){// 展示本地块及其单位状态
		Vector<String> res = new Vector<String>();
		if (isUnitEmpty)
		{
			res.add("+------------+");
			res.add("|            |");
			res.add("|            |");
			res.add("|            |");
			res.add("|____________|");
			return res;
		}
		// TODO 这里需要摆到派生的类中
		// TODO 把自动补全长度的部分模块化
		res.add("+------------+");
		String temName = "|" + unitOnTile.getName();
		while(temName.length() < 13)
			temName = temName + " ";
		temName = temName + "|";
		res.add(temName);
		String temFraction = "|" + unitOnTile.getFactionType().toString();
		while(temFraction.length() < 13)
			temFraction = temFraction + " ";
		temFraction = temFraction + "|";
		res.add(temFraction);
		//res.add("| - - - - - -|");
		res.add("|            |");
		res.add("|____________|");
		return res;
	}
	
	// 构造函数
	public Tile(int lat, int longi) {
		// TODO Auto-generated constructor stub
		latitute = lat;
		longitude = longi;
		isUnitEmpty = true;
	}
	// 获取行坐标
	public int getLatitute() {
		return latitute;
	}
	// 获取列坐标
	public int getLongitude() {
		return longitude;
	}
	// 地块是否为空
	public boolean isUnitEmpty() {
		return isUnitEmpty;
	}
	// 获取地块上的单位
	public Character getUnitOnTile() {
		if (isUnitEmpty) return null;
		return unitOnTile;
	}
	// 地块上的单位走出地块
	protected void stepOut()
	{
		isUnitEmpty = true;		
	}
	// 从另一个地块走到本地块
	public boolean stepInFromAnotherTile(Tile t)
	{
		
		Character temCha = t.getUnitOnTile();
		if (temCha == null) return false;
		else if (!isUnitEmpty) return false;
		else {
			//System.out.print("here");
			t.stepOut();
			unitOnTile = temCha;
			isUnitEmpty = false;
			return true;
		}
	}
	
	// 直接将一个单位走到此地块上
	// 如果此地块上有人，则返回失败
	public boolean stepIn(Character cha)
	{
		if (isUnitEmpty == false || cha == null) return false;
		else {
			unitOnTile = cha;
			isUnitEmpty = false;
			return true;
		}
	}

	
}
