var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":11,"id":1450,"methods":[{"el":10,"sc":5,"sl":5}],"name":"TestBeanWithEqualsThatDoesNotHandleDifferingType","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_132":{"methods":[{"sl":5}],"name":"beanWithEqualsNotHandlingDifferingTypeShouldNotMatch","pass":true,"statements":[{"sl":7},{"sl":8},{"sl":9}]},"test_149":{"methods":[{"sl":5}],"name":"beanWithEqualsNotHandlingDifferingTypeShouldNotMatch","pass":true,"statements":[{"sl":7},{"sl":8},{"sl":9}]},"test_17":{"methods":[{"sl":5}],"name":"beanWithEqualsNotHandlingDifferingTypeShouldBeDiagnosed","pass":true,"statements":[{"sl":7},{"sl":8},{"sl":9}]},"test_51":{"methods":[{"sl":5}],"name":"beanWithEqualsNotHandlingDifferingTypeShouldBeDiagnosed","pass":true,"statements":[{"sl":7},{"sl":8},{"sl":9}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [51, 17, 149, 132], [], [51, 17, 149, 132], [51, 17, 149, 132], [51, 17, 149, 132], [], []]
