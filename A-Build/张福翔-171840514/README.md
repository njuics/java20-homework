# 作业10 张福翔-171840514

### 作业要求

- 使用第三方库（Jar）增强你的葫芦娃
  - Apache Commons https://commons.apache.org/
  - Google Guava https://github.com/google/guava
- 自动构建你的葫芦娃
  - 注意你的gitignore http://gitignore.io/

### 完成情况

- 使用`maven`重新构建了葫芦娃项目.
- 使用`guava`第三方库改善了部分内容的实现, 使用`toStringHelper`重写了各个生物的`toString`方法逻辑, 使用`ComparisonChain`类重写了葫芦娃的比较函数, 使用`Ordering`方法重写了排序方法, 替代了原有的`utils.comparator`中的方法 (因此删除了`utils.comparator`包).