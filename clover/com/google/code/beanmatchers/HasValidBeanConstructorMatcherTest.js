var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":79,"id":857,"methods":[{"el":31,"sc":3,"sl":25},{"el":43,"sc":3,"sl":33},{"el":55,"sc":3,"sl":45},{"el":69,"sc":3,"sl":57},{"el":78,"sc":3,"sl":71}],"name":"HasValidBeanConstructorMatcherTest","sl":18}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_150":{"methods":[{"sl":33}],"name":"beanWithNoArgsConstructorShouldMatch","pass":true,"statements":[{"sl":36},{"sl":39},{"sl":42}]},"test_160":{"methods":[{"sl":57}],"name":"beanWithInvalidGetterShouldBeDiagnosed","pass":true,"statements":[{"sl":60},{"sl":63},{"sl":66},{"sl":67},{"sl":68}]},"test_23":{"methods":[{"sl":45}],"name":"beanWithoutNoArgsConstructorShouldNotMatch","pass":true,"statements":[{"sl":48},{"sl":51},{"sl":54}]},"test_36":{"methods":[{"sl":71}],"name":"shouldDescribeExpectation","pass":true,"statements":[{"sl":74},{"sl":77}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [150], [], [], [150], [], [], [150], [], [], [150], [], [], [23], [], [], [23], [], [], [23], [], [], [23], [], [], [160], [], [], [160], [], [], [160], [], [], [160], [160], [160], [], [], [36], [], [], [36], [], [], [36], [], []]
