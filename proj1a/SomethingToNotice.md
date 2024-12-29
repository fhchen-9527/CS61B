# 在项目中遇到的问题
总的来说，这个项目比较简单，主要是为了练习Lecture 5的内容以及Leture 6。
- 第一个问题就是在添加和删除Node本质是删除连边，因此我们需要注意删除和链接的顺序，不然会得到错误。
- 第二个问题是在method中，我又重新声明了公共变量sentinel，即 StuffNode sentinel = new ...。这直接导致我定义了一个新的变量sentinel，因此我在后续程序里想调用sentinel时，直接导致其为null。
- assertThat中的actual和expected前后顺序搞反。
