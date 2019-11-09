var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":16,"id":304,"methods":[{"el":11,"sc":3,"sl":9},{"el":15,"sc":3,"sl":13}],"name":"BooleanGenerator","sl":5}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_11":{"methods":[{"sl":13}],"name":"testHasValidBeanEquals","pass":true,"statements":[{"sl":14}]},"test_115":{"methods":[{"sl":13}],"name":"testHasValidBeanToString","pass":true,"statements":[{"sl":14}]},"test_131":{"methods":[{"sl":13}],"name":"shouldGenerateRandomValue","pass":true,"statements":[{"sl":14}]},"test_137":{"methods":[{"sl":13}],"name":"testHasValidBeanHashCode","pass":true,"statements":[{"sl":14}]},"test_146":{"methods":[{"sl":9}],"name":"shouldThrowExceptionOnBeanWithPropertyNeedingCustomValueGenerator","pass":true,"statements":[{"sl":10}]},"test_19":{"methods":[{"sl":13}],"name":"testHasValidGettersAndSetters","pass":true,"statements":[{"sl":14}]},"test_89":{"methods":[{"sl":13}],"name":"testBeanHasValidGettersAndSetters","pass":true,"statements":[{"sl":14}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [146], [146], [], [], [89, 19, 137, 11, 115, 131], [89, 19, 137, 11, 115, 131], [], []]
