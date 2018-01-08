var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":16,"id":321,"methods":[{"el":11,"sc":3,"sl":9},{"el":15,"sc":3,"sl":13}],"name":"FloatGenerator","sl":5}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_10":{"methods":[{"sl":13}],"name":"testHasValidBeanToString","pass":true,"statements":[{"sl":14}]},"test_117":{"methods":[{"sl":13}],"name":"shouldGenerateRandomValue","pass":true,"statements":[{"sl":14}]},"test_14":{"methods":[{"sl":9}],"name":"shouldThrowExceptionOnBeanWithPropertyNeedingCustomValueGenerator","pass":true,"statements":[{"sl":10}]},"test_15":{"methods":[{"sl":13}],"name":"testHasValidGettersAndSetters","pass":true,"statements":[{"sl":14}]},"test_24":{"methods":[{"sl":13}],"name":"testHasValidBeanHashCode","pass":true,"statements":[{"sl":14}]},"test_85":{"methods":[{"sl":13}],"name":"testHasValidBeanEquals","pass":true,"statements":[{"sl":14}]},"test_96":{"methods":[{"sl":13}],"name":"testBeanHasValidGettersAndSetters","pass":true,"statements":[{"sl":14}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [14], [14], [], [], [85, 96, 117, 10, 15, 24], [85, 96, 117, 10, 15, 24], [], []]
