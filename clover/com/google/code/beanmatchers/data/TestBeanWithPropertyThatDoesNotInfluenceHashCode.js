var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":19,"id":1703,"methods":[{"el":9,"sc":3,"sl":7},{"el":13,"sc":3,"sl":11},{"el":18,"sc":3,"sl":15}],"name":"TestBeanWithPropertyThatDoesNotInfluenceHashCode","sl":3}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_156":{"methods":[{"sl":11},{"sl":15}],"name":"beanWithPropertyNotInfluencingHashCodeShouldBeDiagnosed","pass":true,"statements":[{"sl":12},{"sl":17}]},"test_163":{"methods":[{"sl":11},{"sl":15}],"name":"beanWithPropertyNotInfluencingHashCodeShouldNotMatch","pass":true,"statements":[{"sl":12},{"sl":17}]},"test_27":{"methods":[{"sl":11},{"sl":15}],"name":"beanWithPropertyNotInfluencingHashCodeShouldBeDiagnosed","pass":true,"statements":[{"sl":12},{"sl":17}]},"test_59":{"methods":[{"sl":11},{"sl":15}],"name":"beanWithPropertyNotInfluencingHashCodeShouldNotMatch","pass":true,"statements":[{"sl":12},{"sl":17}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [59, 163, 27, 156], [59, 163, 27, 156], [], [], [59, 163, 27, 156], [], [59, 163, 27, 156], [], []]
