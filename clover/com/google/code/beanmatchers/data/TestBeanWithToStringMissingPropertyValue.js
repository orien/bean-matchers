var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":18,"id":1925,"methods":[{"el":8,"sc":3,"sl":6},{"el":12,"sc":3,"sl":10},{"el":17,"sc":3,"sl":14}],"name":"TestBeanWithToStringMissingPropertyValue","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_10":{"methods":[{"sl":14}],"name":"testHasValidBeanToStringExcluding","pass":true,"statements":[{"sl":16}]},"test_126":{"methods":[{"sl":10},{"sl":14}],"name":"beanWithoutPropertyValueInToStringShouldBeDiagnosed","pass":true,"statements":[{"sl":11},{"sl":16}]},"test_15":{"methods":[{"sl":10},{"sl":14}],"name":"beanWithoutPropertyValueInToStringShouldNotMatch","pass":true,"statements":[{"sl":11},{"sl":16}]},"test_167":{"methods":[{"sl":10},{"sl":14}],"name":"beanWithoutPropertyValueInToStringShouldNotMatch","pass":true,"statements":[{"sl":11},{"sl":16}]},"test_24":{"methods":[{"sl":14}],"name":"beanWithoutPropertyValueInToStringShouldMatchIfPropertyIsNotDeclared","pass":true,"statements":[{"sl":16}]},"test_32":{"methods":[{"sl":14}],"name":"beanWithoutPropertyValueInToStringShouldMatchIfPropertyIsExcluded","pass":true,"statements":[{"sl":16}]},"test_61":{"methods":[{"sl":10},{"sl":14}],"name":"beanWithoutPropertyValueInToStringShouldBeDiagnosed","pass":true,"statements":[{"sl":11},{"sl":16}]},"test_96":{"methods":[{"sl":14}],"name":"testHasValidBeanToStringFor","pass":true,"statements":[{"sl":16}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [126, 15, 61, 167], [126, 15, 61, 167], [], [], [126, 24, 15, 96, 61, 32, 10, 167], [], [126, 24, 15, 96, 61, 32, 10, 167], [], []]
