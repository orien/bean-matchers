var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":10,"id":1460,"methods":[{"el":9,"sc":5,"sl":5}],"name":"TestBeanWithEqualsThatDoesNotHandleNullValue","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_145":{"methods":[{"sl":5}],"name":"beanWithEqualsNotHandlingNullValueShouldBeDiagnosed","pass":true,"statements":[{"sl":7},{"sl":8}]},"test_35":{"methods":[{"sl":5}],"name":"beanWithEqualsNotHandlingNullValueShouldNotMatch","pass":true,"statements":[{"sl":7},{"sl":8}]},"test_64":{"methods":[{"sl":5}],"name":"beanWithEqualsNotHandlingNullValueShouldBeDiagnosed","pass":true,"statements":[{"sl":7},{"sl":8}]},"test_88":{"methods":[{"sl":5}],"name":"beanWithEqualsNotHandlingNullValueShouldNotMatch","pass":true,"statements":[{"sl":7},{"sl":8}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [35, 88, 145, 64], [], [35, 88, 145, 64], [35, 88, 145, 64], [], []]
