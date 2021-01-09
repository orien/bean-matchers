var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":27,"id":388,"methods":[{"el":22,"sc":3,"sl":10},{"el":26,"sc":3,"sl":24}],"name":"HasValidBeanConstructorMatcher","sl":8}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_123":{"methods":[{"sl":10}],"name":"beanWithInvalidGetterShouldBeDiagnosed","pass":true,"statements":[{"sl":12},{"sl":13},{"sl":16},{"sl":20}]},"test_128":{"methods":[{"sl":24}],"name":"shouldDescribeExpectation","pass":true,"statements":[{"sl":25}]},"test_141":{"methods":[{"sl":10}],"name":"testHasValidBeanConstructor","pass":true,"statements":[{"sl":12},{"sl":13},{"sl":14}]},"test_34":{"methods":[{"sl":10}],"name":"beanWithNoArgsConstructorShouldMatch","pass":true,"statements":[{"sl":12},{"sl":13},{"sl":14}]},"test_44":{"methods":[{"sl":10}],"name":"beanWithoutNoArgsConstructorShouldNotMatch","pass":true,"statements":[{"sl":12},{"sl":13},{"sl":16},{"sl":20}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [44, 123, 141, 34], [], [44, 123, 141, 34], [44, 123, 141, 34], [141, 34], [], [44, 123], [], [], [], [44, 123], [], [], [], [128], [128], [], []]
