var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":9,"id":538,"methods":[{"el":8,"sc":3,"sl":6}],"name":"StringGenerator","sl":5}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_105":{"methods":[{"sl":6}],"name":"testHasValidBeanHashCode","pass":true,"statements":[{"sl":7}]},"test_107":{"methods":[{"sl":6}],"name":"testHasValidBeanToString","pass":true,"statements":[{"sl":7}]},"test_164":{"methods":[{"sl":6}],"name":"shouldProvideDifferingStringOnSubsequentCall","pass":true,"statements":[{"sl":7}]},"test_42":{"methods":[{"sl":6}],"name":"shouldProvideString","pass":true,"statements":[{"sl":7}]},"test_48":{"methods":[{"sl":6}],"name":"testBeanHasValidGettersAndSetters","pass":true,"statements":[{"sl":7}]},"test_52":{"methods":[{"sl":6}],"name":"testHasValidBeanEquals","pass":true,"statements":[{"sl":7}]},"test_90":{"methods":[{"sl":6}],"name":"testHasValidGettersAndSetters","pass":true,"statements":[{"sl":7}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [42, 105, 90, 164, 52, 107, 48], [42, 105, 90, 164, 52, 107, 48], [], []]
