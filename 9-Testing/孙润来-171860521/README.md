# 测试
1. 添加了获取`Iterator`方法，便于测试
2. 使用了`BeforeClass`和`AfterClass`来进行资源的申请与回收
3. 主要测试了`ArrayList`对象的正确性，`SortComparable`方法的排序结果的正确性，以及排序性能

## 排序结果验证
使用`Iterator`来进行`Huluwa`实例的获取，根据排好序的结果使用名字比较来进行验证，`assertTrue(p.getName().compareTo(q.getName())<=0);`

由于还分性别两列排序，所以性别交替的位置不比较，为了测试有没有按照性别分列排序，引入变量`flag`和`assertTrue(p.getGender());
                                                                        assertFalse(q.getGender());
                                                                        assertTrue(flag);`,仅第一次生效且需要性别`true`在`false`之前（先男后女）

## 排序性能
使用`@test(timeout=1000)`后在函数内调用排序方法