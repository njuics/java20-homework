/*
 * @Author: zb-nju
 * @Date: 2020-11-05 13:45:46
 * @LastEditors: zb-nju
 * @LastEditTime: 2020-11-05 14:29:27
 */
package hw8;

interface IFactory<T>{  //接口也可以参数化
    T create();
}

public class CalabashBoyFactory implements IFactory<CalabashBoy>{
    public CalabashBoy create(){
        return new CalabashBoy();
    }
}