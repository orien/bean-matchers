var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":9,"id":493,"methods":[{"el":8,"sc":3,"sl":6}],"name":"StringGenerator","sl":5}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_10":{"methods":[{"sl":6}],"name":"testHasValidBeanToString","pass":true,"statements":[{"sl":7}]},"test_146":{"methods":[{"sl":6}],"name":"shouldProvideDifferingStringOnSubsequentCall","pass":true,"statements":[{"sl":7}]},"test_15":{"methods":[{"sl":6}],"name":"testHasValidGettersAndSetters","pass":true,"statements":[{"sl":7}]},"test_24":{"methods":[{"sl":6}],"name":"testHasValidBeanHashCode","pass":true,"statements":[{"sl":7}]},"test_67":{"methods":[{"sl":6}],"name":"shouldProvideString","pass":true,"statements":[{"sl":7}]},"test_85":{"methods":[{"sl":6}],"name":"testHasValidBeanEquals","pass":true,"statements":[{"sl":7}]},"test_96":{"methods":[{"sl":6}],"name":"testBeanHasValidGettersAndSetters","pass":true,"statements":[{"sl":7}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [146, 10, 85, 96, 15, 67, 24], [146, 10, 85, 96, 15, 67, 24], [], []]
