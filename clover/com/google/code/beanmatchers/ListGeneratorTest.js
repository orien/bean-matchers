var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":39,"id":1431,"methods":[{"el":19,"sc":3,"sl":16},{"el":28,"sc":3,"sl":21},{"el":38,"sc":3,"sl":30}],"name":"ListGeneratorTest","sl":12}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_111":{"methods":[{"sl":21}],"name":"shouldProvideList","pass":true,"statements":[{"sl":24},{"sl":27}]},"test_45":{"methods":[{"sl":30}],"name":"shouldProvideDifferingValueOnSubsequentCall","pass":true,"statements":[{"sl":33},{"sl":34},{"sl":37}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [111], [], [], [111], [], [], [111], [], [], [45], [], [], [45], [45], [], [], [45], [], []]
