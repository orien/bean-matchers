var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":9,"id":538,"methods":[{"el":8,"sc":3,"sl":6}],"name":"UuidGenerator","sl":5}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_119":{"methods":[{"sl":6}],"name":"shouldProvideDifferingUuidOnSubsequentCall","pass":true,"statements":[{"sl":7}]},"test_68":{"methods":[{"sl":6}],"name":"shouldProvideUuid","pass":true,"statements":[{"sl":7}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [119, 68], [119, 68], [], []]
