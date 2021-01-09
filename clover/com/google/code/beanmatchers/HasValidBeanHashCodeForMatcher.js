var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":28,"id":436,"methods":[{"el":14,"sc":3,"sl":11},{"el":20,"sc":3,"sl":16},{"el":27,"sc":3,"sl":22}],"name":"HasValidBeanHashCodeForMatcher","sl":8}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_113":{"methods":[{"sl":11},{"sl":22}],"name":"shouldDescribeExpectationForExcludedProperties","pass":true,"statements":[{"sl":12},{"sl":13},{"sl":24},{"sl":25},{"sl":26}]},"test_35":{"methods":[{"sl":11},{"sl":16}],"name":"beanWithPropertyNotInfluencingHashCodeShouldMatchIfBadPropertyIsNotIncluded","pass":true,"statements":[{"sl":12},{"sl":13},{"sl":18}]},"test_46":{"methods":[{"sl":11},{"sl":16}],"name":"beanWithValidHashCodeShouldMatch","pass":true,"statements":[{"sl":12},{"sl":13},{"sl":18}]},"test_59":{"methods":[{"sl":11},{"sl":16}],"name":"beanWithPropertyNotInfluencingHashCodeShouldBeDiagnosed","pass":true,"statements":[{"sl":12},{"sl":13},{"sl":18}]},"test_8":{"methods":[{"sl":11},{"sl":16}],"name":"beanWithPropertyNotInfluencingHashCodeShouldNotMatch","pass":true,"statements":[{"sl":12},{"sl":13},{"sl":18}]},"test_9":{"methods":[{"sl":11},{"sl":16}],"name":"testHasValidBeanHashCodeFor","pass":true,"statements":[{"sl":12},{"sl":13},{"sl":18}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [35, 59, 8, 9, 113, 46], [35, 59, 8, 9, 113, 46], [35, 59, 8, 9, 113, 46], [], [], [35, 59, 8, 9, 46], [], [35, 59, 8, 9, 46], [], [], [], [113], [], [113], [113], [113], [], []]
