var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":18,"id":1886,"methods":[{"el":8,"sc":3,"sl":6},{"el":12,"sc":3,"sl":10},{"el":17,"sc":3,"sl":14}],"name":"TestBeanWithToStringMissingArrayPropertyValue","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_120":{"methods":[{"sl":10},{"sl":14}],"name":"beanWithoutArrayPropertyValueInToStringShouldNotMatch","pass":true,"statements":[{"sl":11},{"sl":16}]},"test_74":{"methods":[{"sl":10},{"sl":14}],"name":"beanWithoutArrayPropertyValueInToStringShouldNotMatch","pass":true,"statements":[{"sl":11},{"sl":16}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [74, 120], [74, 120], [], [], [74, 120], [], [74, 120], [], []]
