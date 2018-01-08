var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":9,"id":1479,"methods":[{"el":8,"sc":3,"sl":5}],"name":"TestBeanWithEqualsThatDoesNotHandleSameInstance","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_0":{"methods":[{"sl":5}],"name":"beanWithEqualsNotHandlingSameInstanceShouldNotMatch","pass":true,"statements":[{"sl":7}]},"test_136":{"methods":[{"sl":5}],"name":"beanWithEqualsNotHandlingSameInstanceShouldBeDiagnosed","pass":true,"statements":[{"sl":7}]},"test_63":{"methods":[{"sl":5}],"name":"beanWithEqualsNotHandlingSameInstanceShouldBeDiagnosed","pass":true,"statements":[{"sl":7}]},"test_68":{"methods":[{"sl":5}],"name":"beanWithEqualsNotHandlingSameInstanceShouldNotMatch","pass":true,"statements":[{"sl":7}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [63, 68, 136, 0], [], [63, 68, 136, 0], [], []]
