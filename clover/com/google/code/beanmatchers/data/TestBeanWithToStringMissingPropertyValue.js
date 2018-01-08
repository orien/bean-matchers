var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":18,"id":1727,"methods":[{"el":8,"sc":3,"sl":6},{"el":12,"sc":3,"sl":10},{"el":17,"sc":3,"sl":14}],"name":"TestBeanWithToStringMissingPropertyValue","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_102":{"methods":[{"sl":10},{"sl":14}],"name":"beanWithoutPropertyValueInToStringShouldBeDiagnosed","pass":true,"statements":[{"sl":11},{"sl":16}]},"test_129":{"methods":[{"sl":14}],"name":"testHasValidBeanToStringExcluding","pass":true,"statements":[{"sl":16}]},"test_132":{"methods":[{"sl":10},{"sl":14}],"name":"beanWithoutPropertyValueInToStringShouldNotMatch","pass":true,"statements":[{"sl":11},{"sl":16}]},"test_151":{"methods":[{"sl":10},{"sl":14}],"name":"beanWithoutPropertyValueInToStringShouldNotMatch","pass":true,"statements":[{"sl":11},{"sl":16}]},"test_152":{"methods":[{"sl":14}],"name":"beanWithoutPropertyValueInToStringShouldMatchIfPropertyIsNotDeclared","pass":true,"statements":[{"sl":16}]},"test_69":{"methods":[{"sl":10},{"sl":14}],"name":"beanWithoutPropertyValueInToStringShouldBeDiagnosed","pass":true,"statements":[{"sl":11},{"sl":16}]},"test_81":{"methods":[{"sl":14}],"name":"beanWithoutPropertyValueInToStringShouldMatchIfPropertyIsExcluded","pass":true,"statements":[{"sl":16}]},"test_97":{"methods":[{"sl":14}],"name":"testHasValidBeanToStringFor","pass":true,"statements":[{"sl":16}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [102, 132, 151, 69], [102, 132, 151, 69], [], [], [102, 132, 151, 69, 81, 97, 152, 129], [], [102, 132, 151, 69, 81, 97, 152, 129], [], []]
