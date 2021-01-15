/*
 * @Author: zb-nju
 * @Date: 2020-11-05 13:45:46
 * @LastEditors: zb-nju
 * @LastEditTime: 2020-11-15 10:09:34
 */
package hw9;

interface IFactory<T>{  //接口也可以参数化
    T create();
}

public class CalabashBoyFactory implements IFactory<CalabashBoy>{
    public CalabashBoy create(){
        return new CalabashBoy();
    }
}