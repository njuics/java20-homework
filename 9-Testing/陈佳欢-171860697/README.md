![类图.png](http://www.plantuml.com/plantuml/png/ZPBHQi8m58Rl-nG7TZby0nd2OFDYCC72BalM73KOJo1Dgk1yzvbZQfjvBdPL-ltfdtx9MNH1-H0FjcgjwZfuzQX2z0Zd2W3W2RIBtnR1cWsMHD4MVMEnH_id246r-v9ft22roB1f-F4yP5iCJQe_NnxvP1Cnvgsa96zuZIvLLdltYlHAPRCPh8Ctj0LIX_A_Si0rAOHfoJ9-n2yrdCv_EqQttXaDtTxOv3FMVX8sosZZyLezqlhe9BhpAAr-Sz5BsFJIwhKvIHHxf8BV1sB-CviDPrZIV2ZLxS5e52em6mcObOI0dGJEKW9dAmbFj0RLbUjCC8xcDU0f86aU_YJrSX-H6dREQlJvrL00QmWdhwqxbXTVyvtVFXjkdLScd3v-WDSAdh05aeu7-mi0)

## Creature
该类是HuLuWa和之后Monster的基类。

主要属性有：life（血量）、anger_level（蓝量）
、attack（攻击力）、defence（防御力）

主要行为有：get_life（返回血量）、get_anger_level（返回蓝量）、get_attack（返回攻击力）、get_defence（返回防御力），get_name（返回姓名，在HuLuWa和GrandPa中有重写）

## HuLuWa
该类继承Creature，表示葫芦娃基类

附加属性有：name（葫芦娃名字）

### One_Huluwa/Two_Huluwa../Seven_Huluwa
分别表示大娃到七娃，继承HuLuWa类，之后会实现不同的葫芦娃技能大招

## GrandPa
该类继承Creature，表示爷爷这一个体

## Position
组成棋盘的基本元素，采用泛型设计，占据Position的可以是任意一种Creature

主要属性有：T holder（该位置占据者）、line（该位置所在的行）、cow（该位置所在列）

主要行为有：get_creature（返回该位置的占据者）、get_line（返回该位置的行）、get_cow(返回该位置的列)

使用泛型设计的优点：将爷爷、葫芦娃以及之后的妖精们都可以放在一张棋盘上进行对弈

## Test
本次测试主要是对两个排序方法orchestration和choreography的测试