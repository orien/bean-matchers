var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":23,"id":1435,"methods":[{"el":10,"sc":3,"sl":8},{"el":14,"sc":3,"sl":12},{"el":18,"sc":3,"sl":16},{"el":22,"sc":3,"sl":20}],"name":"TestBeanWithBadSetter","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_118":{"methods":[{"sl":8},{"sl":12}],"name":"testHasValidGettersAndSettersExcluding","pass":true,"statements":[{"sl":9},{"sl":13}]},"test_134":{"methods":[{"sl":16},{"sl":20}],"name":"beanWithInvalidSetterShouldNotMatch","pass":true,"statements":[{"sl":17}]},"test_148":{"methods":[{"sl":8},{"sl":12}],"name":"beanWithInvalidSetterShouldMatchIfBadPropertyIsExcluded","pass":true,"statements":[{"sl":9},{"sl":13}]},"test_84":{"methods":[{"sl":8},{"sl":12}],"name":"testBeanHasValidGettersAndSettersExcluding","pass":true,"statements":[{"sl":9},{"sl":13}]},"test_93":{"methods":[{"sl":8},{"sl":12},{"sl":16},{"sl":20}],"name":"beanWithInvalidSetterShouldNotMatch","pass":true,"statements":[{"sl":9},{"sl":13},{"sl":17}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [148, 118, 93, 84], [148, 118, 93, 84], [], [], [148, 118, 93, 84], [148, 118, 93, 84], [], [], [93, 134], [93, 134], [], [], [93, 134], [], [], []]
