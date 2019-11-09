var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":9,"id":536,"methods":[{"el":8,"sc":3,"sl":6}],"name":"StringGenerator","sl":5}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_11":{"methods":[{"sl":6}],"name":"testHasValidBeanEquals","pass":true,"statements":[{"sl":7}]},"test_115":{"methods":[{"sl":6}],"name":"testHasValidBeanToString","pass":true,"statements":[{"sl":7}]},"test_124":{"methods":[{"sl":6}],"name":"shouldProvideString","pass":true,"statements":[{"sl":7}]},"test_137":{"methods":[{"sl":6}],"name":"testHasValidBeanHashCode","pass":true,"statements":[{"sl":7}]},"test_19":{"methods":[{"sl":6}],"name":"testHasValidGettersAndSetters","pass":true,"statements":[{"sl":7}]},"test_63":{"methods":[{"sl":6}],"name":"shouldProvideDifferingStringOnSubsequentCall","pass":true,"statements":[{"sl":7}]},"test_89":{"methods":[{"sl":6}],"name":"testBeanHasValidGettersAndSetters","pass":true,"statements":[{"sl":7}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [89, 19, 124, 137, 63, 11, 115], [89, 19, 124, 137, 63, 11, 115], [], []]
