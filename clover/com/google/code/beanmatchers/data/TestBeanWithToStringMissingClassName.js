var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":18,"id":1913,"methods":[{"el":8,"sc":3,"sl":6},{"el":12,"sc":3,"sl":10},{"el":17,"sc":3,"sl":14}],"name":"TestBeanWithToStringMissingClassName","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_109":{"methods":[{"sl":14}],"name":"beanWithoutClassNameInToStringShouldBeDiagnosed","pass":true,"statements":[{"sl":16}]},"test_119":{"methods":[{"sl":14}],"name":"beanWithoutClassNameInToStringShouldBeDiagnosed","pass":true,"statements":[{"sl":16}]},"test_162":{"methods":[{"sl":14}],"name":"beanWithoutClassNameInToStringShouldNotMatch","pass":true,"statements":[{"sl":16}]},"test_37":{"methods":[{"sl":14}],"name":"beanWithoutClassNameInToStringShouldNotMatch","pass":true,"statements":[{"sl":16}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [37, 162, 109, 119], [], [37, 162, 109, 119], [], []]
