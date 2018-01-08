var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":11,"id":1463,"methods":[{"el":10,"sc":3,"sl":5}],"name":"TestBeanWithEqualsThatDoesNotHandleDifferingType","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_113":{"methods":[{"sl":5}],"name":"beanWithEqualsNotHandlingDifferingTypeShouldBeDiagnosed","pass":true,"statements":[{"sl":7},{"sl":8},{"sl":9}]},"test_131":{"methods":[{"sl":5}],"name":"beanWithEqualsNotHandlingDifferingTypeShouldNotMatch","pass":true,"statements":[{"sl":7},{"sl":8},{"sl":9}]},"test_147":{"methods":[{"sl":5}],"name":"beanWithEqualsNotHandlingDifferingTypeShouldBeDiagnosed","pass":true,"statements":[{"sl":7},{"sl":8},{"sl":9}]},"test_4":{"methods":[{"sl":5}],"name":"beanWithEqualsNotHandlingDifferingTypeShouldNotMatch","pass":true,"statements":[{"sl":7},{"sl":8},{"sl":9}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [131, 4, 113, 147], [], [131, 4, 113, 147], [131, 4, 113, 147], [131, 4, 113, 147], [], []]
