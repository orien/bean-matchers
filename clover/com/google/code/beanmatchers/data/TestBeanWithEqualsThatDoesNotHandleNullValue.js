var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":10,"id":1621,"methods":[{"el":9,"sc":3,"sl":5}],"name":"TestBeanWithEqualsThatDoesNotHandleNullValue","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_108":{"methods":[{"sl":5}],"name":"beanWithEqualsNotHandlingNullValueShouldBeDiagnosed","pass":true,"statements":[{"sl":7},{"sl":8}]},"test_13":{"methods":[{"sl":5}],"name":"beanWithEqualsNotHandlingNullValueShouldNotMatch","pass":true,"statements":[{"sl":7},{"sl":8}]},"test_147":{"methods":[{"sl":5}],"name":"beanWithEqualsNotHandlingNullValueShouldBeDiagnosed","pass":true,"statements":[{"sl":7},{"sl":8}]},"test_53":{"methods":[{"sl":5}],"name":"beanWithEqualsNotHandlingNullValueShouldNotMatch","pass":true,"statements":[{"sl":7},{"sl":8}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [108, 13, 147, 53], [], [108, 13, 147, 53], [108, 13, 147, 53], [], []]
