var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":10,"id":1619,"methods":[{"el":9,"sc":3,"sl":5}],"name":"TestBeanWithEqualsThatDoesNotHandleNullValue","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_14":{"methods":[{"sl":5}],"name":"beanWithEqualsNotHandlingNullValueShouldNotMatch","pass":true,"statements":[{"sl":7},{"sl":8}]},"test_141":{"methods":[{"sl":5}],"name":"beanWithEqualsNotHandlingNullValueShouldBeDiagnosed","pass":true,"statements":[{"sl":7},{"sl":8}]},"test_66":{"methods":[{"sl":5}],"name":"beanWithEqualsNotHandlingNullValueShouldNotMatch","pass":true,"statements":[{"sl":7},{"sl":8}]},"test_79":{"methods":[{"sl":5}],"name":"beanWithEqualsNotHandlingNullValueShouldBeDiagnosed","pass":true,"statements":[{"sl":7},{"sl":8}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [66, 141, 79, 14], [], [66, 141, 79, 14], [66, 141, 79, 14], [], []]
