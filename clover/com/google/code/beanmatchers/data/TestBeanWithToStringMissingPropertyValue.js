var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":18,"id":1714,"methods":[{"el":8,"sc":5,"sl":6},{"el":12,"sc":5,"sl":10},{"el":17,"sc":5,"sl":14}],"name":"TestBeanWithToStringMissingPropertyValue","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_102":{"methods":[{"sl":10},{"sl":14}],"name":"beanWithoutPropertyValueInToStringShouldBeDiagnosed","pass":true,"statements":[{"sl":11},{"sl":16}]},"test_20":{"methods":[{"sl":10},{"sl":14}],"name":"beanWithoutPropertyValueInToStringShouldNotMatch","pass":true,"statements":[{"sl":11},{"sl":16}]},"test_24":{"methods":[{"sl":14}],"name":"beanWithoutPropertyValueInToStringShouldMatchIfPropertyIsNotDeclared","pass":true,"statements":[{"sl":16}]},"test_49":{"methods":[{"sl":14}],"name":"testHasValidBeanToStringExcluding","pass":true,"statements":[{"sl":16}]},"test_55":{"methods":[{"sl":14}],"name":"testHasValidBeanToStringFor","pass":true,"statements":[{"sl":16}]},"test_73":{"methods":[{"sl":10},{"sl":14}],"name":"beanWithoutPropertyValueInToStringShouldBeDiagnosed","pass":true,"statements":[{"sl":11},{"sl":16}]},"test_83":{"methods":[{"sl":14}],"name":"beanWithoutPropertyValueInToStringShouldMatchIfPropertyIsExcluded","pass":true,"statements":[{"sl":16}]},"test_90":{"methods":[{"sl":10},{"sl":14}],"name":"beanWithoutPropertyValueInToStringShouldNotMatch","pass":true,"statements":[{"sl":11},{"sl":16}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [102, 20, 73, 90], [102, 20, 73, 90], [], [], [102, 24, 20, 55, 73, 83, 90, 49], [], [102, 24, 20, 55, 73, 83, 90, 49], [], []]
