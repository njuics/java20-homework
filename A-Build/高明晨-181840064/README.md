## 自动构建  
### 使用的第三方库
#### Apache
org.apache.commons.lang3.RandomStringUtils模块中的  

    String randomAlphabetic(int count);  

可以随机产生count个随机英文字母（包含大小写），以此来随机生成葫芦娃的姓名，而非像之前一样自己手动编写生成随机英文串的函数，简化了实现。  
#### Guava
本次作业使用了Guava中的以下三个模块  

    com.google.common.collect.Ordering  
    com.google.common.base.Predicate  
    com.google.common.collect.Collections2  
为了实现Family类的各种排序迭代器，Guava中的Ordering类可以帮助我们轻松实现，使用到的Ordering类方法有：  

    static <T> Ordering<T>
    from(Comparator<T> comparator) 
        //Returns an ordering for a pre-existing comparator.

    <E extends T> List<E>
    sortedCopy(Iterable<E> iterable) 
        //Returns a copy of the given iterable sorted by this ordering.

    <S extends T> Ordering<S>
    reverse() 
        //Returns the reverse of this ordering; the Ordering equivalent to Collections.reverseOrder(Comparator).

    static Ordering<Object>	
    arbitrary() 
        //Returns an arbitrary ordering over all objects, for which compare(a, b) == 0 implies a == b (identity equality).  
    
注意到这些方法可以连续使用,例如Family中的升序排序迭代器可以直接用一连串的方法实现：  
    
    public Iterator<T> ascendingIterator(){
        return Ordering.from(new CharacterAscendingComparator()).sortedCopy(array).iterator();
    } 
而非像之前一样自己手动编写实现Iterator接口的内部类，并手动实现hasNext()和next方法。这大大简化了Family类的实现。类似的，随机排序的迭代器也可以通过Ordering的arbitrary()方法轻松实现，这里不再赘述。  
  
此外，由于还需要实现关于男性和女性分别排序的迭代器，我们就可以利用Collections2类的静态方法filter来进行过滤操作，其方法接口为：  

    static<E> Collection<E>
    filter(Collection<E> unfiltered, Predicate<? super E> predicate) 
        //Returns the elements of unfiltered that satisfy a predicate.

以实现Family类的maleAscendingIterator方法为例，注意这里利用了Predicate类的函数式编程方法：

    public Iterator<T> maleAscendingIterator(){
        return
        Collections2.filter(Ordering.from(new CharacterAscendingComparator()).sortedCopy(array), 
            new Predicate<Character>(){
                @Override
                public boolean apply(Character x){
                    if(x.getGender()=="Male")
                        return true;
                    else 
                        return false;
                }
            }).iterator();
    }
### pom.xml与自动构建
使用maven进行自动构建，除了需要满足约定的文件目录结构外，还需要编写pom.xml文件，其中依赖项是非常重要的一环。通过这些第三方库的官方网站，可以找到库的依赖文件的\<depndency\>的内容。  
apache.commons.lang3:

        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-lang3</artifactId>
            <version>3.11</version>
        </dependency>

guava：

        <dependency>
            <groupId>com.google.guava</groupId>
            <artifactId>guava</artifactId>
            <version>30.0-jre</version>
          </dependency>

将其添加到\<dependencies\>中即可。  
最后在终端中键入
    
    mvn package
就可以进行自动构建了