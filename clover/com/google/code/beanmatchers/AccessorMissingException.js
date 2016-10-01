var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":8,"id":147,"methods":[{"el":7,"sc":5,"sl":5}],"name":"AccessorMissingException","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_106":{"methods":[{"sl":5}],"name":"shouldThrowExceptionIfSetterIsMissing","pass":true,"statements":[{"sl":6}]},"test_40":{"methods":[{"sl":5}],"name":"beanWithMissingSetterShouldNotMatch","pass":true,"statements":[{"sl":6}]},"test_6":{"methods":[{"sl":5}],"name":"shouldThrowExceptionIfGetterIsMissing","pass":true,"statements":[{"sl":6}]},"test_67":{"methods":[{"sl":5}],"name":"beanWithMissingGetterShouldNotMatch","pass":true,"statements":[{"sl":6}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [40, 106, 67, 6], [40, 106, 67, 6], [], []]
