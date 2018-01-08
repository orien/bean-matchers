var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":10,"id":484,"methods":[{"el":9,"sc":3,"sl":7}],"name":"MockingTypeBasedValueGenerator","sl":5}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_1":{"methods":[{"sl":7}],"name":"testHasValidBeanEqualsExcluding","pass":true,"statements":[{"sl":8}]},"test_10":{"methods":[{"sl":7}],"name":"testHasValidBeanToString","pass":true,"statements":[{"sl":8}]},"test_106":{"methods":[{"sl":7}],"name":"testHasValidGettersAndSettersFor","pass":true,"statements":[{"sl":8}]},"test_118":{"methods":[{"sl":7}],"name":"testHasValidGettersAndSettersExcluding","pass":true,"statements":[{"sl":8}]},"test_140":{"methods":[{"sl":7}],"name":"testHasValidBeanEqualsFor","pass":true,"statements":[{"sl":8}]},"test_15":{"methods":[{"sl":7}],"name":"testHasValidGettersAndSetters","pass":true,"statements":[{"sl":8}]},"test_24":{"methods":[{"sl":7}],"name":"testHasValidBeanHashCode","pass":true,"statements":[{"sl":8}]},"test_34":{"methods":[{"sl":7}],"name":"testBeanHasValidGettersAndSettersFor","pass":true,"statements":[{"sl":8}]},"test_77":{"methods":[{"sl":7}],"name":"testGenerate","pass":true,"statements":[{"sl":8}]},"test_84":{"methods":[{"sl":7}],"name":"testBeanHasValidGettersAndSettersExcluding","pass":true,"statements":[{"sl":8}]},"test_85":{"methods":[{"sl":7}],"name":"testHasValidBeanEquals","pass":true,"statements":[{"sl":8}]},"test_96":{"methods":[{"sl":7}],"name":"testBeanHasValidGettersAndSetters","pass":true,"statements":[{"sl":8}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [106, 85, 77, 96, 84, 34, 118, 10, 140, 1, 15, 24], [106, 85, 77, 96, 84, 34, 118, 10, 140, 1, 15, 24], [], []]
