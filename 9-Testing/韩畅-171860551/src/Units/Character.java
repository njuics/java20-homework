package Units;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.Vector;

import org.apache.commons.lang3.tuple.Pair;

import Ground.Ground;
import Ground.TILE_TYPE;
import Ground.Tile;
import UnitCollection.ORDER;

public class Character extends Unit implements Comparable<Character>{
	// 人物姓名
	protected String name;
	// 视野
	protected int sightSize;
	// 移动力
	private final int moveAbility = 1;
	// 健康
	// protected int health;
	// 自己所在的地块
	protected Tile tileIAmOn; // 并不保证同步——也即如果自身的更新不及时，会导致迷路
	// 自己看到的全部场地情况
	protected Vector<Vector<TILE_TYPE>> mySight; // 并不保证同步，可以向Ground类、友方请求

	
	// ----- 第7次作业 add -----
	protected boolean sex; // true 男 false 女
	
	public boolean getSex() {
		return sex;
	}
	// ----- 第7次作业 add -----
	
	// ----- 第8次作业 add -----
	private ORDER od = ORDER.ASC;
	private boolean sortSex = false;
	
	public void setOd(ORDER o, boolean sSex) {
		od = o;
		sortSex = sSex;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + "\n\t\t" + (sex ? "Male" : "Female");
	}
	
	@Override
	public int compareTo(Character o) {
		// TODO Auto-generated method stub
		if (sortSex && sex != o.sex)
			return (sex ? -1:1);
		else {
			switch (od) {
			case ASC:
				return name.compareTo(o.name);
			case DESC:
				return o.name.compareTo(name);
			case RANDOM:
				return (new Random().nextBoolean() ? 1 : -1);
			default:
				return 0;
				
			}
		}
	}
	
	
	
	// private Vector<Tile> sight;
	// 阵营
	// protected FACTION_TYPE factionType;

	// 场地
	protected Ground myGr;

	// 再向场地看一眼
	private void renewMySight() {
		mySight = myGr.theGroundYouCanSee(this);
	}

	// 构造函数
	public Character(String n, int s, int h, Ground g, boolean se) {
		// TODO Auto-generated constructor stub
		super(h);
		name = n;
		sightSize = s;
		// health = h;
		myGr = g;
		sex = se;
	}

