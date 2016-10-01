var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":18,"id":1702,"methods":[{"el":8,"sc":5,"sl":6},{"el":12,"sc":5,"sl":10},{"el":17,"sc":5,"sl":14}],"name":"TestBeanWithToStringMissingClassName","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_34":{"methods":[{"sl":14}],"name":"beanWithoutClassNameInToStringShouldNotMatch","pass":true,"statements":[{"sl":16}]},"test_47":{"methods":[{"sl":14}],"name":"beanWithoutClassNameInToStringShouldBeDiagnosed","pass":true,"statements":[{"sl":16}]},"test_72":{"methods":[{"sl":14}],"name":"beanWithoutClassNameInToStringShouldBeDiagnosed","pass":true,"statements":[{"sl":16}]},"test_86":{"methods":[{"sl":14}],"name":"beanWithoutClassNameInToStringShouldNotMatch","pass":true,"statements":[{"sl":16}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [72, 47, 34, 86], [], [72, 47, 34, 86], [], []]
