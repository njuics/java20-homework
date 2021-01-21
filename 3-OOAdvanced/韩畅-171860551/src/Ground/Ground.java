package Ground;

import java.util.HashMap;
import java.util.Vector;
import java.util.stream.Collector.Characteristics;

import Units.Character;
import Units.Unit;

public class Ground {
	// 一个Tile为单位的二维数组作为场地类的基础
	private Vector<Vector<Tile>> baseGround;
	// 维护一个单位位置索引表，以便快速获取单位位置
	private HashMap<Unit, Tile> unitOnTheGround;
	// 一个场地大小常量
	private final int groundSize = 10;
	// 场地显示的参数
	private final int printLineNum = 8;
	private final int printLineSize = 15;

	// 把场地的全部信息序列化为字符串
	public String seeAroud() {
		StringBuilder strBd = new StringBuilder();
		strBd.append("\n\n");
		for (int i = 0; i < groundSize * printLineSize; ++i)
			strBd.append("_");
		strBd.append("\n");
		for (Vector<Tile> vecTile : baseGround) {
			StringBuilder[] s = new StringBuilder[printLineNum];
			for (int i = 0; i < printLineNum; ++i)
				s[i] = new StringBuilder();

			for (Tile temTile : vecTile) {
				String[] temTileStr = temTile.seeThis(printLineNum, printLineSize);
				for (int i = 0; i < printLineNum; ++i) {
					s[i].append(temTileStr[i]);
				}

			}
			for (int i = 0; i < printLineNum; ++i) {
				strBd.append(s[i] + "\n");
			}
		}
		for (int i = 0; i < groundSize * printLineSize; ++i)
			strBd.append("_");
		strBd.append("\n\n");
		return strBd.toString();
	}

	// 获取场地大小
	public int getGroundSize() {
		return groundSize;
	}

	// 场地的构造函数
	// 对场地的地块基础初始化，对场地的单位索引初始化
	public Ground() {
		// TODO Auto-generated constructor stub
		// 初始化baseGround
		baseGround = new Vector<Vector<Tile>>();
		for (int i = 0; i < groundSize; ++i) {
			Vector<Tile> groundLine = new Vector<Tile>();
			for (int j = 0; j < groundSize; ++j) {
				groundLine.add(new Tile(i, j));
			}
			baseGround.add(groundLine);
		}
		// 初始化unitOnTheGround
		unitOnTheGround = new HashMap<Unit, Tile>();
	}

	// 内部询问x，y的情况、有合法性检查
	private Tile howIsXY(int x, int y) {
		if (x >= baseGround.size() || y >= baseGround.get(x).size())
			return null;
		else {
			return baseGround.get(x).get(y);
		}
	}

	// 外部询问xy位置的地块情况
	// 询问者的合法性检查 和 视野合法性检查
	public Tile howIsXY(int x, int y, Unit you, int sightSz) {
		if (this.isUnitOnTheGround(you) == false)
			return null;
		Tile yourTile = unitOnTheGround.get(you);
		if (x - yourTile.getLatitute() > sightSz || y - yourTile.getLongitude() > sightSz)
			return null;
		else {
			return howIsXY(x, y);
		}
	}

	// 询问单位在什么位置——由一个单位发起询问，对视野范围进行判断
	public Tile whereIsHim(Character cha) {
		if (!this.unitOnTheGround.containsKey(cha))
			return null;
		else {

			// TODO 视野判断
			return unitOnTheGround.get(cha);
		}
	}

	// x y这个位置是否合法
	public boolean isXYin(int x, int y) {
		return x >= 0 && y >= 0 && x < groundSize && y < groundSize;
	}

	// 某个单位走到场地上的某地，默认cha目前不在场地上
	// TODO 需要对单位的行动力进行判断
	public boolean stepOnXY(int x, int y, Character cha) {
		if (unitOnTheGround.containsKey(cha))
			return false;
		Tile temTile = howIsXY(x, y);
		if (temTile == null)
			return false;
		else {
			if (temTile.stepIn(cha)) {
				unitOnTheGround.put(cha, temTile);
				return true;
			} else
				return false;
		}
	}

