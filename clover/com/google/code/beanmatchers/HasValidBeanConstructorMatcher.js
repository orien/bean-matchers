var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":27,"id":345,"methods":[{"el":22,"sc":5,"sl":10},{"el":26,"sc":5,"sl":24}],"name":"HasValidBeanConstructorMatcher","sl":8}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_103":{"methods":[{"sl":10}],"name":"beanWithInvalidGetterShouldBeDiagnosed","pass":true,"statements":[{"sl":12},{"sl":13},{"sl":16},{"sl":20}]},"test_127":{"methods":[{"sl":10}],"name":"beanWithoutNoArgsConstructorShouldNotMatch","pass":true,"statements":[{"sl":12},{"sl":13},{"sl":16},{"sl":20}]},"test_137":{"methods":[{"sl":10}],"name":"beanWithNoArgsConstructorShouldMatch","pass":true,"statements":[{"sl":12},{"sl":13},{"sl":14}]},"test_70":{"methods":[{"sl":24}],"name":"shouldDescribeExpectation","pass":true,"statements":[{"sl":25}]},"test_85":{"methods":[{"sl":10}],"name":"testHasValidBeanConstructor","pass":true,"statements":[{"sl":12},{"sl":13},{"sl":14}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [85, 137, 127, 103], [], [85, 137, 127, 103], [85, 137, 127, 103], [85, 137], [], [127, 103], [], [], [], [127, 103], [], [], [], [70], [70], [], []]
