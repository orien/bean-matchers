var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":111,"id":1121,"methods":[{"el":41,"sc":3,"sl":35},{"el":54,"sc":3,"sl":43},{"el":67,"sc":3,"sl":56},{"el":83,"sc":3,"sl":69},{"el":96,"sc":3,"sl":85},{"el":110,"sc":3,"sl":98}],"name":"HasValidBeanHashCodeForMatcherTest","sl":19}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_122":{"methods":[{"sl":43}],"name":"beanWithValidHashCodeShouldMatch","pass":true,"statements":[{"sl":46},{"sl":47},{"sl":50},{"sl":53}]},"test_27":{"methods":[{"sl":69}],"name":"beanWithPropertyNotInfluencingHashCodeShouldBeDiagnosed","pass":true,"statements":[{"sl":72},{"sl":73},{"sl":76},{"sl":79},{"sl":80},{"sl":81},{"sl":82}]},"test_46":{"methods":[{"sl":85}],"name":"beanWithPropertyNotInfluencingHashCodeShouldMatchIfBadPropertyIsNotIncluded","pass":true,"statements":[{"sl":88},{"sl":89},{"sl":92},{"sl":95}]},"test_49":{"methods":[{"sl":98}],"name":"shouldDescribeExpectationForExcludedProperties","pass":true,"statements":[{"sl":101},{"sl":104},{"sl":107},{"sl":108},{"sl":109}]},"test_59":{"methods":[{"sl":56}],"name":"beanWithPropertyNotInfluencingHashCodeShouldNotMatch","pass":true,"statements":[{"sl":59},{"sl":60},{"sl":63},{"sl":66}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [122], [], [], [122], [122], [], [], [122], [], [], [122], [], [], [59], [], [], [59], [59], [], [], [59], [], [], [59], [], [], [27], [], [], [27], [27], [], [], [27], [], [], [27], [27], [27], [27], [], [], [46], [], [], [46], [46], [], [], [46], [], [], [46], [], [], [49], [], [], [49], [], [], [49], [], [], [49], [49], [49], [], []]
