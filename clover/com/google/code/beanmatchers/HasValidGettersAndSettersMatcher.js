var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":26,"id":417,"methods":[{"el":15,"sc":5,"sl":12},{"el":20,"sc":5,"sl":17},{"el":25,"sc":5,"sl":22}],"name":"HasValidGettersAndSettersMatcher","sl":9}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_135":{"methods":[{"sl":12},{"sl":17}],"name":"beanWithInvalidSetterShouldNotMatch","pass":true,"statements":[{"sl":13},{"sl":14},{"sl":19}]},"test_32":{"methods":[{"sl":12},{"sl":17}],"name":"beanWithValidGettersAndSettersShouldMatch","pass":true,"statements":[{"sl":13},{"sl":14},{"sl":19}]},"test_37":{"methods":[{"sl":12},{"sl":17}],"name":"beanWithInvalidGetterShouldBeDiagnosed","pass":true,"statements":[{"sl":13},{"sl":14},{"sl":19}]},"test_58":{"methods":[{"sl":12},{"sl":17}],"name":"testHasValidGettersAndSettersFor","pass":true,"statements":[{"sl":13},{"sl":14},{"sl":19}]},"test_79":{"methods":[{"sl":12},{"sl":17}],"name":"beanWithInvalidGetterShouldNotMatch","pass":true,"statements":[{"sl":13},{"sl":14},{"sl":19}]},"test_82":{"methods":[{"sl":12},{"sl":17}],"name":"testBeanHasValidGettersAndSettersFor","pass":true,"statements":[{"sl":13},{"sl":14},{"sl":19}]},"test_92":{"methods":[{"sl":12},{"sl":22}],"name":"shouldDescribeExpectation","pass":true,"statements":[{"sl":13},{"sl":14},{"sl":23},{"sl":24}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [58, 82, 92, 79, 135, 32, 37], [58, 82, 92, 79, 135, 32, 37], [58, 82, 92, 79, 135, 32, 37], [], [], [58, 82, 79, 135, 32, 37], [], [58, 82, 79, 135, 32, 37], [], [], [92], [92], [92], [], []]
