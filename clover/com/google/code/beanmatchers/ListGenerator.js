var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":11,"id":521,"methods":[{"el":10,"sc":3,"sl":8}],"name":"ListGenerator","sl":6}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_51":{"methods":[{"sl":8}],"name":"shouldProvideUuid","pass":true,"statements":[{"sl":9}]},"test_61":{"methods":[{"sl":8}],"name":"shouldProvideDifferingUuidOnSubsequentCall","pass":true,"statements":[{"sl":9}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [61, 51], [61, 51], [], []]
