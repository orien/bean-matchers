var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":10,"id":527,"methods":[{"el":9,"sc":3,"sl":7}],"name":"MockingTypeBasedValueGenerator","sl":5}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_100":{"methods":[{"sl":7}],"name":"testHasValidGettersAndSettersFor","pass":true,"statements":[{"sl":8}]},"test_11":{"methods":[{"sl":7}],"name":"testHasValidBeanEquals","pass":true,"statements":[{"sl":8}]},"test_110":{"methods":[{"sl":7}],"name":"testHasValidBeanEqualsExcluding","pass":true,"statements":[{"sl":8}]},"test_115":{"methods":[{"sl":7}],"name":"testHasValidBeanToString","pass":true,"statements":[{"sl":8}]},"test_137":{"methods":[{"sl":7}],"name":"testHasValidBeanHashCode","pass":true,"statements":[{"sl":8}]},"test_156":{"methods":[{"sl":7}],"name":"testBeanHasValidGettersAndSettersExcluding","pass":true,"statements":[{"sl":8}]},"test_157":{"methods":[{"sl":7}],"name":"testBeanHasValidGettersAndSettersFor","pass":true,"statements":[{"sl":8}]},"test_19":{"methods":[{"sl":7}],"name":"testHasValidGettersAndSetters","pass":true,"statements":[{"sl":8}]},"test_34":{"methods":[{"sl":7}],"name":"testHasValidBeanEqualsFor","pass":true,"statements":[{"sl":8}]},"test_47":{"methods":[{"sl":7}],"name":"testGenerate","pass":true,"statements":[{"sl":8}]},"test_58":{"methods":[{"sl":7}],"name":"testHasValidGettersAndSettersExcluding","pass":true,"statements":[{"sl":8}]},"test_89":{"methods":[{"sl":7}],"name":"testBeanHasValidGettersAndSetters","pass":true,"statements":[{"sl":8}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [100, 156, 137, 34, 89, 19, 47, 110, 157, 58, 11, 115], [100, 156, 137, 34, 89, 19, 47, 110, 157, 58, 11, 115], [], []]
