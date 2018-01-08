var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":19,"id":1634,"methods":[{"el":10,"sc":3,"sl":8},{"el":14,"sc":3,"sl":12},{"el":18,"sc":3,"sl":16}],"name":"TestBeanWithMissingGetter","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_142":{"methods":[{"sl":16}],"name":"shouldThrowExceptionIfGetterIsMissing","pass":true,"statements":[{"sl":17}]},"test_99":{"methods":[{"sl":16}],"name":"beanWithMissingGetterShouldNotMatch","pass":true,"statements":[{"sl":17}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [142, 99], [142, 99], [], []]
