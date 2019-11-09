var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":79,"id":900,"methods":[{"el":31,"sc":3,"sl":25},{"el":43,"sc":3,"sl":33},{"el":55,"sc":3,"sl":45},{"el":69,"sc":3,"sl":57},{"el":78,"sc":3,"sl":71}],"name":"HasValidBeanConstructorMatcherTest","sl":18}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_12":{"methods":[{"sl":57}],"name":"beanWithInvalidGetterShouldBeDiagnosed","pass":true,"statements":[{"sl":60},{"sl":63},{"sl":66},{"sl":67},{"sl":68}]},"test_166":{"methods":[{"sl":33}],"name":"beanWithNoArgsConstructorShouldMatch","pass":true,"statements":[{"sl":36},{"sl":39},{"sl":42}]},"test_26":{"methods":[{"sl":45}],"name":"beanWithoutNoArgsConstructorShouldNotMatch","pass":true,"statements":[{"sl":48},{"sl":51},{"sl":54}]},"test_75":{"methods":[{"sl":71}],"name":"shouldDescribeExpectation","pass":true,"statements":[{"sl":74},{"sl":77}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [166], [], [], [166], [], [], [166], [], [], [166], [], [], [26], [], [], [26], [], [], [26], [], [], [26], [], [], [12], [], [], [12], [], [], [12], [], [], [12], [12], [12], [], [], [75], [], [], [75], [], [], [75], [], []]
