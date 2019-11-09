var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":24,"id":1573,"methods":[{"el":10,"sc":3,"sl":8},{"el":14,"sc":3,"sl":12},{"el":19,"sc":3,"sl":16},{"el":23,"sc":3,"sl":21}],"name":"TestBeanWithBadGetter","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_113":{"methods":[{"sl":16},{"sl":21}],"name":"beanWithInvalidGetterShouldBeDiagnosed","pass":true,"statements":[{"sl":18},{"sl":22}]},"test_42":{"methods":[{"sl":8},{"sl":12},{"sl":16},{"sl":21}],"name":"beanWithInvalidGetterShouldNotMatch","pass":true,"statements":[{"sl":9},{"sl":13},{"sl":18},{"sl":22}]},"test_46":{"methods":[{"sl":16},{"sl":21}],"name":"beanWithInvalidGetterShouldNotMatch","pass":true,"statements":[{"sl":18},{"sl":22}]},"test_57":{"methods":[{"sl":8},{"sl":12},{"sl":16},{"sl":21}],"name":"beanWithInvalidGetterShouldBeDiagnosed","pass":true,"statements":[{"sl":9},{"sl":13},{"sl":18},{"sl":22}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [42, 57], [42, 57], [], [], [42, 57], [42, 57], [], [], [46, 113, 42, 57], [], [46, 113, 42, 57], [], [], [46, 113, 42, 57], [46, 113, 42, 57], [], []]
