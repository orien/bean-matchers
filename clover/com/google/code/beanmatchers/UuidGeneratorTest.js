var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":41,"id":1470,"methods":[{"el":21,"sc":3,"sl":18},{"el":30,"sc":3,"sl":23},{"el":40,"sc":3,"sl":32}],"name":"UuidGeneratorTest","sl":14}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_30":{"methods":[{"sl":32}],"name":"shouldProvideDifferingUuidOnSubsequentCall","pass":true,"statements":[{"sl":35},{"sl":36},{"sl":39}]},"test_97":{"methods":[{"sl":23}],"name":"shouldProvideUuid","pass":true,"statements":[{"sl":26},{"sl":29}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [97], [], [], [97], [], [], [97], [], [], [30], [], [], [30], [30], [], [], [30], [], []]
