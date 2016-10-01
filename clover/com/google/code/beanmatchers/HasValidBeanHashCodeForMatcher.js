var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":27,"id":393,"methods":[{"el":15,"sc":5,"sl":12},{"el":20,"sc":5,"sl":17},{"el":26,"sc":5,"sl":22}],"name":"HasValidBeanHashCodeForMatcher","sl":9}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_139":{"methods":[{"sl":12},{"sl":17}],"name":"beanWithPropertyNotInfluencingHashCodeShouldBeDiagnosed","pass":true,"statements":[{"sl":13},{"sl":14},{"sl":19}]},"test_147":{"methods":[{"sl":12},{"sl":17}],"name":"beanWithPropertyNotInfluencingHashCodeShouldNotMatch","pass":true,"statements":[{"sl":13},{"sl":14},{"sl":19}]},"test_4":{"methods":[{"sl":12},{"sl":22}],"name":"shouldDescribeExpectationForExcludedProperties","pass":true,"statements":[{"sl":13},{"sl":14},{"sl":23},{"sl":24},{"sl":25}]},"test_53":{"methods":[{"sl":12},{"sl":17}],"name":"testHasValidBeanHashCodeFor","pass":true,"statements":[{"sl":13},{"sl":14},{"sl":19}]},"test_74":{"methods":[{"sl":12},{"sl":17}],"name":"beanWithValidHashCodeShouldMatch","pass":true,"statements":[{"sl":13},{"sl":14},{"sl":19}]},"test_87":{"methods":[{"sl":12},{"sl":17}],"name":"beanWithPropertyNotInfluencingHashCodeShouldMatchIfBadPropertyIsNotIncluded","pass":true,"statements":[{"sl":13},{"sl":14},{"sl":19}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [74, 139, 147, 4, 53, 87], [74, 139, 147, 4, 53, 87], [74, 139, 147, 4, 53, 87], [], [], [74, 139, 147, 53, 87], [], [74, 139, 147, 53, 87], [], [], [4], [4], [4], [4], [], []]
