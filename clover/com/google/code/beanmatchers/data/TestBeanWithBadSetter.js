var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":23,"id":1583,"methods":[{"el":10,"sc":3,"sl":8},{"el":14,"sc":3,"sl":12},{"el":18,"sc":3,"sl":16},{"el":22,"sc":3,"sl":20}],"name":"TestBeanWithBadSetter","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_110":{"methods":[{"sl":8},{"sl":12},{"sl":16},{"sl":20}],"name":"beanWithInvalidSetterShouldNotMatch","pass":true,"statements":[{"sl":9},{"sl":13},{"sl":17}]},"test_125":{"methods":[{"sl":8},{"sl":12}],"name":"testBeanHasValidGettersAndSettersExcluding","pass":true,"statements":[{"sl":9},{"sl":13}]},"test_136":{"methods":[{"sl":8},{"sl":12}],"name":"testHasValidGettersAndSettersExcluding","pass":true,"statements":[{"sl":9},{"sl":13}]},"test_26":{"methods":[{"sl":16},{"sl":20}],"name":"beanWithInvalidSetterShouldNotMatch","pass":true,"statements":[{"sl":17}]},"test_6":{"methods":[{"sl":8},{"sl":12}],"name":"beanWithInvalidSetterShouldMatchIfBadPropertyIsExcluded","pass":true,"statements":[{"sl":9},{"sl":13}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [110, 125, 6, 136], [110, 125, 6, 136], [], [], [110, 125, 6, 136], [110, 125, 6, 136], [], [], [110, 26], [110, 26], [], [], [110, 26], [], [], []]
