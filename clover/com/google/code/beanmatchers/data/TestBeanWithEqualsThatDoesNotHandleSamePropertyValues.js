var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":23,"id":1468,"methods":[{"el":9,"sc":5,"sl":7},{"el":13,"sc":5,"sl":11},{"el":22,"sc":5,"sl":15}],"name":"TestBeanWithEqualsThatDoesNotHandleSamePropertyValues","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_3":{"methods":[{"sl":11},{"sl":15}],"name":"beanWithEqualsNotHandlingSamePropertyValuesShouldNotMatch","pass":true,"statements":[{"sl":12},{"sl":17},{"sl":18},{"sl":19},{"sl":20},{"sl":21}]},"test_50":{"methods":[{"sl":11},{"sl":15}],"name":"beanWithEqualsNotHandlingSamePropertyValuesShouldNotMatch","pass":true,"statements":[{"sl":12},{"sl":17},{"sl":18},{"sl":19},{"sl":20},{"sl":21}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [50, 3], [50, 3], [], [], [50, 3], [], [50, 3], [50, 3], [50, 3], [50, 3], [50, 3], [], []]
