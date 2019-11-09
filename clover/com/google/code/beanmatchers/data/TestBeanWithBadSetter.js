var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":23,"id":1581,"methods":[{"el":10,"sc":3,"sl":8},{"el":14,"sc":3,"sl":12},{"el":18,"sc":3,"sl":16},{"el":22,"sc":3,"sl":20}],"name":"TestBeanWithBadSetter","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_130":{"methods":[{"sl":8},{"sl":12}],"name":"beanWithInvalidSetterShouldMatchIfBadPropertyIsExcluded","pass":true,"statements":[{"sl":9},{"sl":13}]},"test_152":{"methods":[{"sl":16},{"sl":20}],"name":"beanWithInvalidSetterShouldNotMatch","pass":true,"statements":[{"sl":17}]},"test_156":{"methods":[{"sl":8},{"sl":12}],"name":"testBeanHasValidGettersAndSettersExcluding","pass":true,"statements":[{"sl":9},{"sl":13}]},"test_50":{"methods":[{"sl":8},{"sl":12},{"sl":16},{"sl":20}],"name":"beanWithInvalidSetterShouldNotMatch","pass":true,"statements":[{"sl":9},{"sl":13},{"sl":17}]},"test_58":{"methods":[{"sl":8},{"sl":12}],"name":"testHasValidGettersAndSettersExcluding","pass":true,"statements":[{"sl":9},{"sl":13}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [156, 130, 50, 58], [156, 130, 50, 58], [], [], [156, 130, 50, 58], [156, 130, 50, 58], [], [], [50, 152], [50, 152], [], [], [50, 152], [], [], []]
