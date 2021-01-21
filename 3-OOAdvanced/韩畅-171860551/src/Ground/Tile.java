package Ground;
import java.util.Vector;

import Units.Character;
import Units.HuLuBaby;
import Units.Unit;

// 地块类
public class Tile {
	private int latitute; // x
	private int longitude; // y
	private Unit unitOnTile; // 地块上的单位
	private boolean isTileEmpty; // 地块上的单位是否有效

	public String[] seeThis(int lineNum, int maxColLines) {
		String tabStr = new String("|");
		String topStr = new String("+");
		String botStr = new String("|");
		for (int i = 0; i < maxColLines - 2; ++i) {
			tabStr += " ";
			topStr += "-";
			botStr += "_";
		}
		tabStr += "|";
		topStr += "+";
		botStr += "|";
		
		String []res = new String[lineNum];
		res[0] = topStr;
		res[lineNum - 1] = botStr;
		if (!isTileEmpty && unitOnTile!=null) {
			String[]temRes =unitOnTile.situation(lineNum - 2, maxColLines - 2);
			for (int i = 0; i < lineNum - 2; ++i){
				res[i+1] = "|";
				res[i+1] += temRes[i];
				res[i+1] += "|";
			}
		}
		else {
			for (int i = 1; i < lineNum - 1; ++i)
				res[i] = tabStr;	
		}
		return res;
		
	}
	
//	public Vector<String> seeThis() {// 展示本地块及其单位状态
//		Vector<String> res = new Vector<String>();
//		if (isTileEmpty) {
//			res.add("+------------+");
//			res.add("|            |");
//			res.add("|            |");
//			res.add("|            |");
//			res.add("|____________|");
//			return res;
//		}
//		// TODO 这里需要摆到派生的类中
//		// TODO 把自动补全长度的部分模块化
//		res.add("+------------+");
////		String temName = "|" + unitOnTile.getName();
////		while(temName.length() < 13)
////			temName = temName + " ";
////		temName = temName + "|";
////		res.add(temName);
//		String temColor = "";
//		if (unitOnTile.getClass() == HuLuBaby.class) {
//			temColor = "|" + ((HuLuBaby)unitOnTile).getColor().toString();
//			while (temColor.length() < 13)
//				temColor = temColor + " ";
//			temColor = temColor + "|";
//			
//		}
//		res.add(temColor);
//
//		String temFraction = "|" + unitOnTile.getFactionType().toString();
//		while (temFraction.length() < 13)
//			temFraction = temFraction + " ";
//		temFraction = temFraction + "|";
//		res.add(temFraction);
//		// res.add("| - - - - - -|");
//		res.add("|            |");
//		res.add("|____________|");
//		return res;
//	}

	// 构造函数
	public Tile(int lat, int longi) {
		// TODO Auto-generated constructor stub
		latitute = lat;
		longitude = longi;
		isTileEmpty = true;
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
	public boolean isTileEmpty() {
		return isTileEmpty;
	}

	// 获取地块上的单位
	public Unit getUnitOnTile() {
		if (isTileEmpty)
			return null;
		return unitOnTile;
	}

	// 地块上的单位走出地块
	protected void stepOut() {
		isTileEmpty = true;
	}

	// 从另一个地块走到本地块
	// 理论上不承担检错任务
	public boolean stepInFromAnotherTile(Tile t) {

		Unit temCha = t.getUnitOnTile();
		if (temCha == null)
			return false;
		else if (!isTileEmpty)
			return false;
		else {
			// System.out.print("here");
			t.stepOut();
			unitOnTile = temCha;
			isTileEmpty = false;
			return true;
		}
	}

	// 直接将一个单位走到此地块上
	// 如果此地块上有人，则返回失败
	// 理论上不承担检错任务
	public boolean stepIn(Unit cha) {
		if (isTileEmpty == false || cha == null)
			return false;
		else {
			unitOnTile = cha;
			isTileEmpty = false;
			return true;
		}
	}

}
