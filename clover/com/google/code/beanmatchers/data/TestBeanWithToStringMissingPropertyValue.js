var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":18,"id":1904,"methods":[{"el":8,"sc":3,"sl":6},{"el":12,"sc":3,"sl":10},{"el":17,"sc":3,"sl":14}],"name":"TestBeanWithToStringMissingPropertyValue","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1":{"methods":[{"sl":14}],"name":"beanWithoutPropertyValueInToStringShouldMatchIfPropertyIsExcluded","pass":true,"statements":[{"sl":16}]},"test_105":{"methods":[{"sl":10},{"sl":14}],"name":"beanWithoutPropertyValueInToStringShouldBeDiagnosed","pass":true,"statements":[{"sl":11},{"sl":16}]},"test_27":{"methods":[{"sl":10},{"sl":14}],"name":"beanWithoutPropertyValueInToStringShouldNotMatch","pass":true,"statements":[{"sl":11},{"sl":16}]},"test_28":{"methods":[{"sl":14}],"name":"testHasValidBeanToStringExcluding","pass":true,"statements":[{"sl":16}]},"test_48":{"methods":[{"sl":10},{"sl":14}],"name":"beanWithoutPropertyValueInToStringShouldBeDiagnosed","pass":true,"statements":[{"sl":11},{"sl":16}]},"test_70":{"methods":[{"sl":10},{"sl":14}],"name":"beanWithoutPropertyValueInToStringShouldNotMatch","pass":true,"statements":[{"sl":11},{"sl":16}]},"test_9":{"methods":[{"sl":14}],"name":"beanWithoutPropertyValueInToStringShouldMatchIfPropertyIsNotDeclared","pass":true,"statements":[{"sl":16}]},"test_90":{"methods":[{"sl":14}],"name":"testHasValidBeanToStringFor","pass":true,"statements":[{"sl":16}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [27, 70, 105, 48], [27, 70, 105, 48], [], [], [90, 28, 1, 27, 70, 105, 48, 9], [], [90, 28, 1, 27, 70, 105, 48, 9], [], []]
