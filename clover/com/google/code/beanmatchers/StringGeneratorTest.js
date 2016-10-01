var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":36,"id":1381,"methods":[{"el":16,"sc":5,"sl":13},{"el":25,"sc":5,"sl":18},{"el":35,"sc":5,"sl":27}],"name":"StringGeneratorTest","sl":9}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_96":{"methods":[{"sl":18}],"name":"shouldProvideString","pass":true,"statements":[{"sl":21},{"sl":24}]},"test_99":{"methods":[{"sl":27}],"name":"shouldProvideDifferingStringOnSubsequentCall","pass":true,"statements":[{"sl":30},{"sl":31},{"sl":34}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [96], [], [], [96], [], [], [96], [], [], [99], [], [], [99], [99], [], [], [99], [], []]
