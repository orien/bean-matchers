var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":16,"id":352,"methods":[{"el":11,"sc":3,"sl":9},{"el":15,"sc":3,"sl":13}],"name":"DoubleGenerator","sl":5}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_105":{"methods":[{"sl":13}],"name":"testHasValidBeanHashCode","pass":true,"statements":[{"sl":14}]},"test_107":{"methods":[{"sl":13}],"name":"testHasValidBeanToString","pass":true,"statements":[{"sl":14}]},"test_135":{"methods":[{"sl":13}],"name":"shouldGenerateRandomValue","pass":true,"statements":[{"sl":14}]},"test_154":{"methods":[{"sl":9}],"name":"shouldThrowExceptionOnBeanWithPropertyNeedingCustomValueGenerator","pass":true,"statements":[{"sl":10}]},"test_48":{"methods":[{"sl":13}],"name":"testBeanHasValidGettersAndSetters","pass":true,"statements":[{"sl":14}]},"test_52":{"methods":[{"sl":13}],"name":"testHasValidBeanEquals","pass":true,"statements":[{"sl":14}]},"test_90":{"methods":[{"sl":13}],"name":"testHasValidGettersAndSetters","pass":true,"statements":[{"sl":14}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [154], [154], [], [], [105, 90, 52, 107, 48, 135], [105, 90, 52, 107, 48, 135], [], []]
