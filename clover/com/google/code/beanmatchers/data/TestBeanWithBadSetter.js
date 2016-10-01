var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":23,"id":1422,"methods":[{"el":10,"sc":5,"sl":8},{"el":14,"sc":5,"sl":12},{"el":18,"sc":5,"sl":16},{"el":22,"sc":5,"sl":20}],"name":"TestBeanWithBadSetter","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_111":{"methods":[{"sl":16},{"sl":20}],"name":"beanWithInvalidSetterShouldNotMatch","pass":true,"statements":[{"sl":17}]},"test_116":{"methods":[{"sl":8},{"sl":12}],"name":"testHasValidGettersAndSettersExcluding","pass":true,"statements":[{"sl":9},{"sl":13}]},"test_135":{"methods":[{"sl":8},{"sl":12},{"sl":16},{"sl":20}],"name":"beanWithInvalidSetterShouldNotMatch","pass":true,"statements":[{"sl":9},{"sl":13},{"sl":17}]},"test_158":{"methods":[{"sl":8},{"sl":12}],"name":"beanWithInvalidSetterShouldMatchIfBadPropertyIsExcluded","pass":true,"statements":[{"sl":9},{"sl":13}]},"test_84":{"methods":[{"sl":8},{"sl":12}],"name":"testBeanHasValidGettersAndSettersExcluding","pass":true,"statements":[{"sl":9},{"sl":13}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [135, 158, 84, 116], [135, 158, 84, 116], [], [], [135, 158, 84, 116], [135, 158, 84, 116], [], [], [135, 111], [135, 111], [], [], [135, 111], [], [], []]
