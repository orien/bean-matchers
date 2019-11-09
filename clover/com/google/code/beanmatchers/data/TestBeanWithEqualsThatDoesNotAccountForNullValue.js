var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":23,"id":1588,"methods":[{"el":9,"sc":3,"sl":7},{"el":13,"sc":3,"sl":11},{"el":22,"sc":3,"sl":15}],"name":"TestBeanWithEqualsThatDoesNotAccountForNullValue","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_22":{"methods":[{"sl":15}],"name":"beanWithEqualsNotAccountingNullValueShouldNotMatch","pass":true,"statements":[{"sl":17},{"sl":18}]},"test_49":{"methods":[{"sl":15}],"name":"beanWithEqualsNotAccountingNullValueShouldNotMatch","pass":true,"statements":[{"sl":17},{"sl":18}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [22, 49], [], [22, 49], [22, 49], [], [], [], [], []]
