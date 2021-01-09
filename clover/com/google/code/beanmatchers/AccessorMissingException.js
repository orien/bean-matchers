var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":8,"id":187,"methods":[{"el":7,"sc":3,"sl":5}],"name":"AccessorMissingException","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_39":{"methods":[{"sl":5}],"name":"shouldThrowExceptionIfSetterIsMissing","pass":true,"statements":[{"sl":6}]},"test_60":{"methods":[{"sl":5}],"name":"beanWithMissingSetterShouldNotMatch","pass":true,"statements":[{"sl":6}]},"test_66":{"methods":[{"sl":5}],"name":"beanWithMissingGetterShouldNotMatch","pass":true,"statements":[{"sl":6}]},"test_73":{"methods":[{"sl":5}],"name":"shouldThrowExceptionIfGetterIsMissing","pass":true,"statements":[{"sl":6}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [39, 60, 66, 73], [39, 60, 66, 73], [], []]
