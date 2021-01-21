# homework9 - Testing
### 1. 说明
本次作业利用JUnit框架，基于作业8，针对orchestration和choreography两种排序策略各自的升序、降序、乱序功能编写并运行了单元测试。
### 2. 测试数据
设置了三个数组：huluBrothers1, huluBrothers2和huluBrothers3，在@BeforeEach注解的模块对其进行初始化，在@AfterEach下进行清理。其中第一个数组代表了一般情况下的数据，后两个数组分别表示了两种边界情况。
~~~ java
@BeforeEach
    void setUp(){
        huluBrothers1 = new ArrayList<Hulu>(){
            {
                add(new Hulu("a", gender.MALE));
                add(new Hulu("f", gender.FEMALE));
                add(new Hulu("b", gender.MALE));
                add(new Hulu("g", gender.FEMALE));
                add(new Hulu("c", gender.MALE));
                add(new Hulu("h", gender.FEMALE));
                add(new Hulu("d", gender.MALE));
                add(new Hulu("i", gender.FEMALE));
                add(new Hulu("e", gender.MALE));
                add(new Hulu("j", gender.FEMALE));
            }
        };
        huluBrothers2 = new ArrayList<Hulu>(){
            {
                add(new Hulu("a", gender.MALE));
                add(new Hulu("a", gender.FEMALE));
                add(new Hulu("a", gender.MALE));
                add(new Hulu("a", gender.FEMALE));
                add(new Hulu("a", gender.MALE));
                add(new Hulu("a", gender.FEMALE));
                add(new Hulu("a", gender.MALE));
                add(new Hulu("a", gender.FEMALE));
                add(new Hulu("a", gender.MALE));
                add(new Hulu("a", gender.FEMALE));
            }
        };
        huluBrothers3 = new ArrayList<Hulu>(){
            {
                add(new Hulu("a", gender.MALE));
                add(new Hulu("f", gender.MALE));
                add(new Hulu("b", gender.MALE));
                add(new Hulu("g", gender.MALE));
                add(new Hulu("c", gender.MALE));
                add(new Hulu("h", gender.MALE));
                add(new Hulu("d", gender.MALE));
                add(new Hulu("i", gender.MALE));
                add(new Hulu("e", gender.MALE));
                add(new Hulu("j", gender.MALE));
            }
        };
    }

    @AfterEach
    public void tearDown(){
        this.huluBrothers1 = null;
        this.huluBrothers2 = null;
        this.huluBrothers3 = null;
    }
~~~    
### 3. 测试逻辑
以在ascSort方法中的逻辑为例，先对三个数组调用排序函数，option设置为1，表示按正序排序。之后设置一个flag变量，通过一次遍历，对排序后数组进行检验，用flag表示其是否满足升序条件。最后加入判断条件 assertTrue(flag) 对测试结果进行检验。检验乱序和倒序的逻辑同理。
