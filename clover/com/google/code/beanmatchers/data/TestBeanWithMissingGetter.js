var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":19,"id":1621,"methods":[{"el":10,"sc":5,"sl":8},{"el":14,"sc":5,"sl":12},{"el":18,"sc":5,"sl":16}],"name":"TestBeanWithMissingGetter","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_6":{"methods":[{"sl":16}],"name":"shouldThrowExceptionIfGetterIsMissing","pass":true,"statements":[{"sl":17}]},"test_67":{"methods":[{"sl":16}],"name":"beanWithMissingGetterShouldNotMatch","pass":true,"statements":[{"sl":17}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [67, 6], [67, 6], [], []]
