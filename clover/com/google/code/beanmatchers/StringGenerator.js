var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":9,"id":491,"methods":[{"el":8,"sc":5,"sl":6}],"name":"StringGenerator","sl":5}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_12":{"methods":[{"sl":6}],"name":"testBeanHasValidGettersAndSetters","pass":true,"statements":[{"sl":7}]},"test_138":{"methods":[{"sl":6}],"name":"testHasValidBeanHashCode","pass":true,"statements":[{"sl":7}]},"test_157":{"methods":[{"sl":6}],"name":"testHasValidGettersAndSetters","pass":true,"statements":[{"sl":7}]},"test_21":{"methods":[{"sl":6}],"name":"testHasValidBeanEquals","pass":true,"statements":[{"sl":7}]},"test_60":{"methods":[{"sl":6}],"name":"testHasValidBeanToString","pass":true,"statements":[{"sl":7}]},"test_96":{"methods":[{"sl":6}],"name":"shouldProvideString","pass":true,"statements":[{"sl":7}]},"test_99":{"methods":[{"sl":6}],"name":"shouldProvideDifferingStringOnSubsequentCall","pass":true,"statements":[{"sl":7}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [21, 99, 157, 60, 12, 96, 138], [21, 99, 157, 60, 12, 96, 138], [], []]