	// 在Move操作成功的时候，更新人物内部的位置 --- 此部分转移到Character内部进行处理，每次成功移动都重新获取位置
	// 在Move操作成功的时候，更新地块上的单位
	public boolean unitMoveToXY(int x, int y, Character cha) {
		// 如果单位不在地块上，直接返回false失败
		if (unitOnTheGround.containsKey(cha) == false)
			return false;
		else {

			Tile oriTile = unitOnTheGround.get(cha);
			// 如果单位在地块上，对单位的移动距离和移动位置进行核查，如果不合法，仍然返回false失败
			if (Math.abs(oriTile.getLatitute() - x) + Math.abs(oriTile.getLongitude() - y) > cha.getMoveAbility(this))
				return false;
			else if (isXYin(x, y) == false) {
				return false;
			} else {
				// 如果成功则进行移动

				Tile desTile = baseGround.get(x).get(y);
				boolean res = desTile.stepInFromAnotherTile(oriTile);
				if (res == false)
					return false;
				else {
					// 更新单位表

					unitOnTheGround.replace(cha, oriTile, desTile);
					return true;
				}
			}

		}
	}

	// 单位是否在场地当中
	public boolean isUnitOnTheGround(Unit you) {
		return you != null && unitOnTheGround.containsKey(you);
	}
//	public Tile whereIsHim(Character cha)
//	{
//		return unitOnTheGround.get(cha);
//	}

	// 不加检查的基础单位地块交换
	public void baseSwap(Tile t1, Tile t2, Character cha1, Character cha2) {
		// 此处最好加一下检查
		t1.stepOut();
		t2.stepOut();
		t1.stepIn(cha2);
		t2.stepIn(cha1);
		unitOnTheGround.replace(cha1, t2);
		unitOnTheGround.replace(cha2, t1);
		cha1.whereAmI();
		cha2.whereAmI();
		System.out.print(seeAroud());
	}

	// 将整块场地进行概要提取后，返回给单位——有视野判断，模拟单位环顾的过程
	public Vector<Vector<TILE_TYPE>> theGroundYouCanSee(Character cha) {
		if (!unitOnTheGround.containsKey(cha))
			return null;
		int sightSz = cha.getSightSize(this);
		Vector<Vector<TILE_TYPE>> res = new Vector<Vector<TILE_TYPE>>();

		Tile t = unitOnTheGround.get(cha);
		int cx = t.getLatitute();
		int cy = t.getLongitude();
		for (int i = 0; i < groundSize; ++i) {
			Vector<TILE_TYPE> tem = new Vector<TILE_TYPE>();
			for (int j = 0; j < groundSize; ++j) {
				if (i < cx - sightSz || i > cx + sightSz || j < cy - sightSz || j > cy + sightSz)
					tem.add(TILE_TYPE.UNKNOWN);
				else {
					Unit u = baseGround.get(i).get(j).getUnitOnTile();
					if (u == null)
						tem.add(TILE_TYPE.NOBODY);
					else if (!(u instanceof Character))
						tem.add(TILE_TYPE.OTHERS);
					else {
						Character temCha = (Character) u;
						if (temCha.getFactionType() == cha.getFactionType())
							tem.add(TILE_TYPE.FRIEND);
						else if (temCha.getFactionType() != cha.getFactionType())
							tem.add(TILE_TYPE.ENEMY);
						else {
							tem.add(TILE_TYPE.OTHERS);
						}
					}
				}
			}
			res.add(tem);
		}
		return res;
	}
//		if (unitOnTheGround.containsKey(cha))
//		{
//			int y = unitOnTheGround.get(cha).getLongitude();
//			int x = unitOnTheGround.get(cha).getLatitute();
//			int stX = x - sightSz;
//			stX = stX>0?stX:0;
//			int stY = y - sightSz;
//			stY = stY>0?stY:0;
//			int edX = x + sightSz;
//			edX = edX<groundSize-1?edX:groundSize-1;
//			int edY = y + sightSz;
//			edY = edY<groundSize-1?edY:groundSize-1;
//			for (int i = stX; i <= edX; ++i) {
//				for (int j = stY; j <= edY; ++j) {
//					res.add(baseGround.get(i).get(j));
//				}
//			}
//		}

}
