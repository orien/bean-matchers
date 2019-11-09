var clover = new Object();

// JSON: {classes : [{name, id, sl, el,  methods : [{sl, el}, ...]}, ...]}
clover.pageData = {"classes":[{"el":40,"id":1429,"methods":[{"el":20,"sc":3,"sl":17},{"el":29,"sc":3,"sl":22},{"el":39,"sc":3,"sl":31}],"name":"ListGeneratorTest","sl":13}]}

// JSON: {test_ID : {"methods": [ID1, ID2, ID3...], "name" : "testXXX() void"}, ...};
clover.testTargets = {"test_51":{"methods":[{"sl":22}],"name":"shouldProvideUuid","pass":true,"statements":[{"sl":25},{"sl":28}]},"test_61":{"methods":[{"sl":31}],"name":"shouldProvideDifferingUuidOnSubsequentCall","pass":true,"statements":[{"sl":34},{"sl":35},{"sl":38}]}}

// JSON: { lines : [{tests : [testid1, testid2, testid3, ...]}, ...]};
clover.srcFileLines = [[], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [], [51], [], [], [51], [], [], [51], [], [], [61], [], [], [61], [61], [], [], [61], [], []]