	@Override
	public long getBirthTime() {
		// TODO Auto-generated method stub
		return birthTime;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	// 对访问的类型进行判断，必须是友方或物理引擎、场景的询问才做出真实的回应
	public int getMoveAbility(Object obj) {
		if (obj.getClass() == myGr.getClass()) {
			return moveAbility;
		} else {
			Character cha = (Character) obj;
			if (cha.getFactionType() == this.getFactionType())
				return moveAbility;
			return -1;
		}
	}

	// 回应对自身姓名的询问
	public String getName() {
		return name;
	}

	// 回应对自身血量的询问
	// TODO 为了贴近实际，在敌方单位询问时，应当加上一个较大的随机模糊值，也即敌方只能大概估计自身的健康程度，但不能确切知道
	public int getHealth() {
		return health;
	}

	// 回应对自身阵营的询问
	public FACTION_TYPE getFactionType() {
		return factionType;
	}

	// 显示当前状态
	@Override
	public String[] situation(int line, int maxColLen) {
		// TODO Auto-generated method stub
		String tabString = new String();
		for (int i = 0; i < maxColLen; ++i)
			tabString += " ";
		String[] res = new String[line];

		for (int i = 0; i < line; ++i) {
			res[i] = tabString;
		}

		res[0] = strComplement(String.valueOf(this.id), maxColLen);
		res[1] = strComplement(this.name, maxColLen);
		res[2] = strComplement(this.factionType.toString(), maxColLen);
//		System.out.print(res[0]);
//		System.out.print(res[1]);
//		System.out.print(res[2]);
//		System.out.print(res[3] + "|");
//		System.out.print(res[4] + "|");
		return res;

	}

	// 向场地确认自己是否在场地上
	private boolean amIOnTheGround() {
		return myGr.isUnitOnTheGround(this);
	}

	// 只有场地询问时才回复
	public int getSightSize(Object obj) {
		if (obj.getClass() == myGr.getClass())
			return sightSize;
		else
			return -1;
	}

	// 0 --- 本来就在场地上
	// -1 --- 无法进入
	// 1 --- 已经进入
	public int findAMerginToStepIn() {
		if (amIOnTheGround())
			return 0; // 本来就在场地上
		else {
			int sz = myGr.getGroundSize();
			for (int i = 0; i < sz; ++i) {
				if (myGr.stepOnXY(i, 0, this) || myGr.stepOnXY(i, sz - 1, this)) {
					whereAmI();
					return 1;
				}
				if (myGr.stepOnXY(0, i, this) || myGr.stepOnXY(sz - 1, i, this)) {
					whereAmI();
					return 1;
				}
			}
			return -1;
		}
	}

	// 向场地获取自身位置信息，不在场地，则返回false
	public boolean whereAmI() {
		tileIAmOn = myGr.whereIsHim(this);
		return (tileIAmOn != null);
	}

	// 与友方交换位置
	public boolean swap(Tile t) {

		if (t.isTileEmpty())
			return false;

		Unit u = t.getUnitOnTile();
		if (u.getFactionType() != this.factionType) {
			// TODO 发动进攻后进入
			return false;
		}
		else if (u instanceof Character) {
			
			//System.out.print(Math.min(moveAbility, cha.getMoveAbility(this)));
			Character cha = (Character)u;
			if (this.amIOnTheGround() == false || cha.amIOnTheGround() == false)
				return false;
			else if (Math.abs(this.tileIAmOn.getLatitute() - t.getLatitute())
					+ Math.abs(this.tileIAmOn.getLongitude() - t.getLongitude()) > Math.min(moveAbility,
							cha.getMoveAbility(this)))
				return false;
			else {

				// 交换位置
				myGr.baseSwap(t, this.tileIAmOn, cha, this);
				return true;
			}
		}
		else {
			return false;
		}

	}

	// 去到某个位置
	public boolean goToTile(int x, int y) {
		// 若我本人没在场地，直接返回失败
		if (tileIAmOn == null)
			return false;
		// 如果在场地超出了我的行动范围，也返回失败
		else if (x + y - tileIAmOn.getLatitute() - tileIAmOn.getLongitude() > moveAbility)
			return false;
		// 如果在场地且在我的行动范围则
		else {
			Tile desTile = myGr.howIsXY(x, y, this, sightSize);
			// 如果目标位不存在
			if (desTile == null)
				return false;
			// 如果目标位是空的，直接移动到目标地块
			if (desTile.isTileEmpty()) {
				myGr.unitMoveToXY(x, y, this);
				whereAmI();
				return true;
			}
			// 如果目标位是敌人，fight
			if (desTile.getUnitOnTile().getFactionType() != factionType) {
				return false;
			}
			// TODO 己方阵亡，返回失败（暂时不实现，默认直接使敌方阵亡）
			// 敌人被消灭，地面清除敌人尸体，移动到空位置
			// 如果目标位是友方，交谈，期望它挪一挪
			else {
				// Character charaToMove = desTile.getUnitOnTile();
				// int oriX = tileIAmOn.getLatitute();
				// int oriY = tileIAmOn.getLongitude();
				if (wouldYouSpareATileForMe(desTile.getUnitOnTile())) {
					// 如果友方成功挪动，移动到空位置，发送消息给友方单位，另其移动到己方原位置上
					myGr.unitMoveToXY(x, y, this);
					// myGr.unitMoveToXY(oriX, oriY, charaToMove);
					whereAmI();
					return true;
				}
			}
			return false;
		}
	}

	// 获取障碍物的概要图
	private Vector<Vector<Integer>> get01Map() {
		Vector<Vector<Integer>> pathMap = new Vector<Vector<Integer>>();
		for (Vector<TILE_TYPE> vec : mySight) {
			Vector<Integer> mapLine = new Vector<Integer>();
			for (TILE_TYPE tileTP : vec) {
				if (tileTP != TILE_TYPE.NOBODY) {
					mapLine.add(new Integer(-1));
				} else {
					mapLine.add(new Integer(0));
				}
			}
			pathMap.add(mapLine);
		}
		return pathMap;
	}

	// 此位置是否合法
	private boolean isThisPosLegal(int x, int y, Vector<Vector<Integer>> vec) {
		int sz = vec.size();
		return (x >= 0 && x < sz && y >= 0 && y < sz);
	}

	// 此位置是否为空
	private boolean isThisPosVacant(int x, int y, Vector<Vector<Integer>> vec) {
		int sz = vec.size();
		return (x >= 0 && x < sz && y >= 0 && y < sz && vec.get(x).get(y) == 0);
	}

	// 寻找到某个位置的通路
	private Stack<Pair<Integer, Integer>> findWayFrom01Map(int stX, int stY, int edX, int edY,
			Vector<Vector<Integer>> map01) {
		Stack<Pair<Integer, Integer>> res = new Stack<Pair<Integer, Integer>>();
		Queue<Pair<Integer, Integer>> temQue = new LinkedList<Pair<Integer, Integer>>();
		temQue.offer(Pair.of(stX, stY));
		map01.get(stX).set(stY, 1);
		boolean findIt = false;
		while (!temQue.isEmpty()) {
			Pair<Integer, Integer> temPair = temQue.poll();
			int lf = temPair.getLeft();
			int rt = temPair.getRight();
			if (lf == edX && rt == edY) {
				findIt = true;
				break;
			}
			int val = map01.get(lf).get(rt);
			if (isThisPosVacant(lf, rt + 1, map01)) {
				map01.get(lf).set(rt + 1, val + 1);
				temQue.offer(Pair.of(lf, rt + 1));
			}
			if (isThisPosVacant(lf, rt - 1, map01)) {
				map01.get(lf).set(rt - 1, val + 1);
				temQue.offer(Pair.of(lf, rt - 1));
			}
			if (isThisPosVacant(lf + 1, rt, map01)) {
				map01.get(lf + 1).set(rt, val + 1);
				temQue.offer(Pair.of(lf + 1, rt));
			}
			if (isThisPosVacant(lf - 1, rt, map01)) {
				map01.get(lf - 1).set(rt, val + 1);
				temQue.offer(Pair.of(lf - 1, rt));
			}
		}
		if (findIt == false)
			return res;
		else {
			int curNum = map01.get(edX).get(edY);
			res.push(Pair.of(edX, edY));
			int curX = edX;
			int curY = edY;
			while (curNum != 1) {
				if (isThisPosLegal(curX, curY + 1, map01) && map01.get(curX).get(curY + 1) == curNum - 1) {
					curNum--;
					curY = curY + 1;
					res.push(Pair.of(curX, curY));
					continue;
				}
				if (isThisPosLegal(curX, curY - 1, map01) && map01.get(curX).get(curY - 1) == curNum - 1) {
					curNum--;
					curY = curY - 1;
					res.push(Pair.of(curX, curY));
					continue;
				}
				if (isThisPosLegal(curX + 1, curY, map01) && map01.get(curX + 1).get(curY) == curNum - 1) {
					curNum--;
					curX = curX + 1;
					res.push(Pair.of(curX, curY));
					continue;
				}
				if (isThisPosLegal(curX - 1, curY, map01) && map01.get(curX - 1).get(curY) == curNum - 1) {
					curNum--;
					curX = curX - 1;
					res.push(Pair.of(curX, curY));
					continue;
				}
				// 这里不应被执行到
				findIt = false;
				break;
			}
			return res;
		}
	}

	// 自动寻路到某个位置
	public boolean findWayToXY(int x, int y) {
		renewMySight();
		// 如果目标点看不到，则无法寻路
		if (mySight.get(x).get(y) == TILE_TYPE.UNKNOWN)
			return false;
		// 第一次尝试 --- 从空路径寻路
		else {
			Vector<Vector<Integer>> pathMap = get01Map();
			Stack<Pair<Integer, Integer>> pathStack = findWayFrom01Map(tileIAmOn.getLatitute(),
					tileIAmOn.getLongitude(), x, y, pathMap);
			if (pathStack.isEmpty())
				return false;
			else {
				// System.out.print(this.name + "\n");
				while (!pathStack.isEmpty()) {

					Pair<Integer, Integer> temPos = pathStack.pop();
					if (temPos.getLeft() != tileIAmOn.getLatitute() || temPos.getRight() != tileIAmOn.getLongitude()) {
						// System.out.print(temPos + " ");
						if (goToTile(temPos.getLeft(), temPos.getRight()) == false)
							return false;
					}
					System.out.print(myGr.seeAroud());
				}
				// System.out.print("\n");
				return true;
			}
		}

		// TODO 第二次尝试 --- 从友方寻路
		// TODO 第三次尝试 --- 向敌方进攻
	}

	// 与友方交互，请求其移动一下来为自己腾开位置
	public boolean wouldYouSpareATileForMe(Unit u) {
		// 同阵营检查
		if (u.getFactionType() != factionType)
			return false;
		else if (!(u instanceof Character))
			return false;
		else {
			return ((Character) u).spareAPlaceForHim(this);
		}
	}

	// 回应友方请求，尝试移动一下腾开位置
	public boolean spareAPlaceForHim(Unit u) {
		// 同阵营检查
		if (u.getFactionType() != factionType)
			return false;
		else if (!(u instanceof Character))
			return false;
		else {
			// 自己位置检查
			if (whereAmI() == false)
				return false;
			else {
				int x = tileIAmOn.getLatitute();
				int y = tileIAmOn.getLongitude();
				Tile tileUp = myGr.howIsXY(x, y - 1, this, sightSize);
				if (tileUp.isTileEmpty() && goToTile(x, y - 1))
					return true;
				Tile tileDn = myGr.howIsXY(x, y + 1, this, sightSize);
				if (tileDn.isTileEmpty() && goToTile(x, y + 1))
					return true;
				Tile tileLf = myGr.howIsXY(x - 1, y, this, sightSize);
				if (tileLf.isTileEmpty() && goToTile(x - 1, y))
					return true;
				Tile tileRt = myGr.howIsXY(x + 1, y, this, sightSize);
				if (tileRt.isTileEmpty() && goToTile(x + 1, y))
					return true;
				// 位置都不行 返回出错
				return false;
			}
		}
	}

	// public boolean stepOnMargin() {
	// myGr.
	// }
//	public void seeAround()
//	{
//		sight = myGr.theGroundYouCanSee(this, sightSize);
//	}

}
