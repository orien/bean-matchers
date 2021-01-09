var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":22,"id":1665,"methods":[{"el":9,"sc":3,"sl":7},{"el":13,"sc":3,"sl":11},{"el":21,"sc":3,"sl":15}],"name":"TestBeanWithEqualsThatDoesNotHandleThisNullProperty","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_155":{"methods":[{"sl":11},{"sl":15}],"name":"beanWithEqualsNotHandlingThisNullPropertyShouldNotMatch","pass":true,"statements":[{"sl":12},{"sl":17},{"sl":18},{"sl":19},{"sl":20}]},"test_33":{"methods":[{"sl":11},{"sl":15}],"name":"beanWithEqualsNotHandlingThisNullPropertyShouldNotMatch","pass":true,"statements":[{"sl":12},{"sl":17},{"sl":18},{"sl":19},{"sl":20}]},"test_49":{"methods":[{"sl":11},{"sl":15}],"name":"beanWithEqualsNotHandlingNullPropertyShouldBeDiagnosed","pass":true,"statements":[{"sl":12},{"sl":17},{"sl":18},{"sl":19},{"sl":20}]},"test_98":{"methods":[{"sl":11},{"sl":15}],"name":"beanWithEqualsNotHandlingNullPropertyShouldBeDiagnosed","pass":true,"statements":[{"sl":12},{"sl":17},{"sl":18},{"sl":19},{"sl":20}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [155, 98, 49, 33], [155, 98, 49, 33], [], [], [155, 98, 49, 33], [], [155, 98, 49, 33], [155, 98, 49, 33], [155, 98, 49, 33], [155, 98, 49, 33], [], []]
