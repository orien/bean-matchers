var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":18,"id":1919,"methods":[{"el":8,"sc":3,"sl":6},{"el":12,"sc":3,"sl":10},{"el":17,"sc":3,"sl":14}],"name":"TestBeanWithToStringMissingPropertyName","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_102":{"methods":[{"sl":14}],"name":"beanWithoutPropertyNameInToStringShouldMatchIfPropertyIsExcluded","pass":true,"statements":[{"sl":16}]},"test_114":{"methods":[{"sl":10},{"sl":14}],"name":"beanWithoutPropertyNameInToStringShouldNotMatch","pass":true,"statements":[{"sl":11},{"sl":16}]},"test_145":{"methods":[{"sl":14}],"name":"beanWithoutPropertyNameInToStringShouldMatchIfPropertyNotDeclared","pass":true,"statements":[{"sl":16}]},"test_23":{"methods":[{"sl":10},{"sl":14}],"name":"beanWithoutPropertyNameInToStringShouldNotMatch","pass":true,"statements":[{"sl":11},{"sl":16}]},"test_64":{"methods":[{"sl":10},{"sl":14}],"name":"beanWithoutPropertyNameInToStringShouldBeDiagnosed","pass":true,"statements":[{"sl":11},{"sl":16}]},"test_86":{"methods":[{"sl":10},{"sl":14}],"name":"beanWithoutPropertyNameInToStringShouldBeDiagnosed","pass":true,"statements":[{"sl":11},{"sl":16}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [114, 64, 86, 23], [114, 64, 86, 23], [], [], [114, 64, 86, 23, 145, 102], [], [114, 64, 86, 23, 145, 102], [], []]
