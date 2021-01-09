var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":39,"id":1461,"methods":[{"el":19,"sc":3,"sl":16},{"el":28,"sc":3,"sl":21},{"el":38,"sc":3,"sl":30}],"name":"StringGeneratorTest","sl":12}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_164":{"methods":[{"sl":30}],"name":"shouldProvideDifferingStringOnSubsequentCall","pass":true,"statements":[{"sl":33},{"sl":34},{"sl":37}]},"test_42":{"methods":[{"sl":21}],"name":"shouldProvideString","pass":true,"statements":[{"sl":24},{"sl":27}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [42], [], [], [42], [], [], [42], [], [], [164], [], [], [164], [164], [], [], [164], [], []]
