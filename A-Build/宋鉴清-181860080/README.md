### 自动构建

①使用`junit`第三方库，写测试类。

②使用了`RandomStringGenerator`来随机生成葫芦娃的姓名，所以需要导入`org.apache.commons`的`commons-text`第三方库；

使用`StringUtils`来将葫芦娃姓名的首字母大写，所以需要导入`org.apache.commons`的`commons-lang3`第三方库。

③使用了`com.google.guava`中的`Ordering`，所以需要导入该第三方库，因为前面作业中实现了正序和逆序的迭代器，所以可以通过`Ordering().isOrdered(list)`来判断该迭代器是否是排好序的，即定义一个`Ordering<Gourd> gourdposOrdering = Ordering.natural();`，然后通过

`assertTrue(gourdposOrdering.isOrdered(gourdFamily.positIterable()));`

`assertTrue(gourdposOrdering.reverse().isOrdered(gourdFamily.negaIterable()));`即可测试，相比较而言却是简化代码，使代码更容易读懂。

④使用了`maven-shade-plugin`这个插件，将`main`方法的信息添加到mainifest中，然后就可以直接使用`java -jar target/xxx.jar`运行整个项目；如果不使用该插件，那么打包后的`xxx.jar`没有包含`main`方法，所以不能够被运行，只能被调用。

